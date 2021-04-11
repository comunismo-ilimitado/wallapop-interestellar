package urjc.grupoo.system.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.data.shopData.SystemAdmins;
import urjc.grupoo.data.shopData.SystemClients;
import urjc.grupoo.data.shopData.SystemOffers;

public class AdminFacade {

    private ShopSystem system;

    public AdminFacade(ShopSystem system) {
        this.system = system;
    }

    // Devuelve el administrador
    public Admin login(String user, String passwd) {
        Admin c = null;

        SystemAdmins admins
                = (SystemAdmins) system.getDatabase().get(ShopSystem.adminData);

        c = admins.getAdmin(user);
        return c;
    }

    public Collection<Offer> getModerationList() {
        Collection<Offer> roffers = new ArrayList<>();

        SystemOffers offers = (SystemOffers) system.getDatabase()
                .get(ShopSystem.moderationOfferData);

        roffers = offers.getOffers().values();

        return roffers;
    }

    public void moderateOffer(int offerId, boolean pass) {

        SystemOffers offers = (SystemOffers) system.getDatabase()
                .get(ShopSystem.moderationOfferData);

        //Borrar oferta de moderacion
        Offer offer = offers.getOffers().get(offerId);
        offers.removeOffer(offerId);

        if (pass) {
            // Añadir oferta a la lista correspondiente
            system.getOffersByType(offer.getOfferType()).addOffer(offer, system);

            // Añadir oferta al usuario
            SystemClients clients
                    = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
            if (clients.getClientList().containsKey(offer.getSeller())) {
                clients.getClientList().get(offer.getSeller())
                        .getActiveOffers().put(offer.getOfferId(), offer);
            }
        }
    }

    // Se registra a un usuario como posible fraude
    public void reportUserOfFraud(int clientId) {
        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        if (clients.getClientList().containsKey(clientId)) {
            Client client = clients.getClientList().get(clientId);
            client.getLicense().setFraudSuspect(true);
        }
    }

    // Se registra a un usuario como posible  pirata
    public void reportUserOfPiracy(int clientId) {
        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        if (clients.getClientList().containsKey(clientId)) {
            Client client = clients.getClientList().get(clientId);
            client.getLicense().setPirateSuspect(true);
        }
    }

    // El usuario deja de estar reportado por fraude
    public void resolveUserReportOfFraud(int clientId) {
        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        if (clients.getClientList().containsKey(clientId)) {
            Client client = clients.getClientList().get(clientId);
            client.getLicense().setFraudSuspect(false);
        }
    }

    // El usuario deja de estar reportado por pirateria
    public void resolveUserReportOfPiracy(int clientId) {
        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        if (clients.getClientList().containsKey(clientId)) {
            Client client = clients.getClientList().get(clientId);
            client.getLicense().setPirateSuspect(false);
        }
    }

    // Guarda un cliente en la lista de admines
    public void registerAdmin(Admin admin) {
        SystemAdmins admins
                = (SystemAdmins) system.getDatabase().get(ShopSystem.adminData);
        admins.getAdminList().add(admin);
    }
}
