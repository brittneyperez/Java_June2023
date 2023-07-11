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
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Dojos & Ninjas</title>
	</head>
	<body class="bg-dark">
		<div class="container-fluid">
			<header id="DojosNinjas__Header" class="d-flex justify-content-around my-3 col-md-6 mx-auto">
				<a href="/dojos" class="text-light text-decoration-none fw-semibold">Home</a>
				<h3 class="fs-6 fw-bold text-secondary">Dojos and Ninjas <span>•</span> #34 CORE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="DojosNinjas__NinjaForm" class="px-3 bg-dark-subtle col-sm-6 mx-auto rounded-2 py-3">
				<!-- <div id="Ninja__EnrollmentForm" class="px-3 bg-dark-subtle rounded-2 py-3"> -->
					<h2 class="fs-3 fw-bold text-center">Enroll Ninja</h2>
					 <form:form action="/dojos/enrolling" method="post" modelAttribute="newNinja" class="row g-3 my-3">
						<!-- Ninja Name Input -->
						<div class="form-group row mb-3">
							<form:label path="firstName" class="col-md-4 col-form-label">First Name:</form:label>
							<div class="col-lg-8">
								<form:input type="text" path="firstName" class="form-control" />
								<form:errors path="firstName" class="d-flex justify-content-center alert alert-danger mt-2" />
							</div>
						</div>
						<div class="form-group row mb-3">
							<form:label path="lastName" class="col-md-4 col-form-label">Last Name:</form:label>
							<div class="col-lg-8">
								<form:input type="text" path="lastName" class="form-control" />
								<form:errors path="lastName" class="d-flex justify-content-center alert alert-danger mt-2" />
							</div>
						</div>
						<!-- Age Input -->
						<div class="form-group row mb-3">
							<form:label path="age" class="col-md-4 col-form-label">Age:</form:label>
							<div class="col-lg-8">
								<form:input type="number" path="age" class="form-control" />
								<form:errors path="age" class="d-flex justify-content-center alert alert-danger mt-2" />
							</div>
						</div>
						<!-- Dojo Input -->
						<div class="form-group row mb-3">
							<form:label path="dojo" class="col-md-4 col-form-label">Dojo:</form:label>
							<div class="col-lg-8">
								<form:select path="dojo" class="form-select">
									<c:forEach var="singleDojo" items="${dojosList}">
										<option value="${singleDojo.id}"><c:out value="${singleDojo.name}" /></option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<!-- Submit -->
						<div class="d-flex justify-content-center mb-3">
							<input type="submit" value="Enroll" class="btn btn-dark" />
						</div>
					</form:form>
				<!-- </div> -->
			<!--  -->
			</div>
		</div>
	</body>
</html>