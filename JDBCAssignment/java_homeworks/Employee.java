package java_homeworks;

import java.io.*;
import java.util.*;
import java.sql.*;
public class Employee {
	private String firstName, lastName, timeIn, timeOut;
	private int employeeNum;
	public Employee(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	public void createNewEmployee() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:oracle:thin:@localhost:xxxx:orcl";
			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
			stmt = conn.createStatement();
			String sql = "INSERT INTO Employees VALUES (employee_id_no_seq.nextval, "
					+ this.firstName+", "+ this.lastName + ")";
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
	}
}
