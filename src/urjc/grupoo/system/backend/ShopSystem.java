package urjc.grupoo.system.backend;


import java.util.Date;
import urjc.grupoo.data.shopData.Client;
import urjc.grupoo.data.shopData.SoldSpaceships;
import urjc.grupoo.data.shopData.SystemAdmins;
import urjc.grupoo.data.shopData.SystemClients;
import urjc.grupoo.data.shopData.SystemOffers;

public class ShopSystem {
    private Database database;
    
    private PermissionsManager permissionsManager;
    
    public ShopSystem() {
        this.database = new Database();
        this.permissionsManager = new PermissionsManager();
    }
    
    // Funcion que inicia las bases del sistema
    public void start(){
        loadDatabase();
    }
    
    public static String clientData = "ClientData";
    public static String adminData = "AdminData";
    public static String moderationOfferData = "ModOfferData";
    public static String spaceStationOfferData = "StatOfferData";
    public static String cargoOfferData = "CargoOfferData";
    public static String desOfferData = "desOfferData";
    public static String spacefighterOfferData = "fighterOfferData";
    
    public static String soldData = "SoldSpaceShipData";
    
    // Cargar la base de datos del disco
    public void loadDatabase(){
        database.loadFolder();
        
        // Crear datos de cliente
        if(database.get(clientData) == null){
            SystemClients data = new SystemClients();
            database.addContainer(clientData, data);
        }
        
        //Crear datos de admin
        if(database.get(adminData) == null){
            SystemAdmins data = new SystemAdmins();
            database.addContainer(adminData, data);
        }
        
        //Crear datos de ofertas
        if(database.get(moderationOfferData) == null){
            SystemOffers data = new SystemOffers();
            database.addContainer(moderationOfferData, data);
        }
        if(database.get(spaceStationOfferData) == null){
            SystemOffers data = new SystemOffers();
            database.addContainer(spaceStationOfferData, data);
        }
        if(database.get(cargoOfferData) == null){
            SystemOffers data = new SystemOffers();
            database.addContainer(cargoOfferData, data);
        }
        if(database.get(desOfferData) == null){
            SystemOffers data = new SystemOffers();
            database.addContainer(desOfferData, data);
        }
        if(database.get(spacefighterOfferData) == null){
            SystemOffers data = new SystemOffers();
            database.addContainer(spacefighterOfferData, data);
        }
        
        
        //Crear datos de ventas
        if(database.get(soldData) == null){
            SoldSpaceships data = new SoldSpaceships();
            database.addContainer(soldData, data);
        }
    }
    
    public void saveDatabase(){
        database.save();
    }

    public Database getDatabase() {
        return database;
    }

    public PermissionsManager getPermissionsManager() {
        return permissionsManager;
    }
    
    public Date getDate(){
        return new java.util.Date();
    }
    
    public SystemOffers getOffersByType(String offerType){
        SystemOffers offers = null;
        switch(offerType){
            case "Station":
                offers = (SystemOffers)getDatabase()
                        .get(ShopSystem.spaceStationOfferData);
                break;
            case "Cargo":
                offers = (SystemOffers)getDatabase()
                        .get(ShopSystem.cargoOfferData);
                break;
            case "Destructor":
                offers = (SystemOffers)getDatabase()
                        .get(ShopSystem.desOfferData);
                break;
            default:
                offers = (SystemOffers)getDatabase()
                        .get(ShopSystem.spacefighterOfferData);
                break;
        }
        return offers;
    }
    
}
