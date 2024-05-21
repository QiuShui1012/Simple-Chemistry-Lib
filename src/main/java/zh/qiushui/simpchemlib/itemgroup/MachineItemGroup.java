package zh.qiushui.simpchemlib.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import zh.qiushui.simpchemlib.SimpChemLib;
import zh.qiushui.simpchemlib.registry.MachineRegistry;


public class MachineItemGroup {
    public static final ItemGroup MACHINE_IG = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MachineRegistry.ELEMENT_EXTRACTOR_ITEM))
            .displayName(Text.translatable("itemGroup." + SimpChemLib.MOD_ID + ".machine"))
            .entries((context, entries) -> {
                entries.add(MachineRegistry.ELEMENT_EXTRACTOR_ITEM);
            })
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(SimpChemLib.MOD_ID, "machine"), MACHINE_IG);
    }
}
