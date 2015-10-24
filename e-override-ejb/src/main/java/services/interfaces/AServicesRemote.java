package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface AServicesRemote {
	String SayHello(String name);

}
