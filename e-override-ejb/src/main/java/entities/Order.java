package entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name="t_order")
public class Order implements Serializable {

	
	private Integer id;
	private Float totalPrice;
	private Integer quantity;
	private Date dateOrder;
	private Date dateDelivery;
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
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float TotalPrice) {
		this.totalPrice = TotalPrice;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.quantity = Quantity;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public Date getDateDelivery() {
		return dateDelivery;
	}
	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
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
