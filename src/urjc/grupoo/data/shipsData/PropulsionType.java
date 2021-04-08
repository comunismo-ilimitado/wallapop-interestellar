package urjc.grupoo.data.shipsData;

public class PropulsionType {
    public String name;
    public double maxSpeed;


    public PropulsionType(int i, String str) {
        setmaxSpeed(i);
        setName(str);
    }

    ;

    public String getName

    {
        return this.name;
    }

    ;
    public Double getmaxSpeed

    {
        return this.maxSpeed;
    }

    ;

    public void setName(String str) {
        this.name = str;
    }

    ;

    public void setmaxSpeed(int i) {
        this.maxSpeed = i;
    }

    ;

}
