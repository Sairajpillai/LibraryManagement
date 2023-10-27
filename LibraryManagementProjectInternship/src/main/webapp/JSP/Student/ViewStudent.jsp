<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightBlue">
	<c:choose>
		<c:when test="${loginResult eq 'success'}">
			<c:choose>
				<c:when test="${student ne null || ! empty student }">
					<table border="1" align="center">
						<caption> RECORD</caption>
						<tr>
							<th>ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>PASSWORD</th>
							<th>DATE</th>
						</tr>
						<tr>
							<td>${student.sid }</td>
							<td>${student.sfname }</td>
							<td>${student.slname }</td>
							<td>${student.password }</td>
							<td>${student.date }</td>
						</tr>
					</table>
					<%-- <a href="../AddBook.html">Add Book</a>--%>
				</c:when>
				<c:otherwise>
					<h1 style="color: red; text-align: center">No Record to
						display</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
		<h1 style="color: red; text-align: center">You are not authorized to view book</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>