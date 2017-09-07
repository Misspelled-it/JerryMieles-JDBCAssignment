package java_homeworks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class existingEmployee extends Employee{
	public existingEmployee(int empNo, int option) throws SQLException{
		super("","");
		switch (option){
			case 1: clockIn(empNo);
				break;
			case 2: clockOut(empNo);
				break;
			case 3: editInfo(empNo);
				break;
			case 4: deleteEmployee(empNo);
				break;
			case 5: System.out.println("Copy that, Have a great one!");
				break;
			default:
				break;
		}
	}
	public void clockIn(int empNo) throws SQLException {
		this.timeIn = new Date().toString();
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "UPDATE Employees SET time_in ='" + this.timeIn + "' WHERE EmployeeNo=" + this.employeeNum;
			stmt.executeQuery(sql);
			sql = "SELECT time_in FROM Employees WHERE EmployeeNo="+this.employeeNum;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String in = rs.getString("time_in");
				System.out.println(this.firstName + ", you've clocked in at " + in);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
	}
	public void clockOut(int empNo) throws SQLException{
		this.timeOut = new Date().toString();
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "UPDATE Employees SET time_out ='" + this.timeOut + "' WHERE EmployeeNo=" + this.employeeNum;
			stmt.executeQuery(sql);
			sql = "SELECT time_out FROM Employees WHERE EmployeeNo="+this.employeeNum;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String out = rs.getString("time_out");
				System.out.println(this.firstName + ", you've clocked out at " + out);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
	}
	public void editInfo(int empNo) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Updated First Name:");
		this.firstName = input.nextLine();
		System.out.println("Enter Updated Last Name:");
		this.lastName = input.nextLine();
		input.close();
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "UPDATE Employees SET firstName ='" + this.firstName + "', lastName='" + this.lastName + "' WHERE EmployeeNo=" + this.employeeNum;
			stmt.executeQuery(sql);
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		System.out.println("Entry Successful, Your information has been updated");
	}
	public void deleteEmployee(int empNo) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "DELETE FROM Employees WHERE EmployeeNo=" + empNo;
			stmt.executeQuery(sql);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		System.out.println("Sorry to see you go, your information has been deleted");
	}
	

}
