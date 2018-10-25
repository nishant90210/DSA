package DesignPatterns.ChainOfResponsibility;

/**
 * Created by NISHANT on 4/23/18.
 */
public class SubstractNumber implements Chain{

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {

        if (request.getCalculationWanted() == "sub"){
            System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = " + (request.getNumber1() - request.getNumber2()));
        }else {
            nextInChain.calculate(request);
        }
    }
}
