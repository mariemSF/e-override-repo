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
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");

		Client client = proxy.findClientById(1);
		client.setName("ahmed");

		System.out.println(proxy.updateClient(client));
	}

}
