package zh.qiushui.simpchemlib.api.definition;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import zh.qiushui.simpchemlib.api.exception.OutOfRangeException;

import java.util.Map;

import static zh.qiushui.simpchemlib.api.exception.OutOfRangeException.oorErrorMsg;

public class MetalType {
    public static final int NONE = 0;
    public static final int ALKALI_METAL = 1;
    public static final int ALKALINE_EARTH_METAL = 2;
    public static final int LANTHANIDE_ELEMENT = 3;
    public static final int ACTINIDE_ELEMENT = 4;
    public static final int TRANSITION_METAL = 5;
    public static final int POOR_METAL = 6;
    public static final int METALLOID = 7;
    public static final int HALOGEN = 8;
    public static final int NONMETAL = 9;
    public static final int NOBLE_GASES = 10;
    public static final int MAY_ALKALI_METAL = 11;
    public static final int MAY_ALKALI_EARTH_METAL = 12;
    public static final int MAY_TRANSITION_METAL = 13;
    public static final int MAY_POOR_METAL = 14;
    public static final int MAY_METALLOID = 15;
    public static final int MAY_HALOGEN = 16;
    public static final int MAY_NONMETAL = 17;
    public static final int MAY_NOBLE_GASES = 18;
    public static final Map<Integer, String> METAL_TYPE_MAP = Map.ofEntries(
            Map.entry(NONE, "none"),
            Map.entry(ALKALI_METAL, "alkali_metal"),
            Map.entry(ALKALINE_EARTH_METAL, "alkaline-earth_metal"),
            Map.entry(LANTHANIDE_ELEMENT, "lanthanide_element"),
            Map.entry(ACTINIDE_ELEMENT, "actinide_element"),
            Map.entry(TRANSITION_METAL, "transition_metal"),
            Map.entry(POOR_METAL, "poor_metal"),
            Map.entry(METALLOID, "metalloid"),
            Map.entry(HALOGEN, "halogen"),
            Map.entry(NONMETAL, "nonmetal"),
            Map.entry(NOBLE_GASES, "noble_gases")
    );

    public static MutableText getTextMetalTypeName(int metalType, Object... args) {
        if (metalType < 11 && metalType >= 0) {
            return Text.translatable("metalType.simpchemlib." + METAL_TYPE_MAP.get(metalType), args);
        } else if (metalType >= 11 && metalType <= 18) {
            return Text.translatable("qualifier.simpchemlib.inaccuracy", Text.translatable("metalType.simpchemlib." + METAL_TYPE_MAP.get(metalType - 10), args)).formatted(Formatting.GRAY);
        } else {
            zh.qiushui.simpchemlib.SimpChemLib.LOGGER.error(oorErrorMsg(metalType), new OutOfRangeException());
            return null;
        }
    }

    public static String getStringMetalTypeName(int metalType, Object... args) {
        if (metalType < 11 && metalType >= 0) {
            return Text.translatable("metalType.simpchemlib." + METAL_TYPE_MAP.get(metalType), args).toString();
        } else if (metalType >= 11 && metalType <= 18) {
            return Text.translatable("qualifier.simpchemlib.inaccuracy", Text.translatable("metalType.simpchemlib." + METAL_TYPE_MAP.get(metalType - 10), args)).formatted(Formatting.GRAY).toString();
        } else {
            zh.qiushui.simpchemlib.SimpChemLib.LOGGER.error(oorErrorMsg(metalType), new OutOfRangeException());
            return null;
        }
    }
}
