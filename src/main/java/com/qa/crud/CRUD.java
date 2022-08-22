package com.qa.crud;
import com.qa.DBConfig.Configure;
import com.qa.amazon.Person;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CRUD {
	
	private Connection conn;// has a driver manager class which contains the methods to connect to db
	private Statement stmt;// allows us to prepare the query we want to execute
	public ResultSet rs; // Crucial for when returning multiple rows from a database table

	// open connection in the constructor - initialises everything
	public CRUD() {
		try {
			conn = DriverManager.getConnection(Configure.getUrl(), Configure.getUser(), Configure.getPass());
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}
	public void create(Person p) {

//		public void create(String model, int mileage, String vehicleType, int doors) {
			// info to collect to pass into the database
//			String model = "xxx";
//			int mileage = 1234;
//			String vehicleType = "Bike";
//			int doors = 2;

			// INSERT INTO vehicle(model, mileage, vehicle_type, doors)
			// VALUES("tbc",30000,"Car",4);
			String createStmt = "INSERT INTO person(full_name, postcode, age, mobile) VALUES('" + p.getName() + "'," + p.getPostcode()
					+ ",'" + p.getAge() + "'," + p.getMobile() + ");";
			try {
				stmt.executeUpdate(createStmt);
				System.out.println("Create statement executed");
			} catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}
		}
	public void read() {
		String readStmt = "SELECT * FROM person;";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("full_name"));
				System.out.println("Age: " + rs.getInt("age"));
				System.out.println("Postcode: " + rs.getString("postcode"));
				System.out.println("Mobile: " + rs.getLong("mobile"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void readById(Person p) {
		String readStmt = "SELECT * FROM person WHERE id = " +p.getId()+";";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("full_name"));
				System.out.println("Age: " + rs.getInt("age"));
				System.out.println("Postcode: " + rs.getString("postcode"));
				System.out.println("Mobile: " + rs.getLong("mobile"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void delete(Person p ) {
		String delStmt = "DELETE FROM person WHERE id=" + p.getId() + ";";
		try {
			stmt.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}
	public void update(Person p, String updateVal) {
//		UPDATE vehicle SET model = "chevy" WHERE id = 2;
		String updateStmt = "UPDATE vehicle SET mobile = '" + updateVal + "' WHERE id = " + p.getId() + ";";
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}
	
	public void closeConn() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
