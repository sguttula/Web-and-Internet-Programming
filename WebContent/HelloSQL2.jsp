<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- set data source --%>
<sql:setDataSource
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://cs3.calstatela.edu/cs3220stu68"
    user="cs3220stu68"
    password="qwerty1234" />
<%-- query --%>
<sql:query var="results">
  select * from items where
        price < ? and quantity > ?
    
    <sql:param value="${param.price}" />
    <sql:param value="${param.quantity}" />
</sql:query>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL SQL Example 2</TITLE> </HEAD>
<table>
  <c:forEach items="${results.rowsByIndex}" var="row">
  <tr>
    <c:forEach items="${row}" var="col">
        <td>${col}</td>
    </c:forEach>
  </tr>
  </c:forEach>
</table>
    
</BODY>
</HTML>