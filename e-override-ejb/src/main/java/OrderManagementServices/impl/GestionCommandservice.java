package OrderManagementServices.impl;

import java.util.Date;
import java.util.List;

import entities.Order;
import entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import OrderManagementServices.interfaces.GestionCommandserviceLocal;
import OrderManagementServices.interfaces.GestionCommandserviceRemote;

/**
 * Session Bean implementation class GestionCommandservice
 */
@Stateless
public class GestionCommandservice implements GestionCommandserviceRemote, GestionCommandserviceLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionCommandservice() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllCommandsByClient(String ClientName) {
		String jpql = "select c from Command c where c.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllCommandsByCategory(String ProductCategory) {
		//List<Product> product = entityManager.
				//findAllProductsByCategory(Product.getCategory());
		
		String jpql = "select c from Command c where c.product.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ProductCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllCommandsByCommandDate(Date CommandDate) {
		String jpql = "select c from Command c where c.dateCmd=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", CommandDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllCommandsByDeliveryDate(Date DeliveryDate) {
		String jpql = "select c from Command c where c.dateLivraison=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", DeliveryDate);
		return query.getResultList();
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByIdCommand(Integer CommandId) {
		Order order = entityManager.find(Order.class,
				CommandId);
		String jpql = "select p from Product p where p.command=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", order);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllCommandsByClientName(String ClientName) {
		String jpql = "select c from Command c where c.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}

}
