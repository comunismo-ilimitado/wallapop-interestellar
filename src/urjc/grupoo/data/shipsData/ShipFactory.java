package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class ShipFactory {

    
    /**
     * Crea un destructor
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param weaponlist
     * @param defencelist
     * @return 
     */
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

    /**
     * Crea un carguero
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param defence
     * @param cargo
     * @return 
     */
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

    /**
     * Crea una estacion espacial
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
     * @return 
     */
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

    /**
     * Crea un caza
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param weaponlist
     * @param defence
     * @return 
     */
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

    /**
     * Crea un arma
     * @param weaponName
     * @param weaponDamage
     * @return 
     */
    public Weapon CreateWeapon(String weaponName, double weaponDamage) {
        Weapon weapon = new Weapon(weaponName, weaponDamage);
        return weapon;
    }

    /**
     * Crea un blindaje
     * @param damageAllowed
     * @param weigth
     * @param material
     * @return 
     */
    public DefenceSystem CreateDefence(double damageAllowed, double weigth, String material) {
        Armor defence = new Armor(damageAllowed, weigth, material);
        return defence;
    }

    /**
     * Crea un escudo
     * @param damageAllowed
     * @param neededEnergy
     * @return 
     */
    public DefenceSystem CreateDefence(double damageAllowed, double neededEnergy) {
        Shield defence = new Shield(damageAllowed, neededEnergy);
        return defence;
    }


}