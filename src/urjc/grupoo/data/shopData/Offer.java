package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * Clase que contiene los datos de las ofertas
 */

public class Offer implements Serializable{

    private List<Spaceship> offeredSpaceShips;
    private Date limitDate;
    private double price;
    private Client seller;


    public Offer(List<Spaceship> offeredSpaceShips, Date limitDate, double price, Client seller) {
        this.offeredSpaceShips = offeredSpaceShips;
        this.limitDate = limitDate;
        this.price = price;
        this.seller = seller;
    }

    public List<Spaceship> getOfferedSpaceShips() {
        return offeredSpaceShips;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public double getPrice() {
        return price;
    }

    public Client getSeller() {
        return seller;
    }
}
