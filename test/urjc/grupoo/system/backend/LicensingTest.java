package urjc.grupoo.system.backend;

import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import urjc.grupoo.TestLib;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;

public class LicensingTest {
    
    
    ShopSystem system;
    
    ClientFacade clientFacade;
    AdminFacade adminFacade;
    
    @Before
    public void setUp() {
        TestLib.deleteDirectory(new File(Database.savefolder));
        system = TestLib.setUpSystem();
        clientFacade = new ClientFacade(system);
        adminFacade = new AdminFacade(system);
    }
    
    @Test
    public void bannedClientLogin(){
    
        String s = "test-banned";
        Client client = new Client(s, s, s, s, s, s);
        
        clientFacade.registerClient(client);
        client.getLicense().setBanned(true);
        
        boolean correct = clientFacade.login(s, s) != null;
        assertEquals(correct, false);
    }
    
    @Test
    public void fraudClientUploading(){
        String s = "test-fraud";
        Client client = new Client(s, s, s, s, s, s);
        
        clientFacade.registerClient(client);
        adminFacade.reportUserOfFraud(client.getIdNumber());
        
        assertEquals(client.getLicense().isFraudSuspect(), true);
        
        Offer offer = TestLib.testOffer(Spaceship.fighter);
        clientFacade.uploadOffer(0, offer);
        
        // revisar que la oferta no se ha subido
        assertEquals(client.getActiveOffers().size(), 0);
    }
    
    @Test
    public void pirateClientBuyingWeaponized(){
        String s = "test-pirate";
        Client client = new Client(s, s, s, s, s, s);
        
        clientFacade.registerClient(client);
        adminFacade.reportUserOfPiracy(client.getIdNumber());
        
        assertEquals(client.getLicense().isPirateSuspect(), true);
        
        Offer offer = TestLib.testOffer(Spaceship.fighter);
        clientFacade.uploadOffer(0, offer);
        adminFacade.moderateOffer(offer.getOfferId(), true);
        
        boolean t = clientFacade.buyOffer(client.getIdNumber(), offer.getOfferId(), Spaceship.fighter);
        
        assertEquals(t, false);
    }
    
}
