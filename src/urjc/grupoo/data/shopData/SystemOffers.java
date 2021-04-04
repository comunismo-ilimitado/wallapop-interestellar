package urjc.grupoo.data.shopData;

import urjc.grupoo.system.backend.SystemOffersObserver;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


// ESTA CLASE NO ESTA TERMINADA
public class SystemOffers implements Serializable{
    
    private HashMap<Integer, Offer> offers;
    
    private List<SystemOffersObserver> observers;

    private int lastOffer = 0;
    
    public SystemOffers() {
        offers = new HashMap<>();
    }

    public HashMap<Integer, Offer> getOffers() {
        return offers;
    }
    
    public void addOffer(Offer offer){
        offers.put(lastOffer, offer);
        notifyObservers(offer);
        lastOffer += 1;
    }
    
    public void removeOffer(int offerId){
        offers.remove(offerId);
    }
    
    public void notifyObservers(Offer offer){
        observers.forEach((obs) -> {
            obs.update(offer);
        });
    }
    public void attach(SystemOffersObserver obs){
        observers.add(obs);
    }
    public void detach(SystemOffersObserver obs){
        observers.remove(obs);
    }

    public List<SystemOffersObserver> getObservers() {
        return observers;
    }
    
}
