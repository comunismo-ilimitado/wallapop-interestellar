package urjc.grupoo.system.backend;

import java.util.Date;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.data.shopData.SystemClients;
import urjc.grupoo.data.shopData.SystemOffers;
import urjc.grupoo.system.ui.SystemSession;


public class Manager {

    ShopSystem system;
    
    private static int DAYS = 5;
    
    public Manager(ShopSystem system) {
        this.system = system;
    }
    
    public void removeExpiredOffers(){
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date d = new Date(System.currentTimeMillis() - (DAYS * DAY_IN_MS));
        
        SystemOffers offers = system.getOffersByType(Spaceship.cargo);
        internalRemoveOffers(offers, d);
        
        offers = system.getOffersByType(Spaceship.destructor);
        internalRemoveOffers(offers, d);
        
        offers = system.getOffersByType(Spaceship.fighter);
        internalRemoveOffers(offers, d);
        
        offers = system.getOffersByType(Spaceship.station);
        internalRemoveOffers(offers, d);
        
    }
    
    
    // Borra todas las ofertas expiradas
    private void internalRemoveOffers(SystemOffers offers, Date date){
        for(int i : offers.getOffers().keySet()){
            Offer o = offers.getOffers().get(i);
            if(o.getLimitDate().before(date)){
                offers.removeOffer(o.getOfferId());
            }
        }
    }
    
    
    // Desbanea a los usuarios
    public void unbanClients(){
        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date d = new Date(System.currentTimeMillis() - (DAYS * DAY_IN_MS));
        
        for(int i : clients.getClientList().keySet()){
            Client c = clients.getClientList().get(i);
            if(c.getLicense().isBanned() && c.getLicense().getLastBanned().before(d)){
                c.getLicense().setBanned(false);
            }
        }
    }
    
    public void run(){
        unbanClients();
        removeExpiredOffers();
    }
}
