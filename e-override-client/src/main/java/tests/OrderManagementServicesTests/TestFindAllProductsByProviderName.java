package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Product;


public class TestFindAllProductsByProviderName {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<Product> products = proxy.findAllProductsByProviderName("provider1");
		for (Product p : products) {
			System.out.println("Product_name : "+p.getName()+"\n");
		}


	}

}
