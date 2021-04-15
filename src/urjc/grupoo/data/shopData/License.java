package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que almacena los datos de licencia del usuario
 *
 * @author Sergio
 */
public class License implements Serializable {

    private Integer TYPE = 0;
    private boolean fraudSuspect = false;
    private boolean pirateSuspect = false;
    private boolean buysWeapon = true;
    private boolean banned = false;
    private Date lastBanned;
    private Integer warned = 0;

    public License() {
        TYPE = 0;
        fraudSuspect = false;
        pirateSuspect = false;
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public boolean isFraudSuspect() {
        return fraudSuspect;
    }

    public boolean isPirateSuspect() {
        return pirateSuspect;
    }

    public void setFraudSuspect(boolean fraudSuspect) {
        this.fraudSuspect = fraudSuspect;
    }

    public Integer getWarned() {
        return warned;
    }

    public void setWarned(Integer warned) {
        this.warned = warned;
    }

    public boolean isBuysWeapon() {
        return buysWeapon;
    }

    public void setBuysWeapon(boolean buysWeapon) {
        this.buysWeapon = buysWeapon;
    }

    public boolean isBanned() {
        return banned;
    }

    public Date getLastBanned() {
        return lastBanned;
    }

    public void setLastBanned(Date lastBanned) {
        this.lastBanned = lastBanned;
    }
    
    

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    
    

    public void setPirateSuspect(boolean pirateSuspect) {
        this.pirateSuspect = pirateSuspect;
    }

}
