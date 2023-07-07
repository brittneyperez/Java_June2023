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
		<title>Edit Tweet</title>
	</head>
	<body class="bg-primary-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<!-- <span class="invisible">Placeholder</span> -->
				<a href="/tweets">Home</a>
				<h3 class="fs-6 fw-bold text-secondary">TwitterDemo <span>•</span> Week 4 LectureCode</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="form_div">
				<div class="text-center">
					<h1 class="fs-2 fw-bold">Edit a Tweet</h1>
				</div>
				<!--  -->
				<form:form action="/tweets/${tweetToEdit.id}/update" method="post" modelAttribute="tweetToEdit">
					<input type="hidden" name="_method" value="put" />
  					<!-- Tweet Content Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="tweetContent" class="col-md-3 col-form-label">Content:</form:label>
						<div class="col-md-9">
							<form:input type="text" path="tweetContent" class="form-control" />
							<form:errors path="tweetContent" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Integer Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="imaginaryIntAtt" class="col-md-3 col-form-label">Integer:</form:label>
						<div class="col-md-9">
							<form:input type="number" path="imaginaryIntAtt" class="form-control" />
							<form:errors path="imaginaryIntAtt" class="d-flex justify-content-center text-danger" />
						</div>
					</div>
					<!-- Submit -->
					<div class="d-flex justify-content-end mx-5 mb-3">
						<input type="submit" value="Edit" class="btn btn-primary" />
					</div>
				</form:form>
			</div>
			<!--  -->	
		</div>
		
	</body>
</html>