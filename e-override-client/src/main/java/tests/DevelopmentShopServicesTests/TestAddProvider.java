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

		Provider provider = new Provider("Ali", "Aloulou", "3cinfo3");

		System.out.println(proxy.addProvider(provider));

	}

}
