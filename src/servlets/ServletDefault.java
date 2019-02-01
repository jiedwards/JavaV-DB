package servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/** This servlet specifically retrieves the information in the database and assists 
 * in the functionality of displaying all the vehicles on the webpage.
 * @author Jacob Edwards
 *
 */

public class ServletDefault extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Method is used to return the arraylist of all the vehicles.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();
		ArrayList<Vehicle> allCons = null;
		try {
			allCons = dao.getAllVehicles();
			System.out.println(allCons);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(allCons);
			System.out.println("not printing correctly");
		}
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		req.setAttribute("allCons", allCons);
		view.forward(req, resp);
	}

}
