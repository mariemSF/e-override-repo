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
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");
		Client client = proxy.findClientByName("mohamed");

		System.out.println(" Hello " + client.getName()+"\n Your login is "+client.getLogin()+"\n Your password is "+client.getPassword());

	}

}
