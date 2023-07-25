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
		<title>Dashboard</title>
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
			</div>
			<!-- Update Project - Page -->
			<div id="CreateProjectsForm" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="AddProjectTitle_ReturnToHome" class="d-flex align-items-center justify-content-between">
					<h2 class="fw-bold">Create a Project</h2>
					<a href="/project-manager/dashboard" class="text-primary-emphasis text-decoration-none me-2">Back to Home</a>
				</div>
				
				<form:form action="/projects/${projectToEdit.id}/update" method="post" modelAttribute="projectToEdit" class="mt-2 col-lg-10 col-12 text-start">
					<input type="hidden" name="_method" value="put" />
					<!-- Title Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="title" class="col-md-3 col-form-label"><strong>Project Title:</strong></form:label>
						<div class="col-md-9">
							<form:input type="text" path="title" class="form-control" style="border-color: gainsboro; border-width: 2px;" />
							<form:errors path="title" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Description Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="description" class="col-md-3 col-form-label"><strong>Project Description:</strong></form:label>
						<div class="col-md-9">
							<form:textarea path="description" rows="8" cols="40" class="form-control" style="border-color: gainsboro; border-width: 2px;"></form:textarea>
							<form:errors path="description" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Due Date Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="dueDate" class="col-md-3 col-form-label"><strong>Due Date:</strong></form:label>
						<div class="col-md-9">
							<form:input type="date" path="dueDate" class="form-control" style="border-color: gainsboro; border-width: 2px;" />
							<form:errors path="dueDate" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Submit Button -->
					<div class="d-flex justify-content-end mb-3 me-5">
						<input type="submit" value="Save Changes" class="btn btn-dark" />
					</div>
				</form:form>
			</div>	
		</div>
	</body>
</html>