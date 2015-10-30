package gestionCommandservices.impl;

import java.util.Date;
import java.util.List;

import entities.Command;
import entities.Product;
import gestionCommandservices.interfaces.GestionCommandserviceLocal;
import gestionCommandservices.interfaces.GestionCommandserviceRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class GestionCommandservice
 */
@Stateless
public class GestionCommandservice implements GestionCommandserviceRemote, GestionCommandserviceLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionCommandservice() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> findAllCommandsByClient(String ClientName) {
		String jpql = "select c from Command c where c.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Command> findAllCommandsByCategory(String ProductCategory) {
		//List<Product> product = findAllProductsByCategory(Product.getCategory());
		//teams.add(team);
		String jpql = "select c from Command c where c.product.category=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ProductCategory);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> findAllCommandsByCommandDate(Date CommandDate) {
		String jpql = "select c from Command c where c.dateCmd=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", CommandDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> findAllCommandsByDeliveryDate(Date DeliveryDate) {
		String jpql = "select c from Command c where c.dateLivraison=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", DeliveryDate);
		return query.getResultList();
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByIdCommand(Integer CommandId) {
		Command command = entityManager.find(Command.class,
				CommandId);
		String jpql = "select p from Product p where p.command=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", command);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllCommandsByClientName(String ClientName) {
		String jpql = "select c from Command c where c.client.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", ClientName);
		return query.getResultList();
	}

}
