package urjc.grupoo;


import urjc.grupoo.system.backend.ShopSystem;

/**
 *
 *  Clase dedicada a dar soporte a las funciones de testeo.
 *  Recoge el codigo compartido entre tests.
 */
public class TestLib {
    public static ShopSystem setUpSystem(){
        ShopSystem system = new ShopSystem();
        system.start();
        
        return system;
    }
}
