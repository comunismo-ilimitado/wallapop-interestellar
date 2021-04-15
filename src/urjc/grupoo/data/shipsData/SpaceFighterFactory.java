package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceFighterFactory extends ShipFactory {

    public SpaceFighterFactory() {
    }

    /**
     * Función que devuelve un caza con los parámetros proporcionados
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param weaponlist
     * @param defence
     * @return Spaceship
     */
    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                     ArrayList<Weapon> weaponlist, DefenceSystem defence) {
        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        SpaceFighter spacefighter = new SpaceFighter(Type, crewmembers, prop1, prop2, registernumber, weaponlist, defence);
        return spacefighter;
    }

}
