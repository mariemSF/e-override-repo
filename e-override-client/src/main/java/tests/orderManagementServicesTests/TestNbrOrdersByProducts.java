package tests.orderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;

public class TestNbrOrdersByProducts {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override/OrderManagementServices!services.interfaces.OrderManagementServicesRemote");

		List<Order> orders = proxy.nbrOrdersByProduct(1, 20);
		for (Order o : orders) {
			System.out.println(o.getId() + o.getQuantity());
		}
	}


}
