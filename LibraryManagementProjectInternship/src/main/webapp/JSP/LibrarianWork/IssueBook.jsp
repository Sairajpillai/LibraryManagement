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
				<c:when test="${status eq 'success' }">
					<c:choose>
						<c:when test="${bookUpdateStatus eq 'success' }">
							<c:choose>
								<c:when test="${approveStatus eq 'success' }">
Book Issued to student successfully
</c:when>
								<c:otherwise>
Book not issued successfully
</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
Book Qty updated
</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
Book Not available in Stock
</c:otherwise>
			</c:choose>

		</c:when>
		<c:otherwise>
You are not authorized to issue books
</c:otherwise>
	</c:choose>
</body>
</html>