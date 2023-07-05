<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>Save Travels</title>
	</head>
	<body class="bg-success-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">SaveTravels <span>•</span> #32 | CORE</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div class="text-center">
				<h1 class="fs-2 fw-bold">All Expenses</h1>
				<table class="table table-hover table-bordered mt-3">
					<thead class="table-dark">
						<tr>
							<th>id</th>
							<th>Name</th>
							<th>Vendor</th>
							<th>Amount</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="expense" items="${expenses}">
							<tr >
								<td><c:out value="${expense.id}" /></td>
								<td><a href="/expenses/${expense.id}" class="text-info-emphasis"><c:out value="${expense.expenseName}" /></a></td>
								<td><c:out value="${expense.vendor}" /></td>
								<td>
									$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}" />
								</td>
								<td class="d-flex flex-column flex-md-row align-items-center justify-content-around">
									<a href="/expenses/${expense.id}/edit">Edit</a>
									<form action="/expenses/${expense.id}" method="post">
										<input type="hidden" name="_method" value="delete" />
										<input type="submit" class="btn btn-danger btn-sm" value="Delete" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--  -->
			<div id="form_div" class="mt-3">
				<div class="text-center">
					<h1 class="fs-2 fw-bold">Add an Expense</h1>
				</div>
				<!--  -->
				<form:form action="/expenses/addExpense" method="post" modelAttribute="expense">
  					<!-- Expense Name input -->
				    <div class="form-group row mx-5 mb-3">
				        <form:label path="expenseName" class="col-md-3 col-form-label"><strong>Expense Name:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="expenseName" class="form-control" />
					        <form:errors path="expenseName" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
  					<!-- Vendor Input -->
  					<div class="form-group row mx-5 mb-3">
				        <form:label path="vendor" class="col-md-3 col-form-label"><strong>Vendor:</strong></form:label>
				        <div class="col-md-9">
				            <form:input type="text" path="vendor" class="form-control" />
				            <form:errors path="vendor" class="d-flex justify-content-center text-danger" />
				        </div>
				    </div>
					<!-- Amount Input -->
					<div class="form-group row mx-5 mb-3">
						<form:label path="amount" class="col-md-3 col-form-label"><strong>Amount ($):</strong></form:label>
						<div class="col-md-9">
							<form:input type="number" path="amount" step="0.01" min="0" class="form-control" />
							<form:errors path="amount" class="d-flex justify-content-center text-danger" />
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
					<!-- Submit button -->
					<div class="d-flex justify-content-end mx-5 mb-3">
				  		<input type="submit" value="Submit" class="btn btn-info" type="button" />
					</div>
				</form:form>
			</div>
		</div>
	</body>
</html>