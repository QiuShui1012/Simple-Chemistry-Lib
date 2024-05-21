package zh.qiushui.simpchemlib.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.registry.BucketRegistry;

public class BucketItemGroup {
    public static final ItemGroup BUCKET_IG = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BucketRegistry.BLUE_ICE_BUCKET))
            .displayName(Text.translatable("itemGroup." + SimpChemLib.MOD_ID + ".bucket"))
            .entries((context, entries) -> {
                entries.add(BucketRegistry.BLUE_ICE_BUCKET);
                entries.add(BucketRegistry.MAGMA_BUCKET);
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(SimpChemLib.MOD_ID, "bucket"), BUCKET_IG);
    }
}
