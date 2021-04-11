package urjc.grupoo.data.shipsData;

public abstract class DefenceSystem {

    private double damageAllowed;

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
