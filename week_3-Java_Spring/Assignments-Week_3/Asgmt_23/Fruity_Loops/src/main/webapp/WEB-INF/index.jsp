<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- for Bootstrap CSS (latest) -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<!-- My own local CSS -->
		<link rel="stylesheet" type="text/css" href="/css/style.css"/>
		<title>Fruity Loops</title>
	</head>
	<body class="bg-info-subtle">
		<div class="container col-lg-6 bg-white rounded-2 px-3">
			<div id="header" class="text-center mt-3 pt-2">			
				<h1 class="fs-3 fw-bold">Fruit Store</h1>
				<p class="text-secondary">Assignment #23 | CORE</p> 
			</div>
			<!--  -->
			<div id="fruity_table" class="text-center mt-3 pb-3 px-3">
				<table class="table table-hover table-bordered">
					<thead class="table-dark">
						<tr>
							<th>Name</th>
							<th>Price</th>
						</tr>
					</thead>
					<!--  -->
					<c:forEach var="fruit" items="${fruits}">
					<tbody class="bg-light">
						<%-- ${fruits} = will print the fruitsBasket ArrayList of objects --%>
						<tr>
							<!-- 忍者Bonus: Color fruit name orange if fruit starts with "G".  -->
							<c:choose>
								<c:when test="${fruit.name.startsWith('G')}">
									<td><span class="text-warning fw-semibold">${fruit.name}</span></td>
								</c:when>
								<c:otherwise>
									<td>${fruit.name}</td>
								</c:otherwise>
							</c:choose>
							<td>$<fmt:formatNumber value="${fruit.price}" type="number" pattern="#,##0.00" /></td>
						</tr>
					</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>