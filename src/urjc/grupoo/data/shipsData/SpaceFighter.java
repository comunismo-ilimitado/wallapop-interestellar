package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceFighter extends Spaceship {

    public ArrayList<Weapon> weapons;
    public DefenceSystem defence;

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public DefenceSystem getDefence() {
        return defence;
    }

    public void setDefence(DefenceSystem defence) {
        this.defence = defence;
    }

    public SpaceFighter(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num, ArrayList<Weapon> weaponlist, DefenceSystem dfsystem) {
        super(i, fprop, sprop, num);
        setDefence(dfsystem);
        setWeapons(weaponlist);
    }

}
