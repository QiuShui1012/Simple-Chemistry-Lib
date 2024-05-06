package zh.qiushui.simpchemlib.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SimpChemLibDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(LanguageEntriesProvider.ChineseEntriesProvider::new);
		pack.addProvider(LanguageEntriesProvider.EnglishEntriesProvider::new);
	}
}
