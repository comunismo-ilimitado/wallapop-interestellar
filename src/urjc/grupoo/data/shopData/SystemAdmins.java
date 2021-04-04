package urjc.grupoo.data.shopData;

/*
 * Clase que almacena la lista de administradores
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SystemAdmins implements Serializable{

    private List<Admin> adminList;

    public SystemAdmins() {
        adminList = new ArrayList<>();
    }

    public List<Admin> getAdminList() {
        return adminList;
    }
    
    

}
