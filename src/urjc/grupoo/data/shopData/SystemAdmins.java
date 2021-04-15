package urjc.grupoo.data.shopData;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena todos los administradores
 *
 * @author Sergio
 */
public class SystemAdmins implements Serializable {

    private List<Admin> adminList;

    public SystemAdmins() {
        adminList = new ArrayList<>();
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public Admin getAdmin(String nick) {
        Admin ad = null;
        for (Admin admin : adminList) {
            if (nick.equals(admin.getNick())) {
                ad = admin;
            }
        }
        return ad;
    }

}
