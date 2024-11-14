package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step1: Database Connection Detals
		String jdbcURL = "jdbc:mysql://localhost:3306";
		String userName = "root";
		String passWord = "0000";
		
		
		//Step2: Establish the connection
		try {
			Connection connection = DriverManager.getConnection(jdbcURL,userName,passWord);
			
			if(connection!=null) {
				System.out.println("connection established");
			}
			else {
				System.out.println("Issue in connection");
			}
			
			
			//Step3: Perform operation
			//create statements
			
			String createDB = "CREATE DATABASE JDBC_DEMO",
					use = "USE JDBC_DEMO",
					createTable = "CREATE TABLE JDBC_DEMO (ID INT, NAME VARCHAR(15), CGPA DECIMAL(2.1))",
					insert = "INSERT INTO JDBC_DEMO VALUES (001,'ARUN', 8.5),(002,'DIYA',7.8)",
					select = "SELECT * FROM JDBC_DEMO";
			
			Statement stmt = connection.createStatement();
			
			//Step4: Execute the Statements
			
			stmt.execute(createDB);
			stmt.execute(use);
			stmt.execute(createTable);
			stmt.executeUpdate(insert);
			ResultSet result = stmt.executeQuery(select);
			
			while(result.next()) {
				System.out.println(result.getInt("ID")+" "+result.getString("NAME")+" "+result.getBigDecimal("CGPA"));
			}
			
			//Step5: Close
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Connection Failed");

		}

	}

}
