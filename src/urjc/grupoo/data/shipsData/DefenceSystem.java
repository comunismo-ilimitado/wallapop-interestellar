package urjc.grupoo.data.shipsData;

public abstract class DefenceSystem {

    private double damageAllowed;
    private String defenceType;

    public String getDefenceType() {
        return defenceType;
    }

    public void setDefenceType(String defenceType) {
        this.defenceType = defenceType;
    }

    public DefenceSystem(double i) {
        this.setDamageAllowed(i);
    }

    public double getDamageAllowed() {
        return damageAllowed;
    }

    public void setDamageAllowed(double damageAllowed) {
        this.damageAllowed = damageAllowed;
    }


}
