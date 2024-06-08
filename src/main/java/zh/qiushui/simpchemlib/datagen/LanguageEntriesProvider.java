package zh.qiushui.simpchemlib.datagen;

import com.sun.jna.platform.win32.Tlhelp32;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import zh.qiushui.simpchemlib.SimpChemLib;

public class LanguageEntriesProvider {
    public static final String MOD_ID = "." + SimpChemLib.MOD_ID + ".";
    public static final String CONFIG = "text.autoconfig" + MOD_ID;

    public static class ChineseEntriesProvider extends FabricLanguageProvider {
        protected ChineseEntriesProvider(FabricDataOutput dataOutput) {
            super(dataOutput, "zh_cn");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(CONFIG + "title", "简单化学类库 - 配置");

            translationBuilder.add(CONFIG + "option.displaySettings", "显示设置");

            translationBuilder.add(CONFIG + "option.displaySettings.temperatureUnit", "设置温度单位显示");

            translationBuilder.add(CONFIG + "option.displaySettings.temperatureUnit.@Tooltip", "支持切换为摄氏度、华氏度或开尔文。");

            translationBuilder.add("itemGroup" + MOD_ID + "bucket", "简单化学类库|桶");
            translationBuilder.add("itemGroup" + MOD_ID + "machine", "简单化学类库|机器");

            translationBuilder.add("tooltip" + MOD_ID + "full_name", "元素名：%s");
            translationBuilder.add("tooltip" + MOD_ID + "symbol", "元素符号：%s");
            translationBuilder.add("tooltip" + MOD_ID + "z_number", "原子序数：%s");
            translationBuilder.add("tooltip" + MOD_ID + "mass", "原子量：%s");
            translationBuilder.add("tooltip" + MOD_ID + "metal_type", "金属类型：%s");
            translationBuilder.add("tooltip" + MOD_ID + "bucket", "支持温度：%s");
            // translationBuilder.add("tooltip" + MODMENU + "restart", "修改此项会强制重载资源包");

            translationBuilder.add("qualifier" + MOD_ID + "inaccurate", "%s（未测定）");

            translationBuilder.add("metalType" + MOD_ID + "none", "无");
            translationBuilder.add("metalType" + MOD_ID + "alkali_metal", "碱金属");
            translationBuilder.add("metalType" + MOD_ID + "alkaline-earth_metal", "碱土金属");
            translationBuilder.add("metalType" + MOD_ID + "lanthanide_element", "镧系元素");
            translationBuilder.add("metalType" + MOD_ID + "actinide_element", "锕系元素");
            translationBuilder.add("metalType" + MOD_ID + "transition_metal", "过渡金属");
            translationBuilder.add("metalType" + MOD_ID + "poor_metal", "贫金属");
            translationBuilder.add("metalType" + MOD_ID + "metalloid", "类金属");
            translationBuilder.add("metalType" + MOD_ID + "halogen", "卤素");
            translationBuilder.add("metalType" + MOD_ID + "nonmetal", "非金属");
            translationBuilder.add("metalType" + MOD_ID + "noble_gases", "惰性气体");

            translationBuilder.add("temperature" + MOD_ID + "blue_ice_bucket", "%s以下");
            translationBuilder.add("temperature" + MOD_ID + "magma_bucket", "%s以上");

            translationBuilder.add("temperatureUnit" + MOD_ID + "c", "℃（摄氏度）");
            translationBuilder.add("temperatureUnit" + MOD_ID + "f", "℉（华氏度）");
            translationBuilder.add("temperatureUnit" + MOD_ID + "k", "K（开尔文）");

            translationBuilder.add("block" + MOD_ID + "element_extractor", "元素提取机");

            translationBuilder.add("item" + MOD_ID + "blue_ice_bucket", "蓝冰桶");
            translationBuilder.add("item" + MOD_ID + "magma_bucket", "岩浆桶");

            translationBuilder.add("container.element_extractor", "元素提取机");

            translationBuilder.add("resourcePack" + MOD_ID + "elaborate_model", "精细模型");
        }
    }

    public static class EnglishEntriesProvider extends FabricLanguageProvider {
        protected EnglishEntriesProvider(FabricDataOutput dataOutput) {
            super(dataOutput, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(CONFIG + "title", "Simple Chemistry Lib - Configuration");

            translationBuilder.add(CONFIG + "option.displaySettings", "Display Settings");

            translationBuilder.add(CONFIG + "option.displaySettings.temperatureUnit", "Set temperature unit display");

            translationBuilder.add(CONFIG + "option.displaySettings.temperatureUnit.@Tooltip", "Supports switching to Fahrenheit, Celsius, or Kelvin.");

            translationBuilder.add("itemGroup" + MOD_ID + "bucket", "Simple Chemistry Lib: Buckets");
            translationBuilder.add("itemGroup" + MOD_ID + "machine", "Simple Chemistry Lib: Machines");

            translationBuilder.add("tooltip" + MOD_ID + "full_name", "Element name: %s");
            translationBuilder.add("tooltip" + MOD_ID + "symbol", "Element symbol: %s");
            translationBuilder.add("tooltip" + MOD_ID + "z_number", "Atomic number: %s");
            translationBuilder.add("tooltip" + MOD_ID + "mass", "Atomic mass: %s");
            translationBuilder.add("tooltip" + MOD_ID + "metal_type", "Metal type: %s");
            translationBuilder.add("tooltip" + MOD_ID + "fluid_temp", "Fluid temperature: %s");
            translationBuilder.add("tooltip" + MOD_ID + "gas_temp", "Gas temperature: %s");
            translationBuilder.add("tooltip" + MOD_ID + "bucket", "Supported temperature: %s");
            // translationBuilder.add("tooltip" + MOD_ID + "modmenu.restart", "Modifying this option forces the resource pack to be reloaded");

            translationBuilder.add("qualifier" + MOD_ID + "inaccurate", "%s (Untested)");

            translationBuilder.add("metalType" + MOD_ID + "none", "None");
            translationBuilder.add("metalType" + MOD_ID + "alkali_metal", "Alkali metal");
            translationBuilder.add("metalType" + MOD_ID + "alkaline-earth_metal", "Alkaline-earth metal");
            translationBuilder.add("metalType" + MOD_ID + "lanthanide_element", "Lanthanide element");
            translationBuilder.add("metalType" + MOD_ID + "actinide_element", "Actinide element");
            translationBuilder.add("metalType" + MOD_ID + "transition_metal", "Transition metal");
            translationBuilder.add("metalType" + MOD_ID + "poor_metal", "Poor metal");
            translationBuilder.add("metalType" + MOD_ID + "metalloid", "Metalloid");
            translationBuilder.add("metalType" + MOD_ID + "halogen", "Halogen");
            translationBuilder.add("metalType" + MOD_ID + "nonmetal", "Nonmetal");
            translationBuilder.add("metalType" + MOD_ID + "noble_gases", "Noble gases");

            translationBuilder.add("temperature" + MOD_ID + "blue_ice_bucket", "Below %s");
            translationBuilder.add("temperature" + MOD_ID + "magma_bucket", "Above %s");

            translationBuilder.add("temperatureUnit" + MOD_ID + "f", "℉ (Fahrenheit)");
            translationBuilder.add("temperatureUnit" + MOD_ID + "c", "℃ (Celsius)");
            translationBuilder.add("temperatureUnit" + MOD_ID + "k", "K (Kelvin)");

            translationBuilder.add("block" + MOD_ID + "element_extractor", "Element Extractor");

            translationBuilder.add("item" + MOD_ID + "blue_ice_bucket", "Blue Ice Bucket");
            translationBuilder.add("item" + MOD_ID + "magma_bucket", "Magma Bucket");

            translationBuilder.add("container.element_extractor", "Element Extractor");
        }
    }
}
