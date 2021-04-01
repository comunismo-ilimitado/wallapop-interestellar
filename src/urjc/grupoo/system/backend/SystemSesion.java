package urjc.grupoo.system.backend;

public class SystemSesion {

    private final WindowController controller;
    private boolean active = true;

    public SystemSesion (WindowController controller) {
        this.controller = controller;
    }

    public boolean getActive() {
        return active;
    }

    public void login() {
        controller.loginScreen();
        String user = controller.readText();
    }
}
