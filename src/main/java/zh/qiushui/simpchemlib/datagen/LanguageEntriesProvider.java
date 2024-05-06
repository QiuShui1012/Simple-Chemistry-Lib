package zh.qiushui.simpchemlib.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class LanguageEntriesProvider {
    public static final String MOD_ID = "." + zh.qiushui.simpchemlib.SimpChemLib.MOD_ID + ".";

    public static class ChineseEntriesProvider extends FabricLanguageProvider {
        protected ChineseEntriesProvider(FabricDataOutput dataOutput) {
            super(dataOutput, "zh_cn");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("itemGroup" + MOD_ID + "bucket", "简单化学类库|桶");

            translationBuilder.add("tooltip" + MOD_ID + "full_name", "元素名：%s");
            translationBuilder.add("tooltip" + MOD_ID + "symbol", "元素符号：%s");
            translationBuilder.add("tooltip" + MOD_ID + "z_number", "原子序数：%s");
            translationBuilder.add("tooltip" + MOD_ID + "mass", "原子量：%s");
            translationBuilder.add("tooltip" + MOD_ID + "metal_type", "金属类型：%s");
            translationBuilder.add("tooltip" + MOD_ID + "bucket", "支持温度：%s");

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

            translationBuilder.add("temperature" + MOD_ID + "blue_ice_bucket", "0℃以下");
            translationBuilder.add("temperature" + MOD_ID + "magma_bucket", "1538℃以上");

            translationBuilder.add("item" + MOD_ID + "blue_ice_bucket", "蓝冰桶");
            translationBuilder.add("item" + MOD_ID + "magma_bucket", "岩浆桶");

            translationBuilder.add("container.element_extractor", "元素提取机");
        }
    }

    public static class EnglishEntriesProvider extends FabricLanguageProvider {
        protected EnglishEntriesProvider(FabricDataOutput dataOutput) {
            super(dataOutput, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("itemGroup" + MOD_ID + "bucket", "Simple Chemistry Lib: Buckets");

            translationBuilder.add("tooltip" + MOD_ID + "full_name", "Element name: %s");
            translationBuilder.add("tooltip" + MOD_ID + "symbol", "Element symbol: %s");
            translationBuilder.add("tooltip" + MOD_ID + "z_number", "Atomic number: %s");
            translationBuilder.add("tooltip" + MOD_ID + "mass", "Atomic mass: %s");
            translationBuilder.add("tooltip" + MOD_ID + "metal_type", "Metal type: %s");
            translationBuilder.add("tooltip" + MOD_ID + "bucket", "Supported temperature: %s");

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

            translationBuilder.add("temperature" + MOD_ID + "blue_ice_bucket", "Below 0℃");
            translationBuilder.add("temperature" + MOD_ID + "magma_bucket", "Above 1538℃");

            translationBuilder.add("item" + MOD_ID + "blue_ice_bucket", "Blue Ice Bucket");
            translationBuilder.add("item" + MOD_ID + "magma_bucket", "Magma Bucket");

            translationBuilder.add("container.element_extractor", "Element Extractor");
        }
    }
}
