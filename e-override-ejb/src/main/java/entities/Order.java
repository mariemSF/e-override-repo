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

public class Order implements Serializable {

	
	private Integer id;
	private Integer quantity;
	private Date dateOrder;
	private Date dateDelivery;
	private Integer totalPrice;
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<OrderLine> orderLines;
	
	public Order() {
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
	public Date getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Date DateOrder) {
		this.dateOrder = DateOrder;
	}   
	public Date getDateDelivery() {
		return this.dateDelivery;
	}

	public void setDateDelivery(Date DateDelivery) {
		this.dateDelivery = DateDelivery;
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
	@OneToMany(mappedBy="order")
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
   
}
