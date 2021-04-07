package urjc.grupoo.system.ui;

import java.util.ArrayList;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.ShopSystem;

public class SystemSession {

    private WindowController controller;
    private ShopSystem system;
    private ClientFacade clientFacade;
    private AdminFacade adminFacade;
    private Client activeClient;

    public SystemSession () {
        controller = new WindowController(this);
        this.system = new ShopSystem();
        this.system.start();
        clientFacade = new ClientFacade(system);
    }
    
    public WindowController getController() {
        return controller;
    }
    
    public Client getClient() {
        return activeClient;
    }

    public void start(){
        controller.selectInitialOperation();
    }

    public void createClient(ArrayList <String> clientAtributes){
        Client newClient = new Client(clientAtributes.get(0), clientAtributes.get(1), clientAtributes.get(2), clientAtributes.get(3), clientAtributes.get(4), clientAtributes.get(5));
        clientFacade.registerClient(newClient);
        system.saveDatabase();
//        controller.showClientProfile(newClient);
        controller.selectInitialOperation();  
    }
    
    public void clientLogin(String[] clientAndPassword) {
        activeClient = clientFacade.login(clientAndPassword[0], clientAndPassword[1]);
        if (activeClient != null) {
            new ClientMenuController(activeClient, controller).selectOperation();
        } else {
            System.out.println("incorrectaaaaa");
        }
    }

    private void createAdminAccount(){

    }

    private void adminLogin() {

    }

    
    
}
