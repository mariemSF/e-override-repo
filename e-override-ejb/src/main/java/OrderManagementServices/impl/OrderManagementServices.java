package OrderManagementServices.impl;

import java.util.Date;
import java.util.List;

import entities.Client;
import entities.Order;
import entities.OrderLine;
import entities.OrderLineId;
import entities.Product;
import entities.Provider;

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
	public List<Order> findAllOrdersByCategory(String ProductCategory) {
		List<Product> product = findAllProductsByCategory(ProductCategory);
		String jpql = "select c from Order c where c.orderlines.product.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", product);
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
		String jpql = "select c from Order c where c.delivery.deliveryDate=:param";
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
	public List<Order> findAllOrdersByClientName(String ClientName) {
		String jpql = "select o from Order o where o.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByBasketId(Integer idBasket) {
		Basket basket = entityManager.find(Basket.class,
				idBasket);
		String jpql = "select p from Products p where p.basket.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", basket);
		return query.getResultList();
	}*/

	@Override
	public Boolean AddOrder(Client c) {
		Boolean b = false;
		try {
			
			Order order =new Order();
			order.setClient(c);
			order.setQuantity(0);
			order.setDateOrder(new Date());
			Float f = new Float(0.0) ;
			order.setTotalPrice(f);
			
			
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
		
		
		List<Product> products = (List<Product> )  query2.getResultList(); 
		
	
	    int max  = 0 ;
	    
	    String productmaxname = "" ;
	    
 for (Product product2 : products) {
			
	
	    	 int somm = 0 ; 
	    	List<OrderLine>  ol =  product2.getOrderlines();
	    	
	    	for (OrderLine orderLine : ol) {
	    		
	    		somm += orderLine.getQuantity() ;
	    		
		    	}
	    	if (somm >max) { max = somm ;
    		productmaxname= product2.getName();
				
			}
	    	
	    	
			
		
	}
		
		return productmaxname;
		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrdersByProductId(Integer idProduct) {
		String jpql = "select o from OrderLine o where o.id_product=:param";
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
		Provider provider = entityManager.find(Provider.class,
				pName);
		String jpql = "select p from Product p where p.provider=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", provider);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByIdProvider(Integer idProvider) {
		Provider provider = entityManager.find(Provider.class,
				idProvider);
		String jpql = "select p from Product p where p.provider=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", provider);
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

	@Override
	public List<Order> findAllOrders() {
		String jpql = "select o from order o";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean AssignOrderLine(Product p, Order o, Float f, Integer qn) {
		
		
		
			OrderLine ol  = new OrderLine() ;
			
			OrderLineId olid = new OrderLineId();
			olid.setIdOrder(o.getId());
			olid.setIdProduct(p.getId());
			
			ol.setTotalPrice(f);
			ol.setOrderlineid(olid);
			ol.setQuantity(qn);
			
			entityManager.persist(ol);
			return true ;
	
		
		
	}

	@Override
	public Order findOrderById(Integer idOrder ) {
		return entityManager.find(Order.class, idOrder);
	}


}
