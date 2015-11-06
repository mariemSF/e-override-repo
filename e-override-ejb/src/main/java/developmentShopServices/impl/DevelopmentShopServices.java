package developmentShopServices.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import developmentShopServices.interfaces.DevelopmentShopServicesLocal;
import developmentShopServices.interfaces.DevelopmentShopServicesRemote;
import entities.Client;
import entities.Order;
import entities.Product;
import entities.Provider;


/**
 * Session Bean implementation class DevelopmentShopServices
 */
@Stateless
public class DevelopmentShopServices implements DevelopmentShopServicesRemote, DevelopmentShopServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public DevelopmentShopServices() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Client loginClient(String login, String password) {
		String jpql = "select c from Client c where c.login=:param1 and c.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		Client client = null;
		try {
			client =(Client) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("error");
		}
		return client;
	}

	@Override
	public Provider loginProvider(String login, String password) {
		String jpql = "select p from Provider p where p.login=:param1 and p.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		Provider provider = null;
		try {
			provider = (Provider) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("error");
		}
		return provider;
	}

	@Override
	public Boolean updateClient(Client client) {
		Boolean b = false;
		try {
			entityManager.merge(client);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateProvider(Provider provider) {
		Boolean b = false;
		try {
			entityManager.merge(provider);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProviders() {
		String jpql = "select p from Provider p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllClients() {
		String jpql = "select c from Client c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Client findClientByName(String clientName) {
		String jpql = "select c from Client c where c.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", clientName);
		return (Client) query.getResultList().get(0);
	}

	@Override
	public Client findClientById(Integer idClient) {
		return entityManager.find(Client.class, idClient);
	}


	@Override
	public Provider findProviderByName(String providerName) {
		
		String jpql = "select c from Provider c where c.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", providerName);
		return (Provider) query.getResultList().get(0);
	}

	@Override
	public Provider findProviderById(Integer idProvider) {
		return (Provider) entityManager.find(Provider.class, idProvider);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProvidersByCategory(String categoryName) {
		
		List<Provider>  providers = null ;
		try {
			String jpql = "select p from Provider p";
			Query query = entityManager.createQuery(jpql);
			providers =  (List<Provider>)query.getResultList();
			 
			for (Provider provider : providers) {
				 Boolean b =  true ;
				 List<Product>  products = provider.getProducts() ;
				 for (Product product : products) {
					 if( product.getCategory().equals(categoryName)){
						  b = false ;
					 }
				 }
				 if(b) providers.remove(provider);
			}
			return providers ;
		} catch (Exception e) {
			System.out.print("Problem providers");
			return providers ; 
		}
	}

	@Override
	public Provider findProviderByIdProduct(Integer idProduct) {
		String jpql = "select p from Product p where p.provider.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idProduct);
		return (Provider) query.getSingleResult();
	}


	@Override
	public Boolean deleteClientById(Integer IdClient) {
		Boolean b = false;
		try {
			entityManager.remove(findClientById(IdClient));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteProviderById(Integer IdProvider) {
		Boolean b = false;
		try {
			entityManager.remove(findProviderById(IdProvider));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}


	@Override
	public Boolean addClient(Client client) {
		Boolean b = false;
		try {
			entityManager.persist(client);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean addProvider(Provider provider) {
		Boolean b = false;
		try {
			entityManager.persist(provider);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
