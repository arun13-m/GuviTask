package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//step1: connecting the databse
		String jdbcURL = "jdbc:mysql://localhost:3306", userName = "root", passWord = "0000";
		
		//step2: connection
		try {
			Connection connection = DriverManager.getConnection(jdbcURL,userName,passWord);
			
			if(connection!=null) {
				System.out.println("Connection established");
			}
			else {
				System.out.println("Issue in connection");
			}
			
			//step3: create the sql commands
			String createDB = "CREATE DATABASE EMP",
					useDb = "USE EMP",
					createTD = "CREATE TABLE EMP (EMPCODE INT, EMPNAME VARCHAR(20), EMPAGE INT, ESALARY INT)",
					insert = "INSERT INTO EMP VALUES (101,'JENNY',25,10000),(102,'JACKY',30,20000),"
							+ "(103,'JOE',20,40000),(104,'JOHN',40,80000),(105,'SHAMEER',25,90000)",
					select = "SELECT * FROM EMP ";
			  
			//STEP4: EXECUTE THE COMMANDS
			Statement smt = connection.createStatement();
			smt.execute(createDB);
			smt.execute(useDb);
			smt.execute(createTD);
			smt.executeUpdate(insert);
			ResultSet lines = smt.executeQuery(select);
			
			while(lines.next()) {
				System.out.println(lines.getInt("EMPCODE")+" "+lines.getString("EMPNAME")+" "+lines.getInt("EMPAGE")+" "+lines.getInt("ESALARY"));
			}
			
			//step5: close
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Connection Failed: "+e);
		}

	}

}
