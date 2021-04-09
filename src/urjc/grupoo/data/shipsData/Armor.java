package urjc.grupoo.data.shipsData;

public class Armor extends DefenceSystem {

    private Double addedWeigth;
    private String material;

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


}
