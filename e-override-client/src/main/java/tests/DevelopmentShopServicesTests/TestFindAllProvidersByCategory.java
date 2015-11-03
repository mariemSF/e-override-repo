package tests.DevelopmentShopServicesTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Provider;

public class TestFindAllProvidersByCategory {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DevelopmentShopServicesRemote proxy = (DevelopmentShopServicesRemote) context
				.lookup("/e-override-ejb/DevelopmentShopServices!developmentShopServices.interfaces.DevelopmentShopServicesRemote");

		List<Provider> providers = proxy.findAllProvidersByCategory("telephone");
		for (Provider p : providers) {
			System.out.println(p.getName());
		}

	}

}
