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
		<title>Home</title>
	</head>
	<body class="bg-danger-subtle">
		<nav id="BookClub_Header" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-bold text-secondary">BookClub • #37 CORE</p>
		</nav>
		<div class="container-fluid">
			<!--  -->
			<header id="BookClub_Header" class="ms-5 my-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">本棚 Hondana Book Club</h1>
				<!-- <p class="fs-5 fw-medium">A place for friends to share thoughts on books.</p> -->
			</header>
			<div id="RegistrationForm" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<h2 class="fw-bold">Book List</h2>
				<table class="mt-3 table table-hover table-striped table-bordered">
					<thead class="table-dark">
						<tr>
							<th>id</th>
							<th>Title</th>
							<th>Author</th>
							<th>Posted By</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Hearless</td>
							<td>Mariisa Meyer</td>
							<td>Jane Doe</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>