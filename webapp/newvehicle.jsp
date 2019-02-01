
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/site.css">


<title>Insert new vehicle</title>
</head>
<body>

<div class="container p-3, mb-2 bg-light text-dark">

	<h1>Insert a Vehicle</h1>
	
<%-- The insert form below retrieves the users inserted vehicle information and then parses the information
 to the servlet to execute the functionality --%>	

	<form method="POST" action="./newvehicle">
		<div class="form-group">
			<label for="make">Make</label> <input
				type="text" class="form-control" id="make" name="make"
				placeholder="Volkswagen">
		</div>
		<div class="form-group">
			<label for="model">Model</label> <input
				type="text" class="form-control" id="model" name="model"
				placeholder="Polo">
		</div>
		<div class="form-group">
			<label for="year">Year</label> <input
				type="text" class="form-control" min=1900 id="year" name="year"
				placeholder="2014">
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input
				type="text" class="form-control" min=0 id="price" name="price"
				placeholder="6000">
		</div>
		
<%-- The license number contains a pattern which ensures the entered input matches the UK's license number plate format from 1983 onwards which is shown below. --%>
		
		<div class="form-group">
			<label for="license_number">License Number(e.g. 1983 to 2001: 'A123ZSG' or 2001 onwards 'LT04ZSG')</label> <input
				type="text" class="form-control" pattern="[A-Z][A-Z0-9][0-9][0-9][A-Z][A-Z][A-Z]" id="license_number" name="license_number"
				placeholder="BW14HWD">
		</div>
		<div class="form-group">
			<label for="colour">Colour</label> <input
				type="text" class="form-control" id="colour" name="colour"
				placeholder="White">
		</div>
				<div class="form-group">
			<label for="number_doors">Number of Doors</label> <select
				class="form-control" id="number_doors" name="number_doors"> 
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
			</select>
		</div>
		<div class="form-group">
			<label for="transmission">Transmission</label> <input
				type="text" class="form-control" id="transmission" name="transmission"
				placeholder="Petrol">
		</div>
		<div class="form-group">
			<label for="mileage">Mileage</label> <input
				type="text" class="form-control" min=0 id="mileage" name="mileage"
				placeholder="60316">
		</div>
		<div class="form-group">
			<label for="fuel_type">Fuel Type</label> <input
				type="text" class="form-control" id="fuel_type" name="fuel_type"
				placeholder="Petrol">
		</div>
		<div class="form-group">
			<label for="engine_size">Engine Size</label> <input
				type="text" class="form-control" min=1000 id="engine_size" name="engine_size"
				placeholder="1000">
		</div>
		<div class="form-group">
			<label for="body_style">Body Style</label> <input
				type="text" class="form-control" min=1000 id="body_style" name="body_style"
				placeholder="Hatchback">
		</div>
		<div class="form-group">
			<label for="condition">Condition</label> <input
				type="text" class="form-control" min=1000 id="condition" name="condition"
				placeholder="Excellent">
		</div>
		<div class="form-group">
			<label for="notes">Notes</label> <input
				type="text" class="form-control" id="notes" name="notes"
				placeholder="Great car!">
		</div>
		
		<button type="submit" class="btn btn-primary btn-lg btn-block">Finish inserting vehicle data</button>
		<br>
		
		

	</form>

	<a href="./database" class="btn btn-secondary btn-lg btn-block" role="button" >Return to database</a>
	
</div>


</body>
</html>

