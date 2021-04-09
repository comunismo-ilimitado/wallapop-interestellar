package urjc.grupoo.data.shipsData;

public class Shield extends DefenceSystem {

    public double neededEnergy;

    public Shield(double i, double j) {
        super(i);
        setNeededEnergy(j);

    }

    public double getNeededEnergy() {
        return neededEnergy;
    }

    public void setNeededEnergy(double neededEnergy) {
        this.neededEnergy = neededEnergy;
    }

}
