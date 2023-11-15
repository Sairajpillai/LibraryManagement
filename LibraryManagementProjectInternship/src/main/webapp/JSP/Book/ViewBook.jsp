<%-- 1 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightBlue">
	<c:choose>
		<c:when test="${loginResult eq 'success'}">
			<c:choose>
				<c:when test="${book ne null || ! empty book }">
					<table border="1" align="center">
						<caption>BOOK RECORD</caption>
						<tr>
							<th>ID</th>
							<th>BOOK NAME</th>
							<th>BOOK CATEGORY</th>
							<th>BOOK QUANTITY</th>
							<th>BOOK DATE</th>
							<th>BOOK AUTHOR</th>
						</tr>
						<tr>
							<td>${book.bookId }</td>
							<td>${book.bookName }</td>
							<td>${book.bookCategory }</td>
							<td>${book.bookQty }</td>
							<td>${book.bookDate }</td>
							<td>${book.author }</td>
						</tr>
					</table> 1 --%>
					<%-- 2 <a href="../AddBook.html">Add Book</a> 2 --%>
				<%-- 3 </c:when>
				<c:otherwise>
					<h1 style="color: red; text-align: center">No Record to
						display</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
		<h1 style="color: red; text-align: center">You are not authorized to view book</h1>
		</c:otherwise>
	</c:choose>

</body>
</html> 3 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        
        .box-container {
    background-color: rgba(255, 255, 255, 0.8); /* Add semi-transparent white background */
    padding: 20px;
    border-radius: 10px;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(2, 1fr);
    grid-gap: 20px;
    margin-top: 20px;
    margin-bottom: 20px;
}

.box {
    border: 1px solid #ccc;
    padding: 10px;
    text-align: center;
    box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.2);
    background-color: white;
}

img {
    width: 230px;
    height: 230px;
    max-width: 230px;
    height: auto;
    cursor: pointer;
    /*opacity: 0.7;  Add opacity to the images */
    transition: opacity 0.3s; /* Add a transition for a smooth fade effect */
}

img:hover {
    opacity: 1; /* Increase opacity on hover */
}

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
</head>
<body>

<div class="header">
    <div class="company-name">iNeuron</div>
    <div class="navbar-links">
        <a href="../index.html">HOME</a>
        <a href="../HTML/Librarian/AddLibrarian.html">Add Student</a>
        <a href="../HTML/Librarian/EditLibrarian.html">Edit Student</a>
        <a href="../HTML/Librarian/FindLibrarian.html">Find Student</a>
        <a href="../HTML/Librarian/DeleteForm.html">Delete Student</a>
    </div>
</div>
<div class="container">
<div class="table-container">
        <table class="custom-table">
            <thead>
                <tr>
							<th>ID</th>
							<th>BOOK NAME</th>
							<th>BOOK CATEGORY</th>
							<th>BOOK QUANTITY</th>
							<th>BOOK DATE</th>
							<th>BOOK AUTHOR</th>
						</tr>
            </thead>
            <tbody>
               <tr>
							<td>${book.bookId }</td>
							<td>${book.bookName }</td>
							<td>${book.bookCategory }</td>
							<td>${book.bookQty }</td>
							<td>${book.bookDate }</td>
							<td>${book.author }</td>
						</tr>
     
            </tbody>
        </table>
    </div>

</div>
<div class="footer">
    Library Management &copy; <span class="copyright">&copy;</span> 2023
</div>
</body>
</html>