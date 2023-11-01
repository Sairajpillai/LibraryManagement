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
	<c:choose>
		<c:when test="${loginResult eq 'success' }">
			<c:choose>
				<c:when test="${not empty bookList }">
					<c:forEach items="${bookList}" var="book">
						<form action="./librarianwork/acceptbook" method="post">
							<table border="1">
								<tr>
									<th>REQUEST ID</th>
									<th>BOOK ID</th>
									<th>BOOK NAME</th>
									<th>BOOK AUTHOR</th>
									<th>BOOK CATEGORY</th>
									<th>ISSUE DATE</th>
									<th>EXPECTED RETURN DATE</th>
									<th>PENALTY</th>
									<th>AMOUNT STATUS</th>
									<th>Action</th>
								</tr>
								<tr>
									<td><input readonly name="reqid" value="${book.bhid}" /></td>
									<td><input readonly name="bookid"
										value="${book.bookid_fk}" /></td>
									<td><input type="hidden" name="bookname"
										value="${book.bookname}" />${book.bookname}</td>
									<td><input type="hidden" name="author"
										value="${book.author}" />${book.author}</td>
									<td><input type="hidden" name="category"
										value="${book.bookcategory}" />${book.bookcategory}</td>
									<td><input type="hidden" name="idate"
										value="${book.idate}" />${book.idate}</td>
									<td><input type="hidden" name="erdate"
										value="${book.erdate}" />${book.erdate}</td>
									<td><input type="hidden" name="penalty"
										value="${book.penalty}" />${book.penalty}</td>
									<td><input type="hidden" name="amountStatus"
										value="${book.amountStatus}" />${book.amountStatus}</td>
									<td><input type="submit" value="Submit" name="action" />
									</td>
								</tr>
							</table>
						</form>
					</c:forEach>
				</c:when>
				<c:otherwise>
No books are available for Acceptance
</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
You are not authorized
</c:otherwise>
	</c:choose>
</body>
</html>