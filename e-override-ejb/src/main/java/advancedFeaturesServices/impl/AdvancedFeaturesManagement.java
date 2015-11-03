package advancedFeaturesServices.impl;

import java.util.List;

import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementLocal;
import advancedFeaturesServices.interfaces.AdvancedFeaturesManagementRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Client;
import entities.Product;
import entities.Provider;

/**
 * Session Bean implementation class AdvancedFeaturesManagement
 */
@Stateless
public class AdvancedFeaturesManagement implements AdvancedFeaturesManagementRemote, AdvancedFeaturesManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AdvancedFeaturesManagement() {
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
			client = (Client) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("bad credentials");
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
			System.err.println("bad credentials");
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

	@Override
	public Boolean updateProduct(Product product) {
		Boolean b = false;
		try {
			entityManager.merge(product);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean addProduct(Product product) {
		Boolean b = false;
		try {
			entityManager.persist(product);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Product> findAllProducts() {
		String jpql = "select p from Product p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Provider> findAllProviders() {
		String jpql = "select p from Provider p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Client> findAllClients() {
		String jpql = "select p from Provider p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Client findClientByName(String clientName) {
		return entityManager.find(Client.class, clientName);
	}

	@Override
	public Client findClientById(Integer idClient) {
		return entityManager.find(Client.class, idClient);
	}

	@Override
	public Client findClientByIdOrder(Integer idOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider findProviderByName(String providerName) {
		return entityManager.find(Provider.class, providerName);
	}

	@Override
	public Provider findProviderById(Integer idProvider) {
		return entityManager.find(Provider.class, idProvider);
	}

	@Override
	public List<Provider> findProvidersByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provider> findProvidersByIdProduct(Integer idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProductsByCategory(String pCategory) {
		String jpql = "select p from Product p where p.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", pCategory);
		return query.getResultList();
	}

	@Override
	public List<Product> findAllProductsByProviderName(String pName) {
		Provider provider = entityManager.find(Provider.class,
				pName);
		String jpql = "select p from Product p where p.provider=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", provider);
		return query.getResultList();
	}

	@Override
	public List<Product> findAllProductsByIdProvider(Integer idProvider) {
		// TODO Auto-generated method stub
		return null;
	}

}
