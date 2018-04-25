package DesignPatterns.Facade;

/**
 * Created by NISHANT on 4/24/18.
 */
public class SecurityCodeCheck {

    private int securityCode = 1234;

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean isCodeCorrect(int securityCode){
        if (securityCode == getSecurityCode()){
            return true;
        }else {
            return false;
        }
    }
}
