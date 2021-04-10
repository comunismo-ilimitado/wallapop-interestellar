package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceStacionFactory extends ShipFactory {

    public SpaceStacionFactory() {
    }

    public void CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                int passengers, ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {

        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        SpaceStation spacestation = new SpaceStation(Type, crewmembers, prop1, prop2, registernumber, passengers, defencelist, listofships);
    }


}