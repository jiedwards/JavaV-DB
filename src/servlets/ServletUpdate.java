package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* The imports below are necessary in order to retrieve the necessary information from the relevant classes. */
import models.Vehicle;
import models.VehicleDAO;

/** This servlet specifically handles the functionality for the update action to update a vehicle's information in the database.
 * @author Jacob Edwards
 *
 */

public class ServletUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Vehicle Update;
	
	/**
	 * Method is used to retrieve the necessary information to update a vehicle's information, using the user's input from the jsp file.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("updatevehicle.jsp");
		VehicleDAO dao = new VehicleDAO();
		int chosenID = Integer.parseInt(req.getParameter("vehicle_id"));
		System.out.println(chosenID);
		try {
			Update = dao.getVehicle(chosenID);
			System.out.println(Update);
			req.setAttribute("Update", Update);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(Update);
			System.out.println("not printing correctly");
		}

	}
	
	/**
	 * This doPost method parses the necessary information into the update method in the DAO to execute the update query.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();

		int chosenID = Integer.parseInt(req.getParameter("vehicle_id"));
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


		Vehicle Update = new Vehicle(chosenID, Make, Model, Year, Price, License_number, Colour, Number_doors,
				Transmission, Mileage, fuel_Type, engine_Size, body_Style, Condition, Notes, false);
		try {
			System.out.println(Update);
			boolean done = dao.updateVehicle(Update, chosenID);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("database");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
