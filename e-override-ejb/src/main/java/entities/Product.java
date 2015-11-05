package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	
	

	private Integer id;
	private String name;
	private String category;
	private Integer price;
	private Integer quantity;
	private static final long serialVersionUID = 1L;
	private Provider provider;
	private List <OrderLine> orderLines;
	private Basket basket;
	

	public Product() {
		super();
	}   

	public Product(Integer id) {
		super();
		this.id = id;
	}


	public Product(String name, String category, Integer price,
			Integer quantity, Provider provider,Basket basket) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.provider = provider;
		this.basket = basket;
	}







	public Product(String category, Integer price, Integer quantity,
			Provider provider) {
		super();
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.provider = provider;
	}


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String Category) {
		this.category = Category;
	}   
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer Price) {
		this.price = Price;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.quantity = Quantity;
	}
	@ManyToOne(cascade = CascadeType.DETACH)
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	@OneToMany(mappedBy="product",cascade = CascadeType.PERSIST)
	public List <OrderLine> getOrderlines() {
		return orderLines;
	}
	public void setOrderlines(List <OrderLine> orderlines) {
		this.orderLines = orderlines;
	}
	@ManyToOne
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	   
}
