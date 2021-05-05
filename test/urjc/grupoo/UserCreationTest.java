
package urjc.grupoo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;

/**
 *
 * @author Gonzalo Ortega
 */
public class UserCreationTest {
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

    private final String planet = "Marte";
    private final String species = "Marciano";
    private final String name = "Walington";
    private final String nick = "Wal69";
    private final String password = "1234";
    private final String email = "walington@spacemail.com";

    
    public Client createTestClient() {       
        return new Client(planet, species, name, nick, password, email);
    }
    
    public Admin createTestAdmin(){
        return new Admin(name, nick, password, email);
    }
}
