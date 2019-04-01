package DesignPatterns.ChainOfResponsibility;

/**
 * Created by NISHANT on 4/23/18.
 */
public class TestChain {

    public static void main(String[] args) {

        Chain chainCalc1 = new AddNumbers();
        Chain chainCalc2 = new SubstractNumber();
        Chain chainCalc3 = new MultiplyNumber();
        Chain chainCalc4 = new DivideNumber();

        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);
        chainCalc3.setNextChain(chainCalc4);

        Numbers request = new Numbers(60, 50, "div");
        chainCalc1.calculate(request);
    }
}
