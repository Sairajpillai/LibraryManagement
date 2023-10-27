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
	<%-- <c:choose>
		<c:when test="${role eq 'lib' }">
			<a href="../AddBook.html">Add Book</a>
			<a href="../EditBook.html">Update Book</a>
			<a href="../FindBook.html">Find Book</a>
			<a href="../DeleteBook.html">Delete Book</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books1</h1>
		</c:otherwise>
	</c:choose>--%>
	
	<c:choose>
		<c:when test="${role eq 'std' }">
			<a href="../HTML/StudentWork/RequestBook.html">Request Book</a>
			<!--  <a href="../HTML/StudentWork/PendingRequest.html">Pending Book Request</a>-->
			<a href="../studentwork/pendingrequest">Pending Book Request</a>
			<a href="../studentwork/bookhistory">BookHistory</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>