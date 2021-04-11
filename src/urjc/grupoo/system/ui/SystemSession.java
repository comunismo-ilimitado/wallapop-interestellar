package urjc.grupoo.system.ui;

import java.util.ArrayList;
import java.util.Date;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.ShopSystem;

public class SystemSession {

    private WindowController controller;
    private final ShopSystem system;
    private final ClientFacade clientFacade;
    private final AdminFacade adminFacade;

    public SystemSession() {
        controller = null;
        this.system = new ShopSystem();
        this.system.start();
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);

    }

    public void start() {
        this.controller = new WindowController(this);

        // Para añadir ofertas de prueba descomentar estas lineas
        /*for(int i = 0; i < 15; i++){
            Offer offer = new Offer(new ArrayList<Spaceship>(), new Date(), i, 0, Spaceship.station);
            clientFacade.uploadOffer(0, offer);
        }
        for(int i = 0; i < 10; i++){
            adminFacade.moderateOffer(i, true);
        }*/
    }

    public void exit() {
        system.getDatabase().save();
    }

    public WindowController getController() {
        return controller;
    }

    public ShopSystem getSystem() {
        return system;
    }

    public ClientFacade getClientFacade() {
        return clientFacade;
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

}
