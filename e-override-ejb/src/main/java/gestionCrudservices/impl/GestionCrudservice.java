package gestionCrudservices.impl;

import java.util.List;

import entities.Client;
import entities.Product;
import entities.Provider;
import gestionCrudservices.interfaces.GestionCrudserviceLocal;
import gestionCrudservices.interfaces.GestionCrudserviceRemote;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class GestionCrudservice
 */
@Stateless
public class GestionCrudservice implements GestionCrudserviceRemote, GestionCrudserviceLocal {

    /**
     * Default constructor. 
     */
    public GestionCrudservice() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Client loginClient(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider loginProvider(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addProduct(Product produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provider> findAllProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

}
