<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="ba" class="Homework3.EditCustomer" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/Homework3/EditCustomer" method="post">
	</br>
	Last Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "last_name" value = "${entries.lastName}"></br>      
	</br>
	First Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "first_name" value = "${entries.firstName}"></br>           
	</br>
	Phone Number:&nbsp;<input type = "text" name = "phone_number" value = "${entries.phoneNumber}"></br>        
	</br>
	Email Address: <input type = "text" name = "email" value = "${entries.emailAddress}"></br>        
	</br> 
	Company: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "company_name" value = "${entries.companyName}"></br>       
	</br>
	Salary: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "salary" value = "${entries.salary}"></br>              
	</br>
	<input type = "hidden" name = "id" value = "${entries.id}">
	 <input type = "submit" value = "Update Customer" />
	 </form>

</body>
</html>