package zh.qiushui.simpchemlib.config;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.datagen.LanguageEntriesProvider;

public enum ConfigInfo {
    ELABORATE_MODEL(Text.translatable("simpchemlib.modmenu.title.elaborate_model").getString(), false,
            Entry.bool(Text.translatable("simpchemlib.modmenu.option.elaborate_base", Text.translatable("block.simpchemlib.element_extractor")).getString(),
                    SimpChemLib.CONFIG::isEnableElaborateElementExtractorModel,
                    SimpChemLib.CONFIG::setEnableElaborateElementExtractorModel, true,
                    Text.translatable("simpchemlib.modmenu.tooltip.elaborate_base", Text.translatable("block.simpchemlib.element_extractor")).getString(),
                    Text.translatable("tooltip." + SimpChemLib.MOD_ID + ".modmenu.restart").formatted(Formatting.RED).toString())
    ),

    ;

    private final String text;
    private final Entry<?>[] entries;
    private final ConfigInfo[] children;
    private final boolean isChild;

    ConfigInfo(String text, boolean isChild, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = new ConfigInfo[0];
        this.isChild = isChild;
    }

    ConfigInfo(String text, boolean isChild, ConfigInfo[] children, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = children;
        this.isChild = isChild;
    }

    public String text() {
        return text;
    }

    public Entry<?>[] entries() {
        return entries;
    }

    public ConfigInfo[] children() {
        return children;
    }

    public boolean isChild() {
        return isChild;
    }
}
