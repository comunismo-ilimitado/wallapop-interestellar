package urjc.grupoo;


import java.io.File;
import java.util.Date;
import urjc.grupoo.data.shipsData.Spaceship;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.system.backend.ShopSystem;

/**
 *
 *  Clase dedicada a dar soporte a las funciones de testeo.
 *  Recoge el codigo compartido entre tests.
 */
public class TestLib {
    
    public static Offer testOffer(String offerType){
        return new Offer(null, new Date(), 0, 0, offerType);
    }
    
    public static ShopSystem setUpSystem(){
        ShopSystem system = new ShopSystem();
        system.start();
        
        return system;
    }
    
    public static boolean deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directory.delete();
    }
}
