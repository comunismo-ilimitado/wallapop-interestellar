package urjc.grupoo.data.shipsData;

import java.util.ArrayList;
import java.util.Objects;

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

    /**
     * Constructor de Estación Espacial
     * @param type
     * @param i
     * @param fprop
     * @param sprop
     * @param num
     * @param passengers
     * @param defencelist
     * @param listofships
     */
    public SpaceStation(String type, int i, PropulsionType fprop, PropulsionType sprop, String num, int passengers,
            ArrayList<DefenceSystem> defencelist, ArrayList<Spaceship> listofships) {
        super(type, i, fprop, sprop, num);
        setPassengersLimit(passengers);
        setContainedShips(listofships);
        setDefences(defencelist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceStation)) return false;
        if (!super.equals(o)) return false;
        SpaceStation that = (SpaceStation) o;
        return getPassengersLimit() == that.getPassengersLimit() && Objects.equals(getDefences(), that.getDefences()) && Objects.equals(getContainedShips(), that.getContainedShips());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDefences(), getPassengersLimit(), getContainedShips());
    }
}
