package zh.qiushui.simpchemlib.machine.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.api.interfaces.ImplementedInventory;
import zh.qiushui.simpchemlib.recipe.ElementExtract;
import zh.qiushui.simpchemlib.screen.machine.handler.ElementExtractorScreenHandler;

import java.util.Optional;

import static zh.qiushui.simpchemlib.registry.MachineRegistry.ELEMENT_EXTRACTOR_ENTITY;

public class ElementExtractorEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(17,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT_START = 1;
    private static final int OUTPUT_SLOT_END = 16;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 36;
    private boolean active = false;
    public ElementExtractorEntity(BlockPos pos, BlockState state) {
        super(ELEMENT_EXTRACTOR_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> ElementExtractorEntity.this.progress;
                    case 1 -> ElementExtractorEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> ElementExtractorEntity.this.progress = value;
                    case 1 -> ElementExtractorEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("progress",progress);
        nbt.putBoolean("active",active);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
        progress = nbt.getInt("progress");
        active = nbt.getBoolean("active");
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.element_extractor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ElementExtractorScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void tick(World world1, BlockPos pos, BlockState state1) {
        if (world1.isClient()){
            return;
        }
        if (isOutputSlotAvailable()){
            if (this.hasRecipe()){
                this.increaseCraftProgress();
                this.setActive();
                markDirty(world1,pos,state1);

                if (hasCraftingFinished()){
                    this.craftItem();
                    this.resetProgress();
                }
            }else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world1, pos, state1);
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.active = false;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT,1);
        Optional<ElementExtract> recipe = getCurrentRecipe();

        for (int i = OUTPUT_SLOT_START; i <= OUTPUT_SLOT_END; ++i) {
            if (recipe.isPresent()) {
                int correctItemCount = getStack(i).getCount() + recipe.get().getOutput(null).getCount();
                if (correctItemCount <= SimpChemLib.DEFAULT_ELEMENT_ITEM_MAX_COUNT) {
                    this.setStack(i, new ItemStack(recipe.get().getOutput(null).getItem(),
                            correctItemCount));
                } else {
                    this.setStack(i, new ItemStack(recipe.get().getOutput(null).getItem(),
                            SimpChemLib.DEFAULT_ELEMENT_ITEM_MAX_COUNT));
                    this.setStack(i + 1, new ItemStack(recipe.get().getOutput(null).getItem(),
                            correctItemCount - SimpChemLib.DEFAULT_ELEMENT_ITEM_MAX_COUNT));
                }
            }
        }
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private void setActive() {
        if (!active) {
            active = true;
        }
    }

    private boolean hasRecipe() {
        Optional<ElementExtract> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null)) &&
        canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
    }

    private Optional<ElementExtract> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i< this.size(); i++){
            inv.setStack(i,this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(ElementExtract.Type.INSTANCE,inv,getWorld());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT_START).getCount() + result.getCount() <= getStack(OUTPUT_SLOT_START).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT_START).getItem() == item || this.getStack(OUTPUT_SLOT_START).isEmpty();
    }

    private boolean isOutputSlotAvailable() {
        return this.getStack(OUTPUT_SLOT_START).isEmpty() || this.getStack(OUTPUT_SLOT_START).getCount() < this.getStack(OUTPUT_SLOT_START).getMaxCount();
    }
}
