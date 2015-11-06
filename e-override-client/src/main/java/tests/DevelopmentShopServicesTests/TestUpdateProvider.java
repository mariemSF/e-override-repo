package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;

public class TestUpdateProvider {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");

		Provider provider = proxy.findProviderById(3);
		provider.setName("brahim");

		System.out.println(proxy.updateProvider(provider));
		System.out.println("Your New Name is "+provider.getName());

	}

}
