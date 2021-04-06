package urjc.grupoo.system.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import urjc.grupoo.data.shopData.Admin;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.Offer;
import urjc.grupoo.data.shopData.SystemAdmins;
import urjc.grupoo.data.shopData.SystemClients;
import urjc.grupoo.data.shopData.SystemOffers;


public class AdminFacade {
    
    private ShopSystem system;
    
    public AdminFacade(ShopSystem system){
        this.system = system;
    }
   
    
    // Devuelve el administrador
    public Admin login(String user, String passwd){
        Admin c = null;
        
        SystemAdmins admins = 
                (SystemAdmins)system.getDatabase().get(ShopSystem.adminData);
        
        boolean found = false;
        c = admins.getAdmin(user);
        return c;
    }
    
    
    public Collection<Offer> getModerationList(){
        Collection<Offer> roffers = new ArrayList<>();
        
        SystemOffers offers = (SystemOffers)system.getDatabase()
                .get(ShopSystem.moderationOfferData);
        
        roffers = offers.getOffers().values();
        
        return roffers;
    }
    
    public void moderateOffer(int offerId, boolean pass){
    
        SystemOffers offers = (SystemOffers)system.getDatabase()
                .get(ShopSystem.moderationOfferData);
        
        if(pass){
            
        }
        
    }
    
}
