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
		return entityManager.find(Client.class, clientName);
	}

	@Override
	public Client findClientById(Integer idClient) {
		return entityManager.find(Client.class, idClient);
	}

	@Override
	public Client findClientByIdOrder(Integer idOrder) {
		Order order = entityManager.find(Order.class,idOrder);
		String jpql = "select c from Client c where c.orders.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", order);
		return (Client) query.getSingleResult();	
	}

	@Override
	public Provider findProviderByName(String providerName) {
		return entityManager.find(Provider.class, providerName);
	}

	@Override
	public Provider findProviderById(Integer idProvider) {
		return entityManager.find(Provider.class, idProvider);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProvidersByCategory(String categoryName) {
		Product product = entityManager.find(Product.class,
				categoryName);
		String jpql = "select p from Provider p where p.products.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", product);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> findAllProvidersByIdProduct(Integer idProduct) {
		Product product = entityManager.find(Product.class,
				idProduct);
		String jpql = "select p from Provider p where p.products.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", product);
		return query.getResultList();
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
