package zh.qiushui.simpchemlib.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.machine.entity.ElementExtractorEntity;

import static zh.qiushui.simpchemlib.SimpChemLib.MOD_ID;
import static zh.qiushui.simpchemlib.registry.MachineRegistry.ELEMENT_EXTRACTOR;

public class MachineEntityRegistry {
    public static final BlockEntityType<ElementExtractorEntity> ELEMENT_EXTRACTOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "element_extractor_entity"),
            FabricBlockEntityTypeBuilder.create(ElementExtractorEntity::new, ELEMENT_EXTRACTOR).build()
    );
}
