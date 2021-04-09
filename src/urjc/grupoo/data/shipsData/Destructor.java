package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class Destructor extends Spaceship {
    public ArrayList<DefenceSystem> defences;
    public ArrayList<Weapon> weapons;

    public Destructor(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        super(i, fprop, sprop, num);
    }
}
