package zh.qiushui.simpchemlib.resource;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.metadata.ModOrigin;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.SimpChemLib;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class BuiltinResourcePacksRegistry {
    public static void registerAll() {
    }
}
