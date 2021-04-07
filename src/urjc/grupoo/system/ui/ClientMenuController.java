package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;

public class ClientMenuController {

    private final WindowController controller;
    private Client client;

    public ClientMenuController(Client client, WindowController controller) {
        this.controller = controller;
        this.client = client;
 
    }

    public void selectOperation(){
        controller.showClientMenu();

    }
}
