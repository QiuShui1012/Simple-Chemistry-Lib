package zh.qiushui.simpchemlib.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.machine.ElementExtractor;
import zh.qiushui.simpchemlib.machine.TristateConverter;
import zh.qiushui.simpchemlib.machine.entity.ElementExtractorEntity;
import zh.qiushui.simpchemlib.machine.entity.TristateConverterEntity;
import zh.qiushui.simpchemlib.screen.machine.handler.ElementExtractorScreenHandler;
import zh.qiushui.simpchemlib.screen.machine.handler.TristateConverterScreenHandler;

import static zh.qiushui.simpchemlib.SimpChemLib.MOD_ID;

public class MachineRegistry {
    public static final ElementExtractor ELEMENT_EXTRACTOR = new ElementExtractor(FabricBlockSettings.create().strength(4.0f));
    public static final BlockItem ELEMENT_EXTRACTOR_ITEM = new BlockItem(ELEMENT_EXTRACTOR, new FabricItemSettings());
    public static final TristateConverter TRISTATE_CONVERTER = new TristateConverter(FabricBlockSettings.create().strength(4.0f));
    public static final BlockItem TRISTATE_CONVERTER_ITEM = new BlockItem(TRISTATE_CONVERTER, new FabricItemSettings());

    public static final BlockEntityType<ElementExtractorEntity> ELEMENT_EXTRACTOR_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "element_extractor_entity"),
            FabricBlockEntityTypeBuilder.create(ElementExtractorEntity::new, ELEMENT_EXTRACTOR).build()
    );
    public static final BlockEntityType<TristateConverterEntity> TRISTATE_CONVERTER_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(MOD_ID, "tristate_converter_entity"),
            FabricBlockEntityTypeBuilder.create(TristateConverterEntity::new, TRISTATE_CONVERTER).build()
    );

    public static final ScreenHandlerType<ElementExtractorScreenHandler> ELEMENT_EXTRACTOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(SimpChemLib.MOD_ID,"element_extractor"),
                    new ExtendedScreenHandlerType<>(ElementExtractorScreenHandler::new));
    public static final ScreenHandlerType<TristateConverterScreenHandler> TRISTATE_CONVERTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,new Identifier(SimpChemLib.MOD_ID,"tristate_converter"),
                    new ExtendedScreenHandlerType<>(TristateConverterScreenHandler::new));

    public static void registerAll() {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "element_extractor"), ELEMENT_EXTRACTOR);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "element_extractor"), ELEMENT_EXTRACTOR_ITEM);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tristate_converter"), TRISTATE_CONVERTER);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "tristate_converter"), TRISTATE_CONVERTER_ITEM);
    }
}
