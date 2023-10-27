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
				<c:when test="${res eq 'success' }">
					<c:choose>
						<c:when test="${issueBook eq 'success' }">
                             Your request for the book is generated wait for the librarian Approval
                        </c:when>

						<c:otherwise>
                             Book not issued
                    </c:otherwise>
					</c:choose>
				</c:when>

				<c:otherwise>
                You have already requested for the book
            </c:otherwise>
			</c:choose>
		</c:when>

		<c:otherwise>
                You are not authorized to request books
</c:otherwise>
	</c:choose>
</body>
</html>