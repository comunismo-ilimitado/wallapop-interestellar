/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urjc.grupoo;

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
import urjc.grupoo.system.ui.SystemSession;

/**
 *
 * @author Gonzalo Ortega
 */
public class OfferCreationTest {

    public OfferCreationTest() {
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

    private final SystemSession session = new SystemSession();
    private final Client client = new UserCreationTest().createTestClient();

    ShipCreationTest testShips = new ShipCreationTest();

    ArrayList<Spaceship> shipsList = new ArrayList<>();
    Date limitDate = new Date();
    Double price = 199.99;
    Double price2 = 23.67;
    String offerType = shipsList.get(0).getType();

    public Offer createTestOffer() {
        for (int i = 0; i < 10; i++) {
            shipsList.add(testShips.createTestCargo());
        }
        return new Offer(shipsList, limitDate, price, client.getIdNumber(), offerType);
     
    }
    
    public Offer createTestOffer2() {
        for (int i = 0; i < 10; i++) {
            shipsList.add(testShips.createTestCargo());
        }
        return new Offer(shipsList, limitDate, price2, client.getIdNumber(), offerType);
    
    }

    @Test
    public void testOfferUpload() {
        Offer newOffer = createTestOffer();
        session.getClientFacade().uploadOffer(client.getIdNumber(), newOffer);
        
        Offer uploadOffer = session.getClientFacade().getOffer(newOffer.getOfferId(), newOffer.getOfferType());
        assertTrue(uploadOffer.getPrice() == price);
    }

}
