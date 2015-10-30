package gestionCrudservices.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Product;
import entities.Provider;


@Remote
public interface GestionCrudserviceRemote {
	
	Client loginClient(String name, String password);
	Provider loginProvider(String name, String password);
	Boolean addProduct(Product produit);
	List<Product> findAllProducts();
	List<Provider> findAllProviders();
	List<Client> findAllClients();
}
