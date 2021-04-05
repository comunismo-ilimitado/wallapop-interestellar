package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.User;
import urjc.grupoo.system.backend.ShopSystem;

public class SystemSession {

    private final WindowController controller;
    private boolean active = true;
    private ShopSystem system;

    public SystemSession (WindowController controller) {
        this.controller = controller;
        this.system = new ShopSystem();
        this.system.start();
    }
    
    public boolean getActive() {
        return active;
    }

    public void start(){
        switch(controller.selectInitialOperation()){
            case "1": login();
            case "2": createAccount();
        }
    }

    public void createAccount(){
        Client newClient = controller.readClient();
        controller.printClient(newClient);
    }

    public void login() {
        String[] userPassword = controller.readUserPassword();
        String clientType = checkUser(userPassword[0], userPassword[1]);
        if (clientType.equals("Client")){
            // Abrir el menu de cliente
        } else if (clientType.equals("Admin")){
            // Abrir el menu de administrador
        }
    }

    private String checkUser(String user, String password) {
        return "Client";
        //return "Admin";
        //return "No coincidence"
    }
}
