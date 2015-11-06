package tests.DevelopmentShopServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;

public class TestFindAllProvidersByCategory {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");
	
		OrderManagementServicesRemote proxy1 = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
      
		if(!proxy1.findAllProductsByCategory("tv").isEmpty()){
		      List<Provider> providers = proxy.findAllProvidersByCategory("TV");
		      for (Provider p : providers) {
			         System.out.println(p.getName());
		      }
        }else{
		     System.out.println("No such category");
		}
	}

}
