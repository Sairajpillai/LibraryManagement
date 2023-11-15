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
</html>--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
      .header {
            background-color: #333;
            color: #fff;
            overflow: hidden;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
        }

        .company-name {
            float: left;
            display: block;
            padding: 10px 20px;
            font-weight: bold;
            font-size: 18px; /* Smaller font size */
        }

        .navbar-links {
            float: right;
        }

        .navbar-links a {
            display: inline-block; /* Display links horizontally */
            color: #fff;
            text-align: center;
            padding: 10px 15px; /* Smaller padding */
            text-decoration: none;
        }

        .navbar-links a:hover {
            background-color: #555;
        }

        /* Style for the container */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 50px; /* Adjust the margin */
        }

        /* Style for each box */
       /* .box {
            width: 200px;
            padding: 20px;
            margin: 20px;
            background-color: #f9f9f9;
            box-shadow: 0px 0px 5px 0px #333;
            border-radius: 5px;
            text-align: center;
        }

        .box img {
            max-width: 100%;
            max-height: 100px;
            display: block;
            margin: 0 auto;
        }*/

        /* Style for the footer */
        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
        }

        /* Style for the copyright symbol */
        .copyright {
            font-size: 20px;
        }
        .table-container {
    margin: 20px auto;
    max-width: 800px;
    background-color: #f8f8f8;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
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
</head>
<body>

<div class="header">
    <div class="company-name">iNeuron</div>
    <div class="navbar-links">
        <a href="../index.html">HOME</a>
        <a href="../HTML/Librarian/AddLibrarian.html">Add Librarian</a>
        <a href="../HTML/Librarian/EditLibrarian.html">Edit Librarian</a>
        <a href="../HTML/Librarian/FindLibrarian.html">Find Librarian</a>
        <a href="../HTML/Librarian/DeleteForm.html">Delete Librarian</a>
    </div>
</div>

<div class="container">
  

<c:choose>
		<c:when test="${loginResult eq 'success' }">
			<c:choose>
				<c:when test="${not empty bookList }">
					<c:forEach items="${bookList}" var="book">
						<form action="./librarianwork/acceptbook" method="post">
													
   <div class="table-container">
        <table class="custom-table">
            <thead>
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
								 </thead>
            <tbody>
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
								</tbody>
									</table>
									</div>
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






</div>
<div class="footer">
    Library Management &copy; <span class="copyright">&copy;</span> 2023
</div>

</body>
</html>