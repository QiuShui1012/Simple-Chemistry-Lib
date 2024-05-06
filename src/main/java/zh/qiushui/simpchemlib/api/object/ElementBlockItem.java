package zh.qiushui.simpchemlib.api.object;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import zh.qiushui.simpchemlib.api.information.Element;

import java.util.List;

import static zh.qiushui.simpchemlib.api.tooltip.ElementTooltip.addElementTooltip;

public class ElementBlockItem extends BlockItem {
    public final Element information;

    public ElementBlockItem(Block block, Settings settings, Element information) {
        super(block, settings);
        this.information = information;
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        addElementTooltip(tooltip, information);
    }
}
