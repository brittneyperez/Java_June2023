<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- for Bootstrap CSS -->
		<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
		
		<!-- YOUR own local CSS and JS-->
		<link rel="stylesheet" type="text/css" href="/css/style.css"/>
		<!-- <script type="text/javascript" src="/js/app.js"></script> -->
		
		<!-- For any Bootstrap that uses JS -->
		<!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
		<title>Display Date & Time</title>
	</head>
	<body>
		<div class="container">
			<div id="header" class="text-center mt-3">			
				<h1 class="fw-bold" id="page_title">Display Date & Time</h1>
				<p class="text-secondary">Assignment #22 - Practice</p> 
			</div>
			
			<div id="date_time_links" class="d-flex justify-content-evenly mt-5">
				<a href="/home/date">
					<h3><span id="link_icon" class="me-2">🗓</span>️Display Date</h3>
				</a>
				<a href="/home/time">
					<h3><span id="link_icon" class="me-2">⏰</span>Display Time</h3>
				</a>
			</div>
			
		</div>
	</body>
</html>