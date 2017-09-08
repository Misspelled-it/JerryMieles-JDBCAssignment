package java_homeworks;

import java.io.*;
import java.util.*;
import java.sql.*;
public class Main {

	public static void main(String[] args) throws SQLException, IOException {
//		Connection conn = null;
//		Statement stmt = null;
//		try{
		//make a connection and create the table Employees
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//			conn = DriverManager.getConnection(URL,"sys as sysdba", "password123");
//			stmt = conn.createStatement();
//			String sql = "CREATE TABLE Employees (EmployeeNo NUMBER(10) NOT NULL, "
//					+ "firstName VARCHAR(255), "
//					+ "lastName VARCHAR(255), "
//					+ "time_in VARCHAR(255), "
//					+ "time_out VARCHAR(255), "
//					+ "CONSTRAINT Employees_pk PRIMARY KEY (EmployeeNo));
//			stmt.executeQuery(sql);
		//while the connection is still up make a sequence to use when inserting new employees into the table
//			sql = "CREATE SEQUENCE employee_id_no_seq START WITH 1 "
//					+ "INCREMENT BY 1 "
//					+ "MINVALUE 1 "
//					+ "MAXVALUE 10000";
//			stmt.executeQuery(sql);
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} finally {
//			if(conn!=null) {
//				conn.close();
//			}
//			if(stmt!=null) {
//				stmt.close();
//			}
//		}
		//make an input collector and run the logic
		inputCollector example = new inputCollector();
		example.collectInput();
	}

}
