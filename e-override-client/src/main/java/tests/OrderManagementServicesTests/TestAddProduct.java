package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAddProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		
		Provider provider = new Provider();
        provider.setName("Ali");
        Product product = new Product("AB", 200, 20, provider);

        System.out.println(proxy.addProduct(product));
	}

}
