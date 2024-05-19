package zh.qiushui.simpchemlib.config;

import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import zh.qiushui.simpchemlib.SimpChemLib;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

public class SimpChemConfig {
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "simpchemlib.json");

    //Elaborate Model Config
    private boolean enableElaborateElementExtractorModel = true;


    public SimpChemConfig() {
    }

    public static SimpChemConfig load() {
        SimpChemConfig configuration = new SimpChemConfig();
        if (!CONFIG_FILE.exists()) {
            save(configuration);
        }

        Reader reader;
        try {
            reader = Files.newBufferedReader(CONFIG_FILE.toPath());
            configuration = (new GsonBuilder().setPrettyPrinting().create()).fromJson(reader, SimpChemConfig.class);
            reader.close();
        } catch (IOException e) {
            SimpChemLib.LOGGER.error("Error while trying to load configuration file. Default configuration used.", e);
        }

        return configuration;
    }

    public static void save(SimpChemConfig config) {
        try {
            Writer writer = Files.newBufferedWriter(CONFIG_FILE.toPath());
            (new GsonBuilder().setPrettyPrinting().create()).toJson(config, writer);

            writer.close();

        } catch (IOException e) {
            SimpChemLib.LOGGER.error("Error while trying to save configuration file.", e);
        }
    }

    public boolean isEnableElaborateElementExtractorModel() {
        return enableElaborateElementExtractorModel;
    }
    public void setEnableElaborateElementExtractorModel(boolean enableElaborateElementExtractorModel) {
        this.enableElaborateElementExtractorModel = enableElaborateElementExtractorModel;
    }
}
