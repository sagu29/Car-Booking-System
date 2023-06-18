package UI;

import java.util.List;
import java.util.Scanner;

import ENTITY.Car;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import SERVICE.CarService;
import SERVICE.CarServiceImpl;
import SERVICE.CustomerService;
import SERVICE.CustomerServiceImpl;

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
		String carBrand = sc.next();
		
		Car car = new Car(carName, manufacturingYear, carPrice,  carBrand, null);
		

		CarService carService = new CarServiceImpl();
		try {
			carService.addCar(car);
			System.out.println("Car added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void viewCars(Scanner sc) {
		// TODO Auto-generated method stub

		CarService carService = new CarServiceImpl();
		try {
			List<Car> carList = carService.getCarList();
			carList.forEach(car -> System.out.println("Id: " + car.getId() + " car Name:" + car.getCarName() + " car manufacturing Year:"
							+ car.getManufacturingYear() + " car brand" + car.getBrand()));
			
			int ch;
			do {
				System.out.println("1. View Car By Assending Order of Car Price");
				System.out.println("2. View Car By Desending Order of Car Price");
				System.out.println("3. View Car By Assending Order of Manufacturing  Year");
				System.out.println("4. View Car By Desending Order of Manufacturing Year");
				System.out.println("0. Exit");

				ch = sc.nextInt();
				
				switch(ch) {
				case 1 : 
					carList.stream().sorted((s1,s2) -> s1.getCarPrice() - s2.getCarPrice()).forEach(st -> System.out.println("Id: " + st.getId() + " car Name:" + st.getCarName() + " car Manufacturing Year:"
							+ st.getManufacturingYear() + "  Brand Type:" + st.getBrand()+" CarPrice :"+st.getCarPrice()) );
					System.out.println("\n");
					break;
				case 2:
					carList.stream().sorted((s1,s2) -> s2.getCarPrice() - s1.getCarPrice()).forEach(st -> System.out.println("Id: " + st.getId() + " car Name:" + st.getCarName() + " car Manufacturing Year:"
							+ st.getManufacturingYear() + "  Brand Type:" + st.getBrand()+" CarPrice :"+st.getCarPrice())  );
					System.out.println("\n");
					break;
				case 3 : 
					carList.stream().sorted((s1,s2) -> s1.getManufacturingYear() - s2.getManufacturingYear()).forEach(st -> System.out.println("Id: " + st.getId() + " car Name:" + st.getCarName() + " car Manufacturing Year:"
							+ st.getManufacturingYear() + "  Brand Type:" + st.getBrand()+" CarPrice :"+st.getCarPrice()) );
					System.out.println("\n");
					break;
				case 4:
					carList.stream().sorted((s1,s2) -> s2.getManufacturingYear() - s1.getManufacturingYear()).forEach(st -> System.out.println("Id: " + st.getId() + " car Name:" + st.getCarName() + " car Manufacturing Year:"
							+ st.getManufacturingYear() + "  Brand Type:" + st.getBrand()+" CarPrice :"+st.getCarPrice())  );
					System.out.println("\n");
					break;
				default:
					System.out.println("Enter Valid Choice");
					System.out.println("\n");
				}
			} while (ch != 0);
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
		Car car = new Car();
		car.setId(id);
		car.setCarName(carName);
		car.setManufacturingYear(manufacturingYear);
		car.setBrand(carBrand);

		CarService carService = new CarServiceImpl();

		try {
			carService.updateCar(car);
			System.out.println("car updated successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void DeleteCarById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Car Id");
		int id = sc.nextInt();

		CarService carService = new CarServiceImpl();
		try {
			carService.DeleteCarById(id);
			System.out.println("Car Deleted Successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void viewAllCustomers(Scanner sc) {
		// TODO Auto-generated method stub
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
