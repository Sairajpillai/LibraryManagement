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
	<br />
	<br />
	<c:choose>
		<c:when test="${loginResult eq 'success'}">
			<c:choose>
				<c:when test="${ student ne null || ! empty student}">
					<form action="./student/UpdateStudent" method="post">
						<table align="center">
							<tr>
								<th>STUDENT ID</th>
								<td><input type="text" name="sid" readonly="readonly"
									value='${student.sid}' /></td>
							</tr>
							<tr>
								<th>STUDENT FIRST NAME</th>
								<td><input type="text" name="fname"
									value='${student.sfname}' /></td>
							</tr>
							<tr>
								<th>STUDENT LAST NAME</th>
								<td><input type="text" name="lname"
									value='${student.slname}' /></td>
							</tr>
							<tr>
								<th>STUDENT PASSWORD</th>
								<td><input type="text" name="password"
									value='${student.password}' /></td>
							</tr>
						

							<tr>
								<th></th>
								<td><input type="submit" value='update' /></td>
							</tr>

						</table>

					</form>
				</c:when>
				<c:otherwise>

					<h1 style="color: red; text-align: center">NO RECORD TO
						DISPLAY</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">You are not
				authorized to view book</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>