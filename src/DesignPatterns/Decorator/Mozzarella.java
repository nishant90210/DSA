package DesignPatterns.Decorator;

/**
 * Created by NISHANT on 4/24/18.
 */
public class Mozzarella extends ToppingDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Dough");

        System.out.println("Adding Moz");
    }

    public String getDesc() {
        return tempPizza.getDesc() + ", Mozzarella";
    }

    public double getCost() {
        return tempPizza.getCost() + 0.50;
    }
}
