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
		<title>Project Manager</title>
	</head>
	<body class="bg-info bg-opacity-10">
		<header id="TopDiv" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fw-6 fw-semibold text-secondary">Project Manager • #40</p>
		</header>
		<div class="container-fluid">
			<div id="ProjectManagerNav" class="ms-md-5 ms-2 mt-3 text-start">
				<h1 class="fs-2 fw-bold" style="font-family:serif;">
					<a href="/project-manager/dashboard" class="text-decoration-none text-dark">Project Manager</a>
				</h1>
				<p class="fw-medium">A place for teams to manage projects.</p>
			</div>
			
			<div id="Flex_FormContents" class="row d-flex justify-content-evenly">
				<!-- Registration -->
				<div id="RegistrationForm" class="col-md-5 col-11 px-3 mb-3 py-3 bg-white rounded-2 border border-light-subtle">
					<div id="RegisterHeader" class="text-center">
						<p class="text-secondary fw-medium">New Here?</p>
						<h2 class="fs-3 fw-bold">Register</h2>
						<form:form action="/project-manager/register" method="post" modelAttribute="newUser" class="text-start">
							<!-- Name Input -->
							<div class="form-group row mb-4">
								<form:label path="firstName" class="col-md-4 col-form-label">First Name:</form:label>
								<div class="col-xl-8">
									<form:input type="text" path="firstName" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="firstName" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<div class="form-group row mb-3">
								<form:label path="lastName" class="col-md-4 col-form-label">Last Name:</form:label>
								<div class="col-xl-8">
									<form:input type="text" path="lastName" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="lastName" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Email Input -->
							<div class="form-group row mb-3">
								<form:label path="email" class="col-md-4 col-form-label">Email:</form:label>
								<div class="col-xl-8">
									<form:input type="text" path="email" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="email" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Username Input -->
							<div class="form-group row mb-3">
								<form:label path="username" class="col-md-4 col-form-label">Username:</form:label>
								<div class="col-xl-8">
									<form:input type="text" path="username" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="username" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Password Input -->
							<div class="form-group row mb-3">
								<form:label path="password" for="passInput" class="col-md-4 col-form-label">Password:</form:label>
								<div class="col-xl-8">
									<form:input type="password" path="password" id="passInput" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="password" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<div class="form-group row mb-3">
								<form:label path="confirmPassword" for="confirmPassInput" class="col-md-4 col-form-label">Confirm Password:</form:label>
								<div class="col-xl-8">
									<form:input type="password" path="confirmPassword" autocomplete="off" id="confirmPassInput" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="confirmPassword" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Date of Birth Input -->
							<div class="form-group row mb-3">
								<form:label path="dateOfBirth" class="col-md-4 col-form-label">Date of Birth:</form:label>
								<div class="col-xl-8">
									<form:input type="date" path="dateOfBirth" id="passInput" autocomplete="off" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
									<form:errors path="dateOfBirth" class="d-flex justify-content-center text-danger" />
								</div>
							</div>
							<!-- Submit -->
							<div class="d-flex justify-content-end mb-3">
								<input type="submit" value="Register" class="btn btn-primary" />
							</div>
						</form:form>
					</div>
				</div>
				
				<!-- Login -->
				<div id="LoginForm" class="col-md-5 col-11 px-3 mb-3 py-3 bg-white rounded-2 border border-light-subtle">
					<div id="LoginHeader" class="text-center">
						<p class="text-secondary fw-medium">Already registered?</p>
						<h2 class="fs-3 fw-bold">Login</h2>
						<form:form action="/project-manager/login" method="post" modelAttribute="loginUser" class="text-start">
							<!-- Email Input -->
							<div class="form-group row mb-3">
								<form:label path="loginCredential" class="col-md-4 col-form-label">Email/Username:</form:label>
								<div class="col-xl-8">
									<form:input type="text" path="loginCredential" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
								</div>
							</div>
							<!-- Password Input -->
							<div class="form-group row mb-3">
								<form:label path="password" for="passInput" class="col-md-4 col-form-label">Password:</form:label>
								<div class="col-xl-8">
									<form:input type="password" path="password" id="passInput" class="form-control" style="border-color: gainsboro; border-width: 3px;" />
								</div>
							</div>
							<!-- Errors -->
							<form:errors path="loginCredential" class="d-flex justify-content-center text-danger" />
							<form:errors path="password" class="d-flex justify-content-center text-danger" />
							<!-- Submit -->
							<div class="d-flex justify-content-end mb-3">
								<input type="submit" value="Login" class="btn btn-success" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>