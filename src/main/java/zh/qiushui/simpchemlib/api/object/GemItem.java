package zh.qiushui.simpchemlib.api.object;

import net.minecraft.item.Item;

public class GemItem extends Item {
    public final String gemName;

    public GemItem(Settings settings, String gemName) {
        super(settings);
        this.gemName = gemName;
    }
}
