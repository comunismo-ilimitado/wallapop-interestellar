package urjc.grupoo.system.backend;

import java.io.File;
import urjc.grupoo.TestLib;
import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.ClientComment;
import urjc.grupoo.data.shopData.Offer;


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
        TestLib.deleteDirectory(new File(Database.savefolder));
        system = TestLib.setUpSystem();
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);
    }
    
    @After
    public void tearDown() {
    }


    
    @Test
    public void clientRegistrationAndLogin(){
        
        // Caso no especial
        String s = "test";
        Client client = new Client(s, s, s, s, s, s);
        
        clientFacade.registerClient(client);
        
        boolean correct = clientFacade.login(s, s) != null;
        assertEquals(correct, true);

        // Caso cliente y contraseña incorrectas
        boolean correct2 = clientFacade.login("ÑÑÑ", "ÑÑÑ") != null;
        assertEquals(correct2, false);

    }
    
    
    @Test
    public void clientRegistrationStress() {
        for (int i = 0; i < 1000; i++) {
            // Caso no especial
            String s = "test"+Integer.toString(i);
            Client client = new Client(s, s, s, s, s, s);

            clientFacade.registerClient(client);

            boolean correct = clientFacade.login(s, s) != null;
            assertEquals(correct, true);
        }
    }
    
    @Test
    public void adminRegistration(){
        String s = "test";
        Admin admin = new Admin(s, s, s, s);
        
        adminFacade.registerAdmin(admin);
        
        boolean correct = adminFacade.login(s, s) != null;
        assertEquals(correct, true);
    }
    
    @Test
    public void offerSearch(){
        Offer offer = TestLib.testOffer(Spaceship.fighter);
        clientFacade.uploadOffer(0, offer);
        adminFacade.moderateOffer(offer.getOfferId(), true);
        
        Collection<Offer> roffers = clientFacade.getOffers(Spaceship.fighter);
        assertEquals(roffers.contains(offer), true);
    }
    
    @Test
    public void subscriptionNotifications(){
        
        // Crear un cliente de prueba
        String s = "test";
        Client client = new Client(s, s, s, s, s, s);
        clientFacade.registerClient(client);
        clientFacade.suscribeClientTo(client.getIdNumber(), Spaceship.fighter);
        
        // Crear una oferta del tipo
        Offer offer = TestLib.testOffer(Spaceship.fighter);
        clientFacade.uploadOffer(0, offer);
        adminFacade.moderateOffer(offer.getOfferId(), true);
        
        // Comprobar que la id de la oferta coincida
        int offerId = client.getNotifications().getNotificationList().get(0).getOfferId();
        assertEquals(offerId == offer.getOfferId(), true);
        
        // Comprobar que una vez se ven las notificaciones estas desaparecen
        clientFacade.notificationsSeen(client.getIdNumber());
        assertEquals(client.getNotifications().getNotificationList().size(), 0);
    }
    
    @Test
    public void addComment(){
        // Crear un cliente de prueba
        String s = "test";
        Client client = new Client(s, s, s, s, s, s);
        clientFacade.registerClient(client);
        
        ClientComment comment = new ClientComment(0, s, null, 0);
        clientFacade.addComment(client.getIdNumber(), comment);
        assertNotEquals(client.getCommentList().size(), 0);
    }

    
    
}
