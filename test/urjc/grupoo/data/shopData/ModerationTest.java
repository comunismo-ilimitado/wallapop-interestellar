package urjc.grupoo.data.shopData;

import org.junit.Test;
import static org.junit.Assert.*;
import urjc.grupoo.OfferCreationTest;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.ShopSystem;

/**
 * Test referidos a la moderación de usuarios
 *
 * @author Sergio
 */
public class ModerationTest {

    public ModerationTest() {
    }

    
        String planet1 = "Luna";
        String species1 = "Azul";
        String name1 = "Lucas";
        String nick1 = "Luquitas2";
        String password1 = "holahola";
        String email1 = "lucas@gmail.com";
        String planet2 = "Sol";
        String species2 = "Rojo";
        String name2 = "Marcos";
        String nick2 = "Marquitos2";
        String password2 = "hola";
        String email2 = "marcos@gmail.com";
        
        ShopSystem system = new ShopSystem();
        AdminFacade admin = new AdminFacade(system);
        ClientFacade clients = new ClientFacade(system);
    
    
    
    
    /**
     * Test para comprobar que un cliente es incluido correctamente en la lista
     * de fraude
     */
    @Test
    public void testInFraudList() {
        

        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        system.start();
        clients.registerClient(client);
        admin.reportUserOfFraud(client.getIdNumber());
        assertTrue(client.getLicense().isFraudSuspect());

    }

    /**
     * Test para comprobar que un cliente es incluido correctamente en la lista
     * de piratería
     */
    @Test
    public void testInPirateList() {

        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        system.start();
        clients.registerClient(client);
        admin.reportUserOfPiracy(client.getIdNumber());
        assertTrue(client.getLicense().isPirateSuspect());

    }

    /**
     * Test para comprobar que un cliente es eliminado correctamente de la lista
     * de fraude
     */
    @Test
    public void testNoInFraudList() {
        
        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        system.start();
        clients.registerClient(client);
        admin.reportUserOfFraud(client.getIdNumber());
        assertTrue(client.getLicense().isFraudSuspect());
        admin.resolveUserReportOfFraud(client.getIdNumber());
        assertFalse(client.getLicense().isFraudSuspect());

    }

    /**
     * Test para comprobar que un cliente es eliminado correctamente de la lista
     * de piratería
     */
    @Test
    public void testNoInPirateList() {
        
        //Reportamos dos clientes de piratería, quitamos solo 1 y comprobamos
        Client client1 = new Client(planet1, species1, name1, nick1, password1, email1);
        Client client2 = new Client(planet2, species2, name2, nick2, password2, email2);
        system.start();
        clients.registerClient(client1);
        clients.registerClient(client2);
        admin.reportUserOfPiracy(client1.getIdNumber());
        admin.reportUserOfPiracy(client2.getIdNumber());
        admin.resolveUserReportOfPiracy(client1.getIdNumber());
        assertFalse(client1.getLicense().isPirateSuspect());
        assertTrue(client2.getLicense().isPirateSuspect());
    }

    /**
     * Test para comprobar que un cliente es baneado correctamente forzando
     * baneo
     */
    @Test
    public void testBanned() {
  
        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        client.getLicense().setBanned(true);
        assertTrue(client.getLicense().isBanned());

    }

    /**
     * Test para comprobar que un cliente es baneado correctamente por subir más
     * de 2 ofertas inadecuadas
     */
    public void testBanned2() {

        //Creamos ofertas 1 y 2
        OfferCreationTest offercreate = new OfferCreationTest();
        Offer newOffer1 = offercreate.createTestOffer();
        Offer newOffer2 = offercreate.createTestOffer();

        //Creamos cliente
        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        system.start();
        clients.registerClient(client);

        //Subimos ofertas 1 y 2
        clients.uploadOffer(client.getIdNumber(), newOffer1);
        clients.uploadOffer(client.getIdNumber(), newOffer2);

        //Rechazamos oferta 1 y 2
        admin.moderateOffer(newOffer1.getOfferId(), false);
        admin.moderateOffer(newOffer2.getOfferId(), false);

        //Cliente baneado, se comprueba que es correcto
        assertFalse(client.getLicense().isBanned());
        
//        //Actualizo sistema
//        Manager manager = new Manager(system);
//        manager.run();
//
//        //Coimpruebo que está desbaneado
//        assertFalse(client.getLicense().isBanned());

    }
}
