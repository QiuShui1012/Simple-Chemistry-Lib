package zh.qiushui.simpchemlib.api.definition.map;

import zh.qiushui.simpchemlib.api.exception.UnsupportedObjectException;

import java.awt.Color;
import java.util.Map;

import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_ALKALI_EARTH_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_ALKALI_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_HALOGEN;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_METALLOID;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_NOBLE_GASES;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_NONMETAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_POOR_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.MAY_TRANSITION_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.NONE;
import static zh.qiushui.simpchemlib.api.definition.MetalType.ACTINIDE_ELEMENT;
import static zh.qiushui.simpchemlib.api.definition.MetalType.ALKALINE_EARTH_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.ALKALI_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.HALOGEN;
import static zh.qiushui.simpchemlib.api.definition.MetalType.LANTHANIDE_ELEMENT;
import static zh.qiushui.simpchemlib.api.definition.MetalType.METALLOID;
import static zh.qiushui.simpchemlib.api.definition.MetalType.NOBLE_GASES;
import static zh.qiushui.simpchemlib.api.definition.MetalType.NONMETAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.POOR_METAL;
import static zh.qiushui.simpchemlib.api.definition.MetalType.TRANSITION_METAL;
import static zh.qiushui.simpchemlib.api.exception.UnsupportedObjectException.ufErrorMsg;

public class TypeColorMap {
    public static Map<Integer, Integer> typeColorMap = Map.ofEntries(
            Map.entry(NONE, 0xCFCFCF),
            Map.entry(ALKALI_METAL, 0xFF6666),
            Map.entry(ALKALINE_EARTH_METAL, 0xFFDEAD),
            Map.entry(LANTHANIDE_ELEMENT, 0xFFBFFF),
            Map.entry(ACTINIDE_ELEMENT, 0xFF99CC),
            Map.entry(TRANSITION_METAL, 0xFFC0C0),
            Map.entry(POOR_METAL, 0xCCCCCC),
            Map.entry(METALLOID, 0xCCCC99),
            Map.entry(HALOGEN, 0xFFFF99),
            Map.entry(NONMETAL, 0xA0FFA0),
            Map.entry(NOBLE_GASES, 0xC0FFFF),
            Map.entry(MAY_ALKALI_METAL, 0xCC5252),
            Map.entry(MAY_ALKALI_EARTH_METAL, 0xCCB28A),
            Map.entry(MAY_TRANSITION_METAL, 0xCC9A9A),
            Map.entry(MAY_POOR_METAL, 0xA3A3A3),
            Map.entry(MAY_METALLOID, 0xA3A37A),
            Map.entry(MAY_HALOGEN, 0xCCCC7A),
            Map.entry(MAY_NONMETAL, 0x80CC80),
            Map.entry(MAY_NOBLE_GASES, 0x9ACCCC)
    );

    public static Color getColor(int metalType) {
        return switch (metalType) {
            case ALKALI_METAL -> createColorObject(ALKALI_METAL);
            case ALKALINE_EARTH_METAL -> createColorObject(ALKALINE_EARTH_METAL);
            case LANTHANIDE_ELEMENT -> createColorObject(LANTHANIDE_ELEMENT);
            case ACTINIDE_ELEMENT -> createColorObject(ACTINIDE_ELEMENT);
            case TRANSITION_METAL -> createColorObject(TRANSITION_METAL);
            case POOR_METAL -> createColorObject(POOR_METAL);
            case METALLOID -> createColorObject(METALLOID);
            case HALOGEN -> createColorObject(HALOGEN);
            case NONMETAL -> createColorObject(NONMETAL);
            case NOBLE_GASES -> createColorObject(NOBLE_GASES);
            case NONE -> createColorObject(NONE);
            case MAY_ALKALI_METAL -> createColorObject(MAY_ALKALI_METAL);
            case MAY_ALKALI_EARTH_METAL -> createColorObject(MAY_ALKALI_EARTH_METAL);
            case MAY_TRANSITION_METAL -> createColorObject(MAY_TRANSITION_METAL);
            case MAY_POOR_METAL -> createColorObject(MAY_POOR_METAL);
            case MAY_METALLOID -> createColorObject(MAY_METALLOID);
            case MAY_HALOGEN -> createColorObject(MAY_HALOGEN);
            case MAY_NONMETAL -> createColorObject(MAY_NONMETAL);
            case MAY_NOBLE_GASES -> createColorObject(MAY_NOBLE_GASES);
            default -> {
                zh.qiushui.simpchemlib.SimpChemLib.LOGGER.error(ufErrorMsg(metalType), new UnsupportedObjectException());
                yield null;
            }
        };
    }

    private static Color createColorObject(int metalType) {
        return new Color(typeColorMap.get(metalType));
    }
}
