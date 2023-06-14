package UI;

import java.util.Scanner;

public class App {
	static void displayAdminMenu() {
		System.out.println("1. Add new Car");
		System.out.println("2. View Car");
		System.out.println("3. Update Car details");
		System.out.println("4. Delete Car details");
		System.out.println("5. View All rejected or confirmed car by customer");
		System.out.println("6. Car Booking report");
		System.out.println("0. Logout");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//AdminUI.addCompany(sc);
    				break;
    			case 2:
    				//AdminUI.viewCompanies();
    				break;
    			case 3:
    				//AdminUI.updateCompanyDetails(sc);
    				break;
    			case 4:
    				//AdminUI.addPlan(sc);
    				break;
    			case 5:
    				//AdminUI.viewPlan();
    				break;
    			case 6:
    				//AdminUI.updatePlan(sc);
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
    public static void main( String[] args ){
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				
    				break;
    			case 3:
    				
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    }
}
