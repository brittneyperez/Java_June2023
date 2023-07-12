<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Dashboard</title>
	</head>
	<body class="bg-dark">
		<div class="container-fluid">
			<!--  -->
			<header id="LoginRegistration__Header" class="my-3">
				<div id="AssignmentDetails" class="d-flex justify-content-center">
					<span class="invisible">Placeholder</span>
					<h3 class="fs-6 fw-bold text-secondary">Login and Registration <span>•</span> #36 CORE</h3>
					<span class="invisible"><c:out value="${userId}" /></span>				
				</div>
			</header>
			<!--  -->
			<div id="LoginRegistration__Dashboard" class="text-center mx-auto col-sm-8 col-xxl-6 px-3 py-3 mb-3 bg-dark-subtle rounded-2">
				<h1 class="fs-2 fw-bold">Welcome <c:out value="${currentUser.firstName}" /> <c:out value="${currentUser.lastName}" />!</h1>
				<p><strong>Your email is</strong>: <c:out value="${currentUser.email}" /></p>
				<p><strong>Your username is</strong>: @<c:out value="${currentUser.username}" /></p>
				<p><strong>Your Password is</strong>: You didn't think we'd actually show it to you, right?</p>
				
				<div id="Dashboard_AdditionalDetails" class="mt-3">
					<h2 class="fs-4">Additional Details</h2>		
					<p>
						<strong>Date of Birth</strong>: <c:out value="${userDOB}" /> (<c:out value="${age}" /> yrs)
					</p>
				</div>
				
				<p><strong>Joined</strong>: <fmt:formatDate value="${currentUser.createdAt}" pattern="MM/dd/yyyy" /></p>
				<a href="/authenticate/logout" class="btn btn-danger mt-3">Logout</a>
			</div>
		</div>
	</body>
</html>