package CrudManagementServices.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Product;
import entities.Provider;


@Remote
public interface GestionCrudserviceRemote {
	
	Client loginClient(String login, String password);
	Provider loginProvider(String login, String password);
	Boolean addProduct(Product produit);
	List<Product> findAllProducts();
	List<Provider> findAllProviders();
	List<Client> findAllClients();
	List<Product> findAllProductsByCategory(String pCategory);
	List<Product> findAllProductsByProviderName(String pName);
}
