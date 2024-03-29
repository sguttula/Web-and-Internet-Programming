<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>GuestBook (Bean, EL, and JSTL)</title>
</head>
<body>

<c:if test="${fn:length(gb.entries) == 0}">
	<p>There are no messages yet.</p>
</c:if>

<c:if test="${fn:length(gb.entries) > 0}">
	<table border="1">
	<tr><th>Index</th><th>Name</th><th>Message</th><th>Date</th></tr>
	
	<c:forEach items="${entries}" var="entry" >
		<tr>
		  <td>${entry.id}</td>
		  <td>${entry.name}</td>
		  <td>
		  	<fmt:formatDate value="${entry.date}" pattern="yyyy-MM-dd" />
		  </td>
		</tr>
	</c:forEach>
	
	</table>
</c:if>

<p><a href="AddComment.jsp">Add Comment</a></p>
</body>
</html>