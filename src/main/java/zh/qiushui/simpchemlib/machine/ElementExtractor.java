package zh.qiushui.simpchemlib.machine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.machine.entity.ElementExtractorEntity;

import static zh.qiushui.simpchemlib.registry.MachineRegistry.ELEMENT_EXTRACTOR;
import static zh.qiushui.simpchemlib.registry.MachineRegistry.ELEMENT_EXTRACTOR_;

public class ElementExtractor extends Block implements BlockEntityProvider {
    private static final Text TITLE = Text.translatable("container.element_extractor");

    public ElementExtractor(Settings settings) {
        super(settings);
    }

    @Override
    public Item asItem() {
        return ELEMENT_EXTRACTOR_;
    }

    @Override
    protected Block asBlock() {
        return ELEMENT_EXTRACTOR;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ElementExtractorEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
            return ActionResult.CONSUME;
        }
    }
}
