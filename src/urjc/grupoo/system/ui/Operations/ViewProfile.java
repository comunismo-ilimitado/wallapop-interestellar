package urjc.grupoo.system.ui.Operations;

import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.User;
import urjc.grupoo.system.ui.WindowController;

public class ViewProfile extends Operation {


    public ViewProfile(WindowController controller, User user) {
        super(controller, user);
    }

    @Override
    public String getName() {
        return "Ver perfil";
    }

    @Override
    public void doOperation() {
        getController().printClient((Client) getUser());
    }
}
