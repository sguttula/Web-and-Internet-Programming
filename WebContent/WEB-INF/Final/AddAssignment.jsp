<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${not empty param.add}">
 
  <c:redirect url="Final.jsp" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Assignment</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/final/AddAssignment" method="post">

	&nbsp;&nbsp;Course ID:  <input type="text" name="id" /> <br />
	&nbsp;&nbsp;Assignment: &nbsp;&nbsp;<input type="text" name="assignment" id="assignment">
	&nbsp;&nbsp;<input type="submit" name="addA" value="Add Assignment">
	<br>

	</form>
	<p>
</p>
</body> 
</html>