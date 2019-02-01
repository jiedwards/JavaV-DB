package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VehicleDAO;

/** This servlet specifically handles the functionality for the search action to find vehicles in the database.
 * @author Jacob Edwards
 *
 */

public class ServletSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ArrayList<models.Vehicle> Vehicle = null;

	/**
	 * This doPost method parses the user entered necessary information into the searchAll method in the DAO to execute the search query.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();
		String searchID = (String) req.getParameter("search_id");

		try {
			Vehicle = dao.searchAll(searchID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Vehicle);

		RequestDispatcher view = req.getRequestDispatcher("searchvehicle.jsp");
		req.setAttribute("Vehicle", Vehicle);
		view.forward(req, resp);

	}

}
