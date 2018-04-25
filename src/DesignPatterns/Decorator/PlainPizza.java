package DesignPatterns.Decorator;

/**
 * Created by NISHANT on 4/24/18.
 */
public class PlainPizza implements Pizza{


    @Override
    public String getDesc() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
