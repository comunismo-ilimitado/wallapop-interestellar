package urjc.grupoo.system.backend;

import urjc.grupoo.data.shopData.Client;

public class PermissionsManager {

    public boolean checkPermission(Permission permission, Client client) {
        boolean r = false;

        switch (permission) {

            case UploadOffers:
                r = !client.getLicense().isFraudSuspect();
                break;
            case SendComments:
                r = !client.getLicense().isFraudSuspect();
                break;
            case BuyWeaponizedShip:
                r = !client.getLicense().isPirateSuspect();
                break;
            case Buy:
                r = !client.getLicense().isFraudSuspect();
                break;
        }
        return r;
    }

    public enum Permission {
        SendComments, UploadOffers, BuyWeaponizedShip, Buy
    }
}
