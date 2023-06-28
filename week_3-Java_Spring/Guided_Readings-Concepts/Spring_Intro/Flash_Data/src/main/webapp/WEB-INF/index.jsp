<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Forms in Java</title>
	</head>
	<body>
		<div class="container">
			<h1>Login</h1>
			<p><c:out value="${error}" /></p>
			<form action="/login" method="POST">
				<label>Email:</label>
				<input type="text" name="email" />
				<label>Password:</label>
				<input type="password" name="password" />
				
				<input type="submit" value="Log In" />
			</form> 
		</div>
	</body>
</html>