package urjc.grupoo.system.ui;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;


/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la
 * ventana.
 *
 * @author Gonzalo Ortega
 */
public class WindowController_OLD {

    private final SystemSession_OLD session;
    private final JFrame window;

    // Paneles que se van a utilizar durante la ejecución del programa:
    private JPanel startMenu;
    private JPanel clietnLoginScreen;
    private JPanel cpanel;
    /*private final JPanel clientCreationScreen;
    private final JPanel adminCreationScreen;
    private final ClientProfile clientProfile;
    private final JPanel clientMenu;
    private final JPanel adminLoginScreen;
    private final JPanel adminMenu;
    private final AdminProfile adminProfile; */

    // Lista y pila para admisistrar paneles:
    private final ArrayList<JPanel> panelList = new ArrayList<>();
    private final Stack<JPanel> previousPanels = new Stack<>();

    /**
     * Inicializa todos los paneles y la ventana.
     *
     * @param session
     */
    public WindowController_OLD(SystemSession_OLD session) {

        this.session = session;

        // Se inicializa la ventana
        window = new JFrame("Walapop Interestelar");

        
        
        // Se crean los paneles generales.
       // startMenu = new StartMenu(session);
       // panelList.add(startMenu);

        // Se crean los paneles relaccionados con el cliente.
       // clietnLoginScreen = new ClientLoginScreen(session);
       // panelList.add(clietnLoginScreen);
       /* clientCreationScreen = new ClientCreationScreen(session);
        panelList.add(clientCreationScreen);
        clientProfile = new ClientProfile(session);
        panelList.add(clientProfile);
        clientMenu = new ClientMenu(session);
        panelList.add(clientMenu);

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
            panel.setBounds(0, 0, 700, 400);
            window.add(panel);
            panel.setVisible(false);
        }
        */
       window.add(startMenu);
       startMenu.setVisible(true);
       startMenu.setBounds(0, 0, 700, 400);
       cpanel = startMenu;
        // Se establecen los parametros de la ventana.
        window.setSize(700, 400);
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

    public void update(JPanel panel){
        window.remove(cpanel);
        cpanel = panel;
        window.add(cpanel);
        cpanel.setVisible(true);
        window.update(window.getGraphics());
    }
    
    /**
     * Restaura la vista del panel anterior.
     */
    public void goBack() {
        if (!previousPanels.isEmpty()) {
            JPanel previous = previousPanels.pop();
            window.add(previous);
            previous.setVisible(true);
        }
    }

    
    // Los siguientes métodos sirven para mostrar los diferentes paneles:
    
    public void selectInitialOperation() {
        startMenu.setVisible(true);
    }

    public void login() {
        clietnLoginScreen.setVisible(true);
    }

    public void createClient() {
        //clientCreationScreen.setVisible(true);
    }

    public void createAdmin() {
        //adminCreationScreen.setVisible(true);
    }

    public void showClientProfile(Client client) {
        //clientProfile.showCLient(client);
        //clientProfile.setVisible(true);
    }

    public void showClientMenu() {
        //clientMenu.setVisible(true);
    }

    void adminClientMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void adminLogin(){
        //adminLoginScreen.setVisible(true);
    }

    public void showAdminMenu() {
        //adminMenu.setVisible(true);
    }
    
    

    public void showAdminProfile(Admin admin) {
        //adminProfile.showAdmin(admin);
        //adminProfile.setVisible(true);
    }
}
