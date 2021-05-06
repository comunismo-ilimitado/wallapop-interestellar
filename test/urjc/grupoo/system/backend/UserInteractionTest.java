/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urjc.grupoo.system.backend;

import urjc.grupoo.TestLib;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;

/**
 *
 * @author jorge
 */
public class UserInteractionTest {
    
    ShopSystem system;
    
    ClientFacade clientFacade;
    AdminFacade adminFacade;
    
    public UserInteractionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        system = TestLib.setUpSystem();
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);
    }
    
    @After
    public void tearDown() {
    }


    
    @Test
    public void clientRegistration(){
        
        // Caso no especial
        String s = "test";
        Client client = new Client(s, s, s, s, s, s);
        
        clientFacade.registerClient(client);
        
        boolean correct = clientFacade.login(s, s) != null;
        assertEquals(correct, true);

    }
    
    @Test
    public void adminRegistration(){
        String s = "test";
        Admin admin = new Admin(s, s, s, s);
        
        adminFacade.registerAdmin(admin);
        
        boolean correct = adminFacade.login(s, s) != null;
        assertEquals(correct, true);
    }
    
    
    
}
