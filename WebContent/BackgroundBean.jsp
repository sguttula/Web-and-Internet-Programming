<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="beans.BGBean" id="bg" scope="session"></jsp:useBean>

<jsp:setProperty property="*" name="bg" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Background Bean</title>
    
    <style>
        body{
            background-color: rgb(
                                    <jsp:getProperty property="r" name="bg" />, 
                                    <jsp:getProperty property="g" name="bg" />, 
                                    <jsp:getProperty property="b" name="bg" />
                                );
        }
    </style>
    
</head>
<body>

<h3>
    R: <jsp:getProperty property="r" name="bg" /> <br />
    G: <jsp:getProperty property="g" name="bg" /> <br />
    B: <jsp:getProperty property="b" name="bg" /> <br />
</h3>

<form action="BackgroundBean.jsp" method="get">
    <input type="text" name="r" placeholder="Enter the red channel value"> <br>
    <input type="text" name="g" placeholder="Enter the green channel value"> <br>
    <input type="text" name="b" placeholder="Enter the blue channel value"> <br>
    <input type="submit" value="Change Background Color">
</form>


</body>
</html>