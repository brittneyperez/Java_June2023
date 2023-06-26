<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Hopper's Receipt</title>
	</head>
	<body>
		<div class="container">
			<h1><span style="color: grey;">Customer Name:</span> <c:out value="${customerName}" /></h1>
			<div class="item_details">
				<h3><span style="color: grey;">Item Name:</span> <c:out value="${itemName}" /></h3>
				<h3><span style="color: grey;">Price:</span> $<c:out value="${itemPrice}" /></h3>
				<h3><span style="color: grey;">Description:</span> <c:out value="${itemDescription}" /></h3>
				<h3><span style="color: grey;">Vendor:</span> <c:out value="${itemVendor}" /></h3>
			</div>
		</div>
	</body>
</html>