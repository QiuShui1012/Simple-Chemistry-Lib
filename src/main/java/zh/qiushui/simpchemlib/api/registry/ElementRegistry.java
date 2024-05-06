package zh.qiushui.simpchemlib.api.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.api.information.Element;
import zh.qiushui.simpchemlib.api.object.ElementBlock;
import zh.qiushui.simpchemlib.api.object.ElementBlockItem;
import zh.qiushui.simpchemlib.api.object.ElementItem;

import java.util.Arrays;

import static zh.qiushui.simpchemlib.api.map.ElementStorageMap.registerElementToMap;

public class ElementRegistry {
    private static final String DEFAULT = "en_us";
    public static final int NO_BLOCK = 0;
    public static final int NO_ITEM = 1;
    public static final int HAS_GEM = 2;

    public void registerBlock(String modId, Element information, float blockStrength) {
        ElementBlock block = new ElementBlock(FabricBlockSettings.create().strength(blockStrength));
        Registry.register(Registries.BLOCK, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_block"), block);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_block"), new ElementBlockItem(block, new FabricItemSettings(), information));
        registerElementToMap(information.zNumber, information);
    }

    public void registerItem(String modId, Element information) {
        ElementItem item = new ElementItem(new FabricItemSettings(), information);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase()), item);
        registerElementToMap(information.zNumber, information);
    }

    public void registerMetal(String modId, Element information) {
        Item ingot = new Item(new FabricItemSettings());
        Item nugget = new Item(new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_ingot"), ingot);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_nugget"), nugget);
    }

    public void registerGem(String modId, Element information, String gemName) {
        Item gem = new Item(new FabricItemSettings());
        if (gemName != null) {
            Registry.register(Registries.ITEM, new Identifier(modId, gemName), gem);
        } else {
            Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_gem"), gem);
        }
    }

    public void simpleRegistry(String modId, Element information, float blockStrength, String gemName, int... except) {
        if (Arrays.stream(except).anyMatch(f -> f == 0)) {
            registerBlock(modId, information, blockStrength);
            if (Arrays.stream(except).anyMatch(f -> f == 3)) {
                registerGem(modId, information, gemName);
            } else {
                registerMetal(modId, information);
            }
        } else if (Arrays.stream(except).anyMatch(f -> f == 1)) {
            registerItem(modId, information);
        }


    }
}
