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
		<title>Show Dojo</title>
	</head>
	<body class="bg-dark">
		<div class="container-fluid">
			<header id="DojosNinjas__Header" class="d-flex justify-content-around my-3 col-lg-8 mx-auto">
				<a href="/dojos" class="text-light text-decoration-none fw-semibold">Home</a>
				<h3 class="fs-6 fw-bold text-secondary">Dojos and Ninjas <span>•</span> #34 CORE</h3>
				<a href="/dojos/enroll/ninja" class="text-light text-decoration-none fw-semibold">Enroll Ninja</a>
			</header>
			<!--  -->
			<div class="text-center px-3 bg-dark-subtle col-lg-8 mx-auto rounded-2 py-3">
				<h1 class="fs-2 fw-bold"><c:out value="${dojo.name}" />'s Ninjas</h1>
				<c:choose>
					<c:when test="${empty theseNinjas}">
						<p class="d-flex justify-content-center">There are currently no ninjas enrolled in this dojo.</p>
						<a href="/dojos/enroll/ninja" class="text-primary-emphasis">Enroll one now!</a>
					</c:when>
					<c:otherwise>
						<table class="table table-hover table-striped table-bordered mt-3">
							<thead class="table-dark">
								<tr>
									<th>id</th>
									<th>First Name</th>
									<th>Last name</th>
									<th>Age</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="thisNinja" items="${theseNinjas}">
									<tr >
										<td><c:out value="${thisNinja.id}" /></td>
										<td><c:out value="${thisNinja.firstName}" /></td>
										<td><c:out value="${thisNinja.lastName}" /></td>
										<td><c:out value="${thisNinja.age}" /></td>
										<td>Coming soon!</td>
										<!-- <td class="d-flex flex-column flex-md-row align-items-center justify-content-around">
											<a href="/burgers/${burger.id}/edit">Edit</a>
											<form action="/burgers/${burger.id}" method="post">
												<input type="hidden" name="_method" value="delete" />
												<input type="submit" class="btn btn-danger btn-sm" value="Delete" />
											</form>
										</td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
	</body>
</html>