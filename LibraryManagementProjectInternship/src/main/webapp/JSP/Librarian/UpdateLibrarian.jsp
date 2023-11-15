<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
		<c:when test="${loginResult eq 'success' }">
	<c:choose>
		<c:when test="${ librarian ne null || ! empty librarian}">
			<form action="./controller/UpdateLibrarian" method="post">
				<table align="center">
					<tr>
						<th>LIBID</th>
						<td><input type="text" name="libid" readonly="readonly"
							value='${librarian.libid}' /></td>
					</tr>
					<tr>
						<th>LIBRARIAN FIRSTNAME</th>
						<td><input type="text" name="libfname" value='${librarian.libfname}' /></td>
					</tr>
					<tr>
						<th>LIBRARIAN LASTNAME</th>
						<td><input type="text" name="liblname" value='${librarian.liblname}' /></td>
					</tr>
					
					<tr>
						<th></th>
						<td><input type="submit" value='update' /></td>
					</tr>

				</table>

			</form>
		</c:when>
		<c:otherwise>
		
			<h1 style="color: red; text-align: center">NO RECORD TO DISPLAY</h1>
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

/* Style for the table container */
.table-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Style for the table */
.custom-table {
    width: 80%; /* Adjust the width as needed */
    border-collapse: collapse;
    background-color: #f8f8f8;
    font-family: Arial, sans-serif;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* Style for table headers (th) */
.custom-table th {
    background-color: #007bff;
    color: #fff;
    padding: 10px;
    text-align: left;
    font-weight: bold;
}

/* Style for table data cells (td) */
.custom-table td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ccc;
}

/* Style for the submit button */
.custom-table input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-weight: bold;
}

/* Highlight even rows with a background color */
.custom-table tr:nth-child(even) {
    background-color: #f2f2f2;
}


</style>
 
 <div class="container">
 <c:choose>
		<c:when test="${loginResult eq 'success' }">
	<c:choose>
		<c:when test="${ librarian ne null || ! empty librarian}">
			<form action="./controller/UpdateLibrarian" method="post">
				<div class="table-container">
    <table class="custom-table">
        <tr>
            <th>LIBID</th>
            <td><input type="text" name="libid" readonly="readonly" value='${librarian.libid}' /></td>
        </tr>
        <tr>
            <th>LIBRARIAN FIRSTNAME</th>
            <td><input type="text" name="libfname" value='${librarian.libfname}' /></td>
        </tr>
        <tr>
            <th>LIBRARIAN LASTNAME</th>
            <td><input type="text" name="liblname" value='${librarian.liblname}' /></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value='update' /></td>
        </tr>
    </table>
</div>


			</form>
		</c:when>
		<c:otherwise>
		
			<h1 class="failure-heading">NO RECORD TO DISPLAY</h1>
		</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>

			<h1 class="failure-heading">You are not Authorized to add Librarians</h1>
		</c:otherwise>
	</c:choose>
 
 
 
 </div>
  <%@ include file="../../templates/footer.html" %> 
 
 
 
 
 
 
 