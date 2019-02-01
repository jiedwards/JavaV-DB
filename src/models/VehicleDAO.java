package models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jetty.server.Authentication.User;

import models.Vehicle;

public class VehicleDAO {

	private Scanner scanner;
	
	/**
	 * @author Jacob Edwards
	 * This is a declaration for the database connection, declaring it once at the beginning prevents
	 * having to repeatedly create a connection.
	 * @return conn, this is the connection which has been declared
	 */

	private static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String url = "jdbc:sqlite:vehicles.sqlite";
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * The method below is used to retrieve all the vehicles' information from the database.
	 * @return vehicleList, this results in all vehicles' information being retrieved from the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 */	
	
	public ArrayList<Vehicle> getAllVehicles() throws SQLException, IOException {
	//Initialisation of variables which will be used in this method
		System.out.println("Retrieving all vehicles ....");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM vehicles;";
		ArrayList<Vehicle> vehicleList = new ArrayList<>();

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			System.out.println("DBQuery = " + query);
	//Execution of the query above
			rs = stmt.executeQuery(query);
	//The while loop below displays each vehicle's information from the vehicle database
			while (rs.next()) {
				int vehicle_id = rs.getInt("vehicle_ID");
				String make = rs.getString("Make");
				String model = rs.getString("Model");
				int year = rs.getInt("Year");
				int price = rs.getInt("Price");
				String license_number = rs.getString("License_Number");
				String colour = rs.getString("Colour");
				int number_doors = rs.getInt("Number_Doors");
				String transmission = rs.getString("Transmission");
				int mileage = rs.getInt("Mileage");
				String fuel_type = rs.getString("Fuel_Type");
				int engine_size = rs.getInt("Engine_Size");
				String body_style = rs.getString("Body_Style");
				String condition = rs.getString("Condition");
				String notes = rs.getString("Notes");
				boolean sold = rs.getBoolean("sold");

				vehicleList.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes, sold));

			}
	//Error message checking if there is a problem with the query
		} catch (Exception e) {
			e.printStackTrace();
		}
	//The variables are then closed, ready to be used in another method so they do not overload.
		finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return vehicleList;
	}

	/**
	 * The method below is used to retrieve a single vehicle's information from the database by inserting the Vehicle ID.
	 * @param searchID, this is essentially the Vehicle ID which is entered from the user's input.
	 * @return true when the query is executed, this results in a single vehicle's information being retrieved from the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */	

	public Vehicle getVehicle(int searchID) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		Vehicle newVehicle = null;
		ResultSet rs = null;

		String query = "SELECT * FROM vehicles where Vehicle_ID = ? ";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Search operation -database successfully opened");
			System.out.println("-------");

			preparedStatement = conn.prepareStatement(query);
			
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
			
			preparedStatement.setInt(1, searchID);
			rs = preparedStatement.executeQuery();
	//Execution of the query above
	//The while loop below displays each vehicle's information from the vehicle database
			while (rs.next()) {
				int vehicle_id = rs.getInt("vehicle_ID");
				String make = rs.getString("Make");
				String model = rs.getString("Model");
				int year = rs.getInt("Year");
				int price = rs.getInt("Price");
				String license_number = rs.getString("License_Number");
				String colour = rs.getString("Colour");
				int number_doors = rs.getInt("Number_Doors");
				String transmission = rs.getString("Transmission");
				int mileage = rs.getInt("Mileage");
				String fuel_type = rs.getString("Fuel_Type");
				int engine_size = rs.getInt("Engine_Size");
				String body_style = rs.getString("Body_Style");
				String condition = rs.getString("Condition");
				String notes = rs.getString("Notes");
				boolean sold = rs.getBoolean("sold");



				newVehicle = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes, sold);

				System.out.print(newVehicle);

			}

	//Error message checking if there is a problem with the query

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	//The variables are then closed, ready to be used in another method so they do not overload.
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Search operation completed, reload program to display results.");
		return newVehicle;
	}

	/**
	 * The method below is used to Delete a vehicle from the database by inputting the Vehicle ID.
	 * @param deleteID, this is essentially the Vehicle ID which is entered from the user's input.
	 * @return true when the query is executed, this results in a vehicle being deleted from the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */
	
	public Boolean deleteVehicle(int deleteID) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		System.out.println(deleteID);
		String query5 = "DELETE from vehicles where Vehicle_ID = ?";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Delete operation -database successfully opened");
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
			preparedStatement = conn.prepareStatement(query5);
			preparedStatement.setInt(1, deleteID);
	//Execution of the query above

			preparedStatement.executeUpdate();

			preparedStatement.close();
			conn.commit();
	//Error message checking if there is a problem with the query
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	//The variables are then closed, ready to be used in another method so they do not overload.
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		System.out.println("-------");
		System.out.println("Reload results to see if operation has completed successfully.");
		return true;
	}

	/**
	 * The method below executes an insert statement to add a vehicle into the database.
	 * @param v : This is the object sub-created from the Vehicle class to store all the vehicles in the database.
	 * @return true when the query is executed, this results in a vehicle being inserted into the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */
	
	
	public Boolean insertVehicle(Vehicle v) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String query1 = "INSERT INTO vehicles ( " + "Make," + "Model," + "Year," + "Price," + "License_Number,"
				+ "Colour," + "Number_Doors," + "Transmission," + "Mileage," + "Fuel_Type," + "Engine_Size,"
				+ "Body_Style," + "Condition," + "Notes) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Database opened successfully");
			preparedStatement = conn.prepareStatement(query1);
	//Each ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
			preparedStatement.setString(1, v.getMake());
			preparedStatement.setString(2, v.getModel());
			preparedStatement.setInt(3, v.getYear());
			preparedStatement.setInt(4, v.getPrice());
			preparedStatement.setString(5, v.getLicense_number());
			preparedStatement.setString(6, v.getColour());
			preparedStatement.setInt(7, v.getNumber_doors());
			preparedStatement.setString(8, v.getTransmission());
			preparedStatement.setInt(9, v.getMileage());
			preparedStatement.setString(10, v.getFuel_type());
			preparedStatement.setInt(11, v.getEngine_size());
			preparedStatement.setString(12, v.getBody_style());
			preparedStatement.setString(13, v.getCondition());
			preparedStatement.setString(14, v.getNotes());

			preparedStatement.executeUpdate();
	//Execution of the query above with the use of prepared statements
			preparedStatement.close();
			conn.commit();
	//Error message checking if there is a problem with the query

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	//The variables are then closed, ready to be used in another method so they do not overload.
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Records successfully created, reload program to display results.");
		return true;
	}

	/**
	 * The method below executes an update statement to edit an existing vehicle's information in the database.
	 * @param Update : This is the object sub-created from the Vehicle class to store all the vehicles in the database.
	 * @param chosenID : This variable which is parsed in the method is the user input of which vehicle ID they have chosen to update.
	 * @return true when the query is executed, this results in an existing vehicle's information being updated in the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */
	
	public Boolean updateVehicle(Vehicle Update, int chosenID) throws SQLException {
	//Initialisation of variables which will be used in this method

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		scanner = new Scanner(System.in);

		String query1 = "UPDATE vehicles SET Make= ? , " + "Model=? ," + "Year=? ," + "Price=? ," + "License_number=? ,"
				+ "Colour=? ," + "Number_Doors=? ," + "Transmission=? ," + "Mileage=? ," + "Fuel_Type=? ,"
				+ "Engine_Size=? ," + "Body_Style=? ," + "Condition=? ," + "Notes=? " + "where Vehicle_ID = ?";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Update operation - database successfully opened");
			preparedStatement = conn.prepareStatement(query1);
			
	//Each ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
			
			preparedStatement.setString(1, Update.getMake());
			preparedStatement.setString(2, Update.getModel());
			preparedStatement.setInt(3, Update.getYear());
			preparedStatement.setInt(4, Update.getPrice());
			preparedStatement.setString(5, Update.getLicense_number());
			preparedStatement.setString(6, Update.getColour());
			preparedStatement.setInt(7, Update.getNumber_doors());
			preparedStatement.setString(8, Update.getTransmission());
			preparedStatement.setInt(9, Update.getMileage());
			preparedStatement.setString(10, Update.getFuel_type());
			preparedStatement.setInt(11, Update.getEngine_size());
			preparedStatement.setString(12, Update.getBody_style());
			preparedStatement.setString(13, Update.getCondition());
			preparedStatement.setString(14, Update.getNotes());
			preparedStatement.setInt(15, Update.getVehicle_id());

			preparedStatement.executeUpdate();
	//Execution of the query above with the use of prepared statements

			conn.commit();
			preparedStatement.close();
	//Error message checking if there is a problem with the query

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	//The variables are then closed, ready to be used in another method so they do not overload.
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Update operation successfully done, reload program to display results.");
		return true;
	}
	
	/**
	 * The method below is used to mark a vehicle's status as sold by entering the Vehicle ID.
	 * @param soldID, this is essentially the Vehicle ID which is entered from the user's input.
	 * @return true when the query is executed, this results in a single vehicle being marked as sold.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */	

	public Boolean soldVehicle(int soldID) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String soldQuery = "UPDATE vehicles SET sold = 1 where Vehicle_ID = ?";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Sold -database successfully opened");
			preparedStatement = conn.prepareStatement(soldQuery);
			preparedStatement.setInt(1, soldID);
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
	//Execution of the query above with the use of prepared statements
			preparedStatement.executeUpdate();

			preparedStatement.close();
			conn.commit();
			
	//Error message checking if there is a problem with the query

		}catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			
	//The variables are then closed, ready to be used in another method so they do not overload.

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Reload results to see if operation has completed successfully.");
		return true;
	}
	
	/**
	 * The method below is used to unmark a vehicle's status from being sold by entering the Vehicle ID.
	 * @param unsoldID, this is essentially the Vehicle ID which is entered from the user's input.
	 * @return true when the query is executed, this results in a single vehicle being unmarked from being sold.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */	

	public Boolean unsoldVehicle(int unsoldID) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String unsoldQuery = "UPDATE vehicles SET sold = 0 where Vehicle_ID = ?";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Unmark sold vehicle -database successfully opened");
			preparedStatement = conn.prepareStatement(unsoldQuery);
			preparedStatement.setInt(1, unsoldID);
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
	//Execution of the query above with the use of prepared statements
			preparedStatement.executeUpdate();

			preparedStatement.close();
			conn.commit();
			
	//Error message checking if there is a problem with the query
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			
	//The variables are then closed, ready to be used in another method so they do not overload.

		} finally {
			
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Reload results to see if operation has completed successfully.");
		return true;
	}
	
	/**
	 * The method below is used to retrieve a user's information from the database upon attempting to login.
	 * @param usernameID, this is the username which the user has attempted to input.
	 * @param passwordID, this is the password which the user has attempted to input.
	 * @return true when the query is executed, this results in a user being pulled from the database
	 * @throws SQLException if there is an error with the SQL query implemented.
	 */

	public boolean getUser(String usernameID, String passwordID) throws SQLException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		@SuppressWarnings("unused")
		Users user = null;
		ResultSet rs = null;

		String query = "SELECT * FROM users where username = ? AND password = ?";

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			System.out.println("Search operation -database successfully opened");
			System.out.println("-------");
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, usernameID);
			preparedStatement.setString(2, passwordID);
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
	//Execution of the query above with the use of prepared statements
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				return true;
			}

			preparedStatement.close();
			
	//Error message checking if there is a problem with the query
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

	//The variables are then closed, ready to be used in another method so they do not overload.
		
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("-------");
		System.out.println("Search operation completed, reload program to display results.");
		return false;

	}
	
	/**
	 * The method below is used to retrieve specified vehicles' information based on the values entered.
	 * @param stringID, this is the value entered into the input field on the web front end.
	 * @return vehicleList, this results in all specified vehicles' information being retrieved from the database.
	 * @throws SQLException if there is an error with the SQL query implemented.
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 */

	public ArrayList<Vehicle> searchAll(String searchID) throws SQLException, IOException {
	//Initialisation of variables which will be used in this method
		Connection conn = null;
		@SuppressWarnings("unused")
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		String query = "SELECT * FROM vehicles where Vehicle_ID = ? OR Make = ? OR Model = ? OR Price = ? ";
		ArrayList<Vehicle> vehicleList = new ArrayList<>();

		try {
			conn = getDBConnection();
			stmt = conn.createStatement();
			System.out.println("DBQuery = " + query);
	//The ? in the query represents a prepared statement in order, which is replaced by the corresponding number below.
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, searchID);
			preparedStatement.setString(2, searchID);
			preparedStatement.setString(3, searchID);
			preparedStatement.setString(4, searchID);
	//Execution of the query above with the use of prepared statements
			rs = preparedStatement.executeQuery();
	//The while loop below displays each vehicle's information from the vehicle database
			while (rs.next()) {
				int vehicle_id = rs.getInt("vehicle_ID");
				String make = rs.getString("Make");
				String model = rs.getString("Model");
				int year = rs.getInt("Year");
				int price = rs.getInt("Price");
				String license_number = rs.getString("License_Number");
				String colour = rs.getString("Colour");
				int number_doors = rs.getInt("Number_Doors");
				String transmission = rs.getString("Transmission");
				int mileage = rs.getInt("Mileage");
				String fuel_type = rs.getString("Fuel_Type");
				int engine_size = rs.getInt("Engine_Size");
				String body_style = rs.getString("Body_Style");
				String condition = rs.getString("Condition");
				String notes = rs.getString("Notes");
				boolean sold = rs.getBoolean("sold");

				vehicleList.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes, sold));

			}
	//Error message checking if there is a problem with the query

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
	//The variables are then closed, ready to be used in another method so they do not overload.
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return vehicleList;
	}
}
