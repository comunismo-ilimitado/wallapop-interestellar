package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.backend.ClientFacade;

public class ClientMenuController {

    private final WindowController controller;
    private final ClientFacade facade;
    private final Client client;
    
    public ClientMenuController(Client client, ClientFacade facade, WindowController controller) {
        this.controller = controller;
        this.client = client;
        this.facade = facade;
    }

    public void selectOperation(){
        controller.showClientMenu();
    }
}
