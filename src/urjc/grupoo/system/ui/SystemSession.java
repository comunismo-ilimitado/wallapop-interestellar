package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
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
    
    
    public void start(){
        this.controller = new WindowController(this);
    }

    public void exit(){
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
