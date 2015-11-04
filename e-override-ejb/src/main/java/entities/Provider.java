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
	private String name;
	private String login;
	private String password;
	private String address;
	private static final long serialVersionUID = 1L;
	private List<Product> products;

	public Provider() {
		super();
	}   
	
	public Provider(Integer id) {
		//super();
		this.id = id;
	}
	public Provider(String nom, String login, String password) {
		super();
		this.name = nom;
		this.login = login;
		this.password = password;
	}
	public Provider(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Provider(String name) {
		super();
		this.name = name;
	}
	
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String Address) {
		this.address = Address;
	}
	@OneToMany(mappedBy="provider")
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
   
}
