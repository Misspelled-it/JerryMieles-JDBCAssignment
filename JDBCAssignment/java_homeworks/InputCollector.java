package java_homeworks;

import java.sql.SQLException;
import java.util.Scanner;

public class inputCollector {
	private String firstName, lastName;
	private int employeeNo, menuItem;
	private void getEmployeeInput() throws SQLException{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Employee number:");
		this.employeeNo = input.nextInt();
		System.out.println("What would you like to do? Enter the corresponding number:\n"
				+ "1-Clock In\n"
				+ "2-Clock Out\n"
				+ "3-Edit Employee Information\n"
				+ "4-Delete Record\n"
				+ "5-Exit");
		this.menuItem = input.nextInt();
		input.close();
		existingEmployee emp = new existingEmployee(this.employeeNo, this.menuItem);
	}
	public void collectInput() throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Good day! Are you a new or existing employee? Enter corresponding number:\n"
				+ "1-New Employee\n"
				+ "2-Existing Employee");
		int option = input.nextInt();
		switch(option) {
			case 1: System.out.println("Enter your First Name:");
				this.firstName = input.next();
				System.out.println("Enter your Last Name:");
				this.lastName = input.next();
				input.close();
				Employee emp = new Employee(this.firstName, this.lastName);
				emp.createNewEmployee();
				break;
			case 2:
				getEmployeeInput();
				break;
			default:
				break;
		}
	}
}
