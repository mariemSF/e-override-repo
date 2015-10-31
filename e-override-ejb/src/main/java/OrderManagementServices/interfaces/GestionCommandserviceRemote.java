package OrderManagementServices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Order;
import entities.Product;

@Remote
public interface GestionCommandserviceRemote {
	List<Order> findAllCommandsByClient(String ClientName);
	List<Order> findAllCommandsByCategory(String ProductCategory);
	List<Order> findAllCommandsByCommandDate(Date CommandDate);
	List<Order> findAllCommandsByDeliveryDate(Date DeliveryDate);
	List<Product> findAllCommandsByClientName(String ClientName);
	List<Product> findAllProductsByIdCommand(Integer CommandId);
}
