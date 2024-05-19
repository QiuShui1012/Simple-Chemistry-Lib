package zh.qiushui.simpchemlib.api.tooltip;

import net.minecraft.text.MutableText;

public class Tooltip extends Texts {
    public static MutableText tooltip(String keys, Object... args) {
        return simpChemText("tooltip", keys, args);
    }
}
