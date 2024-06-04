package zh.qiushui.simpchemlib.api.object;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;
import zh.qiushui.simpchemlib.api.information.Element;
import zh.qiushui.simpchemlib.api.object.fluid.ElementFluid;
import zh.qiushui.simpchemlib.api.object.fluid.ElementHighTempFluid;
import zh.qiushui.simpchemlib.api.object.fluid.ElementLowTempFluid;
import zh.qiushui.simpchemlib.api.object.gas.ElementGas;
import zh.qiushui.simpchemlib.api.object.gas.ElementHighTempGas;
import zh.qiushui.simpchemlib.api.object.gas.ElementLowTempGas;

import java.util.ArrayList;

public class ElementInstance {
    public static final int HIGH_TEMP = 0;
    public static final int MEDIUM_TEMP = 1;
    public static final int LOW_TEMP = 2;

    public ElementBlock elementBlock;
    public ElementBlockItem elementBlockItem;
    public ElementItem elementItem;
    public Item ingot;
    public Item nugget;
    public GemItem gem;
    public ElementHighTempFluid highTempFluid;
    public ElementFluid mediumTempFluid;
    public ElementLowTempFluid lowTempFluid;
    public ElementHighTempGas highTempGas;
    public ElementGas mediumTempGas;
    public ElementLowTempGas lowTempGas;
    public ArrayList<Integer> has;

    private ElementInstance(ElementBlock elementBlock, ElementBlockItem elementBlockItem, ElementItem elementItem, Item ingot, Item nugget, GemItem gem, ElementHighTempFluid highTempFluid, ElementFluid mediumTempFluid, ElementLowTempFluid lowTempFluid, ElementHighTempGas highTempGas, ElementGas mediumTempGas, ElementLowTempGas lowTempGas, ArrayList<Integer> has) {
        this.elementBlock = elementBlock;
        this.elementBlockItem = elementBlockItem;
        this.elementItem = elementItem;
        this.ingot = ingot;
        this.nugget = nugget;
        this.gem = gem;
        this.highTempFluid = highTempFluid;
        this.mediumTempFluid = mediumTempFluid;
        this.lowTempFluid = lowTempFluid;
        this.highTempGas = highTempGas;
        this.mediumTempGas = mediumTempGas;
        this.lowTempGas = lowTempGas;
        this.has = has;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public ElementBlock elementBlock;
        public ElementBlockItem elementBlockItem;
        public ElementItem elementItem;
        public Item ingot;
        public Item nugget;
        public GemItem gem;
        public ElementHighTempFluid highTempFluid;
        public ElementFluid mediumTempFluid;
        public ElementLowTempFluid lowTempFluid;
        public ElementHighTempGas highTempGas;
        public ElementGas mediumTempGas;
        public ElementLowTempGas lowTempGas;
        public ArrayList<Integer> has;

        @NotNull
        public Builder hasBlock(ElementBlock block, ElementBlockItem blockItem) {
            this.elementBlock = block;
            this.elementBlockItem = blockItem;
            this.has.add(0);
            return this;
        }
        @NotNull
        public Builder hasItem(ElementItem item) {
            this.elementItem = item;
            this.has.add(1);
            return this;
        }
        @NotNull
        public Builder hasIngotAndNugget(Item ingot, Item nugget) {
            this.ingot = ingot;
            this.nugget = nugget;
            this.has.add(2);
            return this;
        }
        @NotNull
        public Builder hasGem(GemItem gem) {
            this.gem = gem;
            this.has.add(3);
            return this;
        }
        @NotNull
        public Builder hasFluid(int isHighTemp, Object fluid) {
            switch (isHighTemp) {
                case HIGH_TEMP -> {
                    this.highTempFluid = (ElementHighTempFluid) fluid;
                    this.has.add(4);
                }
                case MEDIUM_TEMP -> {
                    this.mediumTempFluid = (ElementFluid) fluid;
                    this.has.add(5);
                }
                case LOW_TEMP -> {
                    this.lowTempFluid = (ElementLowTempFluid) fluid;
                    this.has.add(6);
                }
            }
            return this;
        }
        @NotNull
        public Builder hasGas(int isHighTemp, Object gas) {
            switch (isHighTemp) {
                case HIGH_TEMP -> {
                    this.highTempGas = (ElementHighTempGas) gas;
                    this.has.add(7);
                }
                case MEDIUM_TEMP -> {
                    this.mediumTempGas = (ElementGas) gas;
                    this.has.add(8);
                }
                case LOW_TEMP -> {
                    this.lowTempGas = (ElementLowTempGas) gas;
                    this.has.add(9);
                }
            }
            return this;
        }

        public ElementInstance build() {
            return new ElementInstance(
                    this.elementBlock,
                    this.elementBlockItem,
                    this.elementItem,
                    this.ingot,
                    this.nugget,
                    this.gem,
                    this.highTempFluid,
                    this.mediumTempFluid,
                    this.lowTempFluid,
                    this.highTempGas,
                    this.mediumTempGas,
                    this.lowTempGas,
                    this.has
            );
        }
    }
}
