package urjc.grupoo.data.shopData;

/*
 * Clase que almacena la información de los comentarios y valoraciones
 */

public class ClientComment {

    private int rating;
    private String comment;
    private SoldSpaceshipRegister sholdShip;
    private int user;

    public ClientComment(int rating, String comment, SoldSpaceshipRegister sholdShip, int user) {
        this.rating = rating;
        this.comment = comment;
        this.sholdShip = sholdShip;
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public SoldSpaceshipRegister getSholdShip() {
        return sholdShip;
    }

    public int getUser() {
        return user;
    }

}
