<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<!-- Homepage Contents -->
			<div id="FlexProjectManager_Tables">
				<div id="AllProjects" class="mx-auto col-md-10 col-11 px-3 mb-3 py-3 bg-white rounded-2 border border-light-subtle">
					<div id="UserWelcome" class="text-start d-flex align-items-center justify-content-between mb-2">
						<h2 class="fw-semibold fs-3">Welcome, <c:out value="${currentUser.firstName}" />!</h2>
						<div id="UserActions" class="d-flex align-items-center gap-3">
							<h5 class="d-none d-sm-block">@ <c:out value="${currentUser.username}" /></h5>
							<a href="/project-manager/logout" class="btn btn-danger btn-sm">Logout</a>
						</div>
					</div>
					<!-- All Available (Joinable) Projects -->
					<div id="AllProjects_CreateBtn" class="d-flex align-items-center justify-content-between mt-2">					
						<h4>All Projects</h4>
						<a href="/projects/new" class="btn btn-dark btn-sm fw-semibold">+ Create a Project</a>
					</div>
					<c:choose>
						<c:when test="${ empty unjoinedProjects }">
							<p class="d-flex justify-content-center">There are currently no active projects. Create one now!</p>
						</c:when>
						<c:otherwise>
							<table id="AllProjects_Table" class="mt-1 text-center table table-hover table-striped table-bordered">
								<thead class="table-dark">
									<tr>
										<th>Project</th>
										<th class="d-none d-md-table-cell">Team Lead</th>
										<th class="d-none d-md-table-cell">Due Date</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="project" items="${unjoinedProjects}">
										<tr>
											<td>
												<a href="/projects/${project.id}/show" class="text-info-emphasis fw-semibold text-decoration-none"><c:out value="${project.title}" /></a>
											</td>
											<td class="d-none d-md-table-cell fw-medium"><c:out value="${project.creator.firstName}" /></td>
											<td class="d-none d-md-table-cell"><fmt:formatDate value="${project.dueDate}" pattern="MMM dd" /></td>
											<td><a href="/projects/${project.id}/join" class="btn btn-secondary btn-sm">Join Team</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="MyProjects" class="mx-auto col-md-10 col-11 px-3 mb-3 py-3 bg-white rounded-2 border border-light-subtle">
					<!-- Projects Joined and/or Created by User -->
					<h4>My Projects</h4>
					<c:choose>
						<c:when test="${ empty currentUser.teamProjects }">
							<p class="d-flex justify-content-center">It's pretty quiet here. Too quiet...</p>
						</c:when>
						<c:otherwise>
							<table id="MyProjects_Table" class="mt-1 text-center table table-hover table-striped table-bordered">
								<thead class="table-dark">
									<tr>
										<th>Project</th>
										<th class="d-none d-md-table-cell">Team Lead</th>
										<th class="d-none d-md-table-cell">Due Date</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="thisProject" items="${currentUser.teamProjects}">
										<tr>
											<td>
												<a href="/projects/${thisProject.id}/show" class="text-info-emphasis fw-semibold text-decoration-none"><c:out value="${thisProject.title}" /></a>
											</td>
											<td class="d-none d-md-table-cell fw-medium"><c:out value="${thisProject.creator.firstName}" /></td>
											<td class="d-none d-md-table-cell"><fmt:formatDate value="${thisProject.dueDate}" pattern="MMM dd" /></td>
											<c:choose>
												<c:when test="${thisProject.creator.id.equals(userId)}">
													<td class="d-flex align-items-center justify-content-center gap-4">
														<a href="/projects/${thisProject.id}/edit" class="btn btn-dark btn-sm">Edit</a>
														<c:if test="${thisProject.teamMembers.size() <= 1}">
															<a href="/projects/${thisProject.id}/delete" class="btn btn-danger btn-sm">Delete</a>
														</c:if>
														<c:if test="${thisProject.teamMembers.size() > 1}">
															<button class="btn btn-danger btn-sm" disabled>Delete</button>
														</c:if>
													</td>
												</c:when>
												<c:otherwise>
													<td>
														<a href="/projects/${thisProject.id}/leave" class="btn btn-secondary btn-sm">Leave Team</a>
													</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</div>			
		</div>
	</body>
</html>