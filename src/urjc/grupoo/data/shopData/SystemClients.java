package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que almacena todos los clientes
 *
 * @author Sergio
 */
public class SystemClients implements Serializable {

    private HashMap<Integer, Client> clientList;

    private int lastId = 0;

    public SystemClients() {
        clientList = new HashMap<>();
        lastId = 0;
    }

    public HashMap<Integer, Client> getClientList() {
        return clientList;
    }

    public void addClient(Client client) {
        client.setIdNumber(lastId);
        clientList.put(lastId, client);
        lastId += 1;
    }
}
