package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;

public class TestAddClient {

	public static void main(String[] args) throws NamingException{
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");

		Client client = new Client("mouna", "mounaa", "3cinfo3");

		System.out.println(proxy.addClient(client));
	}

}
