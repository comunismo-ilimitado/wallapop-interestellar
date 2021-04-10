package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceFighter extends Spaceship {

    private ArrayList<Weapon> weapons;
    private DefenceSystem defence;

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

    public SpaceFighter(String type,int i, PropulsionType fprop, PropulsionType sprop, String num, ArrayList<Weapon> weaponlist, DefenceSystem dfsystem) {
        super(type,i, fprop, sprop, num);
        setDefence(dfsystem);
        setWeapons(weaponlist);
    }

}
