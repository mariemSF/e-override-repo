package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.OrderLine;

public class TestFindAllProductsByIdOrder {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<OrderLine> orderLines = proxy.findAllProductsByIdOrder(1);
		for (OrderLine o : orderLines) {
			System.out.println(o.getProduct().getName());
		}
	}


}
