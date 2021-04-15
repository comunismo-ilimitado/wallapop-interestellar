package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene una lista de todos los registros de ventas
 *
 * @author Sergio
 */
public class SoldSpaceships implements Serializable {

    private List<SoldSpaceshipRegister> soldSpaceshipList;

    public SoldSpaceships() {
        soldSpaceshipList = new ArrayList<>();
    }

    public List<SoldSpaceshipRegister> getSoldSpaceshipList() {
        return soldSpaceshipList;
    }

}
