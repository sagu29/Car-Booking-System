package ENTITY;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Car_name", nullable = false, unique = true, length = 50)
	private String carName;

	@Column(name = "Manufacturing_year", nullable = false)
	int manufacturingYear;

	@Column(name = "Car_price", nullable = false)
	int carPrice;

	@Column(name = "Car_brand", nullable = false, length = 10)
	private String carBrand;

	@ManyToMany(mappedBy = "orderCarSet")
	private Set<Customer> customer;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String carName, int manufacturingYear, int carPrice, String carBrand, Set<Customer> customer) {
		super();
		this.carName = carName;
		this.manufacturingYear = manufacturingYear;
		this.carPrice = carPrice;
		this.carBrand = carBrand;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getBrand() {
		return carBrand;
	}

	public void setBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(carName, other.carName);
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int stockPrice) {
		this.carPrice = carPrice;
	}
	
}
