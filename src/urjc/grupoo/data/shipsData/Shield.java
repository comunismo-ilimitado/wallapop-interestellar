package urjc.grupoo.data.shipsData;

public class Shield extends DefenceSystem{
    public double getNeededEnergy() {
        return neededEnergy;
    }

    public void setNeededEnergy(double neededEnergy) {
        this.neededEnergy = neededEnergy;
    }

    public double neededEnergy;
}
