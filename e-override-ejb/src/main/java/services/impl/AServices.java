package services.impl;

import javax.ejb.Stateless;

import services.interfaces.AServicesRemote;

/**
 * Session Bean implementation class AServices
 */
@Stateless
public class AServices implements AServicesRemote {

    /**
     * Default constructor. 
     */
    public AServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String SayHello(String name) {
		return "Hello "+name;
	}

}
