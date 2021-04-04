package urjc.grupoo.system.ui;

/**
 * Clase encargada de admisistrar las peticiones del programa y gestionar la ventana
 */

public class WindowController {

    private ProgramWindow window;

    public WindowController(ProgramWindow window){
        this.window = window;
    }

    public void loginScreen() {
        window.setHeaderText("Inicio de sesión");
        window.setMainText("Introduzca la contraseña");
    }

    public String readText() {
        return null;
    }
}
