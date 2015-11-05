package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Delivery
 *
 */
@Entity

public class Delivery implements Serializable {

	
	private Integer id;
	private Date DeliveryDate;
	private static final long serialVersionUID = 1L;
	//private List <Order>orders;

	public Delivery() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getDeliveryDate() {
		return this.DeliveryDate;
	}

	public void setDeliveryDate(Date DeliveryDate) {
		this.DeliveryDate = DeliveryDate;
	}
	//@OneToMany(mappedBy="delivery")
	//public List <Order> getOrders() {
		//return orders;
	//}
	//public void setOrders(List <Order> orders) {
		//this.orders = orders;
	//}
   
}
