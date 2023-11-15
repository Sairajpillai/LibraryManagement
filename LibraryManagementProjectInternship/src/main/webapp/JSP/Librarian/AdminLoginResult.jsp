<%-- 1 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 1--%>
<%-- <%@ include file="../../templates/header.html" %> --%>
<%--2 <body> 2--%>
	<%-- <c:choose>
		<c:when test="${role eq 'admin' }">
			<a href="../AddLibrarian.html">Add Librarian</a>
			<a href="../EditLibrarian.html">Update Librarian</a>
			<a href="../FindLibrarian.html">Find Librarian</a>
			<a href="../DeleteForm.html">Delete Librarian</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>--%>
	
	<%-- 3<c:choose>
		<c:when test="${role eq 'admin' }">
			<a href="../HTML/Librarian/AddLibrarian.html">Add Librarian</a>
			<a href="../HTML/Librarian/EditLibrarian.html">Update Librarian</a>
			<a href="../HTML/Librarian/FindLibrarian.html">Find Librarian</a>
			<a href="../HTML/Librarian/DeleteForm.html">Delete Librarian</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ include file="../../templates/header.html" %> 
<style>
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
	<%-- <c:choose>
		<c:when test="${role eq 'admin' }">
			<a href="../AddLibrarian.html">Add Librarian</a>
			<a href="../EditLibrarian.html">Update Librarian</a>
			<a href="../FindLibrarian.html">Find Librarian</a>
			<a href="../DeleteForm.html">Delete Librarian</a>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>--%>
	<div class="container">
	<c:choose>
		<c:when test="${role eq 'admin' }">
			 <div class="box-container">
        <div class="box">
            <a href="../HTML/Librarian/AddLibrarian.html"><img src="../Images/Addlib.png" alt="Image 1"></a>
        </div>
        <div class="box">
            <a href="../HTML/Librarian/EditLibrarian.html"><img src="../Images/EditLibrarian.png" alt="Image 2"></a>
        </div>
        <div class="box">
             <a href="../HTML/Librarian/FindLibrarian.html"><img src="../Images/Findlib.png" alt="Image 3"></a>
        </div>
        <div class="box">
            <a href="../HTML/Librarian/DeleteForm.html"><img src="../Images/Dellib.png" alt="Image 4"></a>
        </div>
    </div>
		</c:when>
		<c:otherwise>
			<h1>You are not authorized to add books</h1>
		</c:otherwise>
	</c:choose>
</div>
	 <%@ include file="../../templates/footer.html" %> 
