package models;

/**
 * This class is used to control and call upon the variables necessary for the vehicles in the system.
 * All of the variables declared at the beginning are used constantly throughout the system,
 * therefore there are getter and setter methods made for each in order to call upon these values.
 * Lastly is the toString method which defines what is printed to the console.
 * @author Jacob
 * @return any of the variables are returned if any of the getters is called.
 * @version 1.0
 */

public class Vehicle {

	private int vehicle_id;
	private String make;
	private String model;
	private int year;
	private int price;
	private String license_number;
	private String colour;
	private int number_doors;
	private String transmission;
	private int mileage;
	private String fuel_type;
	private int engine_size;
	private String body_style;
	private String condition;
	private String Notes;
	boolean sold;

	
	public Vehicle(int vehicle_id, String make, String model, int year, int price,
			String license_number, String colour, int number_doors, String transmission,
			int mileage, String fuel_type, int engine_size, String body_style,
			String condition, String Notes, Boolean sold) {
		
		this.vehicle_id = vehicle_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.license_number = license_number;
		this.colour = colour;
		this.number_doors = number_doors;
		this.transmission = transmission;
		this.mileage = mileage;
		this.fuel_type = fuel_type;
		this.engine_size = engine_size;
		this.body_style = body_style;
		this.condition = condition;
		this.Notes = Notes;
		this.sold = sold;
		
	}
	
	public Vehicle() {
	}

	//Below are the getters and setters for each variable, they are used multiple times throughout the program to retrieve values.
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getNumber_doors() {
		return number_doors;
	}
	public void setNumber_doors(int number_doors) {
		this.number_doors = number_doors;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public int getEngine_size() {
		return engine_size;
	}
	public void setEngine_size(int engine_size) {
		this.engine_size = engine_size;
	}
	public String getBody_style() {
		return body_style;
	}
	public void setBody_style(String body_style) {
		this.body_style = body_style;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}
	
	/* The following method defines what is printed to the console when this entire class is called upon.*/

	@Override
	public String toString() {
		return "Car details are as follows: " + System.lineSeparator()
		+ " Vehicle ID: " + this.getVehicle_id()  + System.lineSeparator() 
		+ " Make: "+this.getMake() + System.lineSeparator() 
		+ " Model: " + this.getModel() + System.lineSeparator() 
		+ " Year: "+this.getYear() + System.lineSeparator() 
		+ " Price: " + this.getPrice() + System.lineSeparator()
		+ " License Number: "+this.getLicense_number() + System.lineSeparator() 
		+ " Colour: " + this.getColour() + System.lineSeparator() 
		+ " Number of Doors: "+this.getNumber_doors() + System.lineSeparator() 
		+ " Transmission: " + this.getTransmission()+ System.lineSeparator()
		+ " Mileage: "+this.getMileage() + System.lineSeparator()
		+ " Fuel Type: " + this.getFuel_type() + System.lineSeparator()
		+ " Engine Size: "+this.getEngine_size() + System.lineSeparator()
		+ " Body Style: " + this.getBody_style() + System.lineSeparator()
		+ " Condition: "+this.getCondition() + System.lineSeparator()
		+ " Notes: " + this.getNotes() + System.lineSeparator()
		+ " Sold: " + this.isSold() + System.lineSeparator();
	}
}
