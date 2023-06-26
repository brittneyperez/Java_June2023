<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>W3D9 | Counter</title>
	</head>
	<body>
		<div class="container">
			<h1>Hello ${currentUser}</h1>
			<h3>Current Count is: 
				<c:out value="${count}" />
			</h3>
			<p>Note: For <strong>action attribute</strong> in forms, we need to define the route we want this form to POST to.</p>
			<form action="/counting/clear" method="POST">
				<input type="submit" value="Clear Session" />
			</form>
			
			<div>
				<h3>Add Player | Form</h3>
				<c:out value="${amountError}" />
				<form action="/counting/increment/${userId}" method="POST" <%-- //* ② Flow of Data: the userId attribue can be accessed here, and is passed in through the form's action to post route --%>>
					<label>Player Name:</label>
					<input type="text" name="playerName" />
					<label>Amount to Increment:</label>
					<input type="number" name="amount" />
					<input type="submit" value="Count By This" />
				</form>
			</div>
		</div>
	</body>
</html>