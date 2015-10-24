package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity

public class Provider implements Serializable {

	
	private Integer id;
	private String Name;
	private String Address;
	private static final long serialVersionUID = 1L;
	private List<Product> products;

	public Provider() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	@OneToMany(mappedBy="provider")
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
   
}
