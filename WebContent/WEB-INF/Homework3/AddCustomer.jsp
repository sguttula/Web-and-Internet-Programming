<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}//Homework3/AddCustomer" method="post">
	</br>
	Last Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "last_name"></br>      
	</br>
	First Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "first_name"></br>           
	</br>
	Phone Number:&nbsp;<input type = "text" name = "phone_number"></br>        
	</br>
	Email Address: <input type = "text" name = "email"></br>        
	</br> 
	Company: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "company_name"></br>       
	</br>
	Salary: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type = "text" name = "salary"></br>              
	</br>
	 <input type = "submit" value = "Add Customer" />
	 </form>
</body>
</html>