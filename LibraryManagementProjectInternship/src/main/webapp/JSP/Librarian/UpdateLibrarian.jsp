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
	<br />
	<br />
	<c:choose>
		<c:when test="${loginResult eq 'success' }">
	<c:choose>
		<c:when test="${ librarian ne null || ! empty librarian}">
			<form action="./controller/UpdateLibrarian" method="post">
				<table align="center">
					<tr>
						<th>LIBID</th>
						<td><input type="text" name="libid" readonly="readonly"
							value='${librarian.libid}' /></td>
					</tr>
					<tr>
						<th>LIBRARIAN FIRSTNAME</th>
						<td><input type="text" name="libfname" value='${librarian.libfname}' /></td>
					</tr>
					<tr>
						<th>LIBRARIAN LASTNAME</th>
						<td><input type="text" name="liblname" value='${librarian.liblname}' /></td>
					</tr>
					
					<tr>
						<th></th>
						<td><input type="submit" value='update' /></td>
					</tr>

				</table>

			</form>
		</c:when>
		<c:otherwise>
		
			<h1 style="color: red; text-align: center">NO RECORD TO DISPLAY</h1>
		</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>

			<h1>You are not Authorized to add Librarians</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>