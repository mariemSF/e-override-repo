package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Order;
import entities.OrderLine;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestFindAllOrdersByCategory {

	public static void main(String[] args) throws NamingException{
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		List<OrderLine> orderLines = proxy.findAllOrdersByCategory("TV");
		for (OrderLine o : orderLines) {
			System.out.println("The Order : "+o.getOrder().getId()+" -The Client_name : "+o.getOrder().getClient().getName()+"\n");
		}

	}

}
