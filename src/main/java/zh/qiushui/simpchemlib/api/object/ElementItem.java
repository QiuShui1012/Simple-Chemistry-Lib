package zh.qiushui.simpchemlib.api.object;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.api.information.Element;

import java.util.List;

import static zh.qiushui.simpchemlib.api.tooltip.ElementTooltip.addElementTooltip;

public class ElementItem extends Item {
    public final Element information;

    public ElementItem(Settings settings, Element information) {
        super(settings);
        this.information = information;
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        addElementTooltip(tooltip, information);
    }
}
