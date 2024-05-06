package zh.qiushui.simpchemlib.api.tooltip;

import net.minecraft.text.MutableText;
import zh.qiushui.simpchemlib.api.definition.Text;

public class Tooltip extends Text {
    public static MutableText tooltip(String keys, Object... args) {
        return text("tooltip", keys, args);
    }
}
