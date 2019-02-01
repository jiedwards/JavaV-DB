package controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Vehicle;
import models.VehicleDAO;

public class Controller {
	
	/**
	 * This method contains all the scanners and input's required to execute many of the functions, such as insert, update, delete etc.
	 * @param vChoice, this is the input declared which controls the console's choice after it's launch.
	 * @throws SQLException if there is an error with the SQL queries implemented.
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 */

	public static void main(String[] args) throws SQLException, IOException {

	/* Both the arraylist and the scanner have been initialised at the beginning of the page to prevent
	multiple declarations. */
		VehicleDAO dao = new VehicleDAO();
		ArrayList<Vehicle> allVehicles = null;
	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println(""
				+ "----------------------------- \n"
				+ "Vehicle Inventory System \n"
				+ "Choose from theese options \n"
				+ "----------------------------- \n"
				+ "1 - Retrieve all vehicles \n"
				+ "2 - Search for vehicle \n"
				+ "3 - Insert new vehicle into database \n"
				+ "4 - Update existing vehicle details \n"
				+ "5 - Delete vehicle from database \n"
				+ "6 - Mark a vehicle as sold \n"
				+ "7 - Mark a vehicle as unsold \n"
				+ "8 - Exit \n"
				+ "Enter choice > ");

		/*The vChoice is the scanner variable for the immediate input from the back-end console. It is also the
		 * identifier in the switch case statement that occurs below.*/
		
		int vChoice = (int) scanner.nextFloat();

		switch (vChoice) {
		//Retrieves all vehicles from the array in the VehicleDAO.
		case 1:
			if (vChoice == vChoice) {

				allVehicles = dao.getAllVehicles();
				for (Vehicle v : allVehicles) {
					System.out.println("-------");
					System.out.println(v);
				}
			}
			break;
		//This case retrieves a users choice and parses that vehicle through to the method in the DAO to retrieve an individual vehicle's details.
		case 2:
			if (vChoice == vChoice) {

				System.out.print("Enter a Vehicle by ID number to retrieve the data from the database: ");
				int searchID = scanner.nextInt();
				System.out.println("-------");
				
				dao.getVehicle(searchID);
			}
			break;
		case 3:
		/* Allows a user to enter a new vehicle using the scanners, these inputs are then parsed to the method in the DAO
		 * which executes the insert.*/
			if (vChoice == vChoice) {

				scanner = new Scanner(System.in);

				System.out.print("Enter your vehicles make: ");
				String newMake = scanner.nextLine();

				System.out.print("Enter your vehicles model: ");
				String newModel = scanner.nextLine();

				System.out.print("Enter your vehicles production year (in numerical format): ");
				int newYear = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your vehicles price(in £):  ");
				int newPrice = scanner.nextInt();
				scanner.nextLine();
		/* The license_number is verified using Java's own matcher function, it requires a pattern (which has been set according to UK's number plates since 1983)
		 * , the value entered by the user's input is then verified against this pattern, if it matches then the program proceeds, if it does not the program exits with a message.*/
				System.out.print("Enter your vehicles license_number in the format post 2001('LT04ZSG') or from 1983-2001 ('A123ZSG'): ");
				String newlicense_Number = scanner.nextLine();
				Matcher m = Pattern.compile("[A-Z]([A-Z]|\\d)\\d\\d[A-Z][A-Z][A-Z]").matcher(newlicense_Number);
				if (m.find()) {
				    System.out.println(newlicense_Number + " is a valid number plate");
				} else {
				    System.out.println(newlicense_Number + " is not a valid number plate. Reload the program to try again.");
					System.exit(0);
				}

				System.out.print("Enter your vehicles colour: ");
				String newColour = scanner.nextLine();

				System.out.print("Enter your vehicles number of doors(in numerical format): ");
				int newnumber_Doors = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your vehicles transmission type:  ");
				String newTransmission = scanner.nextLine();

				System.out.print("Enter your vehicles mileage number(in numerical format): ");
				int newMileage = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your vehicles fuel type: ");
				String newfuel_Type = scanner.nextLine();

				System.out.print("Enter your vehicles engine size(in numerical format(1000 minimum)): ");
				int newengine_Size = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your vehicles body style:  ");
				String newbody_Style = scanner.nextLine();

				System.out.print("Enter your vehicles condition: ");
				String newCondition = scanner.nextLine();

				System.out.print("Enter your any notes for the vehicle:  ");
				String newNotes = scanner.nextLine();
				

				
				Vehicle v = new Vehicle(999, newMake, newModel, newYear, newPrice, newlicense_Number, newColour, newnumber_Doors, newTransmission, newMileage, newfuel_Type, newengine_Size, newbody_Style, newCondition, newNotes, false);
				
				dao.insertVehicle(v);
			}
			break;
		/* Allows a user to update a vehicle's data using the scanners, these inputs are then parsed to the method in the DAO
		* which executes the update.*/
		case 4:
			if (vChoice == vChoice) {

				System.out.print("Enter the ID of the Vehicle record you would like to update: ");
				int chosenID = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your updated vehicles make: ");
				String updatedMake = scanner.nextLine();

				System.out.print("Enter your updated vehicles model: ");
				String updatedModel = scanner.nextLine();

				System.out.print("Enter your updated vehicles year (in numerical format): ");
				int updatedYear = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your updated vehicles price (in numerical format):  ");
				int updatedPrice = scanner.nextInt();
				scanner.nextLine();
	/* The license_number is verified using Java's own matcher function, it requires a pattern (which has been set according to UK's number plates since 1983)
	* , the value entered by the user's input is then verified against this pattern, if it matches then the program proceeds, if it does not the program exits with a message.*/
				System.out.print("(\"Enter your vehicles update license_number in the format post 2001('LT04ZSG') or from 1983-2001 ('A123ZSG'): ");
				String updatedlicense_Number = scanner.nextLine();
				Matcher m = Pattern.compile("[A-Z]([A-Z]|\\d)\\d\\d[A-Z][A-Z][A-Z]").matcher(updatedlicense_Number);
				if (m.find()) {
				    System.out.println(updatedlicense_Number + " is a valid number plate");
				} else {
				    System.out.println(updatedlicense_Number + " is not a valid number plate. Reload the program to try again.");
					System.exit(0);
				}

				System.out.print("Enter your updated vehicles colour: ");
				String updatedColour = scanner.nextLine();

				System.out.print("Enter your updated vehicles number of doors (in numerical format): ");
				int updatednumber_Doors = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your updated vehicles transmission type:  ");
				String updatedTransmission = scanner.nextLine();

				System.out.print("Enter your updated vehicles mileage number (in numerical format): ");
				int updatedMileage = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your updated vehicles fuel type: ");
				String updatedfuel_Type = scanner.nextLine();

				System.out.print("Enter your updated vehicles engine size (in numerical format (1000 minimum)): ");
				int updatedengine_Size = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter your updated vehicles body style:  ");
				String updatedbody_Style = scanner.nextLine();

				System.out.print("Enter your updated vehicles condition: ");
				String updatedCondition = scanner.nextLine();

				System.out.print("Enter your updated vehicles notes:  ");
				String updatedNotes = scanner.nextLine();

				Vehicle Update = new Vehicle(chosenID, updatedMake, updatedModel, updatedYear, updatedPrice, updatedlicense_Number, updatedColour, updatednumber_Doors, updatedTransmission, updatedMileage, updatedfuel_Type, updatedengine_Size, updatedbody_Style, updatedCondition, updatedNotes, false);

			//the method which links to the dao is executed here and the variables and parsed through.	
				dao.updateVehicle(Update, chosenID);
			}
			break;
		/* Allows a user to enter a vehicle id using the scanner below, this input is then parsed to the method in the DAO
		 *  which executes a delete function. */
		case 5:
			if (vChoice == vChoice) {

				System.out.print("Enter a Vehicle by ID number to delete that Vehicle from the database: ");
				int deleteID = scanner.nextInt();
				
				dao.deleteVehicle(deleteID);
			}
		/* Allows a user to mark a vehicle as sold by entering a vehicle ID into the scanner */
			break;
		case 6:
			if (vChoice == vChoice) {

				System.out.print("Enter a Vehicle by ID number to mark that vehicle as sold: ");
				int soldID = scanner.nextInt();
				
				dao.soldVehicle(soldID);
			}
			break;
		/* Allows a user to unmark a vehicle from previously being sold by entering a vehicle ID into the scanner */
		case 7:
			if (vChoice == vChoice) {

				System.out.print("Enter a Vehicle by ID number to unmark that vehicle from sold: ");
				int unsoldID = scanner.nextInt();
				
				dao.unsoldVehicle(unsoldID);
			}
			break;
		/* Allows a user exit the system and not call upon any functions. */
		case 8:
			if (vChoice == vChoice) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			break;
		}
	}
}