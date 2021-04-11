package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceStation extends Spaceship {

    private ArrayList<DefenceSystem> defences;
    private int passengersLimit;
    private ArrayList<Spaceship> containedShips;

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

    public SpaceStation(String type, int i, PropulsionType fprop, PropulsionType sprop, String num, int passengers,
            ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {
        super(type, i, fprop, sprop, num);
        setPassengersLimit(passengers);
        setContainedShips(listofships);
        setDefences(defencelist);
    }
}
