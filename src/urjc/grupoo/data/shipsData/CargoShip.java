package urjc.grupoo.data.shipsData;

public class CargoShip extends Spaceship {
    public DefenceSystem defence;
    public int maxCargo;

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


    public CargoShip(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        super(i, fprop, sprop, num);
    }
}
