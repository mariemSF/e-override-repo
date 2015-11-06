package tests.OrderManagementServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.OrderLine;
import entities.Product;

public class TestFindAllOrders {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		List<OrderLine> orderLines = proxy.findAllOrders();
		for (OrderLine o : orderLines) {
			System.out.println("The order Id: "+o.getOrder().getId()+" -The Product_name: "+o.getProduct().getName()+" -The Client_name: "+o.getOrder().getClient().getName()+"\n");
		}
	}

}
