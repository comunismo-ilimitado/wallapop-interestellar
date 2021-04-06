package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena la lista de offertas para notificar
 */

public class ClientNotifications implements Serializable {

    private List<Integer> notificationList;

    public ClientNotifications(){
        notificationList = new ArrayList<>();
    }

    public List<Integer> getNotificationList() {
        return notificationList;
    }
}
