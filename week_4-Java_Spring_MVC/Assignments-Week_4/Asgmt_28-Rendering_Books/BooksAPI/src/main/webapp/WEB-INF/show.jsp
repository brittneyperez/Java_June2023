<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- <link rel="stylesheet" href="/css/style.css"/> -->
		<title>Rendering Books</title>
	</head>
	<body>
		<div class="container">	
			<%-- <div id="test__code">			
				<h4>Passing in as an Object:</h4>
				<p><strong>One Book:</strong> ${book}</p>
				<p><strong>All Books:</strong> <c:out value="${books}" /></p>
			</div> --%>
			<h1>Welcome! Enter an id number at the end of the URL to see the details</h1>
			
			<h2><c:out value="${book.title}" /></h2>
			<h3>Description: <c:out value="${book.description}" /></h3>
			<h3>Language: <c:out value="${book.language}" /></h3>
			<h3>Number of Pages: <c:out value="${book.numberOfPages}" /></h3>
			
		</div>
	</body>
</html>