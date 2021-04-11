package urjc.grupoo.data.shopData;

import java.io.Serializable;

/*
 * Clase que almacena los datos de licencia del usuario
 */
public class License implements Serializable {

    private Integer TYPE = 0;
    private boolean fraudSuspect = false;
    private boolean pirateSuspect = false;

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

    public void setPirateSuspect(boolean pirateSuspect) {
        this.pirateSuspect = pirateSuspect;
    }

}
