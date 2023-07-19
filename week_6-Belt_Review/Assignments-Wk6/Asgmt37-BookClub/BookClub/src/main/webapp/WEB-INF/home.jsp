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
		<div id="BookClub_Header" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-bold text-secondary">BookClub • #37 CORE</p>
		</div>
		<div class="container-fluid">
			<!--  -->
			<header id="BookClub_Header" class="ms-5 my-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">
					<a href="/book-club/books" class="text-decoration-none text-dark">本棚 Hondana Book Club</a>
				</h1>
			</header>
			<div id="BookClub_AllBookList" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="AllBookList_Nav" class="text-start">
					<div id="Welcome_and_Logout" class="d-flex align-items-center justify-content-between">
						<h2 class="fw-bold">Welcome, <c:out value="${currentUser.firstName}" />.</h2>
						<div class="d-flex align-items-center gap-4">
							<h4>@<c:out value="${currentUser.username}" /></h4>
							<a href="/book-club/logout" class="btn btn-danger">Logout</a>
						</div>
					</div>
					<div id="PageDesc_and_AddPage" class="d-flex align-items-center justify-content-between">
						<c:choose>
							<c:when test="${empty books}">
								<span class="invisible">None</span>
							</c:when>
							<c:otherwise>
								<p>Books from everyone's shelves.</p>
							</c:otherwise>
						</c:choose>
						<a href="/book-club/books/new">+ Add Book to Bookshelf</a>
					</div>
				</div>
				<c:choose>
					<c:when test="${empty books}">
						<p class="d-flex justify-content-center">There are currently no books registered at the moment.</p>
					</c:when>
					<c:otherwise>
						<table class="mt-1 table table-hover table-striped table-bordered">
							<thead class="table-dark">
								<tr>
									<th>id</th>
									<th>Title</th>
									<th>Author</th>
									<th>Posted By</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="thisBook" items="${books}">
									<tr>
										<td><c:out value="${thisBook.id}" /></td>
										<td><a href="/book-club/books/${thisBook.id}" class="text-decoration-none fst-italic"><c:out value="${thisBook.title}" /></a></td>
										<td><c:out value="${thisBook.author}" /></td>
										<td>@<c:out value="${thisBook.reader.username}" /></td>
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