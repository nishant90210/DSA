package DesignPatterns.Facade;

/**
 * Created by NISHANT on 4/24/18.
 */
public class FundsCheck {

    private double cashInAccount = 1000.00;

    public double getCashInAccount() {
        return cashInAccount;
    }

    public void decreaseCashInAccount(double cashWithdrawn){

        cashInAccount -= cashWithdrawn;
    }

    public void increaseCashInAccount(double cashDeposit){

        cashInAccount += cashDeposit;
    }

    public boolean haveEnoughMoney(double cashWithdrawal){

        if (cashWithdrawal > getCashInAccount()){
            System.out.println("Not enough money");
            System.out.println("Current balance : "+ getCashInAccount());
            return false;
        }else {
            decreaseCashInAccount(cashWithdrawal);
            System.out.println("Complete : " + getCashInAccount());
            return true;
        }
    }

    public void makeDeposit(double cashToDeposit) {

        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit Complete : " + getCashInAccount());

    }
}
