package urjc.grupoo.system.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import urjc.grupoo.data.shopData.Offer;


public class SystemOffersObserver implements Serializable{

    private int clientId = -1;
    
    
    private List<Offer> offersToNotify;
    
    public SystemOffersObserver(int clientId) {
        this.clientId = clientId;
        offersToNotify = new ArrayList<>();
    }
    
    
    // Updates the client notifications
    public void update(Offer offer){
        offersToNotify.add(offer);
    }

    public List<Offer> getOffersToNotify() {
        return offersToNotify;
    }
    
    
    
}
