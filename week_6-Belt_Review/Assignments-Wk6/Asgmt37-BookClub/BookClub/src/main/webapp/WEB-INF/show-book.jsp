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
				<!-- <p class="fs-5 fw-medium">A place for friends to share thoughts on books.</p> -->
			</header>
			<div id="BookDetails" class="col-md-10 col-11 mx-auto px-5 py-5 mb-3 bg-white rounded-2">
				<div id="TitleNavBar" class="d-flex align-items-center justify-content-between mb-4">
					<h2 class="fw-bold fst-italic" style="font-family: serif;"><c:out value="${book.title}" /></h2>
					<a href="/book-club/books">Back to Shelves</a>
				</div>
				<div id="BookDetails_UserThoughts">
					<c:choose>							
							<c:when test="${currentUser.id == book.reader.id}">
								<h3>You read <span class="fst-italic" style="color: #483D8B;"><c:out value="${book.title}" /></span> by <span style="color: #006400;"><c:out value="${book.author}" /></span>.</h3>
								<h3>Here are your thoughts:</h3>
							</c:when>
							<c:otherwise>
								<h3><span style="color: #8B0000;"><c:out value="${book.reader.firstName}" /></span> read <span class="fst-italic" style="color: #483D8B;"><c:out value="${book.title}" /></span> by <span style="color: #006400;"><c:out value="${book.author}" /></span>.</h3>
								<h3>Here are <c:out value="${book.reader.firstName}" />'s thoughts:</h3>
							</c:otherwise>
						</c:choose>
					<div id="UserThoughts_TextAreaContainer" class="col-lg-10 col-12 text-start">
						<hr />
						<p><c:out value="${book.thoughts}" /></p>
						<hr />
					</div>
					<div id="TimeDetails_and_ActionBtns" class="d-flex flex-wrap align-items-center justify-content-between col-lg-10 col-12">
						<div class="d-flex flex-md-row flex-column align-items-center align-items-md-start justify-content-md-around" style="font-size:.8rem">
							<p class="text-secondary fw-light">Created: <fmt:formatDate value="${book.createdAt}" pattern="MMMM d, yyyy • HH:mm" /></p>
							<c:choose>
								<c:when test="${not empty book.updatedAt}">
									<p class="text-secondary fw-light ms-1">— Edited: <fmt:formatDate value="${book.updatedAt}" pattern="MMMM d, yyyy • HH:mm" /></p>
								</c:when>
								<c:otherwise>
									<span class="invisible">None</span>
								</c:otherwise>
							</c:choose>
						</div>
						<div id="UserSpecificActions_UpdateDelete" class="d-flex gap-3">
							<c:choose>							
								<c:when test="${currentUser.id == book.reader.id}">
									<a href="/book-club/books/${book.id}/edit" class="btn btn-dark">Edit</a>
									<a href="/book-club/books/${book.id}/delete" class="btn btn-danger">Delete</a>
								</c:when>
								<c:otherwise>
									<span class="invisible">None</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>