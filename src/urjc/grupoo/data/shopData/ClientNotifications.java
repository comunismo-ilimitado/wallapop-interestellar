package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena la lista de offertas para notificar
 *
 * @author Sergio
 */
public class ClientNotifications implements Serializable {

    private List<Offer> notificationList;

    public ClientNotifications() {
        notificationList = new ArrayList<>();
    }

    public List<Offer> getNotificationList() {
        return notificationList;
    }
}
