<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Search</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/employee/employeeSearch.do" method="get">
		Employee Number : &nbsp;<input type="text" name="empNo"><br>
		<br> <input type="submit" value="Get Employee Details">
	</form>
</body>
</html>