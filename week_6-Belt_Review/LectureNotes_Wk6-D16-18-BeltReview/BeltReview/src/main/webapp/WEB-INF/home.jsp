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
	<body class="bg-primary-subtle">
		<div id="BeltReview_Top" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-semibold text-secondary">BeltReview • Wk6 Lecture</p>
		</div>
		<div class="container-fluid">
			<!--  -->
			<header id="BeltReview_Header" class="ms-5 mt-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">
					<a href="/users/home" class="text-decoration-none text-dark">Belt Review</a>
				</h1>
			</header>
			<!-- Homepage Contents - Start -->
			<div id="BeltReview_HomepageAndAllProjects" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="BeltReview_Nav" class="text-start">
					<div id="Welcome_and_Logout" class="d-flex align-items-center justify-content-between">
						<h2 class="fw-bold">Welcome, <c:out value="${currentUser.firstName}" />.</h2>
						<div class="d-flex align-items-center gap-3">
							<h5><a href="/users/about?user=${currentUser.id}" class="text-decoration-none text-primary-emphasis">@<c:out value="${currentUser.username}" /></a></h5>
							<a href="/users/logout" class="btn btn-dark btn-sm">Logout</a>
						</div>
					</div>
			<!-- Tables -->
					<div id="BeltReview_AllProjects" class="d-flex align-items-center justify-content-between mt-2">
						<h3 class="fw-semibold text-start">All Available Projects</h3>
						<a href="/projects/new" class="btn btn-primary btn-sm text-decoration-none">+ Create a Project</a>
					</div>
				</div>
				<c:choose>
					<c:when test="${empty unjoinedProjects}">
						<p class="d-flex justify-content-center">There are currently no active projects. Create one now!</p>
					</c:when>
					<c:otherwise>
						<table id="AllProjects" class="mt-1 table table-hover table-striped table-bordered">
							<thead class="table-dark">
								<tr>
									<th>Project</th>
									<th class="d-none d-md-table-cell">Team Lead</th>
									<th class="d-none d-md-table-cell">Due Date</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="thisProject" items="${unjoinedProjects}">									
									<tr>
										<td>
											<a href="/projects/${thisProject.id}/show" class="text-primary-emphasis fw-semibold text-decoration-none"><c:out value="${thisProject.title}" /></a>
										</td>
										<td class="d-none d-md-table-cell fw-medium"><c:out value="${thisProject.creator.firstName}" /></td>
										<td class="d-none d-md-table-cell"><fmt:formatDate value="${thisProject.dueDate}" pattern="MMM dd" /></td>
										<td><a href="/projects/${thisProject.id}/join" class="btn btn-secondary btn-sm">Join team</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>	
			
			<div id="BeltReview_MyProjects" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<h3 class="fw-semibold text-start">My Projects</h3>
				<c:choose>
					<c:when test="${empty currentUser.teamProjects}">
						<p class="d-flex justify-content-center">It's pretty quiet here. Too quiet...</p>
					</c:when>
					<c:otherwise>
						<table id="MyProjects" class="mt-1 table table-hover table-striped table-bordered">
							<thead class="table-dark">
								<tr>
									<th>Project</th>
									<th class="d-none d-md-table-cell">Team Lead</th>
									<th class="d-none d-md-table-cell">Due Date</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${currentUser.teamProjects}">									
									<tr>
										<td>
											<a href="/projects/${project.id}/show" class="text-primary-emphasis fw-semibold text-decoration-none"><c:out value="${project.title}" /></a>
										</td>
										<td class="d-none d-md-table-cell fw-medium"><c:out value="${project.creator.firstName}" /></td>
										<td class="d-none d-md-table-cell"><fmt:formatDate value="${project.dueDate}" pattern="MMM dd" /></td>
										<c:choose>
											<c:when test="${project.creator.id.equals(userId) }">
												<td class="d-flex align-items-center justify-content-center gap-4">
													<a href="/projects/${project.id}/edit" class="btn btn-dark btn-sm">Edit</a>
													<a href="/projects/${project.id}/delete" class="btn btn-danger btn-sm">Delete</a>
													
												</td>
											</c:when>
											<c:otherwise>
												<td><a href="/projects/${project.id}/leave" class="bth btn-secondary btn-sm">Leave team</a></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- Homepage Contents - End -->
		</div>
	</body>
</html>