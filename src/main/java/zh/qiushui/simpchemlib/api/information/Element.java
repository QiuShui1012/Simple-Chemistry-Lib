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
    public final double solidTemp;
    public final double fluidTemp;
    public final double gasTemp;
    public final boolean didMassTested;
    public final boolean didMetalTypeTested;

    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType,
            double solidTemp,
            double fluidTemp,
            double gasTemp
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), solidTemp, fluidTemp, gasTemp, true, true);
    }
    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            boolean didMassTested,
            int metalType,
            double solidTemp,
            double fluidTemp,
            double gasTemp
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), solidTemp, fluidTemp, gasTemp, didMassTested, true);
    }
    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType,
            double solidTemp,
            double fluidTemp,
            double gasTemp,
            boolean didMetalTypeTested
    )
    {
        this(nameMap, symbol, zNumber, mass, metalType, getColor(metalType), solidTemp, fluidTemp, gasTemp, true, didMetalTypeTested);
    }

    public Element(
            I18nNameMap nameMap,
            String symbol,
            int zNumber,
            double mass,
            int metalType,
            Color typeColor,
            double solidTemp,
            double fluidTemp,
            double gasTemp,
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
        this.solidTemp = solidTemp;
        this.fluidTemp = fluidTemp;
        this.gasTemp = gasTemp;
        this.didMassTested = didMassTested;
        this.didMetalTypeTested = didMetalTypeTested;
    }
}
