package urjc.grupoo.data.shopData;

import urjc.grupoo.system.backend.SystemOffersObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import urjc.grupoo.system.backend.ShopSystem;

/**
 * Clase correspondiente a los sitemas de ofertas
 *
 * @author Sergio
 */
public class SystemOffers implements Serializable {

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

    /**
     * Método para añadir una oferta
     *
     * @param offer
     * @param system
     */
    public void addOffer(Offer offer, ShopSystem system) {
        offers.put(lastOffer, offer);
        offer.setOfferId(lastOffer);
        notifyObservers(offer, system);
        lastOffer += 1;
    }

    /**
     * Método para eliminar una oferta
     *
     * @param offerId
     */
    public void removeOffer(int offerId) {
        offers.remove(offerId);
    }

    /**
     * Método para notificar la oferta
     *
     * @param offer
     * @param system
     */
    public void notifyObservers(Offer offer, ShopSystem system) {
        observers.forEach((obs) -> {
            obs.update(offer, system);
        });
    }

    public void attach(SystemOffersObserver obs) {
        observers.add(obs);
    }

    public void detach(SystemOffersObserver obs) {
        observers.remove(obs);
    }

    public List<SystemOffersObserver> getObservers() {
        return observers;
    }

}
