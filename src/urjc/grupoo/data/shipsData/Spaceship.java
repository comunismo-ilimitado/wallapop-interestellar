package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public abstract class Spaceship implements Serializable {
    public int crewMembersAmount;
    public String type;
    public PropulsionType firstpropulsion;
    public PropulsionType secondpropulsion;
    public RegisterNumber registerNumber;

    public RegisterNumber getRegisterNumber() {
        return registerNumber;
    }





    ;

    public Spaceship(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        crewMembersAmount = i;
        firstpropulsion = fprop;
        secondpropulsion = sprop;
        registerNumber = num;
    }


}
