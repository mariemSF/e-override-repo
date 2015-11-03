package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;

public class TestDeleteProviderById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");
	
		System.out.println(proxy.deleteProviderById(1));
	}

}
