<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		
		<!-- YOUR own local CSS -->
		<!-- <link rel="stylesheet" href="/css/style.css"/> -->
		
		<!-- For any Bootstrap that uses JS -->
		<!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
		<script type="text/javascript" src="/js/template.js"></script>
		<title>Time</title>
	</head>
	<body>
		<div class="container">
			<div id="header" class="text-center mt-3">			
				<h1 class="fw-bold">Display Date & Time</h1>
				<p class="text-secondary">Assignment #22 - Practice</p> 
			</div>
			
			<div id="date_time_links" class="mt-5">
				<h3 class="d-flex justify-content-center text-secondary">Current Time</h3>
				<h4 class="d-flex justify-content-center"><c:out value="${time}" /></h4>
			</div>
		</div>
	</body>
</html>