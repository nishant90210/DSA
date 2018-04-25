package DesignPatterns.FactoryPattern;

/**
 * Created by NISHANT on 4/23/18.
 */

// This is a factory thats only job is creating ships
// By encapsulating ship creation, we only have one
// place to make modifications
public class EnemyShipFactoryTest {

    // This could be used as a static method if we
    // are willing to give up subclassing it
    public EnemyShip makeEnemyShip(String newShipType) {

        if (newShipType.equalsIgnoreCase("u")){
            return new UFOEnemyShip();
        } else if (newShipType.equalsIgnoreCase("r")){
            return new RocketEnemyShip();
        }else if (newShipType.equalsIgnoreCase("b")){
            return new BigUFOEnemyShip();
        }else {
            return null;
        }
    }
}
