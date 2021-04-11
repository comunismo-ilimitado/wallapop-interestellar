package urjc.grupoo.system.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.data.shopData.SystemClients;

public class SystemOffersObserver implements Serializable {

    private int clientId = -1;

    public SystemOffersObserver(int clientId) {
        this.clientId = clientId;
    }

    // Updates the client notifications
    public void update(Offer offer, ShopSystem system) {

        SystemClients clients
                = (SystemClients) system.getDatabase().get(ShopSystem.clientData);
        if (clients.getClientList().containsKey(clientId)) {
            Client c = clients.getClientList().get(clientId);
            c.notifyOffer(offer);
        }
    }

    public int getClientId() {
        return clientId;
    }

}
