package zh.qiushui.simpchemlib.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.SimpChemLib;

public class SimpChemScreenHandlers {
    public static final ScreenHandlerType<ElementExtractorScreenHandler> ELEMENT_EXTRACTOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(SimpChemLib.MOD_ID,"element_extractor"),
                    new ExtendedScreenHandlerType<>(ElementExtractorScreenHandler::new));
    public static void registerScreenHandlers(){

    }
}
