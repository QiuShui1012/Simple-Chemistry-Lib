package zh.qiushui.simpchemlib.api.object.fluid;

import net.minecraft.world.WorldView;

public class ElementLowTempFluid extends ElementFluid{
    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 10;
    }
}
