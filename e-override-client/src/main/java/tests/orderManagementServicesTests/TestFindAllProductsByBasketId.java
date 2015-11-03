package tests.orderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Product;

public class TestFindAllProductsByBasketId {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override/OrderManagementServices!services.interfaces.OrderManagementServicesRemote");

		List<Product> products = proxy.findAllProductsByBasketId(1);
		for (Product p : products) {
			System.out.println(p);
		}
	}


}
