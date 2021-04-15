package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public class PropulsionType implements Serializable {

    private String name;
    private double maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     *Constructor de Propulsión
     * @param i
     * @param str
     */
    public PropulsionType(double i, String str) {
        setMaxSpeed(i);
        setName(str);

    }

}
