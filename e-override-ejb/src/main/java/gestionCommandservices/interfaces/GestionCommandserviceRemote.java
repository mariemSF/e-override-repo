package gestionCommandservices.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Command;
import entities.Product;

@Remote
public interface GestionCommandserviceRemote {
	List<Command> findAllCommandsByClient(String ClientName);
	List<Command> findAllCommandsByCategory(String ProductCategory);
	List<Command> findAllCommandsByCommandDate(Date CommandDate);
	List<Command> findAllCommandsByDeliveryDate(Date DeliveryDate);
	List<Product> findAllCommandsByClientName(String ClientName);
	List<Product> findAllProductsByIdCommand(Integer CommandId);
}
