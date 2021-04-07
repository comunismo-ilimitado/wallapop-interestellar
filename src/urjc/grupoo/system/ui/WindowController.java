package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.system.ui.Operations.Operation;

import java.util.ArrayList;

/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la ventana
 */
public class WindowController {

    private ProgramWindow window;

    public WindowController(){
        window = new ProgramWindow();
    }

    private void clearScreen(){
        window.setHeaderText("");
        window.setMainText("");
    }

    private String readText() {
        return window.readText();
    }

    private void showOptions(ArrayList<String> options) {
        StringBuilder b = new StringBuilder();
        b.append("<html><table>");
        for (int i = 0; i < options.size(); i++) {
            b.append(String.format("<tr><td align='left'>%s</td>%s", "["+(i+1)+"]:", options.get(i)));
        }
        b.append("</table></html>");
        window.setMainText(b.toString());
    }

    private void showOperationOptions(ArrayList<Operation> options) {
        StringBuilder b = new StringBuilder();
        b.append("<html><table>");
        for (int i = 0; i < options.size(); i++) {
            b.append(String.format("<tr><td align='left'>%s</td>%s", "["+(i+1)+"]:", options.get(i).getName()));
        }
        b.append("</table></html>");
        window.setMainText(b.toString());
    }

    /**
     * Permite seleccionar la opción inicial deseada.
     */
    public String selectInitialOperation() {
        clearScreen();
        window.setHeaderText("Bienvenido");

        ArrayList<String> options = new ArrayList<>();
        options.add("Iniciar sesión de ususario.");
        options.add("Iniciar sesión de admisistrador.");
        options.add("Crear cuenta de ususario.");
        options.add("Crear cuenta de administrador.");
        showOptions(options);

        return window.readText();
    }

    public String clientMenu() {
        clearScreen();
        window.setHeaderText("Cliente");

        ArrayList<String> options = new ArrayList<>();
        options.add("Ver perfil.");
        options.add("Subir nave.");
        options.add("Explorar naves.");
        options.add("Notificaciones.");
        options.add("Salir.");
        showOptions(options);

        return window.readText();
    }

    /**
     * Mestra la informacion relativa a un cliente (Su perfil).
     */
    public void printClient(Client c){
        clearScreen();
        window.setHeaderText("Perfil del usuario");

        StringBuilder b = new StringBuilder();
        b.append("<html><table>");
        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Nick", c.getNick()));
        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Especie", c.getSpecies()));
        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Planeta de origen", c.getOrigingPlanet()));
        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Nombre", c.getName()));
        b.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "Correo", c.getEmail()));
        b.append("</table></html>");
        window.setMainText(b.toString());
        readText();
    }

    /**
     * @return Un array con el nick y la contraseña introducidos por el usuario.
     */
    public String[] readUserPassword() {
        clearScreen();
        window.setHeaderText("Inicio de sesión");

        String[] userpassword = new String[2];
        window.setMainText("Introduzca su nick:");
        userpassword[0] = readText();
        window.setMainText("Introduzca la contraseña:");
        userpassword[1] = readText();
        return userpassword;
    }

    /**
     * @return Un cliente con los datos que introduzaca el usuario.
     */
    public Client readClient(){
        clearScreen();
        window.setHeaderText("Registro de cliente");

        window.setMainText("Introduzca su nombre:");
        String name = readText();
        window.setMainText("Introduzca un apodo:");
        String nick = readText();
        window.setMainText("Seleccione una contraseña:");
        String password = readText();
        window.setMainText("Introduzca su especie:");
        String species = readText();
        window.setMainText("Introduzca su planeta de origen:");
        String origingPlanet = readText();
        window.setMainText("Por último, introduzca su correo electrónico:");
        String email = readText();
        return new Client(origingPlanet, species, name, nick, password, email);
    }


    public Operation selectOption(ArrayList<Operation> operationList) {
        showOperationOptions(operationList);
        int option;
        try {
            option = Integer.parseInt(window.readText());
        }
        catch (NumberFormatException e)
        {
            option = 1;
        }
        return operationList.get(option-1);
    }
}
