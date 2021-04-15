package urjc.grupoo.data.shipsData;


public class CargoShipFactory extends ShipFactory {

    public CargoShipFactory() {
    }

    /**
     * Función que nos devuelve un Carguero con la información dada
     * @param Type
     * @param crewmembers
     * @param propname1
     * @param maxSpeed1
     * @param propname2
     * @param maxSpeed2
     * @param registernumber
     * @param defence
     * @param cargo
     * @return Spaceship
     */
    public Spaceship CreateSpaceship(String Type, int crewmembers, String propname1, Double maxSpeed1, String propname2, Double maxSpeed2, String registernumber,
            DefenceSystem defence, int cargo) {

        PropulsionType prop1 = new PropulsionType(maxSpeed1, propname1);
        PropulsionType prop2 = new PropulsionType(maxSpeed2, propname2);
        CargoShip cargoship = new CargoShip(Type, crewmembers, prop1, prop2, registernumber, defence, cargo);
        return cargoship;

    }

}
