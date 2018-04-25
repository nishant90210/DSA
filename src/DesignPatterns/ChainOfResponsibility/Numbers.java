package DesignPatterns.ChainOfResponsibility;

/**
 * Created by NISHANT on 4/23/18.
 */
public class Numbers {

    private int number1;
    private int number2;
    private String calculationWanted;

    public Numbers(int number1, int number2, String calculationWanted) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculationWanted = calculationWanted;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getCalculationWanted() {
        return calculationWanted;
    }
}
