package urjc.grupoo.data.shopData;

import java.io.Serializable;

/*
 * Clase que almacena los datos de licencia del usuario
 */

public class License implements Serializable{

    private Integer TYPE;
    private boolean fraudSuspect;
    private boolean pirateSuspect;


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
