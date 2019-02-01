package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VehicleDAO;

/** This servlet specifically handles the functionality for the delete action.
 * @author Jacob Edwards
 *
 */

public class ServletDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Method is used to retrieve information, specifically the vehicle id from the jsp file
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);
	}
	
	/**
	 * This doPost method parses the vehicle_id entered into the method in the DAO to execute the delete query.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();

		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));

		try {
			boolean done = dao.deleteVehicle(vehicle_id);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("database");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}