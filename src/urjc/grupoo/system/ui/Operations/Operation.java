package urjc.grupoo.system.ui.Operations;

import urjc.grupoo.data.shopData.User;
import urjc.grupoo.system.ui.WindowController;

public abstract class Operation {

    private WindowController controller;
    private User user;

    public User getUser() {
        return user;
    }

    public WindowController getController() {
        return controller;
    }

    public Operation(WindowController controller, User user) {
        this.controller = controller;
        this.user = user;
    }
    public abstract String getName();
    public abstract void doOperation();
    
    
}


