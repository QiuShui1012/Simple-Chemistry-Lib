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

import java.util.List;

import static zh.qiushui.simpchemlib.api.definition.Text.text;
import static zh.qiushui.simpchemlib.api.tooltip.Tooltip.tooltip;

public class BlueIceBucket extends BucketItem {
    public static final String BUCKET_ID = "blue_ice_bucket";

    public BlueIceBucket(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(tooltip("ice_bucket", text("temperature", "blue_ice_bucket").formatted(Formatting.AQUA)).formatted(Formatting.RESET, Formatting.GRAY));
    }
}
