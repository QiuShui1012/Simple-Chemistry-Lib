package zh.qiushui.simpchemlib;

import net.fabricmc.api.ClientModInitializer;
import zh.qiushui.simpchemlib.machine.ElementExtractor;
import zh.qiushui.simpchemlib.registry.MachineScreenRegistry;

public class SimpChemLibClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MachineScreenRegistry.registerAll();
    }
}
