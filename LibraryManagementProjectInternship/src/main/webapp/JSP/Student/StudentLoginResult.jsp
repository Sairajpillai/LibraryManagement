<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Page</h1>
<c:choose>
		<c:when test="${role eq 'lib' }">
			<a href="../HTML/Student/AddStudent.html">Add Student</a>
			<a href="../HTML/Student/EditStudent.html">Update Student</a>
			<a href="../HTML/Student/FindStudent.html">Find Student</a>
			<a href="../HTML/Student/DeleteStudent.html">Delete Student</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add Students</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>