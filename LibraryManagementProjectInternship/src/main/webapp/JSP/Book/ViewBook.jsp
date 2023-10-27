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
				<c:when test="${book ne null || ! empty book }">
					<table border="1" align="center">
						<caption>BOOK RECORD</caption>
						<tr>
							<th>ID</th>
							<th>BOOK NAME</th>
							<th>BOOK CATEGORY</th>
							<th>BOOK QUANTITY</th>
							<th>BOOK DATE</th>
							<th>BOOK AUTHOR</th>
						</tr>
						<tr>
							<td>${book.bookId }</td>
							<td>${book.bookName }</td>
							<td>${book.bookCategory }</td>
							<td>${book.bookQty }</td>
							<td>${book.bookDate }</td>
							<td>${book.author }</td>
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