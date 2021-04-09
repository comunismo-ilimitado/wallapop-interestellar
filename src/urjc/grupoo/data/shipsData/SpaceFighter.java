package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceFighter extends Spaceship{
    public ArrayList<Weapon> weapons;
    public DefenceSystem defence;
    public SpaceFighter(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        super(i, fprop, sprop, num);
    }

}
