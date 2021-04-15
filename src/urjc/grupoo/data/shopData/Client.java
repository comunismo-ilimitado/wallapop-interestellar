package urjc.grupoo.data.shopData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Clase de creación y almacén de datos de los clientes
 *
 * @author Sergio
 */
public class Client extends User {

    private String origingPlanet;
    private String species;
    private HashMap<Integer, Offer> activeOffers;
    private List<ClientComment> commentList;
    private ClientNotifications notifications;
    private int ratingAverage;
    private License license;

    public Client(String origingPlanet, String species, String name, String nick, String password, String email) {
        super(name, nick, password, email);
        this.origingPlanet = origingPlanet;
        this.species = species;
        license = new License();
        
        if (species == "Kromagg") {
            license.setBuysWeapon(false);
        } else {
            license.setBuysWeapon(true);
        }
        
        
        notifications = new ClientNotifications();
        commentList = new ArrayList<>();
        activeOffers = new HashMap<>();

    }

    public String getOrigingPlanet() {
        return origingPlanet;
    }

    public String getSpecies() {
        return species;
    }

    public HashMap<Integer, Offer> getActiveOffers() {
        return activeOffers;
    }

    public void setActiveOffers(HashMap<Integer, Offer> activeOffers) {
        this.activeOffers = activeOffers;
    }

    public List<ClientComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<ClientComment> commentList) {
        this.commentList = commentList;
    }

    public int getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public License getLicense() {
        return license;
    }

    public void notifyOffer(Offer offer) {
        notifications.getNotificationList().add(offer);
    }

    public ClientNotifications getNotifications() {
        return notifications;
    }

}
