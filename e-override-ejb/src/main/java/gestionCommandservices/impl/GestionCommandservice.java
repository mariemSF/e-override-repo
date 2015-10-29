package gestionCommandservices.impl;

import gestionCommandservices.interfaces.GestionCommandserviceLocal;
import gestionCommandservices.interfaces.GestionCommandserviceRemote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GestionCommandservice
 */
@Stateless
public class GestionCommandservice implements GestionCommandserviceRemote, GestionCommandserviceLocal {

    /**
     * Default constructor. 
     */
    public GestionCommandservice() {
        // TODO Auto-generated constructor stub
    }

}
