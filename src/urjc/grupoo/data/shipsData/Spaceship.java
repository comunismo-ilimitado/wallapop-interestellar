package urjc.grupoo.data.shipsData;

import java.io.Serializable;

public abstract class Spaceship implements Serializable {

    private RegisterNumber registerNumber;
    private int crewMembersAmount;
    private PropulsionType firstpropulsion;
    private PropulsionType secondpropulsion;
    private String type;

    public int getCrewMembersAmount() {
        return crewMembersAmount;
    }

    public void setCrewMembersAmount(int crewMembersAmount) {
        this.crewMembersAmount = crewMembersAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropulsionType getFirstpropulsion() {
        return firstpropulsion;
    }

    public void setFirstpropulsion(PropulsionType firstpropulsion) {
        this.firstpropulsion = firstpropulsion;
    }

    public PropulsionType getSecondpropulsion() {
        return secondpropulsion;
    }

    public void setSecondpropulsion(PropulsionType secondpropulsion) {
        this.secondpropulsion = secondpropulsion;
    }

    public void setRegisterNumber(RegisterNumber registerNumber) {
        this.registerNumber = registerNumber;
    }

    public RegisterNumber getRegisterNumber() {
        return registerNumber;
    }

    public Spaceship(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        crewMembersAmount = i;
        firstpropulsion = fprop;
        secondpropulsion = sprop;
        registerNumber = num;
    }


}
