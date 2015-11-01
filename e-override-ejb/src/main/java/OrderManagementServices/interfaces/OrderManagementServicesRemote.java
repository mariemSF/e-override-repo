package OrderManagementServices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Order;
import entities.Panier;
import entities.Product;

@Remote
public interface OrderManagementServicesRemote {
	List<Order> findAllOrdersByClient(String ClientName);
	List<Order> findAllOrdersByCategory(String ProductCategory);
	List<Order> findAllOrdersByOrderDate(Date OrderDate);
	List<Order> findAllOrdersByDeliveryDate(Date DeliveryDate);
	List<Product> findAllOrdersByClientName(String ClientName);
	List<Product> findAllProductsByIdOrder(Integer OrderId);
	List<Product> findAllProductsByPanierId(Integer idPanier);
	Boolean ajouterProduitAuPanier(Product product, Panier panier);
	Integer NbrOrdersByProducts(Integer idProduct);
}
