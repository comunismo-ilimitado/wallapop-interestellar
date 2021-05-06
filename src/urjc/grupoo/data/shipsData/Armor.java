package urjc.grupoo.data.shipsData;


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


    public boolean equals(DefenceSystem x) {
        boolean a = false;
        boolean b = false;
        boolean c = false;

        if (this.getDefenceType()==x.getDefenceType()){
            Armor o = (Armor) x;
             a = this.getAddedWeigth()==o.getAddedWeigth();
             b = this.getMaterial()==o.getMaterial();
             c= this.getDamageAllowed()==o.getDamageAllowed();
        }
        return  a && b && c;
    }

}
