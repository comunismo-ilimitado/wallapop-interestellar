package urjc.grupoo.data.shipsData;

import java.util.ArrayList;
import java.util.Objects;

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

    /**
     * Constructor de Caza
     * @param type
     * @param i
     * @param fprop
     * @param sprop
     * @param num
     * @param weaponlist
     * @param dfsystem
     */
    public SpaceFighter(String type, int i, PropulsionType fprop, PropulsionType sprop, String num, ArrayList<Weapon> weaponlist, DefenceSystem dfsystem) {
        super(type, i, fprop, sprop, num);
        setDefence(dfsystem);
        setWeapons(weaponlist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceFighter)) return false;
        if (!super.equals(o)) return false;
        SpaceFighter that = (SpaceFighter) o;
        return Objects.equals(getWeapons(), that.getWeapons()) && Objects.equals(getDefence(), that.getDefence());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeapons(), getDefence());
    }
}
