package UI;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import ENTITY.Car;
import exception.NoRecordFoundException;
import exception.SomeThingWentWrongException;
import service.CustomerService;
import service.CustomerServiceImpl;

public class AdminUI {

	public static void addCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter car name ");
		String carName = sc.next();
		System.out.print("Enter manufacturing year");
		int manufacturingYear = sc.nextInt();
		System.out.println("Enter car Price");
		int carPrice = sc.nextInt();
		System.out.print("Enter Brand ");
		String carbrand = sc.next();

		// code to create Stock Entity object
		Car car = new Car(carName, manufacturingYear, carPrice, carbrand, new HashSet<>());

//		 Create an object of Service Layer here	
		carService stockService = new carServiceImpl();
		try {
			stockService.addStock(car);
			System.out.println("Stock added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void viewCars() {
		// TODO Auto-generated method stub

		carService stockService = new carServiceImpl();
		try {
			List<Car> carList = carService.getCarList();
			carList.forEach(stock -> System.out
					.println("Id: " + car.getId() + " car Name:" + car.getCarName() + " car manufacturing Year:"
							+ car.manufacturingYear() + " car brand" + car.getBrand()));
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updateCarDetails(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter car name ");
		String carName = sc.next();
		System.out.print("Enter manufacturing year");
		int manufacturingYear = sc.nextInt();
		System.out.print("Enter Brand name ");
		String carBrand = sc.next();

		// code to create Company Entity object
		Car stock = new Car();
		car.setId(id);
		car.setCarName(carName);
		car.setManufacturingYear(manufacturingYear);
		car.setBrand(carBrand);

		carService stockService = new carServiceImpl();

		try {
			stockService.updateStock(stock);
			System.out.println("car updated successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void DeleteCarById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Car Id");
		int id = sc.nextInt();

		carService stockService = new carServiceImpl();
		try {
			stockService.DeleteStockById(id);
			System.out.println("Car Deleted Successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void viewAllCustomers(Scanner sc) {
		try {
			CustomerService customerService = new CustomerServiceImpl();
			List<Object[]> customerList = customerService.getCustomerList();
			for (Object obj[] : customerList) {
				System.out.println("Name: " + obj[0] + " Username: " + obj[1] + " Date of Birth: " + obj[2]
						);
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
