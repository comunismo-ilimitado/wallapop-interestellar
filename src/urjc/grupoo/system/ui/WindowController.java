package urjc.grupoo.system.ui;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.ui.Forms.clientForms.ClientMenu;
import urjc.grupoo.system.ui.Forms.clientForms.ClientProfile;
import urjc.grupoo.system.ui.Forms.clientForms.ClientCreationScreen;
import urjc.grupoo.system.ui.Forms.clientForms.ClientLoginScreen;
import urjc.grupoo.system.ui.Forms.StartMenu;
import urjc.grupoo.system.ui.Forms.adminForms.AdminCreationScreen;
import urjc.grupoo.system.ui.Forms.clientForms.SubscriptionsScreen;
import urjc.grupoo.system.ui.Forms.clientForms.ValorationsScreen;
import urjc.grupoo.system.ui.Forms.adminForms.AdminLoginScreen;
import urjc.grupoo.system.ui.Forms.adminForms.AdminMenu;
import urjc.grupoo.system.ui.Forms.adminForms.AdminProfile;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.DestructorCreationScreen;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.PriceSelectionScreen;
import urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.ShipCreationScreen;

/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la
 * ventana.
 *
 * @author Gonzalo Ortega
 */
public class WindowController {

    private final SystemSession session;
    private final JFrame window;

    // Paneles que se van a utilizar durante la ejecución del programa:
    private final JPanel startMenu;
    
    // Paneles de cliente:
    private final JPanel clientLoginScreen;
    private final JPanel clientCreationScreen;
    private final ClientProfile clientProfile;
    private final JPanel clientMenu;
    private final SubscriptionsScreen subscriptionsScreen;
    private final ValorationsScreen valorationsScreen;
    
    // Paneles de naves:
    private final JPanel shipCreationScreen;
    private final JPanel destructorCreationScreen;
    private final JPanel priceSelectionScreen;
    
    // Paneles de administrador:
    private final JPanel adminCreationScreen;
    private final JPanel adminLoginScreen;
    private final JPanel adminMenu;
    private final AdminProfile adminProfile;

    // Lista y pila para admisistrar paneles:
    private final ArrayList<JPanel> panelList = new ArrayList<>();
    private final Stack<JPanel> previousPanels = new Stack<>();
    
    // Dimensiones de la ventana
    private final int windowHeight = 400;
    private final int windowWidth = 700;
    
    /**
     * Inicializa todos los paneles y la ventana.
     *
     * @param session
     */
    public WindowController(SystemSession session) {

        this.session = session;

        // Se inicializa la ventana
        window = new JFrame("Walapop Interestelar");

        // Se crean los paneles generales.
        startMenu = new StartMenu(session);
        panelList.add(startMenu);

        // Se crean los paneles relaccionados con el cliente.
        clientLoginScreen = new ClientLoginScreen(session);
        panelList.add(clientLoginScreen);
        clientCreationScreen = new ClientCreationScreen(session);
        panelList.add(clientCreationScreen);
        clientProfile = new ClientProfile(session);
        panelList.add(clientProfile);
        clientMenu = new ClientMenu(session);
        panelList.add(clientMenu);
        subscriptionsScreen = new SubscriptionsScreen(session);
        panelList.add(subscriptionsScreen);
        valorationsScreen = new ValorationsScreen(session);
        panelList.add(valorationsScreen);
        
        // Se crean los paneles relaccionados con las naves.
        shipCreationScreen = new ShipCreationScreen(session);
        panelList.add(shipCreationScreen);
        destructorCreationScreen = new DestructorCreationScreen(session);
        panelList.add(destructorCreationScreen);
        priceSelectionScreen = new PriceSelectionScreen(session);
        panelList.add(priceSelectionScreen);
        

        // Se crean los paneles relaccionados con el administrador.
        adminCreationScreen = new AdminCreationScreen(session);
        panelList.add(adminCreationScreen);
        adminLoginScreen = new AdminLoginScreen(session);
        panelList.add(adminLoginScreen);
        adminMenu = new AdminMenu(session);
        panelList.add(adminMenu);
        adminProfile = new AdminProfile(session);
        panelList.add(adminProfile);


        // Se establece el tamaño de los paneles, se anaden a la centana y se ocultan.
        for (JPanel panel : panelList) {
            panel.setBounds(0, 0, windowWidth, windowHeight);
            window.add(panel);
            panel.setVisible(false);
        }

        // Se establecen los parametros de la ventana.
        window.setSize(windowWidth, windowHeight);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Añade el ultimo panel usado a la pila de paneles anteriores.
     *
     * @param lastPanel
     */
    public void addLastPanel(JPanel lastPanel) {
        previousPanels.push(lastPanel);
    }

    /**
     * Restaura la vista del panel anterior.
     */
    public void goBack() {
        if (!previousPanels.isEmpty()) {
            JPanel previous = previousPanels.pop();
            previous.setVisible(true);
        }
    }

    
    // Los siguientes métodos sirven para mostrar los diferentes paneles:
    
    public void selectInitialOperation() {
        startMenu.setVisible(true);
    }

    public void login() {
        clientLoginScreen.setVisible(true);
    }

    public void createClient() {
        clientCreationScreen.setVisible(true);
    }

    public void createAdmin() {
        adminCreationScreen.setVisible(true);
    }

    public void showClientProfile(Client client) {
        clientProfile.showCLient(client);
        clientProfile.setVisible(true);
    }

    public void showClientMenu() {
        clientMenu.setVisible(true);
    }

    public void adminLogin(){
        adminLoginScreen.setVisible(true);
    }

    public void showAdminMenu() { adminMenu.setVisible(true);
    }

    public void showAdminProfile(Admin admin) {
        adminProfile.showAdmin(admin);
        adminProfile.setVisible(true);
    }

    public void showSubsciptionsOptions(Client client) {
        subscriptionsScreen.showSubscriptions(client);
        subscriptionsScreen.setVisible(true);
    }

    public void showComments() {
        valorationsScreen.setVisible(true);
    }

    public void createShip() {
        shipCreationScreen.setVisible(true);
    }

    public void createDestructor() {
        destructorCreationScreen.setVisible(true);
    }

    public void selectPrice() {
        priceSelectionScreen.setVisible(true);
    }
}
