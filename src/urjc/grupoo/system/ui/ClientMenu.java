package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.ui.Operations.Operation;
import urjc.grupoo.system.ui.Operations.ViewProfile;

import java.util.ArrayList;

public class ClientMenu {

    private final WindowController controller;
    private Client client;
    private ArrayList<Operation> operationList = new ArrayList<>();

    public ClientMenu(Client client, WindowController controller) {
        this.controller = controller;
        this.client = client;
        operationList.add(new ViewProfile(controller, client));
    }

    public void selectOperation(){
        Operation selectedoperation = controller.selectOption(operationList);
        selectedoperation.doOperation();
        selectOperation();
    }
}
