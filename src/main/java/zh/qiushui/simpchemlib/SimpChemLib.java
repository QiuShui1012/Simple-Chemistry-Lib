package zh.qiushui.simpchemlib;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zh.qiushui.simpchemlib.config.SimpChemConfig;
import zh.qiushui.simpchemlib.itemgroup.SimpChemLibItemGroups;
import zh.qiushui.simpchemlib.registry.BucketRegistry;
import zh.qiushui.simpchemlib.registry.MachineRegistry;

public class SimpChemLib implements ModInitializer {
	public static final String MOD_ID = "simpchemlib";
	public static final int DEFAULT_ELEMENT_ITEM_MAX_COUNT = 256;
	public static final int ROOM_TEMPERATURE = 25;
    public static final Logger LOGGER = LoggerFactory.getLogger("QiuShui's Chemistry Lib");
	public static final SimpChemConfig CONFIG = new SimpChemConfig();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing...");
		BucketRegistry.registerAll();
		MachineRegistry.registerAll();
		SimpChemLibItemGroups.registerAll();
	}
}