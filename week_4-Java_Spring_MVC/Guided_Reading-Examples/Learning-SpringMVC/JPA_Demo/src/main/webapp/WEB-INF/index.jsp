<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- <link rel="stylesheet" href="/css/style.css"/> -->
		<title>Index</title>
	</head>
	<body>
		<div class="container">
			<h1>Hello World!</h1>
			${book1.title}
			
			<br />
			
			${books}
		</div>
	</body>
</html>