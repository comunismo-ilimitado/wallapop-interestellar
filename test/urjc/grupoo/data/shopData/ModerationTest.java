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

    /**
     * Test para comprobar que un cliente es incluido correctamente en la lista
     * de fraude
     */
    @Test
    public void testInFraudList() {
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";
        ShopSystem system = new ShopSystem();
        AdminFacade admin = new AdminFacade(system);
        ClientFacade clients = new ClientFacade(system);

        Client client = new Client(planet, species, name, nick, password, email);
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
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";
        ShopSystem system = new ShopSystem();
        AdminFacade admin = new AdminFacade(system);
        ClientFacade clients = new ClientFacade(system);

        Client client = new Client(planet, species, name, nick, password, email);
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
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";
        ShopSystem system = new ShopSystem();
        AdminFacade admin = new AdminFacade(system);
        ClientFacade clients = new ClientFacade(system);

        Client client = new Client(planet, species, name, nick, password, email);
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
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";
        String planet2 = "Sol";
        String species2 = "Rojo";
        String name2 = "Marcos";
        String nick2 = "Marquitos2";
        String password2 = "hola";
        String email2 = "marcos@gmail.com";

        ShopSystem system = new ShopSystem();
        AdminFacade admin = new AdminFacade(system);
        ClientFacade clients = new ClientFacade(system);
        system.start();

        //Reportamos dos clientes de piratería, quitamos solo 1 y comprobamos
        Client client1 = new Client(planet, species, name, nick, password, email);
        Client client2 = new Client(planet2, species2, name2, nick2, password2, email2);
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
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";

        Client client = new Client(planet, species, name, nick, password, email);
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
        String planet = "Luna";
        String species = "Azul";
        String name = "Lucas";
        String nick = "Luquitas2";
        String password = "holahola";
        String email = "lucas@gmail.com";
        Client client = new Client(planet, species, name, nick, password, email);
        ShopSystem system = new ShopSystem();
        ClientFacade clients = new ClientFacade(system);
        system.start();
        clients.registerClient(client);

        //Subimos ofertas 1 y 2
        clients.uploadOffer(client.getIdNumber(), newOffer1);
        clients.uploadOffer(client.getIdNumber(), newOffer2);

        //Rechazamos oferta 1 y 2
        AdminFacade admin = new AdminFacade(system);
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
