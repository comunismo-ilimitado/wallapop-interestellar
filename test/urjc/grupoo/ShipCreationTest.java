package urjc.grupoo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.data.shipsData.DefenceSystem;
import urjc.grupoo.data.shipsData.ShipFactory;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shipsData.Weapon;

/**
 *
 * @author Gonzalo Ortega
 */
public class ShipCreationTest {
    
    public ShipCreationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    private final int crewNumber = 4;
    private final String propulsionType1 = Spaceship.ftldrive;
    private final String propulsionType2 = Spaceship.ftldrive;
    private final double speed = 50.6;
    private final String regNumber = "Z1111AAA";
    private final int cargo = 20040;
    private final int passangers = 235;
        
    private final DefenceSystem defence = new ShipFactory().CreateDefence(20, 20, "Wood");
    private final ArrayList<DefenceSystem> defenceList = new ArrayList<>();  
    private final ArrayList<Weapon> weaponList = new ArrayList<>();
    private final ArrayList<Spaceship> shipsList = new ArrayList<>();
        
    
    public Spaceship createTestCargo() {       
        return new ShipFactory().CreateSpaceship(
                    Spaceship.cargo, crewNumber, propulsionType1, speed,
                    propulsionType2, speed, regNumber,
                    defence, cargo);
    }
    
    public Spaceship createTestFighter() {
        weaponList.clear();
        weaponList.add(new ShipFactory().CreateWeapon(Spaceship.laserbeams, 20));
        return new ShipFactory().CreateSpaceship(
                    Spaceship.fighter, crewNumber, propulsionType1, speed,
                    propulsionType2, speed, regNumber,
                    weaponList, defence);
    }
    
    public Spaceship createTestDestructor() {
        weaponList.clear();
        weaponList.add(new ShipFactory().CreateWeapon(Spaceship.laserbeams, 20));
        
        defenceList.clear();
        defenceList.add(new ShipFactory().CreateDefence(20, 20, "Wood"));
        
        return new ShipFactory().CreateSpaceship(
                    Spaceship.destructor, crewNumber, propulsionType1, speed,
                    propulsionType2, speed, regNumber,
                    weaponList, defence);
    }
    
    public Spaceship createTestStation() {
        shipsList.clear();
        for (int i = 0; i < 10; i++) {
            shipsList.add(createTestCargo());
        }
        
        defenceList.clear();
        defenceList.add(new ShipFactory().CreateDefence(20, 20, "Wood"));
        defenceList.add(new ShipFactory().CreateDefence(34, 1223));

        return new ShipFactory().CreateSpaceship(
                    Spaceship.station, crewNumber, propulsionType1, speed,
                    propulsionType2, speed, regNumber, passangers,
                    defenceList, shipsList);
    }
    
    @Test
    public void testCargoCreation() {  
        Spaceship newShip = createTestCargo();
        
        assertTrue(Spaceship.cargo.equals(newShip.getType()));
        assertTrue(crewNumber == newShip.getCrewMembersAmount());
        assertTrue(propulsionType1.equals(newShip.getFirstpropulsion().getName()));
        assertTrue(propulsionType2.equals(newShip.getSecondpropulsion().getName()));
        assertTrue(speed == newShip.getFirstpropulsion().getMaxSpeed());
        assertTrue(regNumber.equals(newShip.getRegisterNumber()));
        assertTrue(cargo == newShip.getMaxCargo());
        assertTrue(defence.equals(newShip.getDefenceList().get(0)));
    }
    
    @Test
    public void testFighterCreation() {
        Spaceship newShip = createTestFighter();
        
        assertTrue(Spaceship.fighter.equals(newShip.getType()));
        assertTrue(crewNumber == newShip.getCrewMembersAmount());
        assertTrue(propulsionType1.equals(newShip.getFirstpropulsion().getName()));
        assertTrue(propulsionType2.equals(newShip.getSecondpropulsion().getName()));
        assertTrue(speed == newShip.getFirstpropulsion().getMaxSpeed());
        assertTrue(regNumber.equals(newShip.getRegisterNumber()));
        assertTrue(defence.equals(newShip.getDefenceList().get(0)));
        
        for(int i=0; i<weaponList.size(); i++) {
            assertTrue(weaponList.get(i).equals(newShip.getWeaponList().get(i)));
        }
        
    }
}
