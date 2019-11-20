<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:setProperty property="*" name="bg" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 4</title>
<style>
th{
	text-align: left;
}
table, th, td {
 height: 30px;
	 border-collapse: collapse;
    border: 1px solid black;
	width: 700px; 
	hover {background-color: #ddd;}
    padding: 8px;
}
headelement {
text-align: left;
}
thead tr:nth-child(odd) {
  background: #eee;
}
tbody {
text-align: center;
}
tbody tr:nth-child(odd) {
  background: #eee;
}
</style>
</head>
<body>
	<table class ="table table-striped">
		<thead>
			<tr>
				<th id="headelement" colspan="2">Arithmetic Operators</th>
				<th id="headelement" colspan="2">Relational Operators</th>
			</tr>
			<tr>
				<th>Expression</th>
				<th>Result</th>


				<th>Expression</th>
				<th>Result</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<% out.println("${3+2-1}"); %>
				</td>
				<td>${3+2-1}</td>
				<td>
					<% out.println("${1<2}"); %>
				</td>
				<td>${1<2}</td>				
			</tr>
			
			<tr>
				<td>
					<% out.println("${"); %>
					<% out.println("''"); %>
					<% out.println(1); %>
					<% out.println("''"); %>
					<% out.println("+2}"); %>
				</td>
				<td>${"1"+2}</td>
				<td>
					<% out.println("${"); %>
					<% out.println("''"); %>
					<% out.println("a"); %>
					<% out.println("''"); %>
					<% out.println(">"); %>
					<% out.println("''"); %>
					<% out.println("b"); %>
					<% out.println("''}"); %>
					
				</td>
				<td>${"a">"b"}</td>				
			</tr>
			
			<tr>
			<td>
					<% out.println("${1+2*3+3/4}"); %>
				</td>
				<td>${1+2*3+3/4}</td>
				<td>
					<% out.println("${2/3 >= 3/2}"); %>
				</td>
				<td>${2/3 >= 3/2}</td>
				</tr>
				
					<tr>
			<td>
					<% out.println("${3%2}"); %>
				</td>
				<td>${3%2}</td>
				<td>
					<% out.println("${3/4 == 0.75}"); %>
				</td>
				<td>${3/4 == 0.75}</td>
				
				</tr>
				
						<tr>
			<td>
					<% out.println("${(8 div 2) mod 3}"); %>
				</td>
				<td>${(8 div 2) mod 3}</td>
				<td>
					<% out.println("${null =="); %>
					<% out.println("''"); %>
					<% out.println("test"); %>
					<% out.println("''}"); %>
					
				</td>
				<td>${null == "test"}</td>
				</tr>
				<tr>
				
				<th colspan="2">Logical Operators</th>
				<th colspan="2">Empty Operator</th>
				</tr>
					<tr>
				<th>Expression</th>
				<th>Result</th>


				<th>Expression</th>
				<th>Result</th>
			</tr>
				
			<tr>
			<td>
			<% out.println("${(1<2) && (4<3)}"); %>
			</td>
			<td>${(1<2) && (4<3)}</td>
			<td>
			<% out.println("${empty"); %>
			<% out.println("''"); %>
			<% out.println("''"); %>
			<% out.println("}"); %>
			</td>
			<td>${empty ""}</td>
			</tr>
			
			<tr>
			<td>
			<% out.println("${(1<2) || (4<3)}"); %>
			</td>
			<td>${(1<2) || (4<3)}</td>
			<td>
			<% out.println("${empty null}"); %>
			</td>
			<td>${empty null}</td>
			</tr>
			
			<tr>
			<td>
			<% out.println("${!(1<2)}"); %>
			</td>
			<td>${!(1<2)}</td>
			<td>
			<% out.println("${empty param.biah}"); %>
			</td>
			<td>${empty param.biah}</td>
			</tr>
		<td>${"abc" lt 'b'}</td>
		</tbody>
			
	</table>
	${null eq 'null'}
	${2 + 3/2}
	${"2" + 3/2}
	${empty "null"}
</body>
</html>