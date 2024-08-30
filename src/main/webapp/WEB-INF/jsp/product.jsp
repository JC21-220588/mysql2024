<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JK3B10 </title>
</head>

<%
ArrayList<String[]> maker = (ArrayList<String[]>) request.getAttribute("maker");

ArrayList<String[]> product = (ArrayList<String[]>) request.getAttribute("product");

//ArrayList<String[]> item = (ArrayList<String[]>) request.getAttribute("item");

%>
<body>

	<h1>メーカー一覧</h1>
	<FORM METHOD="GET" ACTION="./product">
		<SELECT NAME="ID">


			<%
			for (String[] ss : maker) {
			%>
			<OPTION VALUE="<%=ss[0]%>">
				<%=ss[1]%>
			</OPTION>
			<%
			}
			%>
		</SELECT> <INPUT TYPE="SUBMIT" VALUE="絞り込む" />

		<h1>商品一覧</h1>

		<table border="3" style="border-style: double;">

			<%
			for (String[] ss : product) {
			%>

			<tr>
				<th><%=ss[0]%></th>
				<td><%=ss[1]%></td>
				<td><%=ss[2]%></td>
			</tr>
			<%
			}
			%>

		</table>


	</FORM>
</body>
</html>