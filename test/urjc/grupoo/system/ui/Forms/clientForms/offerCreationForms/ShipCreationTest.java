package urjc.grupoo.system.ui.Forms.clientForms.offerCreationForms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.data.shipsData.DefenceSystem;
import urjc.grupoo.data.shipsData.ShipFactory;
import urjc.grupoo.data.shipsData.Spaceship;

/**
 *
 * @author gonza
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

    @Test
    public void testCargoCreation() {
        int crewNumber = 4;
        String propulsionType1 = Spaceship.ftldrive;
        String propulsionType2 = Spaceship.ftldrive;
        double speed = 50.6;
        String regNumber = "Z1111AAA";
        int cargo = 20040;
        
        DefenceSystem defence = new ShipFactory().CreateDefence(20, 20, "Wood");
        
        Spaceship newShip = new ShipFactory().CreateSpaceship(
                    Spaceship.cargo, crewNumber, propulsionType1, speed,
                    propulsionType2, speed, regNumber,
                    defence, cargo);
        
        assertTrue(crewNumber == newShip.getCrewMembersAmount());
        assertTrue(propulsionType1.equals(newShip.getFirstpropulsion().getName()));
        assertTrue(propulsionType2.equals(newShip.getSecondpropulsion().getName()));
        assertTrue(speed == newShip.getFirstpropulsion().getMaxSpeed());
        assertTrue(regNumber.equals(newShip.getRegisterNumber()));
        assertTrue(cargo == newShip.getMaxCargo());
        assertTrue(defence.equals(newShip.getDefenceList().get(0)));
    }
}
