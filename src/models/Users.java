package models;

/**
 * This class is used to control and call upon the variables necessary for logging into the system.
 * The only notable variables are username and password, getter and setter methods are made for each in order to call upon these values.
 * @author Jacob
 * @return password if getPassword method is called.
 * @return username if the getUsername method is called.
 * @version 1.0
 */

public class Users {
	
	private String username;
	private String password;
	
	public Users(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/*The toString is what the method which defines what is printed to the console for this method, 
 * this method is only used on the front-end and therefore it is not used.*/
	public String toString() {
		return "Car details are as follows: " + System.lineSeparator()
		+ " Username: " + this.getUsername()  + System.lineSeparator() 
		+ " Password: "+this.getPassword() + System.lineSeparator();
	}


}
