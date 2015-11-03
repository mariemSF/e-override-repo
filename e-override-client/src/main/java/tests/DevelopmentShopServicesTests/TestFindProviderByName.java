package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;

public class TestFindProviderByName {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");
		Provider provider = proxy.findProviderByName("Ali");

		System.out.println(" (Provider) Hello " + provider.getName()+" , your login is "+provider.getLogin()+" , your password is "+provider.getPassword() +" and your products are: "+provider.getProducts());

	}

}
