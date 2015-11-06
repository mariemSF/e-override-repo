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
	private String name;
	private String login;
	private String password;
	private String address;
	private Integer phoneNumber;
	private static final long serialVersionUID = 1L;
	private List<Order> orders;
	private List <Feedback>feedbacks;
	

	public Client() {
		super();
	}   
	public Client(String name, String login, String password) {
		//super();
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public Client(String name) {
		super();
		this.name = name;
	}
	public Client(String login, String password) {
		//super();
		this.login = login;
		this.password = password;
	}
	
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}   
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String Address) {
		this.address = Address;
	}   
	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer PhoneNumber) {
		this.phoneNumber = PhoneNumber;
	}
	/*@OneToMany(mappedBy="client")
	public List<Order> getOrder() {
		return orders;
	}
	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}*/
	@OneToMany(mappedBy="client")
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@OneToMany(mappedBy="client")
	public List <Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List <Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

		   
}
