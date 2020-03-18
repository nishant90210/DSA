package DesignPatterns.ATMType.Design;

public class AtmClient {

    public static void main(String[] args) {
        /*
         * Initially ATMType Machine in 'noDebitCardState'
         */
        AtmMachine atmMachine = new AtmMachine();

        System.out.println("ATMType Machine Current state : " + atmMachine.getAtmMachineState().getClass().getName());

        System.out.println();
        atmMachine.enterPinAndWithdrawMoney();
        atmMachine.ejectDebitCard();
        atmMachine.insertDebitCard();

        System.out.println("\n*******************************************************");

        /*
         * Debit Card has been inserted so internal state of ATMType Machine
         * has been changed to 'hasDebitCardState'
         */
        System.out.println("\nATMType Machine Current state : "
                + atmMachine.getAtmMachineState().getClass().getName());
        System.out.println();

        atmMachine.enterPinAndWithdrawMoney();
        atmMachine.insertDebitCard();
        atmMachine.ejectDebitCard();
        System.out.println("\n*******************************************************");

        /*
         * Debit Card has been ejected so internal state of ATMType Machine
         * has been changed to 'noDebitCardState'
         */

        System.out.println("\nATMType Machine Current state : "
                + atmMachine.getAtmMachineState().getClass().getName());

    }
}
