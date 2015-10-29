package gestionCrudservices.impl;

import gestionCrudservices.interfaces.GestionCrudserviceLocal;
import gestionCrudservices.interfaces.GestionCrudserviceRemote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GestionCrudservice
 */
@Stateless
public class GestionCrudservice implements GestionCrudserviceRemote, GestionCrudserviceLocal {

    /**
     * Default constructor. 
     */
    public GestionCrudservice() {
        // TODO Auto-generated constructor stub
    }

}
