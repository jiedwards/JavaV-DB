<%@page import="models.Vehicle"%>
    <%@page import="models.VehicleDAO"%>

        <%@page import="java.util.ArrayList"%>

<%-- At the beginning of the page, some of the necessary information is declared and the relevant stylesheets and scripts are linked. In the case of this assignment,
I have chosen to put an inline stylesheet into my code as there is not much CSS present. --%>

            <html>

            <head>
                <html lang="en">
                <meta charset="UTF-8">
                <title>Insert title here</title>
                <meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href=".../css/site.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<%--Inline CSS Styling --%>


                <style>
body {
  background-color: #d9e6f2;
}

h1 {
  color: #336699;
  margin-left: 40px;
  font-size: 48px;
} 
th, td {
  color: #336699;
  margin-left: 40px;
  font-size: 14px;
}


p {
  color: maroon;
  margin-left: 40px;
  font-size: 8px;
} 

.table td.fit, 
.table th.fit {
    white-space: nowrap;
    width: 1%;
    font-size: 48px;
  
}

<!-- The below CSS considers that if the database table spills over the borders of the webpage,
 the layout will stay consistent and only the table will stretch the page. -->

.table-wrapper-scroll-x {
display: block;
max-width:	100%;
overflow-x: auto;
-ms-overflow-style: -ms-autohiding-scrollbar;
width: 100% !important;
  font-size: 10px; !important;

}



</style>
                

            </head>
 
 <%-- During the not logged in experience of the website, the search function returns specified vehicles as is expected,
However a user who isn't logged in does not have the permissions to edit/delete or mark vehicles as sold whilst in the search function. --%>	                   

            <body>
            
<%-- The below HTML code is essentially an if/else statement, which displays which information is shown to the user on the web page.
A person who is not logged in will have access to different information compared to when the Admin is logged in --%>

            <c:choose>
<%-- The c:when test decides what the admin sees when they are logged in. --%>

		<c:when test="${loggedin == true}">

                <div class="container mb-2 bg-light text-dark">

                    <div class="container">
                    </div>
                    <h1>Searched Vehicles</h1>
                    <div class="image">
                        <a href="./database">
		<img src="./images/car.jpg" alt="car" height="150" width="150">
		</a>
                    </div>
                    
<%-- The logout button is a form which send a request to the logout jsp file. --%>

                    
                    <form action="${pageContext.request.contextPath}/logout" method="post">
                        <input type="submit" class="d-inline btn btn-danger" value="Logout" />
                    </form>
                    
<%-- The below form is the operation for the search vehicle,
 it submits the value entered into the search field and processes it using the the functionality on the search vehicle jsp. --%>
    
                    <form method="POST" action="./searchvehicle">

                        <div class="container mb-2 bg-light text-dark">
                            <h5>Search by</h5>
                            <label class="options" for="options"> </label>
                            <select class="custom-select mr-sm-2" id="choice">
								<option selected>Any</option>
								
								<option value="vehicle_id">ID</option>
								<option value="make">Make</option>
								<option value="model">Model</option>
								<option value="price">Price				
								<!--  <input type="text" class="form-control input-sm" placeholder="min">
  								<input type="text" class="form-control input-sm" placeholder="max"></option> -->
							</select>
                            <label class="choice" for="choice"></label> <input type="search" class="form-control mb-2" name="search_id" id="search_id" placeholder="'Volkswagen', '27', 'Polo', '5000'" required>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <br><br>
                        </div>
                    </form>

                </div>

<%-- The div's below control the styling of the table displayed on the webpage --%>		

                <div class="container-fluid .table-responsive table table-sm mb-2 bg-light text-dark">
                <div class="table-wrapper-scroll-x">
<%-- Declaration for the table and it's headers.--%>

                    <table id ="hello" class=".table-striped table table-sm table-hover" style="background-color: white;">
					<thead class="thead-dark">
						<tr class="word-wrap">
                            <tr>
                                <th scope="col">Vehicle ID</th>
                                <th scope="col">Make</th>
                                <th scope="col">Model</th>
                                <th scope="col">Year</th>
                                <th scope="col">Price</th>
                                <th scope="col">License Number</th>
                                <th scope="col">Colour</th>
                                <th scope="col">Number of doors</th>
                                <th scope="col">Transmission</th>
                                <th scope="col">Mileage</th>
                                <th scope="col">Fuel Type</th>
                                <th scope="col">Engine Size</th>
                                <th scope="col">Body Style</th>
                                <th scope="col">Condition</th>
                                <th scope="col">Notes</th>
								<th scope="col">Sold</th>

                            </tr>
                        </thead>
                        
<%-- The foreach statement below reads the vehicles from the database, and prints out information for each vehicle that exists. --%>

                        <c:forEach items="${Vehicle}" var="c">

                            <tbody>
                                <tr>
                                    <td>${c.getVehicle_id()}</td>
                                    <td>${c.getMake()}</td>
                                    <td>${c.getModel()}</td>
                                    <td>${c.getYear()}</td>
                                    <td>${c.getPrice()}</td>
                                    <td>${c.getLicense_number()}</td>
                                    <td>${c.getColour()}</td>
                                    <td>${c.getNumber_doors()}</td>
                                    <td>${c.getTransmission()}</td>
                                    <td>${c.getMileage()}</td>
                                    <td>${c.getFuel_type()}</td>
                                    <td>${c.getEngine_size()}</td>
                                    <td>${c.getBody_style()}</td>
                                    <td>${c.getCondition()}</td>
                                    <td>${c.getNotes()}</td>
                                    <td>${c.isSold()}</td>
                                   
<%--  Below is a declaration for a new variable which stores whether each vehicle is sold or not. 
This variable is used for another if test later in the page. --%>	

							<c:set var="soldVehicles" value="${c.isSold()}" />

<%-- The edit code below is a button that passes through the chosen vehicle ID to the updatevehicle jsp page where the functionality occurs. --%>	
									

							  <td>  <a href="./updatevehicle?vehicle_id=${c.getVehicle_id()}"  class="btn btn-sm btn-primary" id="vehicle_id"
								style="height: 30px; width: 80px;">
						          <span class="glyphicon glyphicon-pencil"></span>Edit</a>
						          
<%-- Similar to the function above, the button passes a vehicle ID through to the deletevehicle jsp file which contains the functionality,
however the action is done inline to the page using the post method and therefore, the action happens on the page --%>	
						          
						    <form method="POST" action="./deletevehicle">
									<input type="hidden" value="${c.getVehicle_id()}" min=0
										id="vehicle_id" name="vehicle_id">
									<button type="submit" class="btn-danger glyphicon glyphicon-trash"
										style="height: 30px; width: 80px;">Delete</button>				
							</form>
							
<%-- Below is another test which chooses what to display depending on whether a vehicle is marked as sold or not.
In this event, a button is displayed which allows the admin to mark a vehicle as sold. --%>	
								
								<c:if test="${soldVehicles eq false}">

									<form method="POST" action="./soldVehicle">
										<input type="hidden" value="${c.getVehicle_id()}" min=0
											id="vehicle_id" name="vehicle_id">
										<button type="submit" class="btn btn-sm btn-success"
											style="height: 30px; width: 80px;"
											onClick="(function(){
						    alert('Vehicle successfully marked as sold');

							return c.isSold = true;
						    return true;
						})();return false;">Sold?</button>
									</form>
							</c:if>
							
<%-- In this event, a button is displayed which allows the admin to unmark a vehicle from being previously marked as sold. --%>	

							<c:if test="${soldVehicles eq true}">

								<form method="POST" action="./unsoldVehicle">
									<input type="hidden" value="${c.getVehicle_id()}" min=0
										id="vehicle_id" name="vehicle_id">
									<button type="submit" class="btn btn-sm btn-dark"
										style="height: 30px; width: 80px;"
										onClick="(function(){
						    alert('Vehicle successfully unmarked from sold');

							return c.isSold = true;
						    return true;
						})();return false;">Not sold?</button>
								</form></td>
								
<%-- This test also includes a visual reminder to the user whether a vehicle is already marked as sold. --%>									
								
								<tr>
									<td><button type="button" class="btn btn-sm btn-warning"
											style="height: 35px; width: 50px;" disabled>SOLD</button></td>
								</tr>


							</c:if>
							


					</c:forEach>

</tr>
					</tbody>

                    </table>

                </div>
                </div>
                
<%-- Below is the code which allows the admin to enter a new vehicle in the database whilst staying in the same page, it is a button which toggles a form.
The form contains all the relevant questions and posts this information to the newvehicle.jsp where the functionality occurs. --%>

                <div class="container mb-2 bg-light text-dark">

                    
                    <br>
                    <a href="./database" class="btn btn-secondary btn-lg btn-block" role="button">Return to database</a>


                    <br>

                </div>
                </c:when>

<%-- Below "c:otherwise" is essentially the else part of an if/else statement,
it defines what is shown to a user visiting the page who is not logged in. --%>	

			<c:otherwise>

<%-- During the not logged in experience of the website, the search function returns specified vehicles as is expected,
However a user who isn't logged in does not have the permissions to edit/delete or mark vehicles as sold whilst in the search function. --%>	
			
<div class="container mb-2 bg-light text-dark">

                    
                    <h1>Searched Vehicles</h1>
                    <div class="image">
                        <a href="./database">
		<img src="./images/car.jpg" alt="car" height="150" width="150">
		</a>
		</div>
               
<%-- The below form is the operation for the search vehicle,
 it submits the value entered into the search field and processes it using the the functionality on the search vehicle jsp --%>            
               
                    <form method="POST" action="./searchvehicle">

                            <h5>Search by</h5>
						<label class="options" for="options"> </label> <select class="custom-select mr-sm-2" id="choice">
							<option selected>Any</option>
							<option value="vehicle_id">ID</option>
							<option value="make">Make</option>
							<option value="model">Model</option>
							<option value="price">Price
						</select> <label class="choice" for="choice"></label> <input type="search"
							class="form-control mb-2" name="search_id" id="search_id"
							placeholder="'Volkswagen', '27', 'Polo', '5000'" required>
						<button type="submit" class="btn btn-primary">Submit</button>
						<br> <br>
				</form>
                     </div>
                     
<%-- The div's below control the styling of the table displayed on the webpage --%>		                     

					<div class="table-wrapper-scroll-x">
					
<%-- Declaration for the table and it's headers.--%>

				<div class=".container-fluid .table-responsive table table-sm mb-2 bg-light text-dark">
					<table id ="hello" class=".table-striped table table-sm table-hover" style="background-color: white;">
					<thead class="thead-dark">
						<tr class="word-wrap">
                                <th scope="col">Vehicle ID</th>
                                <th scope="col">Make</th>
                                <th scope="col">Model</th>
                                <th scope="col">Year</th>
                                <th scope="col">Price</th>
                                <th scope="col">License Number</th>
                                <th scope="col">Colour</th>
                                <th scope="col">Number of doors</th>
                                <th scope="col">Transmission</th>
                                <th scope="col">Mileage</th>
                                <th scope="col">Fuel Type</th>
                                <th scope="col">Engine Size</th>
                                <th scope="col">Body Style</th>
                                <th scope="col">Condition</th>
                                <th scope="col">Notes</th>
								<th scope="col">Sold</th>

                            </tr>
                        </thead>
                        
<%-- The foreach statement below reads the vehicles from the database, and prints out information for each vehicle that exists. --%>

                        
                        <c:forEach items="${Vehicle}" var="c">

                            <tbody>
                                <tr>
                                    <td>${c.getVehicle_id()}</td>
                                    <td>${c.getMake()}</td>
                                    <td>${c.getModel()}</td>
                                    <td>${c.getYear()}</td>
                                    <td>${c.getPrice()}</td>
                                    <td>${c.getLicense_number()}</td>
                                    <td>${c.getColour()}</td>
                                    <td>${c.getNumber_doors()}</td>
                                    <td>${c.getTransmission()}</td>
                                    <td>${c.getMileage()}</td>
                                    <td>${c.getFuel_type()}</td>
                                    <td>${c.getEngine_size()}</td>
                                    <td>${c.getBody_style()}</td>
                                    <td>${c.getCondition()}</td>
                                    <td>${c.getNotes()}</td>
                                    <td>${c.isSold()}</td>
                                    
<%--  Below is a declaration for a new variable which stores whether each vehicle is sold or not. 
This variable is used for another if test later in the page. --%>
                                    
                                     <c:set var = "soldVehicles" value = "${c.isSold()}"/>
                                     
<%-- Below is another test which chooses what to display depending on whether a vehicle is marked as sold or not.
In this event, a visual reminder is displayed to show whether a vehicle is sold or not. --%>	
							
																
						<c:if test="${soldVehicles eq true}" >
									<tr><td><button type="button" class="btn btn-sm btn-warning" disabled>SOLD</button></td></tr>									
									
						</c:if>
                                    
                                    



                                </tr>

                        </c:forEach>


                        </tbody>

                    </table>

                </div>
                

               
				<div class="container mb-2 bg-light text-dark">
                            
                    <br>
                    <a href="./database" class="btn btn-secondary btn-lg btn-block" role="button">Return to database</a>


                    <br>

                </div>
                </div>
</div>

<%-- End of the opening otherwise statement, and also the end of the choose statement which loops over the entire page.--%>				


			</c:otherwise>

	</c:choose>
            </body>

            </html>