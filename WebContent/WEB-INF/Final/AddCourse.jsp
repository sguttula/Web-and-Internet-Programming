<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu68"
	user="cs3220stu68"
	password="*tv1n##Z"/>
	
<c:if test="${not empty param.add}">
 
  <c:redirect url="Final.jsp" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
</head>
<body>
<h1>ADD COURSE</h1>
	<form action="${pageContext.request.contextPath}/final/AddCourse" method="post">
	Course Number:&nbsp;&nbsp; <input type="text" name="courseNumber">
	&nbsp;&nbsp;Course Name: &nbsp;&nbsp;<input type="text" name="courseName">
	&nbsp;&nbsp;Assignment: &nbsp;&nbsp;<input type="text" name="assignment">
	&nbsp;&nbsp;<input type="submit" value="Add Course">
	<br>
	</form>
</body>
</html>