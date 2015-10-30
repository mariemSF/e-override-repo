package gestionCrudservices.impl;

import java.util.List;

import entities.Client;
import entities.Product;
import entities.Provider;
import gestionCrudservices.interfaces.GestionCrudserviceLocal;
import gestionCrudservices.interfaces.GestionCrudserviceRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class GestionCrudservice
 */
@Stateless
public class GestionCrudservice implements GestionCrudserviceRemote, GestionCrudserviceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager entityManager;
	
    public GestionCrudservice() {
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
	public Boolean addProduct(Product produit) {
		Boolean b = false;
		try {
			entityManager.persist(produit);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		String jpql = "select p from Product p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
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
		String jpql = "select p from Provider p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByCategory(String pCategory) {
		String jpql = "select p from Product p where p.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", pCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByProviderName(String pName) {
		Provider provider = entityManager.find(Provider.class,
				pName);
		String jpql = "select p from Product p where p.provider=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", provider);
		return query.getResultList();
	}

}
