package controllers;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;


/**
 * This class is used to bind the individual servlet's to a URL link. 
 * It also sets up the server for the web front end to be used.
 * @author Jacob Edwards
 * @version 1.0
 */

public class ControllerServer {

	public static void main(String[] args) throws Exception {
	//Server port the webpage operates on.
		Server server = new Server(8005);
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp");
		ctx.setContextPath("/vehicles");

		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*[^/]*jstl.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
				"org.eclipse.jetty.annotations.AnnotationConfiguration");

		// Mappings
		ctx.addServlet("servlets.ServletDefault", "/database");
		ctx.addServlet("servlets.ServletInsert", "/newvehicle");
		ctx.addServlet("servlets.ServletDelete", "/deletevehicle");
		ctx.addServlet("servlets.ServletSold", "/soldVehicle");
		ctx.addServlet("servlets.ServletUnsold", "/unsoldVehicle");
		ctx.addServlet("servlets.ServletSearch", "/searchvehicle");
		ctx.addServlet("servlets.ServletUpdate", "/updatevehicle");
		ctx.addServlet("servlets.LoginHandler", "/login");
		ctx.addServlet("servlets.LogOutHandler", "/logout");


		

		// Setting the handler and starting the Server
		server.setHandler(ctx);
		server.start();
		server.join();
		
		/* Once this page is run as a java application, the user can access the web-page by pointing their browser to:
		http://localhost:8005/vehicles/database */

	}

}
