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
		<div class="container col-lg-10">
			<header id="DojosNinjas__Header" class="d-flex justify-content-around my-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">Dojos and Ninjas <span>•</span> #34 CORE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="DojosNinjas__BodyContents" class="row">
				<div id="DojosNinjas_DojoForm" class="col-md-7 mb-3">
					<div id="Dojo__Creation_Form" class="px-3 bg-dark-subtle rounded-2 py-3">
						<h2 class="fs-3 fw-bold text-center">New Dojo</h2>
						 <form:form action="/dojos/add" method="post" modelAttribute="dojo" class="row g-3 my-3">
						 	<!-- Dojo Name Input -->
							<div class="row justify-content-center">
								<div class="col-7 ms-2">
									<form:input path="name" type="text" id="dojoNameInput" class="form-control" placeholder="Add a Dojo" />
									<form:errors path="name" class="d-flex justify-content-center alert alert-danger mt-2" />
								</div>
								<div class="col-3">
									<input type="submit" value="Add Dojo" class="btn btn-dark" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<!--  -->
				<div id="DojosNinjas_DojoList" class="text-center col-md-5">
					<div class="px-3 bg-dark-subtle rounded-2 py-3">				
						<h2 class="fs-3 fw-bold">All Dojos</h2>
						
						<c:forEach var="dojo" items="${dojos}">
							<p><a href="/dojos/${dojo.id}/show" class="text-primary-emphasis"><c:out value="${dojo.name}" /></a></p>
						</c:forEach>
						<div class="d-flex justify-content-end mx-5 mb-3">
							<a href="/dojos/enroll/ninja" class="btn btn-dark">Enroll Ninja</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>