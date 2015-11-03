package advancedFeaturesServices.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Product;
import entities.Provider;

@Remote
public interface AdvancedFeaturesManagementRemote {
	Client loginClient(String login, String password);
	Provider loginProvider(String login, String password);
	Boolean updateClient(Client client);
	Boolean updateProvider(Provider provider);
	Boolean updateProduct(Product product);
	Boolean addProduct(Product product);
	List<Product> findAllProducts();
	List<Provider> findAllProviders();
	List<Client> findAllClients();
	Client findClientByName(String clientName);
	Client findClientById(Integer idClient);
	Client findClientByIdOrder(Integer idOrder);
	Provider findProviderByName(String providerName);
	Provider findProviderById(Integer idProvider);
	List<Provider> findProvidersByCategory(String categoryName);
	List<Provider> findProvidersByIdProduct(Integer idProduct);
	List<Product> findAllProductsByCategory(String pCategory);
	List<Product> findAllProductsByProviderName(String pName);
	List<Product> findAllProductsByIdProvider(Integer idProvider);
}
