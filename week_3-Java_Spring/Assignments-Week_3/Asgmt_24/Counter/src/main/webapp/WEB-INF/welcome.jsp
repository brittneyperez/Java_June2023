<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <link rel="stylesheet" href="/css/style.css"/>
	    <title>Welcome</title>
	</head>
	<body>
	<div class="container">
	    <c:choose>
			<c:when test="${count == null || count < 1}">
				<h1>Welcome User!</h1>
			</c:when>
			<c:otherwise>
				<h1>Welcome back, User!</h1>
			</c:otherwise>
		</c:choose>
	    <p><a href="/my_server/counter">Go back to counter page.</a></p>
	    <p><a href="/my_server/counter2">Increment counter by 2.</a></p>
	    <a href="/my_server/reset"><button>Reset Counter.</button></a>
	</div>
	</body>
</html>
