package zh.qiushui.simpchemlib.api.object.gas;

import net.minecraft.world.WorldView;

public class ElementLowTempGas extends ElementGas {
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
