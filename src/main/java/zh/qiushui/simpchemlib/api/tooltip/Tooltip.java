package zh.qiushui.simpchemlib.api.tooltip;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.registry.MachineRegistry;

public class Tooltip{
    public static MutableText simpChemTooltip(String keys, Object... args) {
        return tooltip(SimpChemLib.MOD_ID, keys, args);
    }

    public static MutableText tooltip(String modId, String keys, Object... args) {
        return Text.translatable("tooltip." + modId + "." + keys, args);
    }
}
