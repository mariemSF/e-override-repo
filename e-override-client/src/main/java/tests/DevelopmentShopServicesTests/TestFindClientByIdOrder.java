package tests.DevelopmentShopServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import developmentShopServices.interfaces.DevelopmentShopServicesRemote;

public class TestFindClientByIdOrder {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");
		OrderManagementServicesRemote proxy1 = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
      

	}

}
