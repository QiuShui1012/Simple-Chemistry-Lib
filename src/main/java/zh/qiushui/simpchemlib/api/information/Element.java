package zh.qiushui.simpchemlib.api.information;

import org.jetbrains.annotations.NotNull;
import zh.qiushui.simpchemlib.api.definition.MatterStates;
import zh.qiushui.simpchemlib.api.definition.MetalType;
import zh.qiushui.simpchemlib.api.definition.map.TypeColorMap;
import zh.qiushui.simpchemlib.api.information.language.I18nNameMap;

import java.awt.Color;

public record Element(I18nNameMap nameMap,
                      String symbol,
                      int zNumber,
                      double mass,
                      int metalType,
                      Color typeColor,
                      int matterState,
                      double solidTemp,
                      double fluidTemp,
                      double gasTemp,
                      boolean didMassTested,
                      boolean didMetalTypeTested) {
    public static InformationBuilder builder() {
        return new InformationBuilder();
    }

    public static class InformationBuilder {
        private I18nNameMap nameMap;
        private String symbol;
        private int zNumber;
        private double mass;
        private int metalType = MetalType.NONE;
        private int matterState = MatterStates.SOLID;
        private double solidTemp;
        private double fluidTemp;
        private double gasTemp;
        private boolean didMassTested = true;
        private boolean didMetalTypeTested = true;

        public InformationBuilder() {
        }

        @NotNull
        public InformationBuilder name(String name) {
            return nameMap(I18nNameMap.createNameMap(name));
        }
        @NotNull
        public InformationBuilder nameMap(I18nNameMap nameMap) {
            this.nameMap = nameMap;
            return this;
        }
        @NotNull
        public InformationBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }
        @NotNull
        public InformationBuilder zNumber(int zNumber) {
            this.zNumber = zNumber;
            return this;
        }
        @NotNull
        public InformationBuilder mass(double mass) {
            this.mass = mass;
            return this;
        }
        public InformationBuilder metalType(int metalType) {
            this.metalType = metalType;
            return this;
        }
        public InformationBuilder matterStateAtRoomTemp(int matterState) {
            this.matterState = matterState;
            return this;
        }
        @NotNull
        public InformationBuilder threeStatesTemp(int gasTemp, int fluidTemp, int solidTemp) {
            this.gasTemp = gasTemp;
            this.fluidTemp = fluidTemp;
            this.solidTemp = solidTemp;
            return this;
        }
        public InformationBuilder didMassTested(boolean didMassTested) {
            this.didMassTested = didMassTested;
            return this;
        }
        public InformationBuilder didMetalTypeTested(boolean didMetalTypeTested) {
            this.didMetalTypeTested = didMetalTypeTested;
            return this;
        }

        public Element build() {
            return new Element(
                    this.nameMap,
                    this.symbol,
                    this.zNumber,
                    this.mass,
                    this.metalType,
                    TypeColorMap.getColor(metalType),
                    this.matterState,
                    this.solidTemp,
                    this.fluidTemp,
                    this.gasTemp,
                    this.didMassTested,
                    this.didMetalTypeTested);
        }
    }
}