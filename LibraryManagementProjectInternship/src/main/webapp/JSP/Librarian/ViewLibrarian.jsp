<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightBlue">
<c:choose>
		<c:when test="${loginResult eq 'success' }">
			
	<c:choose>
		<c:when test="${librarian ne null || ! empty librarian }">
			<table border="1" align="center">
			<caption>EMPLOYEE RECORD</caption>
				<tr>
					<th>ID</th>
					<th>lIBRARIAN FIRST NAME</th>
					<th>LIBRARIAN LAST AGE</th>
					<th>LIBRARIAN DATE OF JOINING</th>
				</tr>
				<tr>
					<td>${librarian.libid }</td>
					<td>${librarian.libfname }</td>
					<td>${librarian.liblname }</td>
					<td>${librarian.doj }</td>
				</tr>
			</table>

		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Record to display</h1>
		</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>

			<h1>You are not Authorized to add Librarians</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>