<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>All Books</title>
	</head>
	<body class="bg-info-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">	
			<header class="text-center mb-3">
				<h1 class="fs-3 fw-bold">All Books</h1>
				<p class="text-secondary">Assignment #29 | PRACTICE</p>			
			</header>
			<!--  -->
			<table class="table table-hover table-bordered text-center">
				<thead class="table-dark">
					<tr>
						<th>id</th>
						<th>Title</th>
						<th>Language</th>
						<th># Pages</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr >
							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/${book.id}" class="text-info-emphasis"><c:out value="${book.title}" /></a></td>
							<td><c:out value="${book.language}" /></td>
							<td><c:out value="${book.numberOfPages}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</body>
</html>