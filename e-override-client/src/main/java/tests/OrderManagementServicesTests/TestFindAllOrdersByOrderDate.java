package tests.OrderManagementServicesTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;
import entities.OrderLine;

public class TestFindAllOrdersByOrderDate {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");


		 SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");

		List<OrderLine> orderLines = proxy.findAllOrdersByOrderDate(dateformat3.parse("06/11/2015"));
		for (OrderLine o : orderLines) {
			System.out.println(o.getOrder().getId());
		}
	}

}
