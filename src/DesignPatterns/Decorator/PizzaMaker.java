package DesignPatterns.Decorator;

/**
 * Created by NISHANT on 4/24/18.
 */
public class PizzaMaker {

    public static void main(String[] args) {

        Pizza pizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

        System.out.println("Ingredients : " + pizza.getDesc());

        System.out.println("Cost : " + pizza.getCost());

    }
}
