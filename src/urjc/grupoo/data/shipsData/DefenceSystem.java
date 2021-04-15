package urjc.grupoo.data.shipsData;

import java.io.Serializable;

/**
 *Clase Abstracta de la que derivan Blindaje y Escudo.
 */
public abstract class DefenceSystem implements Serializable {

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
