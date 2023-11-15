<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightBlue">
<c:choose>
		<c:when test="${loginResult eq 'success' }">
			
	<c:choose>
		<c:when test="${librarian ne null || ! empty librarian }">
			<table border="1" align="center">
			<caption>EMPLOYEE RECORD</caption>
				<tr>
					<th>ID</th>
					<th>lIBRARIAN FIRST NAME</th>
					<th>LIBRARIAN LAST AGE</th>
					<th>LIBRARIAN DATE OF JOINING</th>
				</tr>
				<tr>
					<td>${librarian.libid }</td>
					<td>${librarian.libfname }</td>
					<td>${librarian.liblname }</td>
					<td>${librarian.doj }</td>
				</tr>
			</table>

		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Record to display</h1>
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
 <Style>
 .table-container {
    margin: 20px auto;
    max-width: 800px;
    background-color: #f8f8f8;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Style for the table */
.custom-table {
    width: 100%;
    border-collapse: collapse;
}

/* Style for table headers (th) */
.custom-table th {
    background-color: #007bff;
    color: #fff;
    font-weight: bold;
    text-align: left;
    padding: 15px;
}

/* Style for table data cells (td) */
.custom-table td {
    text-align: left;
    padding: 10px 15px;
    border-bottom: 1px solid #ccc;
}

/* Highlight even rows with a background color */
.custom-table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}
</style>
 
 
  <div class="container">
   <div class="table-container">
        <table class="custom-table">
            <thead>
                <tr>
                    <th>ID</th>
					<th>LIBRARIAN FIRST NAME</th>
					<th>LIBRARIAN LAST AGE</th>
					<th>LIBRARIAN DATE OF JOINING</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${librarian.libid }</td>
					<td>${librarian.libfname }</td>
					<td>${librarian.liblname }</td>
					<td>${librarian.doj }</td>
                </tr>
     
            </tbody>
        </table>
    </div>
  
  
  
  </div>
  <%@ include file="../../templates/footer.html" %> 

