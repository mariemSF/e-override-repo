package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;

public class TestFindClientByName {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");
		Client client = proxy.findClientByName("mouna");

		System.out.println(" (Client) Hello " + client.getName()+" , your login is "+client.getLogin()+" , your password is "+client.getPassword() +" and your orders are: "+client.getOrders());

	}

}
