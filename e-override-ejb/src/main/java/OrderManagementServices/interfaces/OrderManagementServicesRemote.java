package OrderManagementServices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Order;
import entities.Basket;
import entities.Product;

@Remote
public interface OrderManagementServicesRemote {

	List<Order> findAllOrdersByCategory(String ProductCategory);

	List<Order> findAllOrdersByOrderDate(Date OrderDate);

	List<Order> findAllOrdersByDeliveryDate(Date DeliveryDate);

	List<Order> findAllOrdersByClientName(String ClientName);

	List<Product> findAllProductsByIdOrder(Integer OrderId);

	List<Product> findAllProductsByBasketId(Integer idBasket);

	Boolean AddProductToBasket(Product product, Basket basket);

	List<Order> nbrOrdersByProduct(Integer idProduct, Integer quantity);

	List<Order> findAllOrdersByProductId(Integer idProduct);

	Boolean updateProduct(Product product);
	
	Boolean addProduct(Product product);
	
	Product findProductById(Integer idProduct);
	
	Boolean deleteproductById(Integer IdProduct);
	
	List<Product> findAllProductsByCategory(String pCategory);
	
	List<Product> findAllProductsByProviderName(String pName);
	
	List<Product> findAllProductsByIdProvider(Integer idProvider);

	List<Product> findAllProducts();
}
