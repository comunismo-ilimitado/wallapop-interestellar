package urjc.grupoo.data.shipsData;


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
     *Constructor de Carguero
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
}
