package DesignPatterns.Facade;

/**
 * Created by NISHANT on 4/24/18.
 */
public class AccountNumberCheck {

    private int accounNumber = 12345678;

    public int getAccounNumber() {
        return accounNumber;
    }

    public boolean accountActive(int accounNumber){
        if (accounNumber == getAccounNumber()){
            return true;
        }else {
            return false;
        }
    }
}
