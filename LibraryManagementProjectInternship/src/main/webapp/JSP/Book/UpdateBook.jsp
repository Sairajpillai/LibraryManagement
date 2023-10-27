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
				<c:when test="${ book ne null || ! empty book}">
					<form action="./book/UpdateBook" method="post">
						<table align="center">
							<tr>
								<th>BOOK ID</th>
								<td><input type="text" name="bookid" readonly="readonly"
									value='${book.bookId}' /></td>
							</tr>
							<tr>
								<th>BOOK NAME</th>
								<td><input type="text" name="bookname"
									value='${book.bookName}' /></td>
							</tr>
							<tr>
								<th>BOOK CATEGORY</th>
								<td><input type="text" name="bookcategory"
									value='${book.bookCategory}' /></td>
							</tr>
							<tr>
								<th>BOOK AUTHOR</th>
								<td><input type="text" name="bookauthor"
									value='${book.author}' /></td>
							</tr>
							<tr>
								<th>BOOK QTY</th>
								<td><input type="text" name="bookqty"
									value='${book.bookQty}' /></td>
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