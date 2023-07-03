<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Create Form</title>
	</head>
	<body class="bg-info-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<a href="/books">All Books</a>
				<h3 class="fs-6 fw-bold text-secondary">All Books <span>•</span> #29 | PRACTICE</h3>
				<a href="/books/new">Add a Book</a>
			</header>
			<!--  -->
			<div id="form_div">
				<div class="text-center">
					<h1 class="fs-2 fw-bold">Edit a Book</h1>
				</div>
				<!--  -->
				<form:form action="/books/${book.id}" method="post" modelAttribute="book">
					<input type="hidden" name="_method" value="put" />
  					<!-- Title input -->
				    <div class="form-group row mx-5 mb-3">
				        <form:label path="title" class="col-md-3 col-form-label"><strong>Title:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="title" class="form-control" />
					        <form:errors path="title" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
				    <!-- Description Input -->
				    <div class="form-group row mx-5 mb-3">
				        <form:label path="description" class="col-md-3 col-form-label"><strong>Description:</strong></form:label>
				        <div class="col-md-9">
				            <form:textarea path="description" class="form-control"></form:textarea>
				            <form:errors path="description" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
  					<!-- Language Input -->
  					<div class="form-group row mx-5 mb-3">
				        <form:label path="language" class="col-md-3 col-form-label"><strong>Language:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="language" class="form-control" />
				            <form:errors path="language" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
  					<!-- Page Number Input -->
  					<div class="form-group row mx-5 mb-3">
				        <form:label path="numberOfPages" class="col-md-3 col-form-label"><strong>Number of Pages:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="number" path="numberOfPages" class="form-control" />
				            <form:errors path="numberOfPages" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
					<!-- Submit button -->
					<div class="d-grid gap-2 mx-5 mb-3">
				  		<input type="submit" value="Submit" class="btn btn-info" type="button" />
					</div>
				</form:form>
			</div>
			<!--  -->	
		</div>
		
	</body>
</html>