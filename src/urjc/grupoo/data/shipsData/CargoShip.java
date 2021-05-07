package urjc.grupoo.data.shipsData;


import java.util.Objects;

public class CargoShip extends Spaceship {

    private DefenceSystem defence;
    private int maxCargo;

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;
    }

    public DefenceSystem getDefence() {
        return defence;
    }

    public void setDefence(DefenceSystem defence) {
        this.defence = defence;
    }

    /**
     * Constructor de Carguero
     *
     * @param type
     * @param i
     * @param fprop
     * @param sprop
     * @param num
     * @param defence
     * @param j
     */
    public CargoShip(String type, int i, PropulsionType fprop, PropulsionType sprop, String num, DefenceSystem defence, int j) {
        super(type, i, fprop, sprop, num);
        setDefence(defence);
        setMaxCargo(j);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoShip)) return false;
        if (!super.equals(o)) return false;
        CargoShip cargoShip = (CargoShip) o;
        return getMaxCargo() == cargoShip.getMaxCargo() && Objects.equals(getDefence(), cargoShip.getDefence());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDefence(), getMaxCargo());
    }
}

