<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/style.css"/>
		<title>Current Visit Count</title>
	</head>
	<body>
		<div class="container">
			<h2>You have visited <a href="/my_server">localhost:8080/my_server</a> <c:out value="${count}" /> times.</h2>
			<p><a href="/my_server">Test another visit?</a></p>
		</div>
	</body>
</html>