<%--1 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 1--%>
	<%--2 <c:choose>
		<c:when test="${role eq 'lib' }">
			<a href="../AddBook.html">Add Book</a>
			<a href="../EditBook.html">Update Book</a>
			<a href="../FindBook.html">Find Book</a>
			<a href="../DeleteBook.html">Delete Book</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books1</h1>
		</c:otherwise>
	</c:choose> 2--%>
	
	<%--3 <c:choose>
		<c:when test="${role eq 'lib' }">
			<a href="../HTML/Book/AddBook.html">Add Book</a>
			<a href="../HTML/Book/EditBook.html">Update Book</a>
			<a href="../HTML/Book/FindBook.html">Find Book</a>
			<a href="../HTML/Book/DeleteBook.html">Delete Book</a>
			<a href="../librarianwork/IssueBook">Issue Book</a>
			<a href="../HTML/LibrarianWork/BookAcceptPage.html">Accept Book</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>

</body>
</html> 3--%>

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
    grid-template-columns: repeat(3, 1fr);
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
    </style>
</head>
<body>

<div class="header">
    <div class="company-name">iNeuron</div>
    <div class="navbar-links">
        <a href="../index.html">HOME</a>
        <a href="../HTML/Book/AddBook.html">Add Book</a>
        <a href="../librarianwork/IssueBook">Issue Student</a>
        <a href="../HTML/Book/FindBook.html">Find Book</a>
        <a href="../HTML/LibrarianWork/BookAcceptPage.html">Accept Book</a>
    </div>
</div>
<div class="container">
	<c:choose>
		<c:when test="${role eq 'lib' }">
		<div class="box-container">
        <div class="box">
            <a href="../HTML/Book/AddBook.html"><img src="../Images/BookAdd.png" alt="Image 1"></a>
        </div>
        <div class="box">
            <a href="../HTML/Book/EditBook.html"><img src="../Images/BookUpdate.png" alt="Image 2"></a>
        </div>
        <div class="box">
             <a href="../HTML/Book/FindBook.html"><img src="../Images/BookFind.png" alt="Image 3"></a>
        </div>
        <div class="box">
            <a href="../HTML/Book/DeleteBook.html"><img src="../Images/BookDelete.png" alt="Image 4"></a>
        </div>
        <div class="box">
             <a href="../librarianwork/IssueBook"><img src="../Images/BookIssue.png" alt="Image 3"></a>
        </div>
        <div class="box">
            <a href="../HTML/LibrarianWork/BookAcceptPage.html"><img src="../Images/AcceptBook.png" alt="Image 4"></a>
        </div>
        </div>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>
</div>