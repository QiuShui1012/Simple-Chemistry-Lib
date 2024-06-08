package zh.qiushui.simpchemlib;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zh.qiushui.simpchemlib.config.SimpChemLibConfig;
import zh.qiushui.simpchemlib.itemgroup.SimpChemLibItemGroups;
import zh.qiushui.simpchemlib.registry.BucketRegistry;
import zh.qiushui.simpchemlib.registry.MachineRegistry;

public class SimpChemLib implements ModInitializer {
	public static final String MOD_ID = "simpchemlib";
	public static final int DEFAULT_ELEMENT_ITEM_MAX_COUNT = 256;
	public static final int ROOM_TEMPERATURE = 25;
    public static final Logger LOGGER = LoggerFactory.getLogger("QiuShui's Chemistry Lib");
	public static SimpChemLibConfig config = AutoConfig
			.register(SimpChemLibConfig.class, JanksonConfigSerializer::new)
			.getConfig();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing...");
		BucketRegistry.registerAll();
		MachineRegistry.registerAll();
		SimpChemLibItemGroups.registerAll();
	}
}