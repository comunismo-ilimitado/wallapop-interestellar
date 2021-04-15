package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class Destructor extends Spaceship {

    private ArrayList<Weapon> weapons;
    private ArrayList<DefenceSystem> defences;

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

    /**
     *Constructor de Destructor
     * @param type
     * @param i
     * @param fprop
     * @param sprop
     * @param num
     * @param weaponlist
     * @param defencelist
     */
    public Destructor(String type, int i, PropulsionType fprop, PropulsionType sprop, String num, ArrayList<Weapon> weaponlist, ArrayList<DefenceSystem> defencelist) {
        super(type, i, fprop, sprop, num);
        setDefences(defencelist);
        setWeapons(weaponlist);
    }
}
