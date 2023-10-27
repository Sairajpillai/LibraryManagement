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
		<c:when test="${role eq 'admin' }">
			<a href="../AddLibrarian.html">Add Librarian</a>
			<a href="../EditLibrarian.html">Update Librarian</a>
			<a href="../FindLibrarian.html">Find Librarian</a>
			<a href="../DeleteForm.html">Delete Librarian</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>--%>
	
	<c:choose>
		<c:when test="${role eq 'admin' }">
			<a href="../HTML/Librarian/AddLibrarian.html">Add Librarian</a>
			<a href="../HTML/Librarian/EditLibrarian.html">Update Librarian</a>
			<a href="../HTML/Librarian/FindLibrarian.html">Find Librarian</a>
			<a href="../HTML/Librarian/DeleteForm.html">Delete Librarian</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>