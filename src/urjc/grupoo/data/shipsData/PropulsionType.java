package urjc.grupoo.data.shipsData;

public class PropulsionType {
    public String name;
    public double maxSpeed;


    public PropulsionType(int i, String str) {
        setmaxSpeed(i);
        setName(str);
    }

    ;

    public void setName(String str) {
        this.name = str;
    }

    ;
    public String getName

    {
        return name;
    }

    ;
    public Double getmaxSpeedADouble

    {
        return maxSpeed;
    }

    ;


    public void setmaxSpeed(int i) {
        maxSpeed = i;
    }

    ;

}
