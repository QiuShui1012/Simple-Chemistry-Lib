package zh.qiushui.simpchemlib.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import zh.qiushui.simpchemlib.config.SimpChemLibConfig;

public class SimpChemLibModMenuApiImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(SimpChemLibConfig.class, parent).get();
    }
}
