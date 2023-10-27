<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Lightblue">
	<br />
	<br />
	<c:choose>
		<c:when test="${loginResult eq 'success' }">
	<c:choose>
		<c:when test="${status eq 'success'}">
			<h1 style="color: green; text-align: center">RECORD DELETED
				SUCCESSFULLY</h1>
		</c:when>
		<c:when test="${status eq 'failure'}">
			<h1 style="color: red; text-align: center">RECORD DELETION
				FAILED</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: black; text-align: center">RECORD NOT
				AVAILABLE FOR DELETION</h1>
		</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>

			<h1>You are not Authorized to add Librarians</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>