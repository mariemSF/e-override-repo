package tests.DevelopmentShopServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;


public class TestFindAllClients {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/ebi/TeamManagementServices!services.interfaces.TeamManagementServicesRemote");

		List<Client> clients = proxy.findAllClients();
		for (Client c : clients) {
			System.out.println(c.getName());
		}
	}

}
