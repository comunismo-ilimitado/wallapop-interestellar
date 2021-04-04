package urjc.grupoo.system.ui;

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

    public void login() {
        controller.loginScreen();
        String user = controller.readText();
    }
}
