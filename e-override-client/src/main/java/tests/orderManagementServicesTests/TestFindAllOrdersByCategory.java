package tests.orderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Order;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestFindAllOrdersByCategory {

	public static void main(String[] args) throws NamingException{
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override/OrderManagementServices!services.interfaces.OrderManagementServicesRemote");
		List<Order> orders = proxy.findAllOrdersByCategory("AB");
		for (Order o : orders) {
			System.out.println(o);
		}

	}

}
