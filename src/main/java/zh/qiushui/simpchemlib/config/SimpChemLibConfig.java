package zh.qiushui.simpchemlib.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.SimpChemLib;

@Config(name = SimpChemLib.MOD_ID)
public class SimpChemLibConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("ds")
    @ConfigEntry.Gui.TransitiveObject
    public DisplaySettings displaySettings = new DisplaySettings();

    public SimpChemLibConfig() {
    }

    @Config(name = "ds")
    public static class DisplaySettings implements ConfigData {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        public TemperatureUnit temperatureUnit;

        public DisplaySettings() {
            this.temperatureUnit = TemperatureUnit.C;
        }

        public enum TemperatureUnit {
            C(Text.translatable("temperatureUnit.simpchemlib.c")),
            F(Text.translatable("temperatureUnit.simpchemlib.f")),
            K(Text.translatable("temperatureUnit.simpchemlib.k"))
            ;

            private final Text unit;
            TemperatureUnit(Text unit) {
                this.unit = unit;
            }

            @Override
            public String toString() {
                return getUnit();
            }

            public String getUnit() {
                return unit.getString();
            }
        }
    }
}
