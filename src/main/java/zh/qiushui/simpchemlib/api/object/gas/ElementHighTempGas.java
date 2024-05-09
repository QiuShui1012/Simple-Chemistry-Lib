package zh.qiushui.simpchemlib.api.object.gas;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;

public class ElementHighTempGas extends ElementGas {
    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 6;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }
}
