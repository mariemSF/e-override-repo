package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;


public class TestLoginClient{

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");

		Client clientLoggedIn = proxy.loginClient("mouna", "3cinfo3");

		System.out.println("Welcome " + clientLoggedIn.getName());
	}
}
