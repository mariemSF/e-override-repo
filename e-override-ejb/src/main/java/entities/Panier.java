package entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

import java.util.List;
/**
 * Entity implementation class for Entity: Panier
 *
 */
@Entity

public class Panier implements Serializable {

	
	private Integer id;
	private List<OrderLine> orderLines;
	private List<Product> products;
	private Client client;
	
	
	private static final long serialVersionUID = 1L;

	public Panier() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	@OneToOne
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@OneToMany(mappedBy="panier")
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/*public void linkProductsToPanier(List<Product> products) {
		this.orderLines = products;
		for (Product p : products) {
			//p.se
		}
	}*/
	
   
}
