package urjc.grupoo.data.shipsData;


import java.util.Objects;

public class Armor extends DefenceSystem {

    private Double addedWeigth;
    private String material;

    /**
     *Constructor de Blindaje
     * @param i
     * @param j
     * @param str
     */
    public Armor(double i, double j, String str) {

        super(i);
        setAddedWeigth(j);
        setMaterial(str);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getAddedWeigth() {
        return addedWeigth;
    }

    public void setAddedWeigth(Double addedWeigth) {
        this.addedWeigth = addedWeigth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;
        if (!super.equals(o)) return false;
        Armor armor = (Armor) o;
        return Objects.equals(getAddedWeigth(), armor.getAddedWeigth()) && Objects.equals(getMaterial(), armor.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAddedWeigth(), getMaterial());
    }
}
