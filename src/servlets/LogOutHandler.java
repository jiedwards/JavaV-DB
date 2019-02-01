package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

/** This servlet specifically handles the logout portion of the website.
 * @author Jacob Edwards
 *
 */

public class LogOutHandler extends HttpServlet {

	/**
	 * This doPost method invalidates the session, therefore the user will no longer be able to access the
	 * restricted information on the website.
	 * @author Jacob Edwards
	 * @throws ServletException an exception a servlet will commonly throw when it encounters a problem
	 * @throws IOException throws up an error message if there is a problem with an input or output
	 * @param HttpServletRequest provides request information for HTTP servlets.
	 * @param HttpServletResponse provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.
	 */
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/database");
	}

}
