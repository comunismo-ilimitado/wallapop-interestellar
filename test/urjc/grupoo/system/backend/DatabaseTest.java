
package urjc.grupoo.system.backend;

import java.io.File;
import java.io.Serializable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Clase dedicada a testear la carga/descarga de datos en disco.
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Database database;
    
    @Before
    public void setUp() {
        database = new Database();
    }
    
    @After
    public void tearDown() {
    }

    private void internalPrepareDocument(){
        String s = "test string";
        database.addContainer("test", s);
    }
    
    @Test
    public void saveDocument(){
        internalPrepareDocument();
        database.save();
        File file = new File(Database.savefolder + "test" + Database.suffix);
        assertEquals(file.exists(), true);
        
        // Borrar el archivo de prueba
        if(file.exists()) file.delete();
    }
    
    @Test
    public void loadDocument(){
        // Preparar el archivo "test"
        internalPrepareDocument();
        database.save();
        database.get("test");
        // Cargar la base otra vez
        database = new Database();
        database.loadFolder();
        assertEquals(database.get("test") != null, true);
        
        // Borrar el archivo de prueba
        File file = new File(Database.savefolder + "test" + Database.suffix);
        if(file.exists()) file.delete();
    }
    
}
