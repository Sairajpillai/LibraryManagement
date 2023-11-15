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
<h1>Student Page</h1>
<c:choose>
		<c:when test="${role eq 'lib' }">
			<a href="../HTML/Student/AddStudent.html">Add Student</a>
			<a href="../HTML/Student/EditStudent.html">Update Student</a>
			<a href="../HTML/Student/FindStudent.html">Find Student</a>
			<a href="../HTML/Student/DeleteStudent.html">Delete Student</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add Students</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>--%>
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
	<c:choose>
		<c:when test="${role eq 'lib' }">
			 <div class="box-container">
        <div class="box">
            <a href="../HTML/Student/AddStudent.html"><img src="../Images/AddStudent.png" alt="Image 1"></a>
        </div>
        <div class="box">
            <a href="../HTML/Student/EditStudent.html"><img src="../Images/UpdateStudent.png" alt="Image 2"></a>
        </div>
        <div class="box">
             <a href="../HTML/Student/FindStudent.html"><img src="../Images/FindStudent.png" alt="Image 3"></a>
        </div>
        <div class="box">
            <a href="../HTML/Student/DeleteStudent.html"><img src="../Images/StudentDelete.png" alt="Image 4"></a>
        </div>
    </div>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>
</div>


<div class="footer">
    Library Management &copy; <span class="copyright">&copy;</span> 2023
</div>
</body>
</html>