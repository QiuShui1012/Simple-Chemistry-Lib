package zh.qiushui.simpchemlib.api.information;

import zh.qiushui.simpchemlib.api.information.language.I18nNameMap;

import java.awt.Color;

import static zh.qiushui.simpchemlib.api.map.TypeColorMap.getColor;

public class Element {
    public final I18nNameMap nameMap;
    public final String symbol;
    public final int zNumber;
    public final double mass;
    public final int metalType;
    public final Color typeColor;
    public final boolean didMassTested;
    public final boolean didMetalTypeTested;

    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), true, true);
    }
    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            boolean didMassTested,
            int metalType
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), didMassTested, true);
    }
    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType,
            boolean didMetalTypeTested
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), true, didMetalTypeTested);
    }

    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType,
            Color typeColor,
            boolean didMassTested,
            boolean didMetalTypeTested
    )
    {
        this.nameMap = nameMap;
        this.symbol = symbol;
        this.zNumber = zNumber;
        this.mass = mass;
        this.metalType = metalType;
        this.typeColor = typeColor;
        this.didMassTested = didMassTested;
        this.didMetalTypeTested = didMetalTypeTested;
    }
}
