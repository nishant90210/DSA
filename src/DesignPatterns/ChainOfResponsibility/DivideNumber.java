package DesignPatterns.ChainOfResponsibility;

/**
 * Created by NISHANT on 4/23/18.
 */
public class DivideNumber implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {

        if (request.getCalculationWanted() == "div"){
            System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = " + (request.getNumber1() / request.getNumber2()));
        }else {
            System.out.println("Only works for add, sub, mulitply or divide");
        }
    }
}
