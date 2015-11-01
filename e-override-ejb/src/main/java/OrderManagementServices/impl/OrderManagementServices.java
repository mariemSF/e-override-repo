package OrderManagementServices.impl;

import java.util.Date;
import java.util.List;

import entities.Department;
import entities.Order;
import entities.Panier;
import entities.Product;
import entities.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import OrderManagementServices.interfaces.OrderManagementServicesLocal;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;

/**
 * Session Bean implementation class GestionOrderservice
 */
@Stateless
public class OrderManagementServices implements OrderManagementServicesRemote, OrderManagementServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public OrderManagementServices() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrdersByClient(String ClientName) {
		String jpql = "select c from Order c where c.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrdersByCategory(String ProductCategory) {
		//List<Product> product = findAllProductsByCategory(Product.getCategory());
		//teams.add(team);
		String jpql = "select c from Order c where c.product.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ProductCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrdersByOrderDate(Date OrderDate) {
		String jpql = "select c from Order c where c.dateOrder=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", OrderDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrdersByDeliveryDate(Date DeliveryDate) {
		String jpql = "select c from Order c where c.dateDelivery=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", DeliveryDate);
		return query.getResultList();
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByIdOrder(Integer OrderId) {
		Order Order = entityManager.find(Order.class,
				OrderId);
		String jpql = "select p from Product p where p.Order=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", Order);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllOrdersByClientName(String ClientName) {
		String jpql = "select o from Order o where o.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}
	public List<Product> findAllProductsByPanierId(Integer id){
		Product
	}
	
	@Override
	public Boolean ajouterProduitAuPanier(Product product, Panier panier) {
		Boolean b = false;
		try {
			List<Product> products = findAllTeamsByDepartmentId(panier.getId());
			products.add(product);
			panier.linkProductsToPanier(products);
			entityManager.persist(panier);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
