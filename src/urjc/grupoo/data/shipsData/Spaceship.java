package urjc.grupoo.data.shipsData;

import java.io.Serializable;
import java.util.ArrayList;

public class Spaceship implements Serializable {

    private String registerNumber;
    private int crewMembersAmount;
    private PropulsionType firstpropulsion;
    private PropulsionType secondpropulsion;
    private String type;

    public static final String station = "Estación espacial", cargo = "Carguero", destructor = "Destructor", fighter = "Caza",
            plasmacannon = "Cañón de plasma", thermonuclearmissiles = "Misiles termonucleares", laserbeams = "Rayos láser", pem = "PEM",
            warpdrive = "Motor de curvatura", tracecompressor = "Compresor de traza", ftldrive = "Motor FTL", solarsail = "Velas solares",
            ionthruster = "Motor iónico", seat = "Seat Panda intergaláctico", motorm = "Motor de pedos de marciano", uwu = "UWU",
            shield = "Escudo", armor = "Blindaje";

    /**
     * Constructor de Nave Espacial
     * @param type
     * @param i
     * @param fprop
     * @param sprop
     * @param num
     */
    public Spaceship(String type, int i, PropulsionType fprop, PropulsionType sprop, String num) {
        setType(type);
        setCrewMembersAmount(i);
        setFirstpropulsion(fprop);
        setSecondpropulsion(sprop);
        setRegisterNumber(num);
    }

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


    public ArrayList<Weapon> getWeaponList() {
        ArrayList<Weapon> list = new ArrayList<>();
        if ((this.getType() == this.fighter) || (this.getType() == this.destructor)) {
            if (this.getType() == this.fighter) {
                SpaceFighter ship2 = (SpaceFighter) this;
                list = ship2.getWeapons();
            }
            if (this.getType() == this.destructor) {
                Destructor ship2 = (Destructor) this;
                list = ship2.getWeapons();
            }
        } else {
            return null;
        }
        return list;
    }

    public ArrayList<DefenceSystem> getDefenceList() {
        ArrayList<DefenceSystem> list = new ArrayList<>();
        if (this.getType() == this.cargo) {
            CargoShip ship2 = (CargoShip) this;
            list.add(ship2.getDefence());
        }
        if (this.getType() == this.fighter) {
            SpaceFighter ship2 = (SpaceFighter) this;
            list.add(ship2.getDefence());
        }
        if (this.getType() == this.station) {
            SpaceStation ship2 = (SpaceStation) this;
            list = ship2.getDefences();
        }
        if (this.getType() == this.destructor) {
            Destructor ship2 = (Destructor) this;
            list = ship2.getDefences();
        }
        return list;
    }

    public ArrayList<Spaceship> getSpaceshipList() {
        ArrayList<Spaceship> list = new ArrayList<>();
        if (this.getType() == this.station) {
            SpaceStation ship2 = (SpaceStation) this;
            list = ship2.getContainedShips();
        } else {
            return null;
        }
        return list;
    }

    public int getPassengersLimit() {
        if (this.getType() == this.station) {
            SpaceStation ship2 = (SpaceStation) this;
            return ship2.getPassengersLimit();
        } else {
            return 0;
        }
    }

    public int getMaxCargo() {
        if (this.getType() == this.cargo) {
            CargoShip ship2 = (CargoShip) this;
            return ship2.getMaxCargo();
        } else {
            return 0;
        }

    }

}
