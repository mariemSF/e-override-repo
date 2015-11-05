package tests.OrderManagementServicesTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;

public class TestFindAllOrdersByOrderDate {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");


		 SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");

		List<Order> orders = proxy.findAllOrdersByOrderDate(dateformat3.parse("10/09/2015"));
		System.out.println(orders.size());

	}

}
