package OrderManagementServices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Order;
import entities.OrderLine;
import entities.Product;

@Remote
public interface OrderManagementServicesRemote {

	List<OrderLine> findAllOrdersByCategory(String ProductCategory);

	List<OrderLine> findAllOrdersByOrderDate(Date OrderDate);

	List<OrderLine> findAllOrdersByDeliveryDate(Date DeliveryDate);

	List<OrderLine> findAllOrdersByClientName(String ClientName);

	List<OrderLine> findAllProductsByIdOrder(Integer IdOrder);

	String BestProduct();

	List<OrderLine> findAllOrdersByProductId(Integer idProduct);

	Boolean updateProduct(Product product);
	
	Boolean addProduct(Product product);
	
	Product findProductById(Integer idProduct);
	
	Boolean deleteproductById(Integer IdProduct);
	
	List<Product> findAllProductsByCategory(String pCategory);
	
	List<Product> findAllProductsByProviderName(String pName);
	
	List<Product> findAllProductsByIdProvider(Integer idProvider);
	
	List<OrderLine> findAllOrders();
	
	Order findOrderById(Integer idOrder);
	
	List<Product> findAllProducts();

	Boolean AddOrder(Client c);
	Boolean AssignOrderLine(Product p , Order o , Float f , Integer qn);
}
