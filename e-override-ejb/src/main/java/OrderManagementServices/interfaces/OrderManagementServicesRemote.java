package OrderManagementServices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Order;
import entities.Basket;
import entities.OrderLine;
import entities.Product;

@Remote
public interface OrderManagementServicesRemote {

	List<Order> findAllOrdersByCategory(String ProductCategory);

	List<Order> findAllOrdersByOrderDate(Date OrderDate);

	List<Order> findAllOrdersByDeliveryDate(Date DeliveryDate);

	List<Order> findAllOrdersByClientName(String ClientName);

	List<Product> findAllProductsByIdOrder(Integer OrderId);

	//List<Product> findAllProductsByBasketId(Integer idBasket);

	String BestProduct();

	List<Order> findAllOrdersByProductId(Integer idProduct);

	Boolean updateProduct(Product product);
	
	Boolean addProduct(Product product);
	
	Product findProductById(Integer idProduct);
	
	Boolean deleteproductById(Integer IdProduct);
	
	List<Product> findAllProductsByCategory(String pCategory);
	
	List<Product> findAllProductsByProviderName(String pName);
	
	List<Product> findAllProductsByIdProvider(Integer idProvider);
	
	List<Order> findAllOrders();
	Order findOrderById(Integer idOrder);
	
	List<Product> findAllProducts();

	Boolean AddOrder(Client c);
	Boolean AssignOrderLine(Product p , Order o , Float f , Integer qn);
}
