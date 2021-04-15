package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceStationFactory extends ShipFactory {

    public SpaceStationFactory() {
    }

    /**
     * Función que devuelve una Estación Espacial con los parámetros proporcionados
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param passengers
     * @param defencelist
     * @param listofships
     * @return Spaceship
     */
    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
            int passengers, ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {

        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        SpaceStation spacestation = new SpaceStation(Type, crewmembers, prop1, prop2, registernumber, passengers, defencelist, listofships);
        return spacestation;
    }

}
