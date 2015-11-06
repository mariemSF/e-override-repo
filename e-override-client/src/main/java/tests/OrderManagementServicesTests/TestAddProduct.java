package tests.OrderManagementServicesTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import entities.Provider;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

public class TestAddProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		OrderManagementServicesRemote proxy = (OrderManagementServicesRemote) context
				.lookup("/e-override-ejb/OrderManagementServices!OrderManagementServices.interfaces.OrderManagementServicesRemote");
		
		/*Provider provider1 = new Provider();
        provider1.setId(1);
        Product product1 = new Product("iphone","Mobile", 1200, 40, provider1);
        Product product3 = new Product("dell","PC", 1700, 1, provider1);*/

        
        Provider provider2 = new Provider();
        provider2.setId(2);
        Product product2 = new Product("TCL","TV", 2200, 10, provider2);

       //System.out.println(proxy.addProduct(product1));
        System.out.println(proxy.addProduct(product2));
        //System.out.println(proxy.addProduct(product3));
        
       
	}

}
