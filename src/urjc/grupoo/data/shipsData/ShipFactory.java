package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public abstract class ShipFactory {

    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                     ArrayList<Weapon> weaponlist, ArrayList<DefenceSystem> defencelist) {
        if (Type == Spaceship.destructor) {
            DestructorFactory destructorfactory = new DestructorFactory();
            return destructorfactory.CreateSpaceship(Type, crewmembers, propname1, maxSpeed1, propname2, maxSpeed2, registernumber,
                    weaponlist, defencelist);
        } else {
            return null;
        }
    }


    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                     DefenceSystem defence, int cargo) {
        if (Type == Spaceship.cargo) {
            CargoShipFactory cargofactory = new CargoShipFactory();
            return cargofactory.CreateSpaceship(Type, crewmembers, propname1, maxSpeed1, propname2, maxSpeed2, registernumber,
                    defence, cargo);
        } else {
            return null;

        }


    }

    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                     int passengers, ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {
        if (Type == Spaceship.station) {
            SpaceStationFactory spacestationfactory = new SpaceStationFactory();
            return spacestationfactory.CreateSpaceship(Type, crewmembers, propname1, maxSpeed1, propname2, maxSpeed2, registernumber,
                    passengers, defencelist, listofships
            );
        } else {
            return null;

        }
    }

    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
                                     ArrayList<Weapon> weaponlist, DefenceSystem defence) {
        if (Type == Spaceship.fighter) {
            SpaceFighterFactory spaceFighterFactory = new SpaceFighterFactory();
            return spaceFighterFactory.CreateSpaceship(Type, crewmembers, propname1, maxSpeed1, propname2, maxSpeed2, registernumber,
                    weaponlist, defence
            );
        } else {
            return null;

        }

    }

    public Weapon CreateWeapon(String str, double i) {
        Weapon weapon = new Weapon(str, i);
        return weapon;
    }

    public DefenceSystem Createdefence(double i, double j, String str) {
        Armor defence = new Armor(i, j, str);
        return defence;
    }

    public DefenceSystem Createdefence(double i, double j) {
        Shield defence = new Shield(i, j);
        return defence;
    }


}