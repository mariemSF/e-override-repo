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
	private String Type;
	private Integer Price;
	private Integer Quantity;
	private static final long serialVersionUID = 1L;
	private Provider provider;
	private List<Command> cmds;

	public Product() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}   
	public Integer getPrice() {
		return this.Price;
	}

	public void setPrice(Integer Price) {
		this.Price = Price;
	}   
	public Integer getQuantity() {
		return this.Quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}
	@ManyToOne
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public List<Command> getCmds() {
		return cmds;
	}
	public void setCmds(List<Command> cmds) {
		this.cmds = cmds;
	}
   
}
