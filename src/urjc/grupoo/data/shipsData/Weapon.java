package urjc.grupoo.data.shipsData;

public class Weapon {
    private double power;
    private String name;

    public Weapon(String str ,double i) {
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

