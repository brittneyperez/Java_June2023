<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Expense Details</title>
	</head>
	<body class="bg-success-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">SaveTravels <span>•</span> #32 | CORE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div>
				<h2><c:out value="${expense.expenseName}" /></h2>
				
				<p><strong>Description:</strong> <c:out value="${expense.description}" /></p>
				<p><strong>Vendor:</strong> <c:out value="${expense.vendor}" /></p>
				<p><strong>Amount:</strong> 
					$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}" />
				</p>
			</div>
			
		</div>
	</body>
</html>