package DesignPatterns.Decorator;

/**
 * Created by NISHANT on 4/24/18.
 */
public abstract class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza) {
        this.tempPizza = newPizza;
    }

    public String getDesc() {
        return tempPizza.getDesc();
    }

    public double getCost() {
        return tempPizza.getCost();
    }
}
