package advancedFeaturesServices.impl;

import java.util.List;

import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementLocal;
import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Client;
import entities.Product;
import entities.Provider;

/**
 * Session Bean implementation class AdvancedFeaturesManagement
 */
@Stateless
public class AdvancedFeaturesManagement implements AdvancedFeaturesManagementRemote, AdvancedFeaturesManagementLocal {

	
    /**
     * Default constructor. 
     */
    public AdvancedFeaturesManagement() {
        // TODO Auto-generated constructor stub
    }


}
