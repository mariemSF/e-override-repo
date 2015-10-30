package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Command
 *
 */
@Entity

public class Command implements Serializable {

	
	private Integer id;
	private Integer quantity;
	private Date dateCmd;
	private Date dateLivraison;
	private Integer totalPrice;
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<Product> prds;

	public Command() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.quantity = Quantity;
	}   
	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date DateCmd) {
		this.dateCmd = DateCmd;
	}   
	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date DateLivraison) {
		this.dateLivraison = DateLivraison;
	}   
	public Integer getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Integer TotalPrice) {
		this.totalPrice = TotalPrice;
	}
	@ManyToOne
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToMany(mappedBy="cmds")
	public List<Product> getPrds() {
		return prds;
	}
	public void setPrds(List<Product> prds) {
		this.prds = prds;
	}
   
}
