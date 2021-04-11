package urjc.grupoo.system.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.ClientComment;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.data.shopData.SoldSpaceshipRegister;
import urjc.grupoo.data.shopData.SoldSpaceships;
import urjc.grupoo.data.shopData.SystemClients;
import urjc.grupoo.data.shopData.SystemOffers;


public class ClientFacade {
    
    private ShopSystem system;
    
    public ClientFacade(ShopSystem system){
        this.system = system;
    }
    
    
    // Añade un comentario al usario indicado
    public void addComment(int clientId, ClientComment comment){
        SystemClients clients = (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        if(clients.getClientList().containsKey(clientId)){
            Client c = clients.getClientList().get(clientId);
            if(system.getPermissionsManager()
                    .checkPermission(PermissionsManager.Permission.SendComments, c))
                c.getCommentList().add(comment);
        }
    }
    
    // Sube una oferta a moderacion
    public void uploadOffer(int clientId, Offer offer){
        
        // Check permission
        SystemClients clients = (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        if(clients.getClientList().containsKey(clientId)){
            Client c = clients.getClientList().get(clientId);
            if(!system.getPermissionsManager()
                    .checkPermission(PermissionsManager.Permission.UploadOffers, c))
                return;
        }
        
        SystemOffers modoffers = (SystemOffers)system.getDatabase()
                .get(ShopSystem.moderationOfferData);
        modoffers.addOffer(offer, system);
    }
    
    // Guarda un cliente en la lista de clientes
    public void registerClient(Client client){
        SystemClients clients = 
                (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        clients.addClient(client);
    }
    
    
    // TODO cambiar lo de offerType a algo mas estandar
    //Suscribe al cliente a una oferta
    public void suscribeClientTo(int clientId, String offerType){
        
        SystemOffers offers = system.getOffersByType(offerType);
        SystemOffersObserver observer = new SystemOffersObserver(clientId);
        offers.attach(observer);
        
    }
    
    public void unsuscribeClientTo(int clientId, String offerType){
        SystemOffers offers = system.getOffersByType(offerType);
        SystemOffersObserver observer = new SystemOffersObserver(clientId);
        offers.detach(observer);
        
    }
    
    public void buyOffer(int buyerId, int offerId, String offerType){
        // TODO revisar que el buyer y la offerta existen
        //Obtener el cliente
        SystemClients clients = 
                (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        Client c = clients.getClientList().get(buyerId);
        
        // chequear que el usuario puede comprar
        if(!system.getPermissionsManager()
                    .checkPermission(PermissionsManager.Permission.Buy, c))
                return;
        
        // chequear que el usuario puede comprar armas
        if(!offerType.equals("Cargo") && !system.getPermissionsManager()
                    .checkPermission(PermissionsManager.Permission.BuyWeaponizedShip, c))
                return;
        
        //Obtener la oferta
        SystemOffers offers = system.getOffersByType(offerType);
        
        // Borrar la oferta
        Offer offer = offers.getOffers().get(offerId);
        Client s = clients.getClientList().get(offer.getSeller());
        s.getActiveOffers().remove(offer.getOfferId());
        offers.removeOffer(offerId);
        
        // Crear el registro
        SoldSpaceshipRegister reg = new SoldSpaceshipRegister
            (offer.getOfferedSpaceShips(), system.getDate(), s, c, offer.getPrice());
        
        // guardar la nave vendida en el registro
        SoldSpaceships spaceships = (SoldSpaceships)system.getDatabase()
                .get(ShopSystem.soldData);
        spaceships.getSoldSpaceshipList().add(reg);
    }
    
    
    public Client login(String user, String passwd){
        Client c = null;
        
        SystemClients clients = 
                (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        
        boolean found = false;
        Iterator<Client> it = clients.getClientList().values().iterator();
        while(!found && it.hasNext()){
            Client t = it.next();
            if(t.getNick().equals(user)){
                if(t.getPassword().equals(passwd)){
                    c = t;
                    found = true;
                }
            }
        }
        
        
        return c;
    }
    
    public Client getClientInfo(int clientId){
        Client c = null;
        
        SystemClients clients = 
                (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        if(clients.getClientList().containsKey(clientId)){
            c = clients.getClientList().get(clientId);
        }
        return c;
    }
    
    
    // Devuelve la lista de ofertas disponibles de un tipo
    public Collection<Offer> getOffers(String offerType){
        Collection<Offer> roffers = new ArrayList<>();
        
        //Obtener la oferta
        SystemOffers offers = system.getOffersByType(offerType);
        
        roffers = offers.getOffers().values();
        
        return roffers;
    }
    
    
    // Obtiene una offerta con el codigo de oferta
    public Offer getOffer(int offerId, String offerType){
        SystemOffers offers = system.getOffersByType(offerType);
        return offers.getOffers().get(offerId);
    }
    
    
    // Descarta una notificacion
    public void notificationsSeen(int clientId){
        SystemClients clients = 
                (SystemClients)system.getDatabase().get(ShopSystem.clientData);
        if(clients.getClientList().containsKey(clientId)){
            Client c = clients.getClientList().get(clientId);
            c.getNotifications().getNotificationList().clear();
        }
    }
    
}
