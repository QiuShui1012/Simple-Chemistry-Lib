package zh.qiushui.simpchemlib.api.definition.map;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.Map;

public class TemperatureUnitMap {
    public static Map<Integer, MutableText> tempUnitMap = Map.ofEntries(
            Map.entry(0, Text.translatable("temperatureUnit.simpchemlib.c")),
            Map.entry(1, Text.translatable("temperatureUnit.simpchemlib.f")),
            Map.entry(2, Text.translatable("temperatureUnit.simpchemlib.k"))
    );
}
