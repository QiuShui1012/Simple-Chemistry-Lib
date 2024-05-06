package zh.qiushui.simpchemlib.api.definition;

import net.minecraft.text.MutableText;

import static zh.qiushui.simpchemlib.SimpChemLib.MOD_ID;

public class Text {
    public static MutableText text(String type, String keys, Object... args) {
        return net.minecraft.text.Text.translatable(type+ "." + MOD_ID + "." + keys, args);
    }
}
