package DesignPatterns.CofferMaker;

import java.math.BigDecimal;

public enum Ingredient {

    COCOA("0.90"),
    COFFEE("0.75"),
    CREAM("0.25"),
    DECAF_COFFEE("0.75"),
    ESPRESSO("1.10"),
    FOAMED_MILK("0.35"),
    STEAMED_MILK("0.35"),
    SUGAR("0.25"),
    WHIPPED_CREAM("1.00");

    private final String name;
    private final BigDecimal cost;

    Ingredient(String cost) {
        this.name = this.name().replace("_", " ").toLowerCase();
        this.cost = new BigDecimal(cost);
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public String toString() {
        return this.name;
    }
}
