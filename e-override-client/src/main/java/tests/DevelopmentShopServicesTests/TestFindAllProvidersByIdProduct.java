package tests.DevelopmentShopServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;


public class TestFindAllProvidersByIdProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		
			
		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		
		System.out.print(proxy.findProductById(9).getProvider().getName());
		
	}

}
