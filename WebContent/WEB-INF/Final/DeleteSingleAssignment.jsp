<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<p>
Delete an Assignment
</p>
<form action="${pageContext.request.contextPath}/final/DeleteSingleAssignment" method="post">
Enter Course Id:
<input type="text" name="id"/>&nbsp;
<input type="submit" name="del" value="Delete Assignment" />
</form>
</body>
</html>