package zh.qiushui.simpchemlib.machine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.CompassItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.config.SimpChemConfig;
import zh.qiushui.simpchemlib.machine.entity.ElementExtractorEntity;
import zh.qiushui.simpchemlib.registry.MachineRegistry;

import java.util.Objects;

import static net.minecraft.block.HorizontalFacingBlock.FACING;

public class ElementExtractor extends BlockWithEntity implements BlockEntityProvider {
    private static final BooleanProperty ELABORATE = BooleanProperty.of("elaborate");
    private static final BooleanProperty ACTIVE = BooleanProperty.of("active");

    private static final VoxelShape ELABORATE_NORTH_INCREASE_AABB = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(2.0, 4.0, 5.0, 8.0, 13.0, 11.0),
            Block.createCuboidShape(12.0, 4.0, 7.0, 14.0, 14.0, 9.0)
    );
    private static final VoxelShape ELABORATE_SOUTH_INCREASE_AABB = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(8.0, 4.0, 5.0, 14.0, 13.0, 11.0),
            Block.createCuboidShape(2.0, 4.0, 7.0, 4.0, 14.0, 9.0)
    );
    private static final VoxelShape ELABORATE_EAST_INCREASE_AABB = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(5.0, 4.0, 2.0, 11.0, 13.0, 8.0),
            Block.createCuboidShape(7.0, 4.0, 12.0, 9.0, 14.0, 14.0)
    );
    private static final VoxelShape ELABORATE_WEST_INCREASE_AABB = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            Block.createCuboidShape(5.0, 4.0, 8.0, 11.0, 13.0, 14.0),
            Block.createCuboidShape(7.0, 4.0, 2.0, 9.0, 14.0, 4.0)
    );
    private static final VoxelShape NORTH_AABB = VoxelShapes.combineAndSimplify(VoxelShapes.empty(), ELABORATE_NORTH_INCREASE_AABB, BooleanBiFunction.NOT_SAME);
    private static final VoxelShape SOUTH_AABB = VoxelShapes.combineAndSimplify(VoxelShapes.empty(), ELABORATE_SOUTH_INCREASE_AABB, BooleanBiFunction.NOT_SAME);
    private static final VoxelShape EAST_AABB = VoxelShapes.combineAndSimplify(VoxelShapes.empty(), ELABORATE_EAST_INCREASE_AABB, BooleanBiFunction.NOT_SAME);
    private static final VoxelShape WEST_AABB = VoxelShapes.combineAndSimplify(VoxelShapes.empty(), ELABORATE_WEST_INCREASE_AABB, BooleanBiFunction.NOT_SAME);

    public ElementExtractor(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(getDefaultState().with(ELABORATE, true));
        setDefaultState(getDefaultState().with(ACTIVE, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(ELABORATE);
        builder.add(ACTIVE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (SimpChemLib.CONFIG.isEnableElaborateElementExtractorModel()) {
            Direction dir = state.get(FACING);
            switch (dir) {
                default -> {
                    return NORTH_AABB;
                }
                case SOUTH -> {
                    return SOUTH_AABB;
                }
                case EAST -> {
                    return EAST_AABB;
                }
                case WEST -> {
                    return WEST_AABB;
                }
            }
        } else {
            return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ElementExtractorEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ElementExtractorEntity) {
                ItemScatterer.spawn(world, pos, (ElementExtractorEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = (ElementExtractorEntity) world.getBlockEntity(pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, MachineRegistry.ELEMENT_EXTRACTOR_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}