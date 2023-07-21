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
		<title>New Book</title>
	</head>
	<body class="bg-danger-subtle">
		<div id="BookClub_Header" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-bold text-secondary">BookClub • #37-38 CORE</p>
		</div>
		<div class="container-fluid">
			<!--  -->
			<header id="BookClub_Header" class="ms-5 my-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">
					<a href="/book-club/books" class="text-decoration-none text-dark">本棚 Hondana Book Club</a>
				</h1>
			</header>
			<!--  -->
			<div id="BookClub_AddBookForm" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="AddBook_ReturnToHome" class="d-flex align-items-center justify-content-between">
					<h2 class="fw-bold">Add a Book to Your Shelf!</h2>
					<a href="/book-club/books" class="text-danger-emphasis text-decoration-none">Back to Shelves</a>
				</div>
				<form:form action="/book-club/books/create" method="post" modelAttribute="newBook" class="mt-2 col-lg-10 col-12 text-start">
					<!-- Title Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="title" class="col-md-3 col-form-label"><strong>Title:</strong></form:label>
						<div class="col-md-9">
							<form:input type="text" path="title" class="form-control" style="border-color: gainsboro; border-width: 2px;" />
							<form:errors path="title" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Author Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="author" class="col-md-3 col-form-label"><strong>Author:</strong></form:label>
						<div class="col-md-9">
							<form:input type="text" path="author" class="form-control" style="border-color: gainsboro; border-width: 2px;" />
							<form:errors path="author" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Thoughts Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="thoughts" class="col-md-3 col-form-label"><strong>My Thoughts:</strong></form:label>
						<div class="col-md-9">
							<form:textarea path="thoughts" rows="8" cols="40" class="form-control" style="border-color: gainsboro; border-width: 2px;"></form:textarea>
							<form:errors path="thoughts" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Submit Button -->
					<div class="d-flex justify-content-end mb-3 me-5">
						<input type="submit" value="Add Book" class="btn btn-dark" />
					</div>
				</form:form>
			</div>
		</div>
	</body>
</html>