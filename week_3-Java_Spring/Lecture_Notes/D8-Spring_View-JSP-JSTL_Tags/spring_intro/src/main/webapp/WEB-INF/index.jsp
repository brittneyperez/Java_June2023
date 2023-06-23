<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>First JSP</title>
	</head>
	<body>
		<h1>Hello World!!!</h1>
		<h2><c:out value="${pizza}"/></h2>
		<h2><c:out value="${dfpizza}"/></h2>
		
<!-- 		Loop Through Pizzas -->
		<h1>Pizza Menu from ArrayList</h1>
		
		<c:forEach var="pizzaMenu" items="${allPizzas}">
<%-- 			<h2>${pizzaMenu}</h2> --%>
			<c:choose>
				<c:when test="${pizzaMenu.equals('Hawaiian')}">
					<p>Maybe we can leave this flavor out...</p>
				</c:when>
				<c:otherwise>
					<h2>${pizzaMenu}</h2>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</body>
</html>