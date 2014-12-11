<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Request</title>
</head>
<meta http-equiv="refresh" content="10">
<body> <form action="FileCounter">
<label>Fibonacci Request</label><br>
	
	<%session.setAttribute("request-type", "pull"); %>
	<label>Job number is - ${jobNumber}</label><br>
	<label> The page is going to refresh in 10 seconds.<%request.getAttribute("timer"); %></label><br>
	
		</form>
		
</body>
</html>