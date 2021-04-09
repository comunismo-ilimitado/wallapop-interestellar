package urjc.grupoo.data.shipsData;

public class CargoShip extends Spaceship{
    public int maxCargo;
    public DefenceSystem defence;

    public CargoShip(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        super(i, fprop, sprop, num);
    }
}
