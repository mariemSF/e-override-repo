package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	
	private Integer id;
	private String Name;
	private String Address;
	private Integer PhoneNumber;
	private static final long serialVersionUID = 1L;
	private List<Command> commands;

	public Client() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}   
	public Integer getPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setPhoneNumber(Integer PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	@OneToMany(mappedBy="client")
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
   
}
