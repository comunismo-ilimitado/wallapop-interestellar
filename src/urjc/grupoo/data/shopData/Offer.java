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
    private int offerId;
    private String offerType; // Los offertype estan definidos en ShopSystem


    public Offer(List<Spaceship> offeredSpaceShips, Date limitDate, double price, int seller, String offerType) {
        this.offeredSpaceShips = offeredSpaceShips;
        this.limitDate = limitDate;
        this.price = price;
        this.seller = seller;
        this.offerType = offerType;
        offerId = -1;
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

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getOfferId() {
        return offerId;
    }

    public String getOfferType() {
        return offerType;
    }
    
    
    
}
