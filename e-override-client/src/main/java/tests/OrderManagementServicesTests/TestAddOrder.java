package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Basket;
import entities.OrderLine;
import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAddOrder {

	public static void main(String[] args)throws NamingException  {
		Context context = new InitialContext();
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");

		OrderLine orderLine = new OrderLine();
        System.out.println(proxy.AddOrder(1, orderLine));
	}

}
