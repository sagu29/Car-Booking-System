package ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "car_model", nullable = false, unique = true, length = 50)
	private String Model;
	
	@Column(name = "car_brand", nullable = false, length = 50)
	private String brand;
	
	@Column(name = "car_price", nullable = false)
	private long price;
	
	@Column(name = "car_availibilty", nullable = false)
	private String availability;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int id, String model, String brand, long price, String availability) {
		super();
		this.id = id;
		Model = model;
		this.brand = brand;
		this.price = price;
		this.availability = availability;
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
