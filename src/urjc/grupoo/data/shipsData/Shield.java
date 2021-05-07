package urjc.grupoo.data.shipsData;

import java.util.Objects;

public class Shield extends DefenceSystem {

    private double neededEnergy;

    /**
     * Cosntructor de Escudo
     * @param i
     * @param j
     */
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shield)) return false;
        if (!super.equals(o)) return false;
        Shield shield = (Shield) o;
        return Double.compare(shield.getNeededEnergy(), getNeededEnergy()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNeededEnergy());
    }
}
