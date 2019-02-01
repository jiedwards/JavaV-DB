<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <%-- This logout jsp file defines what happens when a user presses the logout button. --%>

	<%
		request.getSession(false);
		if (session == null) {
	%>
	<a href="index.jsp"> Home</a>
	<a href="login.jsp"> Login</a>
	<%
		} else {
			// Already created.
	%>
	<a href="./database"> Logout</a>
	<%
		}
		String name = request.getParameter("name");
	%>
	<br>
	<br>
	<%
		out.println("Welcome: " + name);
	%>
</body>
</html>