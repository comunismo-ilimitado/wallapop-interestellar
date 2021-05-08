package urjc.grupoo.data.shopData;

import java.io.File;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import urjc.grupoo.TestLib;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.system.backend.AdminFacade;
import urjc.grupoo.system.backend.ClientFacade;
import urjc.grupoo.system.backend.Database;
import urjc.grupoo.system.backend.Manager;
import urjc.grupoo.system.backend.ShopSystem;

/**
 * Test referidos a la moderación de usuarios
 *
 * @author Sergio
 */
public class ModerationTest {

    ShopSystem system;
    AdminFacade admin;
    ClientFacade clients;

    public ModerationTest() {
    }

    @Before
    public void setUp() {
        TestLib.deleteDirectory(new File(Database.savefolder));
        system = TestLib.setUpSystem();
        clients = new ClientFacade(system);
        admin = new AdminFacade(system);
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

    /**
     * Test para comprobar que un cliente es incluido correctamente en la lista
     * de fraude
     */
    @Test
    public void testInFraudList() {

        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        clients.registerClient(client);
        admin.reportUserOfFraud(client.getIdNumber());
        assertEquals(client.getLicense().isFraudSuspect(), true);

    }

    /**
     * Test para comprobar que un cliente es incluido correctamente en la lista
     * de piratería
     */
    @Test
    public void testInPirateList() {

        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        clients.registerClient(client);
        admin.reportUserOfPiracy(client.getIdNumber());
        assertEquals(client.getLicense().isPirateSuspect(), true);

    }

    /**
     * Test para comprobar que un cliente es eliminado correctamente de la lista
     * de fraude
     */
    @Test
    public void testNoInFraudList() {

        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
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
        clients.registerClient(client);
        client.getLicense().setBanned(true);
        assertTrue(client.getLicense().isBanned());

    }

    /**
     * Test para comprobar que un cliente es baneado correctamente por subir más
     * de 2 ofertas inadecuadas
     */
    @Test
    public void testBanned2() {

        Offer newOffer1 = TestLib.testOffer(Spaceship.fighter);
        Offer newOffer2 = TestLib.testOffer(Spaceship.fighter);

        //Creamos cliente
        Client client = new Client(planet1, species1, name1, nick1, password1, email1);
        clients.registerClient(client);

        //Subimos ofertas 1 y 2
        clients.uploadOffer(client.getIdNumber(), newOffer1);
        clients.uploadOffer(client.getIdNumber(), newOffer2);

        //Rechazamos oferta 1 y 2
        admin.moderateOffer(newOffer1.getOfferId(), false);
        admin.moderateOffer(newOffer2.getOfferId(), false);

        //Cliente baneado, se comprueba que es correcto
        assertTrue(client.getLicense().isBanned());

        //Sumamos 5 días a la fecha actual
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date d = new Date(System.currentTimeMillis() - (5 * DAY_IN_MS + 1));
        client.getLicense().setLastBanned(d);
        Manager manager = new Manager(system);
        manager.run();

        //Compruebo que está desbaneado
        assertFalse(client.getLicense().isBanned());
    }
}
