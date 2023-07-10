<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Home</title>
	</head>
	<body class="bg-dark-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">
			<!--  -->
			<header id="Auth_Demo__Header" class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">AuthenticationDemo <span>•</span> Week 5 Lecture Code</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="Auth_Demo__Dashboard" class="text-center">
				<h1 class="fs-2 fw-bold">Dashboard Home for User <c:out value="${userId}" /></h1>
				
				<h3>Welcome <c:out value="${currentUser.firstName}" /> <c:out value="${currentUser.lastName}" />!</h3>
				<h3>Your email is: <c:out value="${currentUser.email}" /></h3>
				<a href="/users/logout" class="btn btn-danger mt-3">Logout</a>
				
			</div>
		</div>
	</body>
</html>