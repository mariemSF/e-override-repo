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
	private Date orderDate;
	private Date DeliveryDate;
	private static final long serialVersionUID = 1L;
	private Client client;
	private List<OrderLine> orderLines;
	private List<Feedback> feedbacks;
	//private Delivery delivery;

	public Order() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		return orderDate;
	}
	public void setDateOrder(Date dateOrder) {
		this.orderDate = dateOrder;
	}
	@ManyToOne
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@OneToMany(mappedBy="order",cascade = CascadeType.PERSIST)
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	@OneToMany(mappedBy="order")
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	//@ManyToOne
	//public Delivery getDelivery() {
	//	return delivery;
	//}
	//public void setDelivery(Delivery delivery) {
	//	this.delivery = delivery;
	//}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
		
}
