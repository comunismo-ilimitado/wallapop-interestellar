package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public class Weapon implements Serializable {

    private double power;
    private String name;

    /**
     * Constructor de Arma
     * @param str
     * @param i
     */
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

    public boolean equals(Weapon x) {
        boolean a = false;
        boolean b = false;
        b = this.getName()==x.getName();
        a = this.getPower()==x.getPower();
        return a&&b;
        }


}
