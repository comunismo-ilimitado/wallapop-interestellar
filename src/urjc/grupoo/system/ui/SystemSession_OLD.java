package urjc.grupoo.system.ui;

import java.util.ArrayList;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.ShopSystem;

/**
 * Clase que admisistra la egecucución general del programa.
 *
 * @author Gonzalo Ortega
 */
public class SystemSession_OLD {

    private final WindowController_OLD controller;
    private final ShopSystem system;
    private final ClientFacade clientFacade;
    private final AdminFacade adminFacade;
    private Client activeClient;
    private Admin activeAdmin;

    public SystemSession_OLD() {
        this.system = new ShopSystem();
        this.system.start();
        controller = new WindowController_OLD(this);
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);
    }

    // Getters de las propiedaes:
    public WindowController_OLD getController() {
        return controller;
    }

    public ShopSystem getSystem() {
        return system;
    }

    public ClientFacade getClientFacade() {
        return clientFacade;
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public Client getClient() {
        return activeClient;
    }

    public Admin getAdmin() {
        return activeAdmin;
    }

    /**
     * Comienza el programa
     */
    public void start() {
        controller.selectInitialOperation();
    }

    /**
     * Crea un cliente nuevo y lo guarda.
     *
     * @param clientAtributes: Lista de atributos necesarios para crear un
     * cliente.
     */
    public void createClient(ArrayList<String> clientAtributes) {
        Client newClient = new Client(
                clientAtributes.get(0), clientAtributes.get(1), clientAtributes.get(2),
                clientAtributes.get(3), clientAtributes.get(4), clientAtributes.get(5));
        clientFacade.registerClient(newClient);
        system.saveDatabase();
        controller.selectInitialOperation();
    }

    /**
     * Comprueba el usuario y la contraseña y abre el menu de cliente.
     *
     * @param clientAndPassword: Array con el cliente en la primera posición y
     * con la contraseña en la segunda.
     */
    public void clientLogin(String[] clientAndPassword) {
        activeClient = clientFacade.login(clientAndPassword[0], clientAndPassword[1]);
        if (activeClient != null) {
            selectClientOperation();
        } else {
            System.out.println("incorrectaaaaa");
        }
    }

    /**
     * Crea un administrador nuevo y lo guarda.
     *
     * @param adminAtributes: Lista de atributos necesarios para crear un
     * cliente.
     */
    public void createAdmin(ArrayList<String> adminAtributes) {
        Admin newAdmin = new Admin(
                adminAtributes.get(0), adminAtributes.get(1),
                adminAtributes.get(2), adminAtributes.get(3));
        //adminFacade.
        activeAdmin = newAdmin; //ESTA LINEA HAY Q QUITARLA LUEGO
        system.saveDatabase();
        controller.selectInitialOperation();
    }

    /**
     * Comprueba el usuario y la contraseña y abre el menu de administrador.
     *
     * @param clientAndPassword: Array con administrador en la primera posición
     * y con la contraseña en la segunda.
     */
    public void adminLogin(String[] clientAndPassword) {
        activeAdmin = adminFacade.login(clientAndPassword[0], clientAndPassword[1]);
//        if (activeAdmin != null) {
//             controller.showAdminMenu();
//        } else {
//            System.out.println("incorrectaaaaa");
//        }
          controller.showAdminMenu(); //ESTO HAY CREO CAMBIARLO LUEGO
    }

    private void selectClientOperation() {
        controller.showClientMenu();
    }


}
