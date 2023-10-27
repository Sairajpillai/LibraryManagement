<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Book List</title>
</head>
<body>
	<%-- 
    <form action="./studentwork/requestbook" method="post">
        <table border="1">
            <tr>
                <th>BOOK ID</th>
                <th>BOOK NAME</th>
                <th>BOOK AUTHOR</th>
                <th>BOOK CATEGORY</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${booksList}" var="book" varStatus="loop">
                <tr>
                <td><input readonly name="bookid" value="${book.bookId}" /></td>
                    <td> <input type="hidden" name="bookname" value="${book.bookName}" />${book.bookName}</td>
                    <td><input type="hidden" name="author" value="${book.author}" />${book.author}</td>
                    <td><input type="hidden" name="category" value="${book.bookCategory}" />${book.bookCategory}</td>
                    <td>
                        <input type="submit" value="Submit" name="action" />
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>--%>

	<%-- <c:forEach items="${booksList}" var="book">
		<form action="./studentwork/requestbook" method="post">
			<table border="1">
				<tr>
					<th>BOOK ID</th>
					<th>BOOK NAME</th>
					<th>BOOK AUTHOR</th>
					<th>BOOK CATEGORY</th>
					<th>Action</th>
				</tr>
				<tr>
					<td><input readonly name="bookid" value="${book.bookId}" /></td>
					<td><input type="hidden" name="bookname"
						value="${book.bookName}" />${book.bookName}</td>
					<td><input type="hidden" name="author" value="${book.author}" />${book.author}</td>
					<td><input type="hidden" name="category"
						value="${book.bookCategory}" />${book.bookCategory}</td>
					<td><input type="submit" value="Submit" name="action" /></td>
				</tr>
			</table>
		</form>
	</c:forEach>--%>

	<c:choose>
		<c:when test="${loginResult eq 'success' }">
			<c:choose>
				<c:when test="${result eq 'success' }">
					<c:choose>
						<c:when test="${not empty booksList }">
							<c:forEach items="${booksList}" var="book">
								<form action="./studentwork/requestbook" method="post">
									<table border="1">
										<tr>
											<th>BOOK ID</th>
											<th>BOOK NAME</th>
											<th>BOOK AUTHOR</th>
											<th>BOOK CATEGORY</th>
											<th>Action</th>
										</tr>
										<tr>
											<td><input readonly name="bookid" value="${book.bookId}" /></td>
											<td><input type="hidden" name="bookname"
												value="${book.bookName}" />${book.bookName}</td>
											<td><input type="hidden" name="author"
												value="${book.author}" />${book.author}</td>
											<td><input type="hidden" name="category"
												value="${book.bookCategory}" />${book.bookCategory}</td>
											<td><input type="submit" value="Submit" name="action" />
											</td>
										</tr>
									</table>
								</form>
							</c:forEach>
						</c:when>
						<c:otherwise>
    The book you searched for is not available
    </c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
    You have been already issued 3 books
    </c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
    You are not authorized to view books
    </c:otherwise>
	</c:choose>

</body>
</html>