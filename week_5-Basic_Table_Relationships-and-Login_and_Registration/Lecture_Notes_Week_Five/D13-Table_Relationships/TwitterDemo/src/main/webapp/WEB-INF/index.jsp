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
		<title>Twitter Demo</title>
	</head>
	<body class="bg-primary-subtle">
		<div class="container col-lg-8 bg-white rounded-2 py-3 px-3 mt-3">		
			<header id="Twitter_Demo__Header" class="d-flex justify-content-around mb-3">
				<span class="invisible">Placeholder</span>
				<h3 class="fs-6 fw-bold text-secondary">TwitterDemo <span>•</span> Week 4 LectureCode</h3>
				<span class="invisible">Placeholder</span>
			</header>
			<!--  -->
			<div id="Twitter_Demo__Form" class="text-center">
				<h1>Welcome to TwitterDemo</h1>
				<%-- FOR TESTING PURPOSES--DO NOT INCLUDE! <h6>Current User: <c:out value="${loggedInUser}" /></h6> --%>
				<!--  -->
				<form:form action="/tweets/post" method="post" modelAttribute="newTweet">
					<%-- FOR TESTING PURPOSES--DO NOT INCLUDE! <form:hidden path="creator" value="${loggedInUser}" /> --%>
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
						<input type="submit" value="Post" class="btn btn-primary" />
					</div>
				</form:form>
			</div>
			<!--  -->
			<div id="Twitter_Demo__All_Tweets" class="text-center">
				<h2 class="fs-2 fw-bold">All Tweets</h2>
				<table class="table table-hover table-bordered mt-3">
					<thead class="table-dark">
						<tr>
							<th>id</th>
							<th>Tweet</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="singleTweet" items="${tweets}">
							<tr>
								<td><c:out value="${singleTweet.id}" /></td>
								<td>
									<c:out value="${singleTweet.tweetContent}" /><br />
									<hr style="width:250px" class="mx-auto" />
									<div class="d-flex align-items-center justify-content-around" style="font-size:.8rem">
										<p class="text-secondary fw-light"><fmt:formatDate value="${singleTweet.createdAt}" pattern="HH:mm • MM/dd/yy" /></p>
										<c:choose>
											<c:when test="${not empty singleTweet.updatedAt}">
												<p class="text-secondary fw-light">Edited: <fmt:formatDate value="${singleTweet.updatedAt}" pattern="HH:mm • MM/dd/yy" /></p>
											</c:when>
											<c:otherwise>
												<span class="invisible">None</span>
											</c:otherwise>
										</c:choose>
										<p>Posted By: @<c:out value="${singleTweet.creator.firstName}" />_<c:out value="${singleTweet.creator.lastName}" /> #<c:out value="${singleTweet.imaginaryIntAtt}" /></p>
									</div>
									
								</td>
								<td class="d-flex flex-column align-items-center justify-content-around mt-4">
									<a href="/tweets/${singleTweet.id}/edit">Edit</a>
									<a href="/tweets/${singleTweet.id}/delete" class="btn btn-danger btn-sm">Delete</a>
									<!-- <form action="/tweets/${singleTweet.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete" />
										<input type="submit" class="btn btn-danger btn-sm" value="Delete" />
									</form> -->
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>