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
				<c:when test="${not empty bookHistoryList }">
					<table border="1">
						<tr>
							<th>BOOK NAME</th>
							<th>BOOK AUTHOR</th>
							<th>BOOK CATEGORY</th>
							<th>LIBRARIAN NAME</th>
							<th>BOOK REQUEST DATE</th>
							<th>BOOK ISSUE DATE</th>
							<th>PENALTY</th>
							<th>AMOUNT STATUS</th>
							<th>EXPECTED RETURN DATE</th>
							<th>ACTUAL RETURN DATE</th>

						</tr>
						<c:forEach items="${bookHistoryList}" var="book">
							<tr>
								<td>${book.bookname}</td>
								<td>${book.author}</td>
								<td>${book.bookcategory}</td>
								<td>${book.libfname}</td>
								<td>${book.reqdate}</td>
								<td>${book.idate}</td>
								<td>${book.penalty}</td>
								<td>${book.amountStatus}</td>
								<td>${book.erdate}</td>
								<td>${book.rdate}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
    You have not requested for any books
    </c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
    You are not authorized to view books
    </c:otherwise>
	</c:choose>

</body>
</html>