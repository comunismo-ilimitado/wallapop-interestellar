package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms.crationHandlers;

import java.util.Stack;
import urjc.grupoo.data.shipsData.Spaceship;

/**
 *
 * @author Gonzalo Ortega
 */
public class OfferCreationHandler {

    private final Stack<Spaceship> offerShipStack = new Stack<>();

    public void addShipToOffer(Spaceship ship) {
        offerShipStack.push(ship);
    }

    public Stack<Spaceship> getOfferShipStack() {
        return offerShipStack;
    }

}
