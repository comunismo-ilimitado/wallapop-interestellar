package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/*
 * Clase que almacena la lista de clientes
 */

public class SystemClients implements Serializable{

    private HashMap<Integer, Client> clientList;

    private int lastId = 0;
    
    public SystemClients() {
        clientList = new HashMap<>();
    }

    public HashMap<Integer, Client> getClientList() {
        return clientList;
    }
    
    public void addClient(Client client){
        client.setIdNumber(lastId);
        clientList.put(lastId, client);
        lastId += 1;
    }
}
