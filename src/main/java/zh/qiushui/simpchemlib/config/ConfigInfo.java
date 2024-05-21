package zh.qiushui.simpchemlib.config;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.datagen.LanguageEntriesProvider;

public enum ConfigInfo {
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
