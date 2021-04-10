package urjc.grupoo.data.shopData;

import urjc.grupoo.system.backend.SystemOffersObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import urjc.grupoo.system.backend.ShopSystem;


// ESTA CLASE NO ESTA TERMINADA
public class SystemOffers implements Serializable{
    
    private HashMap<Integer, Offer> offers;
    
    private List<SystemOffersObserver> observers;

    private int lastOffer = 0;
    
    public SystemOffers() {
        offers = new HashMap<>();
        observers = new ArrayList<>();
    }

    public HashMap<Integer, Offer> getOffers() {
        return offers;
    }
    
    public void addOffer(Offer offer, ShopSystem system){
        offers.put(lastOffer, offer);
        offer.setOfferId(lastOffer);
        notifyObservers(offer, system);
        lastOffer += 1;
    }
    
    public void removeOffer(int offerId){
        offers.remove(offerId);
    }
    
    public void notifyObservers(Offer offer, ShopSystem system){
        observers.forEach((obs) -> {
            obs.update(offer, system);
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
