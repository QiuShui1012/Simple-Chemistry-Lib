package zh.qiushui.simpchemlib.api.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.api.information.Element;
import zh.qiushui.simpchemlib.api.object.ElementBlock;
import zh.qiushui.simpchemlib.api.object.ElementBlockItem;
import zh.qiushui.simpchemlib.api.object.ElementInstance;
import zh.qiushui.simpchemlib.api.object.ElementItem;
import zh.qiushui.simpchemlib.api.object.GemItem;
import zh.qiushui.simpchemlib.api.object.fluid.ElementFluid;
import zh.qiushui.simpchemlib.api.object.fluid.ElementHighTempFluid;
import zh.qiushui.simpchemlib.api.object.fluid.ElementLowTempFluid;
import zh.qiushui.simpchemlib.api.object.gas.ElementGas;
import zh.qiushui.simpchemlib.api.object.gas.ElementHighTempGas;
import zh.qiushui.simpchemlib.api.object.gas.ElementLowTempGas;

import static zh.qiushui.simpchemlib.api.map.ElementStorageMap.registerElementToMap;

public class ElementRegistry {
    private static final String DEFAULT = "en_us";

    public void registerBlock(String modId, Element information, ElementBlock block, ElementBlockItem blockItem) {
        Registry.register(Registries.BLOCK, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_block"), block);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_block"), blockItem);
        registerElementToMap(information.zNumber, information);
    }

    public void registerItem(String modId, Element information, ElementItem item) {
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase()), item);
        registerElementToMap(information.zNumber, information);
    }

    public void registerMetal(String modId, Element information, Item ingot, Item nugget) {
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_ingot"), ingot);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_nugget"), nugget);
    }

    public void registerGem(String modId, Element information, GemItem gem) {
        Registry.register(Registries.ITEM, new Identifier(modId, gem.gemName.toLowerCase()), gem);
        Registry.register(Registries.ITEM, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_gem"), gem);
    }

    public void registerFluid(String modId, Element information, int temp, Object fluid) {
        if (temp == 4) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_fluid"), (ElementHighTempFluid) fluid);
        } else if (temp == 5) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_fluid"), (ElementFluid) fluid);
        } else if (temp == 6) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_fluid"), (ElementLowTempFluid) fluid);
        }
    }

    public void registerGas(String modId, Element information, int temp, Object gas) {
        if (temp == 7) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_gas"), (ElementHighTempGas) gas);
        } else if (temp == 8) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_gas"), (ElementGas) gas);
        } else if (temp == 9) {
            Registry.register(Registries.FLUID, new Identifier(modId, information.nameMap.get(DEFAULT).toLowerCase() + "_gas"), (ElementLowTempGas) gas);
        }
    }

    public void simpleRegistry(String modId, Element information, ElementInstance instance) {
        if (instance.has.contains(0)) {
            registerBlock(modId, information, instance.elementBlock, instance.elementBlockItem);
        }
        if (instance.has.contains(1)) {
            registerItem(modId, information, instance.elementItem);
        }
        if (instance.has.contains(2)) {
            registerMetal(modId, information, instance.ingot, instance.nugget);
        }
        if (instance.has.contains(3)) {
            registerGem(modId, information, instance.gem);
        }
        if (instance.has.contains(4)) {
            registerFluid(modId, information, 4, instance.highTempFluid);
        }
        if (instance.has.contains(5)) {
            registerFluid(modId, information, 5, instance.mediumTempFluid);
        }
        if (instance.has.contains(6)) {
            registerFluid(modId, information, 6, instance.lowTempFluid);
        }
        if (instance.has.contains(7)) {
            registerGas(modId, information, 7, instance.highTempGas);
        }
        if (instance.has.contains(8)) {
            registerGas(modId, information, 8, instance.mediumTempGas);
        }
        if (instance.has.contains(9)) {
            registerGas(modId, information, 9, instance.lowTempGas);
        }
    }
}
