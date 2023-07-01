<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Book Details</title>
	</head>
	<body class="bg-info-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="text-center mb-3">
				<h1 class="fs-3 fw-bold">All Books</h1>
				<p class="text-secondary">Assignment #29 | PRACTICE</p>			
			</header>
			<!--  -->
			<div>
				<h2><c:out value="${book.title}" /></h2>
				
				<p><strong>Description:</strong> <c:out value="${book.description}" /></p>
				<p><strong>Language:</strong> <c:out value="${book.language}" /></p>
				<p><strong>Number of Pages:</strong> <c:out value="${book.numberOfPages}" /></p>
			</div>
			
		</div>
	</body>
</html>