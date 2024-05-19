package zh.qiushui.simpchemlib.api.definition.map;

import net.minecraft.text.MutableText;
import net.minecraft.util.Formatting;
import zh.qiushui.simpchemlib.api.definition.MetalTypes;
import zh.qiushui.simpchemlib.api.exception.OutOfRangeException;

import java.util.Map;

import static zh.qiushui.simpchemlib.api.exception.OutOfRangeException.oorErrorMsg;
import static zh.qiushui.simpchemlib.api.tooltip.Tooltip.simpChemText;

public class MetalTypeMap {
    public static final Map<Integer, String> METAL_TYPE_MAP = Map.ofEntries(
            Map.entry(MetalTypes.NONE, "none"),
            Map.entry(MetalTypes.ALKALI_METAL, "alkali_metal"),
            Map.entry(MetalTypes.ALKALINE_EARTH_METAL, "alkaline-earth_metal"),
            Map.entry(MetalTypes.LANTHANIDE_ELEMENT, "lanthanide_element"),
            Map.entry(MetalTypes.ACTINIDE_ELEMENT, "actinide_element"),
            Map.entry(MetalTypes.TRANSITION_METAL, "transition_metal"),
            Map.entry(MetalTypes.POOR_METAL, "poor_metal"),
            Map.entry(MetalTypes.METALLOID, "metalloid"),
            Map.entry(MetalTypes.HALOGEN, "halogen"),
            Map.entry(MetalTypes.NONMETAL, "nonmetal"),
            Map.entry(MetalTypes.NOBLE_GASES, "noble_gases")
    );

    public static MutableText getTextMetalName(int metalType, Object... args) {
        if (metalType < 11 && metalType >= 0) {
            return simpChemText("metalType" , METAL_TYPE_MAP.get(metalType), args);
        } else if (metalType >= 11 && metalType <= 18) {
            return simpChemText("qualifier", "inaccuracy", simpChemText("metalType", METAL_TYPE_MAP.get(metalType - 10), args)).formatted(Formatting.GRAY);
        } else {
            zh.qiushui.simpchemlib.SimpChemLib.LOGGER.error(oorErrorMsg(metalType), new OutOfRangeException());
            return null;
        }
    }

    public static String getStringMetalName(int metalType, Object... args) {
        if (metalType < 11 && metalType >= 0) {
            return simpChemText("metalType" , METAL_TYPE_MAP.get(metalType), args).toString();
        } else if (metalType >= 11 && metalType <= 18) {
            return simpChemText("qualifier", "inaccuracy", simpChemText("metalType", METAL_TYPE_MAP.get(metalType - 10), args)).formatted(Formatting.GRAY).toString();
        } else {
            zh.qiushui.simpchemlib.SimpChemLib.LOGGER.error(oorErrorMsg(metalType), new OutOfRangeException());
            return null;
        }
    }
}
