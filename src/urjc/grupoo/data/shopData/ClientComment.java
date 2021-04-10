package urjc.grupoo.data.shopData;

import java.io.Serializable;

/*
 * Clase que almacena la información de los comentarios y valoraciones
 */

public class ClientComment implements Serializable{

    private int rating;
    private String comment;
    private Offer offer;
    private int user;

    public ClientComment(int rating, String comment, Offer offer, int user) {
        this.rating = rating;
        this.comment = comment;
        this.offer = offer;
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Offer getOffer() {
        return offer;
    }

    
    public int getUser() {
        return user;
    }

}
