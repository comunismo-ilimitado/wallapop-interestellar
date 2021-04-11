package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public class Weapon implements Serializable {

    private double power;
    private String name;

    public Weapon(String str, double i) {
        setName(str);
        setPower(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
