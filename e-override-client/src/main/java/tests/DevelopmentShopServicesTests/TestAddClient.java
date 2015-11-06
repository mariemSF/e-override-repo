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

		Client client = new Client("mohamed", "med", "3cinfo3");
		Client client1 = new Client("brahim", "barhoum", "2cinfo3");
		Client client2 = new Client("yassine", "yesso", "1cinfo3");


		System.out.println(proxy.addClient(client));
		System.out.println(proxy.addClient(client1));
		System.out.println(proxy.addClient(client2));


	}

}
