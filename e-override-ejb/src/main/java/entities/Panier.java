package entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;
import java.util.List;
/**
 * Entity implementation class for Entity: Panier
 *
 */
@Entity

public class Panier implements Serializable {

	
	private Integer id;
	private List<OrderLine> orderLines;
	
	private static final long serialVersionUID = 1L;

	public Panier() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	
	
   
}
