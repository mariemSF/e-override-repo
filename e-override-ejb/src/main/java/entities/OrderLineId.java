package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderLineId implements Serializable{
	/**
	 * 
	 */
	private Integer idProduct;
	private Integer idOrder;
	private static final long serialVersionUID = 1L;
	
	public OrderLineId() {
		// TODO Auto-generated constructor stub
	}
	@Column(name="id_product")
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	@Column(name="id_order")
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
		result = prime * result
				+ ((idProduct == null) ? 0 : idProduct.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineId other = (OrderLineId) obj;
		if (idOrder == null) {
			if (other.idOrder != null)
				return false;
		} else if (!idOrder.equals(other.idOrder))
			return false;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		return true;
	}
	
	public OrderLineId(Integer idProduct, Integer idOrder) {
		// TODO Auto-generated constructor stub
		super();
		this.idProduct = idProduct;
		this.idOrder = idOrder;
	}

}
