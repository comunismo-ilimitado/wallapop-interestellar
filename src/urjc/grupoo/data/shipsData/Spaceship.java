package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public abstract class Spaceship  implements Serializable {
    public  int crewMembersAmount;
    public String type;
    public PropulsionType firstpropulsion;
    public PropulsionType secondpropulsion;
    public RegisterNumber registerNumber;

    public String getNumber(){ 
        return registerNumber.getNumber();
    };


}
