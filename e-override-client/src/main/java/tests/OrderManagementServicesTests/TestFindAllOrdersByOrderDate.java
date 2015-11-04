package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;

public class TestFindAllOrdersByOrderDate {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<Order> orders = proxy.findAllOrdersByOrderDate("09/10/2015");
		System.out.println(orders.size());

	}

}
