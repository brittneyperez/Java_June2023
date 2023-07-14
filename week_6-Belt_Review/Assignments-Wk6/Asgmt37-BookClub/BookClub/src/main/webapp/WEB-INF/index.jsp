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
		<title>Index</title>
	</head>
	<body class="bg-danger-subtle">
		<nav id="BookClub_Header" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-bold text-secondary">BookClub • #37 CORE</p>
		</nav>
		<div class="container-fluid">
			<!--  -->
			<header id="BookClub_Header" class="ms-5 mt-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">本棚 Hondana Book Club</h1>
				<p class="fs-5 fw-medium">A place for friends to share thoughts on books.</p>
			</header>
			<div id="BookClub_LoginAndRegistration_FormContents" class="row d-flex justify-content-evenly">
				<!-- Registration -->
				<div id="RegistrationForm" class="col-md-5 col-11 px-3 mb-3 bg-white rounded-2">
					<h2>Registration Form</h2>
				</div>
				<!-- Login -->
				<div id="LoginForm" class="col-md-5 col-11 px-3 mb-3 bg-white rounded-2">
					<h2>Login Form</h2>
				</div>
			</div>
		</div>
	</body>
</html>