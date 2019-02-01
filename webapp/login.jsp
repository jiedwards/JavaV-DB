<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
      <title>Insert title here</title>
      <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/site.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        </head>
        <body>
        <%-- The div class is the styling for the login webpage --%>
          <div class="w-50 p-3 container mb-2 bg-light text-dark">
            <h1>Log in </h1>
            <div class="image">
              <a href="./database">
                <img src="./images/login.png" alt="car" height="100" align="middle" width="100">
                </a>
              </div>
              
        <%-- The login form below retrieves the users information, stores the input in "value" and then parses the information to the servlet.
         to execute the functionality --%>
         
              <div class="form-group">
                <form method="POST" action="./login">
                  <br>
                    <input type="text" class="form-control" class="form-control form-control-sm" value="${admin.GetUsername()}" min=0  id="username" placeholder="username" name="username">
                      <br>
                        <input type="password" class="form-control" value="${admin.GetPassword()}" min=0  id="password" placeholder="password" name="password">
                          <br>
                            <button type="submit" class="btn btn-warning">Login</button>
                          </form>
                          
                        </div>
                      </div>
                    </body>
                  </html>