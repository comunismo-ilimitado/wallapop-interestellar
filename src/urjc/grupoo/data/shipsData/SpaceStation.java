package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceStation extends Spaceship {

    public ArrayList<DefenceSystem> defences;
    public int passengersLimit;
    public ArrayList<Spaceship> containedShips;

    public int getPassengersLimit() {
        return passengersLimit;
    }

    public void setPassengersLimit(int passengersLimit) {
        this.passengersLimit = passengersLimit;
    }

    public ArrayList<Spaceship> getContainedShips() {
        return containedShips;
    }

    public void setContainedShips(ArrayList<Spaceship> containedShips) {
        this.containedShips = containedShips;
    }

    public ArrayList<DefenceSystem> getDefences() {
        return defences;
    }

    public void setDefences(ArrayList<DefenceSystem> defences) {
        this.defences = defences;
    }

    public SpaceStation(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num, int passengers,
                        ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {
        super(i, fprop, sprop, num);
        setPassengersLimit(passengers);
        setContainedShips(listofships);
        setDefences(defencelist);
    }
}
