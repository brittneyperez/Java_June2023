<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Java Form Login</title>
	</head>
	<body>
		<div class="container">
			<h1>Welcome, <c:out value="${email}" />.</h1> 
		</div>
	</body>
</html>