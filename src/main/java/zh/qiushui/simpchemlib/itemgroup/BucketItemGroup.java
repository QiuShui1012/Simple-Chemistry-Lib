package zh.qiushui.simpchemlib.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import zh.qiushui.simpchemlib.SimpChemLib;

import static zh.qiushui.simpchemlib.registry.BucketRegistry.BLUE_ICE_BUCKET;
import static zh.qiushui.simpchemlib.registry.BucketRegistry.MAGMA_BUCKET;

public class BucketItemGroup {
    public static final ItemGroup BUCKET_IG = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BLUE_ICE_BUCKET))
            .displayName(Text.translatable("itemGroup." + SimpChemLib.MOD_ID + ".bucket"))
            .build();

    public static void register() {
        BUCKET_IG.contains(BLUE_ICE_BUCKET.getDefaultStack());
        BUCKET_IG.contains(MAGMA_BUCKET.getDefaultStack());
    }
}
