<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Request</title>
</head>
<body>
	Fibonacci Request<br>
	Job number is :<%=request.getAttribute("jobNumber") %><br>
	<input type="hidden" name="" value="Add">
	Page will refresh in 10 seconds.
</body>
</html>