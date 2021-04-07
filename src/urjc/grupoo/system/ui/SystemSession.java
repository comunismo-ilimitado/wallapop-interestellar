package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.ShopSystem;

public class SystemSession {

    private final WindowController controller;
    private boolean active = true;
    private ShopSystem system;
    private ClientFacade clientFacade;
    private AdminFacade adminFacade;

    public SystemSession () {
        controller = new WindowController();
        this.system = new ShopSystem();
        this.system.start();
        clientFacade = new ClientFacade(system);
    }
    
    public boolean getActive() {
        return active;
    }

    public void start(){
        switch(controller.selectInitialOperation()){
            case "1": clientLogin(); break;
            case "2": createClientAccount();
            case "3": createClientAccount();
            case "4": createClientAccount();
        }
    }

    private void createClientAccount(){
        Client newClient = controller.readClient();
        clientFacade.registerClient(newClient);
        system.saveDatabase();
        controller.printClient(newClient);
        start();
    }

    private void createAdminAccount(){
//        Client newAdmin = controller.readAdmin();
//        system.saveDatabase();
    }

    private void clientLogin() {
        String[] clientPassword = controller.readUserPassword();
        Client logedClient = clientFacade.login(clientPassword[0], clientPassword[1]);
        ClientMenu menu = new ClientMenu(logedClient, controller);
        menu.selectOperation();
    }

    private void adminLogin() {
        String[] adminPassword = controller.readUserPassword();
        Admin logedAdmin = adminFacade.login(adminPassword[0], adminPassword[1]);
        AdminMenu menu = new AdminMenu(logedAdmin, controller);
        menu.selectOperation();
    }

}
