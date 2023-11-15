<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
				<c:when test="${message eq 'success' }">
					<h1>Successfully Inserted</h1>
				</c:when>
				<c:otherwise>

					<h1>Insertion Failed</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>

			<h1>You are not Authorized to add Librarians</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ include file="../../templates/header.html" %> 
 
 <style>
.failure-heading {
    font-size: 36px; /* Adjust the font size as needed */
    font-weight: bold;
    color: #ff0000; /* Red font color (warning red) */
    text-align: center; /* Center the text horizontally */
}
.success-heading {
    font-size: 36px; /* Adjust the font size as needed */
    font-weight: bold;
    color: #008000; /* Red font color (warning red) */
    text-align: center; /* Center the text horizontally */
}
</style>
 
 <div class="container">
 <c:choose>
		<c:when test="${loginResult eq 'success' }">
			<c:choose>
				<c:when test="${message eq 'success' }">
					<h1 class="success-heading">Successfully Registered Librarian</h1>
				</c:when>
				<c:otherwise>

					<h1 class="failure-heading">Librarian Registration Failed</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>

			<h1 class="failure-heading">You are not Authorized to access this page</h1>
		</c:otherwise>
	</c:choose>
 
 </div>
 
 
 
 <%@ include file="../../templates/footer.html" %> 