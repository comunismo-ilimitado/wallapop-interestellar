/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urjc.grupoo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.Database;
import urjc.grupoo.system.backend.ShopSystem;
import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class OfferCreationTest {

    public OfferCreationTest() {
    }

    ShopSystem system;
    ClientFacade clientFacade;
    AdminFacade adminFacade;
    
    private final Client client = new UserCreationTest().createTestClient();
    
    @Before
    public void setUp() {
        TestLib.deleteDirectory(new File(Database.savefolder));
        system = TestLib.setUpSystem();
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);
        clientFacade.registerClient(client);
    }

    @AfterClass
    public static void tearDownClass() {
    }

  
    @After
    public void tearDown() {
    }

   

    ShipCreationTest testShips = new ShipCreationTest();

    ArrayList<Spaceship> shipsList = new ArrayList<>();
    Date limitDate = new Date();
    Double price = 199.99;
    Double price2 = 23.67;
    String offerType;

    public Offer createTestOffer() {
        for (int i = 0; i < 10; i++) {
            shipsList.add(testShips.createTestCargo());
        }
        offerType = shipsList.get(0).getType();
        return new Offer(shipsList, limitDate, price, client.getIdNumber(), offerType);
     
    }
    
    public Offer createTestOffer2() {
        for (int i = 0; i < 10; i++) {
            shipsList.add(testShips.createTestCargo());
        }
        offerType = shipsList.get(0).getType();
        return new Offer(shipsList, limitDate, price2, client.getIdNumber(), offerType);
    
    }

    @Test
    public void testOfferUpload() {
        Offer newOffer = createTestOffer();
        clientFacade.uploadOffer(0, newOffer);
        adminFacade.moderateOffer(newOffer.getOfferId(), true);   
        Offer uploadOffer = clientFacade.getOffer(newOffer.getOfferId(), newOffer.getOfferType());
        
        assertTrue(uploadOffer.getPrice() == price);
    }

}
