package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class Destructor extends Spaceship {

    public ArrayList<Weapon> weapons;
    public ArrayList<DefenceSystem> defences;

    public ArrayList<DefenceSystem> getDefences() {
        return defences;
    }

    public void setDefences(ArrayList<DefenceSystem> defences) {
        this.defences = defences;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Destructor(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num, ArrayList<Weapon> weaponlist, ArrayList<DefenceSystem> defencelist) {
        super(i, fprop, sprop, num);
        setDefences(defencelist);
        setWeapons(weaponlist);
    }
}
