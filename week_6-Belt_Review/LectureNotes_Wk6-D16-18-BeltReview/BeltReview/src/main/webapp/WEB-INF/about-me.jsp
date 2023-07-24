<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>About Me</title>
	</head>
	<body class="bg-primary-subtle">
		<div id="BeltReview_Top" class="bg-dark d-flex justify-content-center pt-3">
			<p class="fs-6 fw-semibold text-secondary">BeltReview • Wk6 Lecture</p>
		</div>
		<div class="container-fluid">
			<!--  -->
			<header id="BeltReview_Header" class="ms-5 mt-3 text-start text-dark">
				<h1 class="fs-2 fw-bold" style="font-family: serif;">
					<a href="/users/home" class="text-decoration-none text-dark">Belt Review</a>
				</h1>
			</header>
			<!-- About Me - Start -->
			<div id="BeltReview_Homepage" class="col-md-10 col-11 mx-auto px-3 py-3 mb-3 bg-white rounded-2 text-center">
				<div id="BeltReview_Nav" class="text-start">
					<div id="Welcome_and_Logout" class="d-flex align-items-center justify-content-between">
						<h2 class="fw-bold">About Me</h2>
						<div class="d-flex align-items-center gap-3">
							<h5>@<c:out value="${currentUser.username}" /></h5>
							<a href="/users/logout" class="btn btn-dark btn-sm">Logout</a>
						</div>
					</div>
					<div id="ReturnToHome" class="d-flex align-items-center justify-content-end mt-2">
						<a href="/users/home" class="text-primary-emphasis text-decoration-none">Back to Home</a>
					</div>
				</div>
				<!--  -->
				<div id="BeltReview_UserInfo" class="text-start">
					<p><strong>Full name</strong>: <c:out value="${currentUser.firstName}" /> <c:out value="${currentUser.lastName}" /></p>
					<p><strong>Your email is</strong>: <c:out value="${currentUser.email}" /></p>
					<p><strong>Your username is</strong>: @<c:out value="${currentUser.username}" /></p>
					<p><strong>Your Password is</strong>: You didn't think we'd actually show it to you, right?</p>
					<p><strong>Date of Birth</strong>: <c:out value="${userDOB}" /> (<c:out value="${age}" /> yrs)</p>
					
					<p class="text-secondary fw-light">Joined: <fmt:formatDate value="${currentUser.createdAt}" pattern="MMMM d, yyyy • HH:mm" /></p>
				</div>
			</div>	
			<!-- About Me - End -->
		</div>
	</body>
</html>