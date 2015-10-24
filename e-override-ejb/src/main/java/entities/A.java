package entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity

public class A implements Serializable {

	
	private Integer idA;
	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}   
	@Id    
	public Integer getIdA() {
		return this.idA;
	}

	public void setIdA(Integer idA) {
		this.idA = idA;
	}
   
}
