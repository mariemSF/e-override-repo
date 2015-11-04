package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;

public class TestFindAllOrdersByProductId {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<Order> orders = proxy.findAllOrdersByProductId(1);
		for (Order o : orders) {
			System.out.println(o.getOrderLines());
		}
	}

}
