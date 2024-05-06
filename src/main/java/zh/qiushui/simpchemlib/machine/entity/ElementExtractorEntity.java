package zh.qiushui.simpchemlib.machine.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import static zh.qiushui.simpchemlib.registry.MachineEntityRegistry.ELEMENT_EXTRACTOR_ENTITY;

public class ElementExtractorEntity extends BlockEntity {
    public ElementExtractorEntity(BlockPos pos, BlockState state) {
        super(ELEMENT_EXTRACTOR_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }
}
