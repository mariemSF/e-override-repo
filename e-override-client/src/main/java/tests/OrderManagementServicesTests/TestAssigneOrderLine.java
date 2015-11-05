package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Basket;
import entities.Client;
import entities.Order;
import entities.OrderLine;
import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAssigneOrderLine {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		
		
		Product p = proxy.findProductById(2);
		Order o =  proxy.findOrderById(1);
		
        System.out.println(proxy.AssignOrderLine(p, o , new Float(10.0), 5));
	}

}
