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


<c:choose>
	<c:when test="${empty param.sql }">
	</c:when>
	<c:otherwise>
		<c:catch var="catchException">
		<sql:query var="results">
		${param.sql}
		</sql:query>
		</c:catch>

	</c:otherwise>
</c:choose> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type = "text/css" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></link>
<title>Final Exam</title>
</head>
<body>
	<p style="font-size:75px;">&nbsp;Assignment Organizer</p>
	<hr>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="AddCourse"><button class="btn btn-primary"><font size = "15">Add Course</font></button></a><br>
	
	<hr>


<table border="1" class="table table-bordered table-striped table-hover">
<colgroup>
       <col span="1" style="width: 5%;">
       <col span="1" style="width: 20%;">
       <col span="1" style="width: 25%;">
       <col span="1" style="width: 25%;">
       <col span="2" style="width: 10%;">
      
    </colgroup>
    <th>ID</th>
<th>Course Number</th>
		<th>Course Name</th>
		<th>Assignments</th>

<c:forEach items="${entries}" var="entry">
  <tr>
  <td>${entry.id}</td>
    <td>${entry.courseNumber}</td>
  <td>${entry.courseName}</td>
  
  <td>${entry.assignment}</td>

  </tr>
  
</c:forEach>
</table>
<br>
&nbsp;<a href="AddAssignment?id=${entry.id}"><button class="btn btn-primary">&nbsp;Add Assignment</button></a>
&nbsp;<a href="DeleteSingleAssignment?id=${entry.id}"><button class="btn btn-primary">&nbsp;Delete Assignment</button></a>
&nbsp;<a href="DeleteAssignments?id=${entry.id}"><button class="btn btn-primary">&nbsp;Delete All Assignments</button></a>
&nbsp;<a href="DeleteSingleCourse?id=${entry.id}"><button class="btn btn-primary">&nbsp;Delete Course</button></a>
&nbsp;<a href="DeleteCourse?id=${entry.id}"><button class="btn btn-primary">&nbsp;Delete All Courses</button></a>
&nbsp;<a href="Done"><button class="btn btn-primary">Done</button></a>
&nbsp;<a href="NotDone"><button class="btn btn-primary">Not Done</button></a>
</body>
</html>