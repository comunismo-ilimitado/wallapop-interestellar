package urjc.grupoo.data.shipsData;

import java.util.ArrayList;

public class SpaceStation extends Spaceship {
    public int passengersLimit;
    public ArrayList<Spaceship> containedShips;
    public ArrayList<DefenceSystem>  defences;
    public SpaceStation(int i, PropulsionType fprop, PropulsionType sprop, RegisterNumber num) {
        super(i, fprop, sprop, num);
    }
}
