package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Order;
import entities.OrderLine;

public class TestFindAllOrdersByProductId {

	public static void main(String[] args)throws NamingException {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<OrderLine> orderLines = proxy.findAllOrdersByProductId(2);
		for (OrderLine o : orderLines) {
			System.out.println(o.getOrder().getId()+" "+o.getProduct().getName());
		}
	}

}
