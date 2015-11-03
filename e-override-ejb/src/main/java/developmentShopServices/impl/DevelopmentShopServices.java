package developmentShopServices.impl;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import developmentShopServices.interfces.DevelopmentShopServicesLocal;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DevelopmentShopServices
 */
@Stateless
public class DevelopmentShopServices implements DevelopmentShopServicesRemote, DevelopmentShopServicesLocal {

    /**
     * Default constructor. 
     */
    public DevelopmentShopServices() {
        // TODO Auto-generated constructor stub
    }

}
