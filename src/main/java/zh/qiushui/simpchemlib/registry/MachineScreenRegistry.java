package zh.qiushui.simpchemlib.registry;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import zh.qiushui.simpchemlib.screen.machine.ElementExtractorScreen;
import zh.qiushui.simpchemlib.screen.machine.TristateConverterScreen;

public class MachineScreenRegistry {
    public static void registerAll() {
        HandledScreens.register(MachineRegistry.ELEMENT_EXTRACTOR_SCREEN_HANDLER, ElementExtractorScreen::new);
        HandledScreens.register(MachineRegistry.TRISTATE_CONVERTER_SCREEN_HANDLER, TristateConverterScreen::new);
    }
}
