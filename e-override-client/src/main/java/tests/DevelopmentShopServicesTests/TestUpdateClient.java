package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;



public class TestUpdateClient {

	public static void main(String[] args) throws NamingException{
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");

		Client client = proxy.findClientById(3);
		client.setName("client3");

		System.out.println(proxy.updateClient(client));
		System.out.println("Your New Name is "+client.getName());
	}

}
