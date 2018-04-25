package DesignPatterns.ChainOfResponsibility;

/**
 * Created by NISHANT on 4/23/18.
 */
public interface Chain {

    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);
}
