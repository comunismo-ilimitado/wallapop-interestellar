package urjc.grupoo.data.shipsData;

import java.io.Serializable;
import java.util.Objects;

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

    public boolean equals(DefenceSystem o){
        boolean a= false;
        if (this.defenceType==Spaceship.armor){
            Armor that = (Armor) this;
            a = that.equals(o);
        }
        if (this.defenceType==Spaceship.shield){
            Shield that = (Shield) this;
            a = that.equals(o);
        }
        return a;
    }


}
