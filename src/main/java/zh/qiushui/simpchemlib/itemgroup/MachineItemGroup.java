package zh.qiushui.simpchemlib.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.registry.MachineRegistry;


public class MachineItemGroup {
    public static final ItemGroup BUCKET_IG = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MachineRegistry.ELEMENT_EXTRACTOR_ITEM))
            .displayName(Text.translatable("itemGroup." + SimpChemLib.MOD_ID + ".machine"))
            .build();

    public static void register() {
        BUCKET_IG.contains(MachineRegistry.ELEMENT_EXTRACTOR_ITEM.getDefaultStack());
    }
}
