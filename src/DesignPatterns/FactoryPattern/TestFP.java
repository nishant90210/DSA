package DesignPatterns.FactoryPattern;

import java.util.Scanner;

/**
 * Created by NISHANT on 4/23/18.
 */
public class TestFP {

    public static void main(String[] args) {

        EnemyShip theEnemy = null;
        //Create the factory object
        EnemyShipFactoryTest enemyShipFactoryTest = new EnemyShipFactoryTest();
        Scanner userInput = new Scanner(System.in);
        System.out.print("What type of ship? (U / R / B)");
        if (userInput.hasNextLine()){
            String typeOfShip = userInput.nextLine();
            theEnemy = enemyShipFactoryTest.makeEnemyShip(typeOfShip);
            if(theEnemy != null){
                doStuff(theEnemy);
            } else System.out.print("Please enter U, R, or B next time");
        }



    }

    // Executes methods of the super class
    private static void doStuff(EnemyShip enemyShip) {

        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}
