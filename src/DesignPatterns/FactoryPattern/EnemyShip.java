package DesignPatterns.FactoryPattern;

/**
 * Created by NISHANT on 4/23/18.
 */
public abstract class EnemyShip {

    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is following teh hero");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + getAmtDamage());
    }
}