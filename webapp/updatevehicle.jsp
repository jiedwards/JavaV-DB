
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/site.css">
	<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>

		<c:set value="${Update}" var="c"/>
			<br>
	<title>Update vehicle data</title>

</head>
<body>
	<div class="container mb-2 bg-light text-dark">
	<h1>Update vehicle data</h1>
	
<%-- The update form below retrieves the users updated information, stores the input in "values" and then parses the information to the servlet.
         to execute the functionality --%>
	
	<form method="POST" action="./updatevehicle">
		<div class="form-group"><input type="hidden"  value="${c.getVehicle_id()}" min=0  id="vehicle_id" name="vehicle_id"></div>
		<div class="form-group">
			<label for="make">Make</label> <input
				type="text" class="form-control" value="${c.getMake()}" id="make" name="make">
		</div>
		<div class="form-group">
			<label for="model">Model</label> <input
				type="text" class="form-control" value="${c.getModel()}"  id="model" name="model"
				value="${c.getModel()}">
		</div>
		<div class="form-group">
			<label for="year">Year (in numerical format)</label> <input
				type="text" class="form-control" value="${c.getYear()}" min=1900 id="year" name="year"
				placeholder="2014">
		</div>
		<div class="form-group">
			<label for="price">Price (in numerical format)</label> <input
				type="text" class="form-control" value="${c.getPrice()}" min=0 id="price" name="price"
				placeholder="6000">
		</div>
		
<%-- The license number contains a pattern which ensures the entered input matches the UK's license number plate format from 1983 onwards which is shown below. --%>
		
		<div class="form-group">
			<label for="license_number">License Number (e.g. 1983 to 2001: 'A123ZSG' or 2001 onwards 'LT04ZSG')</label> <input
				type="text" class="form-control" value="${c.getLicense_number()}" id="license_number" pattern="[A-Z][A-Z0-9][0-9][0-9][A-Z][A-Z][A-Z]" id="license_number" name="license_number"
				placeholder="BW14 HWD">
		</div>
		<div class="form-group">
			<label for="colour">Colour</label> <input
				type="text" class="form-control" value="${c.getColour()}" id="colour" name="colour"
				placeholder="White">
		</div>
				<div class="form-group">
			<label for="number_doors">Number of Doors</label> 
			<input type="text" value="${c.getNumber_doors()}" class="form-control" min=1000 id="number_doors" name="number_doors">
		</div>
		<div class="form-group">
			<label for="transmission">Transmission</label> 
			<input type="text" value="${c.getTransmission()}" class="form-control" id="transmission" name="transmission"
				placeholder="Petrol">
		</div>
		<div class="form-group">
			<label for="mileage">Mileage (in numerical format)</label> 
			<input type="text" value="${c.getMileage()}" class="form-control" min=0 id="mileage" name="mileage"
				placeholder="60316">
		</div>
		<div class="form-group">
			<label for="fuel_type">Fuel Type</label>
			<input type="text" value="${c.getFuel_type()}" class="form-control" id="fuel_type" name="fuel_type"
				placeholder="Petrol">
		</div>
		<div class="form-group">
			<label for="engine_size">Engine Size (in numerical format(1000 minimum))</label> 
			<input type="text" value="${c.getEngine_size()}" class="form-control" min=1000 id="engine_size" name="engine_size"
				placeholder="1000">
		</div>
		<div class="form-group">
			<label for="body_style">Body Style</label> 
			<input type="text" value="${c.getBody_style()}" class="form-control" min=1000 id="body_style" name="body_style"
				placeholder="Hatchback">
		</div>
		<div class="form-group">
			<label for="condition">Condition</label> 
			<input type="text" value="${c.getCondition()}" class="form-control" min=1000 id="condition" name="condition"
				placeholder="Excellent">
		</div>
		<div class="form-group">
			<label for="notes">Notes</label> 
			<input type="text" value="${c.getNotes()}" class="form-control" id="notes" name="notes"
				placeholder="Great car!">
		</div>
		
		<button type="submit" class="btn btn-primary btn-lg btn-block">Finish updating vehicle data</button>
		<br>
		
		

	</form>
	
		<a href="./database" class="btn btn-secondary btn-lg btn-block" role="button" >Return to database</a>
	
	</div>

	
</body>
</html>
