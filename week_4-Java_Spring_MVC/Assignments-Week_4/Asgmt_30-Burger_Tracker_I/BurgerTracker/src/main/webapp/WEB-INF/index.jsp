<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Burger Tracker</title>
	</head>
	<body class="bg-warning-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">Burger Tracker <span>•</span> #30 | PRACTICE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div class="text-center">
				<h1 class="fs-2 fw-bold">All Burgers</h1>
				<table class="table table-hover table-striped table-bordered mt-3">
					<thead class="table-dark">
						<tr>
							<th>id</th>
							<th>Burger Name</th>
							<th>Restaurant</th>
							<th>Rating (out of 5 stars)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="burger" items="${burgers}">
							<tr >
								<td><c:out value="${burger.id}" /></td>
								<td>
									<%-- <a href="/burgers/${burgers.id}" class="text-info-emphasis"> --%>
										<c:out value="${burger.name}" />
									<!-- </a> -->
								</td>
								<td><c:out value="${burger.restaurant}" /></td>
								<td><c:out value="${burger.rating}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--  -->
			<div id="form_div">
				<div class="text-center">
					<h1 class="fs-2 fw-bold">Add a Burger</h1>
				</div>
				<!--  -->
				<form:form action="/burgers/addBurger" method="post" modelAttribute="burger">
  					<!-- Burger Name input -->
				    <div class="form-group row mx-5 mb-3">
				        <form:label path="name" class="col-md-3 col-form-label"><strong>Burger Name:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="name" class="form-control" />
					        <form:errors path="name" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
				    <!-- Restaurant Name Input -->
				    <div class="form-group row mx-5 mb-3">
				        <form:label path="restaurant" class="col-md-3 col-form-label"><strong>Restaurant:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="restaurant" class="form-control" />
				            <form:errors path="restaurant" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
  					<!-- Star Rating Input -->
  					<div class="form-group row mx-5 mb-3">
						<label for="rating" class="col-md-3 col-form-label"><strong>Rating</strong>:</label>
						<div class="col-md-9">
        					<select id="rating" name="rating" class="form-control">
            					<option value="1">1</option>
            					<option value="2">2</option>
					            <option value="3">3</option>
            					<option value="4">4</option>
            					<option value="5">5</option>
					        </select>
        					<form:errors path="rating" class="d-flex justify-content-center text-danger" />
					    </div>
					</div>
					<!-- Notes Input -->
					 <div class="form-group row mx-5 mb-3">
				        <form:label path="notes" class="col-md-3 col-form-label"><strong>Notes:</strong></form:label>
				        <div class="col-md-9">
				            <form:textarea path="notes" class="form-control"></form:textarea>
				            <form:errors path="notes" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
					<!-- Submit button -->
					<div class="d-grid gap-2 mx-5 mb-3">
				  		<input type="submit" value="Submit" class="btn btn-info" type="button" />
					</div>
				</form:form>
			</div>
		</div>
		
	</body>
</html>