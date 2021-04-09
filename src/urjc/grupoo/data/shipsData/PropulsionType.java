package urjc.grupoo.data.shipsData;

public class PropulsionType {

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

    public PropulsionType(double i, String str) {
        setMaxSpeed(i);
        setName(str);

    }

}
