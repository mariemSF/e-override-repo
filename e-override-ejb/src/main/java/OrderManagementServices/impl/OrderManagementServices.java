package OrderManagementServices.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import OrderManagementServices.interfaces.OrderManagementServicesLocal;
import OrderManagementServices.interfaces.OrderManagementServicesRemote;
import entities.Client;
import entities.Order;
import entities.OrderLine;
import entities.OrderLineId;
import entities.Product;

/**
 * Session Bean implementation class GestionOrderservice
 */
@Stateless
public class OrderManagementServices implements OrderManagementServicesRemote,
		OrderManagementServicesLocal {

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
	public List<OrderLine> findAllOrdersByCategory(String ProductCategory) {
		String jpql = "select o from OrderLine o where o.product.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ProductCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllOrdersByOrderDate(Date OrderDate) {
		String jpql = "select o from OrderLine o where o.order.dateOrder=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", OrderDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllOrdersByDeliveryDate(Date DeliveryDate) {
		String jpql = "select o from OrderLine o where o.order.deliveryDate=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", DeliveryDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllProductsByIdOrder(Integer IdOrder) {
		String jpql = "select o from OrderLine o where o.order.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", IdOrder);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllOrdersByClientName(String ClientName) {
		String jpql = "select o from OrderLine o where o.order.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}

	@Override
	public Boolean AddOrder(Client c) {
		Boolean b = false;
		try {
			Order order = new Order();
			order.setClient(c);
			order.setQuantity(0);
			order.setDateOrder(new Date());
			order.setDeliveryDate(order.getDateOrder());
			Float totalPrice = new Float(0.0);
			order.setTotalPrice(totalPrice);

			entityManager.persist(order);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String BestProduct() {
		String jpql2 = "select u from Product u";
		Query query2 = entityManager.createQuery(jpql2);
        List<Product> products = (List<Product>) query2.getResultList();
        
		int max = 0;
		String productmaxname = "";
		for (Product product2 : products) {

			int somm = 0;
			List<OrderLine> ol = product2.getOrderlines();

			for (OrderLine orderLine : ol) {
                 somm += orderLine.getQuantity();
			}
			if (somm > max) {
				max = somm;
				productmaxname = product2.getName();
            }
		}
		return productmaxname;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllOrdersByProductId(Integer idProduct) {
		String jpql = "select o from OrderLine o where o.product.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idProduct);
		return query.getResultList();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		String jpql = "select p from Product p";
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
		String jpql = "select p from Product p where p.provider.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", pName);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByIdProvider(Integer idProvider) {
		String jpql = "select p from Product p where p.provider.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idProvider);
		return query.getResultList();
	}

	@Override
	public Boolean deleteproductById(Integer IdProduct) {
		Boolean b = false;
		try {
			entityManager.remove(findProductById(IdProduct));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Product findProductById(Integer idProduct) {
		return entityManager.find(Product.class, idProduct);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> findAllOrders() {
		String jpql = "select o from OrderLine o";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean AssignOrderLine(Product p, Order o, Float totalPrice,
			Integer quantity) {

		OrderLine orderLine = new OrderLine();

		OrderLineId orderLineId = new OrderLineId();
		orderLineId.setIdOrder(o.getId());
		orderLineId.setIdProduct(p.getId());

		orderLine.setTotalPrice(totalPrice);
		orderLine.setOrderlineid(orderLineId);
		orderLine.setQuantity(quantity);

		entityManager.persist(orderLine);
		return true;
	}

	@Override
	public Order findOrderById(Integer idOrder) {
		return entityManager.find(Order.class, idOrder);
	}

}
