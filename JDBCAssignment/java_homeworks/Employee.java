package java_homeworks;

import java.io.*;
import java.util.*;
import java.sql.*;
public class Employee {
	protected String firstName, lastName, timeIn, timeOut;
	protected int employeeNum;
	public Employee(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	public void createNewEmployee() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "INSERT INTO Employees (EmployeeNo, firstName, lastName)  VALUES (employee_id_no_seq.nextval, '"
					+ this.firstName+"', '"+ this.lastName + "')";
			stmt.executeQuery(sql);
			sql = "SELECT EmployeeNo FROM Employees WHERE firstName ='"+ this.firstName + "' AND lastName ='" + this.lastName + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				this.employeeNum = rs.getInt("EmployeeNo");
				System.out.println(this.firstName + " "+ this.lastName + ", your employee number is " + this.employeeNum + ". Use this number to clock in and out.");
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
		inputCollector collect = new inputCollector();
		collect.collectInput();
	}
}
