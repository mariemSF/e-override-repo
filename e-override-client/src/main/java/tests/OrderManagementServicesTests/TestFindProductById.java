package tests.OrderManagementServicesTests;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestFindProductById {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		
			Product p = proxy.findProductById(1);
			System.out.println(p.getName());
		
	}
}
