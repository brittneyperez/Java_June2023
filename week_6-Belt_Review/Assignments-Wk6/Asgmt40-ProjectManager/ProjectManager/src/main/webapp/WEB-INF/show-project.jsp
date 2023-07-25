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
		<title>Show Project</title>
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
			<!--  -->
			<div id="ShowProject" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="SectionTitle_ReturnToHome" class="d-flex align-items-center justify-content-between">
					<h2 class="fw-bold">Show Project</h2>
					<a href="/project-manager/dashboard" class="text-info-emphasis text-decoration-none me-2">Back to Home</a>
				</div>
				
				<div class="mt-3 col-lg-10 col-12 text-start">
					<!-- Title Info -->
					<div id="Title_Info" class="row mx-5 mb-3">
						<p class="fw-bold col-md-3">Project Title:</p>
						<div class="col-md-9">
							<p><c:out value="${project.title}" /></p>
						</div>
					</div>
					<!-- Description Info -->
					<div id="Description_Info" class="row mx-5 mb-3">
						<p class="fw-bold col-md-3">Project Description:</p>
						<div class="col-md-9">
							<p><c:out value="${project.description}" /></p>
						</div>
					</div>
					<!-- Due Date Info -->
					<div id="Due_Date" class="row mx-5 mb-3">
						<p class="fw-bold col-md-3">Due Date:</p>
						<div class="col-md-9">
							<p><fmt:formatDate value="${project.dueDate}" pattern="MM/dd/yyyy" /></p>
						</div>
					</div>
					
					<div id="TimeDetails_and_ActionBtns" class="d-flex flex-wrap align-items-center justify-content-around col-lg-10 col-12">
						<div class="d-flex flex-md-row flex-column align-items-center align-items-md-start justify-content-md-around" style="font-size:.8rem">
							<p class="text-secondary fw-light">Created: <fmt:formatDate value="${project.createdAt}" pattern="MMMM d, yyyy • HH:mm" /></p>
							<c:choose>
								<c:when test="${not empty project.updatedAt}">
									<p class="text-secondary fw-light ms-1">— Edited: <fmt:formatDate value="${project.updatedAt}" pattern="MMMM d, yyyy • HH:mm" /></p>
								</c:when>
								<c:otherwise>
									<span class="invisible">None</span>
								</c:otherwise>
							</c:choose>
						</div>
						<div id="UserSpecificActions_UpdateDelete" class="d-flex gap-3">
							<c:choose>							
								<c:when test="${currentUser.id == project.creator.id}">
									<a href="/projects/${project.id}/edit" class="btn btn-dark btn-sm">Edit</a>
									<c:if test="${project.teamMembers.size() <= 1}">
										<a href="/projects/${project.id}/delete" class="btn btn-danger btn-sm">Delete</a>
									</c:if>
									<c:if test="${project.teamMembers.size() > 1}">
										<button class="btn btn-danger btn-sm" disabled>Delete</button>
									</c:if>
								</c:when>
								<c:otherwise>
									<span class="invisible">None</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>	
			<!--  -->
		</div>
	</body>
</html>