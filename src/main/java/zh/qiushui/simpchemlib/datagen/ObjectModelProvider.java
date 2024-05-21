package zh.qiushui.simpchemlib.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import zh.qiushui.simpchemlib.registry.BucketRegistry;

public class ObjectModelProvider extends FabricModelProvider {
    public ObjectModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BucketRegistry.BLUE_ICE_BUCKET, Models.GENERATED);
        itemModelGenerator.register(BucketRegistry.MAGMA_BUCKET, Models.GENERATED);
    }
}
