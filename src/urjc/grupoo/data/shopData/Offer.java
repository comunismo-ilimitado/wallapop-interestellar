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
    private int seller;


    public Offer(List<Spaceship> offeredSpaceShips, Date limitDate, double price, int seller) {
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

    public int getSeller() {
        return seller;
    }
}
