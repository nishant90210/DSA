package DesignPatterns.Decorator;

/**
 * Created by NISHANT on 4/24/18.
 */
public class TomatoSauce extends ToppingDecorator{

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Tomato Sauce");
    }

    public String getDesc() {
        return tempPizza.getDesc() + ", Tomato";
    }

    public double getCost() {
        return tempPizza.getCost() + 0.20;
    }
}
