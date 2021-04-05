package urjc.grupoo.system.ui;

import urjc.grupoo.data.shopData.Client;

/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la ventana
 */

public class WindowController {

    private ProgramWindow window;

    public WindowController(ProgramWindow window){
        this.window = window;
    }

    /**
     * Permite seleccionar la opción inicial deseada.
     */
    public String selectInitialOperation() {
        clearScreen();
        window.setHeaderText("Bienvenido");

        StringBuilder b = new StringBuilder();
        b.append("<html><table>");
        b.append(String.format("<tr><td align='left'>%s</td>", "[1]: Iniciar sesion."));
        b.append(String.format("<tr><td align='left'>%s</td>", "[2]: Crear cuenta."));
        b.append("</table></html>");
        window.setMainText(b.toString());
        return window.readText();
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

    public void clearScreen(){
        window.setHeaderText("");
        window.setMainText("");
    }

    public String readText() {
        return window.readText();
    }


}
