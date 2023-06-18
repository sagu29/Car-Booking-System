package ENTITY;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50) // this is for not null
	private String name;

	@Column(unique = true, length = 50, nullable = false) // this is for making it unique
	private String username;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_cars", joinColumns = {
			@JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	private Set<Car> orderCarSet;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String username, String password, LocalDate dateOfBirth,Set<Car> orderStockSet) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.orderCarSet = orderCarSet;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<Car> getOrderCarSet() {
		return orderCarSet;
	}

	public void setOrderCarSet(Set<Car> orderStockSet) {
		this.orderCarSet = orderCarSet;
	}

}
