package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class DestructorFactory extends ShipFactory {

    public DestructorFactory() {
    }

    /**
     *Función que devuelve un Destructor con los parámetros proporcionados
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param weaponlist
     * @param defencelist
     * @return Spaceship
     */
    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
            ArrayList<Weapon> weaponlist, ArrayList<DefenceSystem> defencelist) {

        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        Destructor destructor = new Destructor(Type, crewmembers, prop1, prop2, registernumber, weaponlist, defencelist);
        return destructor;
    }
}
