package zh.qiushui.simpchemlib.api.tooltip;

import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.api.information.Element;

import java.util.List;

public class ElementTooltip extends Tooltip{
    public static void addElementTooltip(List<Text> tooltip, Element information, Object... args) {
        tooltip.add(tooltip("full_name", information.nameMap.get("en_us")));
        tooltip.add(tooltip("symbol", information.symbol));
        tooltip.add(tooltip("z_number", String.valueOf(information.zNumber)));

        if (!information.didMassTested) {
            tooltip.add(text("qualifier", "inaccuracy", tooltip("mass", String.valueOf(information.mass))));
        } else {
            tooltip.add(tooltip("mass", String.valueOf(information.mass)));
        }

        if (!information.didMetalTypeTested) {
            tooltip.add(text("qualifier", "inaccuracy", tooltip("metal_type", String.valueOf(information.metalType))));
        } else {
            tooltip.add(tooltip("metal_type", String.valueOf(information.metalType)));
        }
    }
}
