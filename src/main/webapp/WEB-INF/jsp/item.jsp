<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JK3B10</title>
</head>

<%
	//ArrayList<String[]> item = 
			//S(ArrayList<String[]>)request.getAttribute("item");
	
	ArrayList<String[]> item2 = 
			(ArrayList<String[]>)request.getAttribute("item2");
%>

<body>
	<table>

		<% for (String[] ss : item2){ %>
		<tr>
			<th><%= ss[1] %></th>
			<td><%= ss[0] %></td>
			<td><%= ss[2] %></td>
		</tr>
		<% } %>
	</table>

</body>
</html>