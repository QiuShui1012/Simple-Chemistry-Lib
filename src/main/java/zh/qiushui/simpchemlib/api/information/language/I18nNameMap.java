package zh.qiushui.simpchemlib.api.information.language;

import java.util.HashMap;

public class I18nNameMap extends HashMap<String, String> {
    public void addEntry(String languageCode, String value) {
        this.put(languageCode, value);
    }

    public static I18nNameMap createNameMap(String defaultValue) {
        I18nNameMap map = new I18nNameMap();
        map.addEntry("en_us", defaultValue);
        return map;
    }
}
