package urjc.grupoo.data.shipsData;

import java.io.Serializable;
import java.util.ArrayList;


public class Spaceship implements Serializable {

    private String registerNumber;
    private int crewMembersAmount;
    private PropulsionType firstpropulsion;
    private PropulsionType secondpropulsion;
    private String type;

    public static final String station = "Station", cargo = "Cargo", destructor = "Destructor", fighter = "Fighter",
            plasmacannon = "Plasma cannon", thermonuclearmissiles = "Thermonuclear missiles", laserbeams = "Laser beams", pem = "PEM",
            warpdrive = "Warp drive", tracecompressor = " Trace compressor", ftldrive = "FTL drive", solarsail = "Solar sail", ionthruster = "Ion thruster,",
            shield = "Shield", armor = "Armor";


    public int getCrewMembersAmount() {
        return crewMembersAmount;
    }

    public void setCrewMembersAmount(int crewMembersAmount) {
        this.crewMembersAmount = crewMembersAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropulsionType getFirstpropulsion() {
        return firstpropulsion;
    }

    public void setFirstpropulsion(PropulsionType firstpropulsion) {
        this.firstpropulsion = firstpropulsion;
    }

    public PropulsionType getSecondpropulsion() {
        return secondpropulsion;
    }

    public void setSecondpropulsion(PropulsionType secondpropulsion) {
        this.secondpropulsion = secondpropulsion;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public Spaceship(String type, int i, PropulsionType fprop, PropulsionType sprop, String num) {
        setType(type);
        setCrewMembersAmount(i);
        setFirstpropulsion(fprop);
        setSecondpropulsion(sprop);
        setRegisterNumber(num);
    }

    public ArrayList<Weapon> getWeaponList(Spaceship ship) {
        ArrayList<Weapon> list = new ArrayList<>();
        if ((ship.getType() == ship.fighter) || (ship.getType() == ship.destructor)) {
            if (ship.getType() == ship.fighter) {
                SpaceFighter ship2 = (SpaceFighter) ship;
                list = ship2.getWeapons();
            }
            if (ship.getType() == ship.destructor) {
                Destructor ship2 = (Destructor) ship;
                list = ship2.getWeapons();
            }
        } else {
            return null;
        }
        return list;
    }

    public ArrayList<DefenceSystem> getDefenceList(Spaceship ship) {
        ArrayList<DefenceSystem> list = new ArrayList<>();
        if (ship.getType() == ship.cargo) {
            CargoShip ship2 = (CargoShip) ship;
            list.add(ship2.getDefence());
        }
        if (ship.getType() == ship.fighter) {
            SpaceFighter ship2 = (SpaceFighter) ship;
            list.add(ship2.getDefence());
        }
        if (ship.getType() == ship.station) {
            SpaceStation ship2 = (SpaceStation) ship;
            list = ship2.getDefences();
        }
        if (ship.getType() == ship.destructor) {
            Destructor ship2 = (Destructor) ship;
            list = ship2.getDefences();
        }
        return list;
    }

    public ArrayList<Spaceship> getSpaceshipList(Spaceship ship) {
        ArrayList<Spaceship> list = new ArrayList<>();
        if (ship.getType() == ship.station) {
            SpaceStation ship2 = (SpaceStation) ship;
            list = ship2.getContainedShips();
        } else {return null;}
        return list;
    }

}
