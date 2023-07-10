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
		<title>Index</title>
	</head>
	<body class="bg-dark-subtle">
		<div class="container col-lg-10 bg-white rounded-2 py-3 px-3 mt-3">
			<!--  -->
			<header id="Auth_Demo__Header" class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">AuthenticationDemo <span>•</span> Week 5 Lecture Code</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="Auth_Demo__Registration_and_Login" class="row">
				<!-- Registration Form -->
				<div class="col-md-6">
					<div id="Auth_Demo__Registration" class="text-center">
						<p class="text-secondary">New Here?</p>
						<h2 class="fs-3 fw-bold">Register</h2>
						<form:form action="/users/register" method="post" modelAttribute="newUser">
							<!-- Name Input -->
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="firstName" class="col-md-3 col-form-label">First Name:</form:label>
								<div class="col-xl-9">
									<form:input type="text" path="firstName" class="form-control" />
									<form:errors path="firstName" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="lastName" class="col-md-3 col-form-label">Last Name:</form:label>
								<div class="col-xl-9">
									<form:input type="text" path="lastName" class="form-control" />
									<form:errors path="lastName" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Email Input -->
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="email" class="col-md-3 col-form-label">Email:</form:label>
								<div class="col-xl-9">
									<form:input type="text" path="email" class="form-control" />
									<form:errors path="email" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Password Input -->
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="password" for="passInput" class="col-md-3 col-form-label">Password:</form:label>
								<div class="col-xl-9">
									<form:input type="password" path="password" id="passInput" class="form-control" />
									<form:errors path="password" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="confirmPassword" for="confirmPassInput" class="col-md-3 col-form-label">Confirm Password:</form:label>
								<div class="col-xl-9">
									<form:input type="password" path="confirmPassword" id="confirmPassInput" class="form-control" />
									<form:errors path="confirmPassword" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Submit -->
							<div class="d-flex justify-content-end mx-xl-5 mb-3">
								<input type="submit" value="Register" class="btn btn-primary" />
							</div>
						</form:form>
					</div>
				</div>
				<!-- Login Form -->
				<div class="col-md-6">
					<div id="Auth_Demo__Login" class="text-center">
						<p class="text-secondary">Already Registered?</p>
						<h2 class="fs-3 fw-bold">Login</h2>
						<form:form action="/users/login" method="post" modelAttribute="loginUser">
							<!-- Email Input -->
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="email" class="col-md-3 col-form-label">Email:</form:label>
								<div class="col-xl-9">
									<form:input type="text" path="email" class="form-control" />
								</div>
							</div>
							<!-- Password Input -->
							<div class="form-group row mx-xl-5 mb-3">
								<form:label path="password" for="passInput" class="col-md-3 col-form-label">Password:</form:label>
								<div class="col-xl-9">
									<form:input type="password" path="password" id="passInput" class="form-control" />
								</div>
							</div>
							<!-- Errors -->
							<form:errors path="email" class="d-flex justify-content-center text-danger" />
							<form:errors path="password" class="d-flex justify-content-center text-danger" />
							<!-- Submit -->
							<div class="d-flex justify-content-end mx-xl-5 mb-3">
								<input type="submit" value="Login" class="btn btn-success" />
							</div>
						</form:form>
					</div>
				</div>
				<!-- End of Forms -->
			</div>		
		</div>
	</body>
</html>