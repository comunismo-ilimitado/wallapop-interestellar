package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms;

import java.util.ArrayList;
import urjc.grupoo.data.shipsData.DefenceSystem;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shipsData.Weapon;

/**
 *
 * @author Gonzalo Ortega
 */
public class ShipCreationHandler {

    private Spaceship newShip;
    private String type;
    private String regNumber;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    private int crewNumber;
    private int passangerNumber;
    private int cargoCapacity;
    private String propulsion1;
    private String propulsion2;
    private final ArrayList<Weapon> weaponList = new ArrayList<>();
    private String defenceType;
    private final ArrayList<DefenceSystem> defenceList = new ArrayList<>();
    private final ArrayList<Spaceship> shipList = new ArrayList<>();
    private int stationCounter = 0;

    public void addStationCounter() {
        stationCounter++;
    }

    public int getStationCounter() {
        return stationCounter;
    }

    public void removeStationCounter() {
        stationCounter--;
    }

    public String getDefenceType() {
        return defenceType;
    }

    public void setDefenceType(String defenceType) {
        this.defenceType = defenceType;
    }

    public String getPropulsion1() {
        return propulsion1;
    }

    public void setPropulsion1(String propulsion1) {
        this.propulsion1 = propulsion1;
    }

    public String getPropulsion2() {
        return propulsion2;
    }

    public void setPropulsion2(String propulsion2) {
        this.propulsion2 = propulsion2;
    }

    public Spaceship getNewShip() {
        return newShip;
    }

    public String getType() {
        return type;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getCrewNumber() {
        return crewNumber;
    }

    public int getPassangerNumber() {
        return passangerNumber;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public ArrayList<Weapon> getWeaponList() {
        return weaponList;
    }

    public ArrayList<DefenceSystem> getDefenceList() {
        return defenceList;
    }

    public ArrayList<Spaceship> getShipList() {
        return shipList;
    }

    public void setNewShip(Spaceship newShip) {
        this.newShip = newShip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setCrewNumber(int crewNumber) {
        this.crewNumber = crewNumber;
    }

    public void setPassangerNumber(int passangerNumber) {
        this.passangerNumber = passangerNumber;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void addWeapon(Weapon newWeapon) {
        weaponList.add(newWeapon);
    }

    public void addDefenceSystem(DefenceSystem newDefenceSystem) {
        defenceList.add(newDefenceSystem);
    }

    public void addShip(Spaceship newship) {
        shipList.add(newship);
    }

    public void onShipCreated(Spaceship ship) {

    }

}
