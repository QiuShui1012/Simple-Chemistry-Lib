package zh.qiushui.simpchemlib.api.tooltip;

import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.api.information.Element;

import java.util.List;

public class ElementTooltip extends Tooltip{
    public static void addElementTooltip(List<Text> tooltip, Element information, Object... args) {
        tooltip.add(simpChemTooltip("full_name", information.nameMap().get("en_us")));
        tooltip.add(simpChemTooltip("symbol", information.symbol()));
        tooltip.add(simpChemTooltip("z_number", String.valueOf(information.zNumber())));

        if (!information.didMassTested()) {
            tooltip.add(Text.translatable("qualifier.simpchemlib.inaccuracy", tooltip("mass", String.valueOf(information.mass()))));
        } else {
            tooltip.add(tooltip("mass", String.valueOf(information.mass())));
        }

        if (!information.didMetalTypeTested()) {
            tooltip.add(Text.translatable("qualifier.simpchemlib.inaccuracy", tooltip("metal_type", String.valueOf(information.metalType()))));
        } else {
            tooltip.add(tooltip("metal_type", String.valueOf(information.metalType())));
        }
    }
}
