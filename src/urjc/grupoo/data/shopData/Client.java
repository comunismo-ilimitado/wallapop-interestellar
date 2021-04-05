package urjc.grupoo.data.shopData;

import java.util.List;

/*
 * Clase que almacena los datos de los clientes
 */

public class Client extends User {

    private String origingPlanet;
    private String species;
    private List<Integer> activeOffers;
    private List<ClientComment> commentList;
    private int ratingAverage;
    private License license;
    private int idNumber;

    public Client(String origingPlanet, String species, String name, String nick, String password, String email) {
        super(name, nick, password, email);
        this.origingPlanet = origingPlanet;
        this.species = species;
        this.license = null;
        this.idNumber = -1;
    }

    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }

    public String getOrigingPlanet() { return origingPlanet; }

    public String getSpecies() { return species; }

    public List<Integer> getActiveOffers() { return activeOffers; }

    public void setActiveOffers(List<Integer> activeOffers) { this.activeOffers = activeOffers; }

    public List<ClientComment> getCommentList() { return commentList; }

    public void setCommentList(List<ClientComment> commentList) { this.commentList = commentList; }

    public int getRatingAverage() { return ratingAverage; }

    public void setRatingAverage(int ratingAverage) { this.ratingAverage = ratingAverage; }

    public License getLicense() { return license; }
}
