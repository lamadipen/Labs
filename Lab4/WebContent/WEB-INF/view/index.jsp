<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>List of Products</title>
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
</head>
<body>
	<div class="row">
		<div class="page-header">
			<h1 style="margin-left:20px;" ><spring:message code="listProduct.form.title.label"/></h1>
			<a href="?locale=en">English</a>|
			<a href="?locale=jp">Japanese</a>
		</div>
	</div>

	<c:forEach items="${products}" var="product">
		<div class="col-sm-4">
			<div class="thumbnail">
				<a href="getProduct/${product.productId}">
					<h3>${product.name}</h3>
				</a>
				<p>
					<strong>${product.unitPrice}USD</strong>
				</p>
				<p>${product.description}</p>
				<p>Availabe ${product.unitsInStock} units in stock</p>
				<a class="btn btn-danger" href="deleteProduct/${product.productId}">Delete</a>
				<a class="btn btn-warning" href="editProduct/${product.productId}">Edit</a>
			</div>
		</div>
	</c:forEach>

</body>
</html>
