package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;


public class TestUpdateProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		Product product = proxy.findProductById(5);
		product.setCategory("Car");
		product.setName("KIA");
		product.setPrice(20000);
		product.setQuantity(1);

		System.out.println(proxy.updateProduct(product));

	}

}
