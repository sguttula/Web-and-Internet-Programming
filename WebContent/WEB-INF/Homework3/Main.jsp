<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type = "text/css" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>Customer Relationship Management\r\n" + "(CRM)</title>

</head>
<body>
	<table border="1" class="table table-bordered table-striped table-hover">
		<th>Last Name</th>
		<th>First Name</th>
		<th>Phone Number</th>
		<th>Email</th>
		<th>Company</th>
		<th>Salary</th>
		<th>&nbsp;-------</th>
		<th>&nbsp;-------</th>
		
		<c:forEach items ="${entries}" var = "entry">
		<tr>
		<td>${entry.lastName}</td>
		<td>${entry.firstName}</td>
		<td>${entry.phoneNumber}</td>
		<td>${entry.emailAddress}</td>
		<td>${entry.companyName}</td>
		<td>${entry.salary}</td>
		<td>
			<a href="EditCustomer?id=${entry.id}">&nbsp;&nbsp;&nbsp;Edit&nbsp;</a>
			</td>
			<td>
			<a href="DeleteCustomer?id=${entry.id}">&nbsp;Delete</a>
			</td>
			</tr>
		</c:forEach>
	</table>
			<a href="AddCustomer">Add Customer</a>
	
</body>
</html>