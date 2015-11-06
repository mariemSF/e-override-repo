package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;

public class TestAddProvider {

	public static void main(String[] args) throws NamingException{
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");

		Provider provider1 = new Provider("provider1", "pro1", "1cinfo3");
		Provider provider2 = new Provider("provider2", "pro2", "2cinfo3");
		Provider provider3 = new Provider("provider3", "pro3", "3cinfo3");


		System.out.println(proxy.addProvider(provider1));
		System.out.println(proxy.addProvider(provider2));
		System.out.println(proxy.addProvider(provider3));

	}

}
