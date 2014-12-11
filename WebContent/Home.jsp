<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP page for Fibonacci Sequence</title>
</head> 
<body>
<form action="FileCounter" method="get">			
			 Please enter your Fibonacci Sequence number: <br>
			<input type="hidden" name="request-type" value="Add">
			Enter a number between 1-100<br>
			<input type="text" name="jobNumber"size="20px">
			<input type="submit" value="submit">						
		</form>
</body>
</html>