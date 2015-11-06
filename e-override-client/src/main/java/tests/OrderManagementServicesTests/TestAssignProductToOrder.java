package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;
import entities.Order;
import entities.OrderLine;
import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAssignProductToOrder {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		
		
		Product p = proxy.findProductById(4);
		Order o =  proxy.findOrderById(2);
		
        System.out.println(proxy.AssignProductToOrder(p, o , new Float(1200.0), 1));
	}

}
