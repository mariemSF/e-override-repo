package developmentShopServices.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Product;
import entities.Provider;

@Remote
public interface DevelopmentShopServicesRemote {
	Client loginClient(String login, String password);
	Provider loginProvider(String login, String password);
	Boolean updateClient(Client client);
	Boolean updateProvider(Provider provider);
	Boolean addClient(Client client);
	Boolean addProvider(Provider provider);
	List<Provider> findAllProviders();
	List<Client> findAllClients();
	Client findClientByName(String clientName);
	Client findClientById(Integer idClient);
	Client findClientByIdOrder(Integer idOrder);
	Provider findProviderByName(String providerName);
	Provider findProviderById(Integer idProvider);
	List<Provider> findProvidersByCategory(String categoryName);
	List<Provider> findProvidersByIdProduct(Integer idProduct);
	Boolean deleteClientById(Integer IdClient);
	Boolean deleteProviderById(Integer IdProvider);
}
