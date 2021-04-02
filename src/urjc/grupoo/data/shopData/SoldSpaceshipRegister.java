package urjc.grupoo.data.shopData;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * Clase en el que se almacena el registro de ventas
 */

public class SoldSpaceshipRegister implements Serializable{

    private List<Spaceship> soldSpacheshipsList;
    private double soldPrice;
    private Date soldDate;
    private Client seller;
    private Client buyer;
    private double totalDamageAllowed;
    private double totalPower;

    public SoldSpaceshipRegister(List<Spaceship> soldSpacheshipsList, Date soldDate, Client seller, Client buyer, double totalDamageAllowed, double totalPower) {
        this.soldSpacheshipsList = soldSpacheshipsList;
        this.soldDate = soldDate;
        this.seller = seller;
        this.buyer = buyer;
        this.totalDamageAllowed = totalDamageAllowed;
        this.totalPower = totalPower;
    }

    public List<Spaceship> getSoldSpacheshipsList() {
        return soldSpacheshipsList;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public Client getSeller() {
        return seller;
    }

    public Client getBuyer() {
        return buyer;
    }

    public double getTotalDamageAllowed() {
        return totalDamageAllowed;
    }

    public double getTotalPower() {
        return totalPower;
    }
}