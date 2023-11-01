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
				<c:when test="${bookUpdateStatus eq 'success' }">
					<c:choose>
						<c:when test="${acceptStatus eq 'success' }">
		Book Accepted successfully
		</c:when>
						<c:otherwise>
		Book is either accepted by another Librarian
		</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
		book qty cannot be updated
		</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
                You are not authorized to request books
</c:otherwise>
	</c:choose>
</body>
</html>