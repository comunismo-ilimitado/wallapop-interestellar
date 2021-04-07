package urjc.grupoo.system.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.ui.Forms.ClientMenu;
import urjc.grupoo.system.ui.Forms.ClientProfile;
import urjc.grupoo.system.ui.Forms.CreateClientScreen;
import urjc.grupoo.system.ui.Forms.LoginScreen;
import urjc.grupoo.system.ui.Forms.StartMenu;

/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la
 * ventana
 */
public class WindowController {

    private SystemSession session;
    private JFrame window;
    private JPanel startMenu;
    private JPanel loginScreen;
    private JPanel createClientScreen;
    private ClientProfile clientProfile;
    private JPanel clientMenu;

    public WindowController(SystemSession session) {

        this.session = session;

        window = new JFrame("Walapop Interestelar");
        startMenu = new StartMenu(session);
        loginScreen = new LoginScreen(session);
        createClientScreen = new CreateClientScreen(session);
        clientProfile = new ClientProfile(session);
        clientMenu = new ClientMenu(session);
        
        startMenu.setBounds(0, 0, 700, 400);
        window.add(startMenu);
        startMenu.setVisible(false);

        createClientScreen.setBounds(0, 0, 700, 400);
        window.add(createClientScreen);
        createClientScreen.setVisible(false);

        loginScreen.setBounds(0, 0, 700, 400);
        window.add(loginScreen);
        loginScreen.setVisible(false);
        
        clientProfile.setBounds(0, 0, 700, 400);
        window.add(clientProfile);
        clientProfile.setVisible(false);
        
        clientMenu.setBounds(0, 0, 700, 400);
        window.add(clientMenu);
        clientMenu.setVisible(false);


        // Se establecen los parametros de la ventana.
        window.setSize(700, 400);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Permite seleccionar la opción inicial deseada.
     */
    public void selectInitialOperation() {
        startMenu.setVisible(true);
    }

    public void login() {
        loginScreen.setVisible(true);
    }

    public void createClient() {
        createClientScreen.setVisible(true);
    }
    
    public void showClientProfile(Client client){
        clientProfile.showCLient(client);
        clientProfile.setVisible(true);
    }
    
    public void showClientMenu(){
        clientMenu.setVisible(true);
    }
    
    

//    private void clearScreen(){
//        window.setHeaderText("");
//        window.setMainText("");
//    }
//    private String readText() {
//        return window.readText();
//    }
//    private void showOptions(ArrayList<String> options) {
//        StringBuilder b = new StringBuilder();
//        b.append("<html><table>");
//        for (int i = 0; i < options.size(); i++) {
//            b.append(String.format("<tr><td align='left'>%s</td>%s", "["+(i+1)+"]:", options.get(i)));
//        }
//        b.append("</table></html>");
//        window.setMainText(b.toString());
//    }
//    private void showOperationOptions(ArrayList<Operation> options) {
//        StringBuilder b = new StringBuilder();
//        b.append("<html><table>");
//        for (int i = 0; i < options.size(); i++) {
//            b.append(String.format("<tr><td align='left'>%s</td>%s", "["+(i+1)+"]:", options.get(i).getName()));
//        }
//        b.append("</table></html>");
//        window.setMainText(b.toString());
//    }
//    public String clientMenu() {
//        clearScreen();
//        window.setHeaderText("Cliente");
//
//        ArrayList<String> options = new ArrayList<>();
//        options.add("Ver perfil.");
//        options.add("Subir nave.");
//        options.add("Explorar naves.");
//        options.add("Notificaciones.");
//        options.add("Salir.");
//        showOptions(options);
//
//        return window.readText();
//    }
//    /**
//     * Mestra la informacion relativa a un cliente (Su perfil).
//     */
//    public void printClient(Client c){
//        clearScreen();
//        window.setHeaderText("Perfil del usuario");
//
//        StringBuilder b = new StringBuilder();
//        b.append("<html><table>");
//        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Nick", c.getNick()));
//        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Especie", c.getSpecies()));
//        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Planeta de origen", c.getOrigingPlanet()));
//        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Nombre", c.getName()));
//        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Correo", c.getEmail()));
//        b.append("</table></html>");
//        window.setMainText(b.toString());
//        readText();
//    }
//    /**
//     * @return Un array con el nick y la contraseña introducidos por el usuario.
//     */
//    public String[] readUserPassword() {
//        clearScreen();
//        window.setHeaderText("Inicio de sesión");
//
//        String[] userpassword = new String[2];
//        window.setMainText("Introduzca su nick:");
//        userpassword[0] = readText();
//        window.setMainText("Introduzca la contraseña:");
//        userpassword[1] = readText();
//        return userpassword;
//    }
//    /**
//     * @return Un cliente con los datos que introduzaca el usuario.
//     */
//    public Client readClient(){
//        clearScreen();
//        window.setHeaderText("Registro de cliente");
//
//        window.setMainText("Introduzca su nombre:");
//        String name = readText();
//        window.setMainText("Introduzca un apodo:");
//        String nick = readText();
//        window.setMainText("Seleccione una contraseña:");
//        String password = readText();
//        window.setMainText("Introduzca su especie:");
//        String species = readText();
//        window.setMainText("Introduzca su planeta de origen:");
//        String origingPlanet = readText();
//        window.setMainText("Por último, introduzca su correo electrónico:");
//        String email = readText();
//        return new Client(origingPlanet, species, name, nick, password, email);
//    }
//    public Operation selectOption(ArrayList<Operation> operationList) {
//        showOperationOptions(operationList);
//        int option;
//        try {
//            option = Integer.parseInt(window.readText());
//        }
//        catch (NumberFormatException e)
//        {
//            option = 1;
//        }
//        return operationList.get(option-1);
//    }
}
