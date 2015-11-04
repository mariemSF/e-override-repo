package tests.OrderManagementServicesTests;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestDeleteProductById {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		System.out.println(proxy.deleteproductById(2));
	}

}
