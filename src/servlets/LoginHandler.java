package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Users;
import models.VehicleDAO;

@SuppressWarnings("serial")
/** This servlet specifically handles the login portion of the website, it also handles the information entered in the form.
 * @author Jacob Edwards
 *
 */
public class LoginHandler extends HttpServlet {

	boolean admin = false;

	@Override
	/**
	 * This doGet method retrieves information from the jsp file, which stored the user's input on the login form.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("login.jsp");
		view.forward(req, resp);
	}
	/**
	 * This doPost method verifies the user's login information and checks it against the MD5 hash.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	//The user input is being checked against an MD5 hash to see if it matches what is in the database using the getUser method call below.
		try {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String pwhash = number.toString(16);
			System.out.println(pwhash);
	//If there is a match, a session is set and giving a variable name and a boolean state.
			admin = dao.getUser(username, pwhash);
			if (admin == true) {
				HttpSession session = req.getSession();
				session.setAttribute("loggedin", true);
				System.out.println("Login successful.");
				resp.sendRedirect("database");
				

			} 
	//If there is no match, the user is redirected to the login form.
			else {
				resp.sendRedirect("login");
				System.out.println("False login, try again.");

			}
	//Error message checking
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}