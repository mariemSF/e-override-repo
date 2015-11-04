package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Basket;
import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAddProductToBasket {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		Basket basket = new Basket();
		basket.setId(1);
		Provider provider = new Provider();
		provider.setName("med");
	    Product product = new Product("iphone", "apple", 2000, 100, provider, basket);

	    //System.out.println(proxy.AddOrder(product, order));
	}

}
