package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.crationHandlers;

import java.util.ArrayList;
import java.util.Stack;
import urjc.grupoo.data.shipsData.Spaceship;

/**
 *
 * @author Gonzalo Ortega
 */
public class OfferCreationHandler {

    private final ArrayList<Spaceship> offerShipList = new ArrayList<>();

    public void addShipToOffer(Spaceship ship) {
        offerShipList.add(ship);
    }

    public ArrayList<Spaceship> getOfferShipList() {
        return offerShipList;
    }

    private final Stack<ArrayList<Spaceship>> stationShipsLists = new Stack<>();

    public void addStationShipList() {
        ArrayList<Spaceship> shipList = new ArrayList<>();
        stationShipsLists.push(shipList);
    }

    public ArrayList<Spaceship> getShipList() {
        return stationShipsLists.peek();
    }
    
    public void removeShipList() {
        stationShipsLists.pop();
    }
    
    public boolean isStationShipsListsEmpty() {
        return stationShipsLists.isEmpty();
    }

    public void addShip(Spaceship newship) {
        stationShipsLists.peek().add(newship);
    }
}
