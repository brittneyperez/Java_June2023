<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Burger Details</title>
	</head>
	<body class="bg-warning-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<a href="/burgers">All Burgers</a>
				<h3 class="fs-6 fw-bold text-secondary">BurgerTracker <span>•</span> #30-31 | PRACTICE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div>
				<h2><c:out value="${burger.name}" /></h2>
				
				<p><strong>Notes:</strong> <c:out value="${burger.notes}" /></p>
				<p><strong>Restaurant:</strong> <c:out value="${burger.restaurant}" /></p>
				<p><strong>Rating:</strong> <c:out value="${burger.rating}" /> Stars</p>
			</div>
			
		</div>
	</body>
</html>