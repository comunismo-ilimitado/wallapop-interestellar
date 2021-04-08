package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.system.backend.AdminFacade;

public class AdminMenuController {

    private final WindowController controller;
    private final AdminFacade facade;
    private final Admin admin;

    public AdminMenuController(Admin admin, AdminFacade facade, WindowController controller) {
        this.controller = controller;
        this.admin = admin;
        this.facade = facade;
    }

    public void selectOperation(){
        controller.adminClientMenu();
    }

}
