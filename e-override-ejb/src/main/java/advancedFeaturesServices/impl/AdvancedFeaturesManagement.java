package advancedFeaturesServices.impl;

import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementLocal;
import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 * Session Bean implementation class AdvancedFeaturesManagement
 */
@Stateless
public class AdvancedFeaturesManagement implements AdvancedFeaturesManagementRemote, AdvancedFeaturesManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AdvancedFeaturesManagement() {
        // TODO Auto-generated constructor stub
    }
    
    


}
