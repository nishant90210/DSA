package DesignPatterns.ATMType.Design;

public interface AtmMachineState {

    void insertDebitCard();
    void ejectDebitCard();
    void enterPinAndWithdrawMoney();
}
