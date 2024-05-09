package zh.qiushui.simpchemlib.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.machine.entity.ElementExtractorEntity;

import static zh.qiushui.simpchemlib.SimpChemLib.MOD_ID;

public class MachineRegistry {
    public static final Block ELEMENT_EXTRACTOR = new Block(FabricBlockSettings.create().strength(4.0f));
    public static final BlockItem ELEMENT_EXTRACTOR_ITEM = new BlockItem(ELEMENT_EXTRACTOR, new FabricItemSettings());

    public static final BlockEntityType<ElementExtractorEntity> ELEMENT_EXTRACTOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "element_extractor_entity"),
            FabricBlockEntityTypeBuilder.create(ElementExtractorEntity::new, ELEMENT_EXTRACTOR).build()
    );

    public static void registerAll() {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "element_extractor"), ELEMENT_EXTRACTOR);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "element_extractor"), ELEMENT_EXTRACTOR_ITEM);
    }
}
