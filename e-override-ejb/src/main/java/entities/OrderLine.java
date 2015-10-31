package entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LigneCmd
 *
 */
@Entity

public class OrderLine implements Serializable {

	
	private Integer quantity;
	private Float totalPrice;
	private OrderLineId orderlineid;
	private static final long serialVersionUID = 1L;
	private Product product;
	private Order order;

	public OrderLine() {
		super();
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.quantity = Quantity;
	}   
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float TotalPrice) {
		this.totalPrice = TotalPrice;
	}
	@EmbeddedId
	public OrderLineId getOrderlineid() {
		return orderlineid;
	}
	public void setOrderlineid(OrderLineId orderlineid) {
		this.orderlineid = orderlineid;
	}
	@ManyToOne
	@JoinColumn(name="id_product",referencedColumnName="id",insertable=false,updatable=false)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="id_order",referencedColumnName="id",insertable=false,updatable=false)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderLine(Integer quantity, Float totalPrice, Product product,
			Order order) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
		this.order = order;
		this.orderlineid=new OrderLineId(product.getId(), order.getId());
	}
	
   
}
