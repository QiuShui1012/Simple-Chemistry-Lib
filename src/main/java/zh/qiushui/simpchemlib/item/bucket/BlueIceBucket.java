package zh.qiushui.simpchemlib.item.bucket;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.config.SimpChemLibConfig;

import java.util.List;

import static zh.qiushui.simpchemlib.api.tooltip.Tooltip.simpChemTooltip;
import static zh.qiushui.simpchemlib.api.tooltip.Tooltip.tooltip;

public class BlueIceBucket extends BucketItem {
    public static final String BUCKET_ID = "blue_ice_bucket";
    private static final int CELSIUS_TEMP = 0;

    public BlueIceBucket(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (SimpChemLib.config.displaySettings.temperatureUnit.ordinal() == 0) {
            tooltip.add(simpChemTooltip("bucket", Text.translatable("temperature.simpchemlib.blue_ice_bucket", Text.literal(CELSIUS_TEMP + "℃").formatted(Formatting.AQUA))).formatted(Formatting.GRAY));
        } else if (SimpChemLib.config.displaySettings.temperatureUnit.ordinal() == 1) {
            tooltip.add(simpChemTooltip("bucket", Text.translatable("temperature.simpchemlib.blue_ice_bucket", Text.literal((CELSIUS_TEMP * 1.8 + 32) + "℉").formatted(Formatting.AQUA))).formatted(Formatting.GRAY));
        } else if (SimpChemLib.config.displaySettings.temperatureUnit.ordinal() == 2) {
            tooltip.add(simpChemTooltip("bucket", Text.translatable("temperature.simpchemlib.blue_ice_bucket", Text.literal((CELSIUS_TEMP + 273.15) + "K").formatted(Formatting.AQUA))).formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("报错！"));
        }
    }
}
