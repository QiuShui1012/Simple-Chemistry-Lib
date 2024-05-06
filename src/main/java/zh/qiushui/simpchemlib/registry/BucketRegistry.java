package zh.qiushui.simpchemlib.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.item.bucket.BlueIceBucket;
import zh.qiushui.simpchemlib.item.bucket.MagmaBucket;

import static zh.qiushui.simpchemlib.SimpChemLib.MOD_ID;

public class BucketRegistry {
    public static final BlueIceBucket BLUE_ICE_BUCKET = new BlueIceBucket(Fluids.EMPTY, new FabricItemSettings());
    public static final MagmaBucket MAGMA_BUCKET = new MagmaBucket(Fluids.EMPTY, new FabricItemSettings());

    public static void registerAll() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, BlueIceBucket.BUCKET_ID), BLUE_ICE_BUCKET);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, MagmaBucket.BUCKET_ID), MAGMA_BUCKET);
    }
}
