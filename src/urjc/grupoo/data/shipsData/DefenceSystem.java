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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefenceSystem)) return false;
        DefenceSystem that = (DefenceSystem) o;
        return Double.compare(that.getDamageAllowed(), getDamageAllowed()) == 0 && Objects.equals(getDefenceType(), that.getDefenceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDamageAllowed(), getDefenceType());
    }
}
