package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/** This servlet specifically handles the functionality for the insert action to add a vehicle in the database.
 * @author Jacob Edwards
 *
 */

public class ServletInsert extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Method is used to retrieve the necessary information to insert a new vehicle, from the jsp file
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("newvehicle.jsp");
		view.forward(req, resp);
	}

	/**
	 * This doPost method parses the necessary information into the insert method in the DAO to execute the insert query.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();

		int Vehicle_id = 999;
		String Make = (String) req.getParameter("make");
		String Model = (String) req.getParameter("model");
		int Year = Integer.parseInt(req.getParameter("year"));
		int Price = Integer.parseInt(req.getParameter("price"));
		String License_number = (String) req.getParameter("license_number");
		String Colour = (String) req.getParameter("colour");
		int Number_doors = Integer.parseInt(req.getParameter("number_doors"));
		String Transmission = (String) req.getParameter("transmission");
		int Mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuel_Type = (String) req.getParameter("fuel_type");
		int engine_Size = Integer.parseInt(req.getParameter("engine_size"));
		String body_Style = (String) req.getParameter("body_style");
		String Condition = (String) req.getParameter("condition");
		String Notes = (String) req.getParameter("notes");
	/* The license_number is verified using Java's own matcher function, it requires a pattern (which has been set according to UK's number plates since 1983)
	* , the value entered by the user's input is then verified against this pattern, if it matches then the program proceeds, if it does not the program exits with a message.*/
		Matcher m = Pattern.compile("[A-Z]([A-Z]|\\d)\\d\\d[A-Z][A-Z][A-Z]").matcher(License_number);
		if (m.find()) {
			System.out.println(License_number + " is a valid number plate");
		} else {
			System.exit(0);
			System.out.println(License_number + " is not a valid number plate. Reload the program to try again.");
		}

		Vehicle v = new Vehicle(Vehicle_id, Make, Model, Year, Price, License_number, Colour, Number_doors,
				Transmission, Mileage, fuel_Type, engine_Size, body_Style, Condition, Notes, false);
		try {
			boolean done = dao.insertVehicle(v);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("database");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
