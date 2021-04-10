package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceFighterFactory extends ShipFactory {

    public SpaceFighterFactory() {
    }


    public void CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                ArrayList<Weapon> weaponlist, DefenceSystem defence) {

        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        SpaceFighter spacefighter = new SpaceFighter(Type, crewmembers, prop1, prop2, registernumber, weaponlist, defence);
    }

}
