<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Product Detail Page</title>
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="row">
		<div class="page-header">
			<h1 style="margin-left:20px;" >${product.name} Detail Page</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
				<ul class="list-group">
					<li  class="list-group-item"><a>Home</a></li>
					<li  class="list-group-item"><a>Products</a></li>
				</ul>
		</div>
		<div class="col-md-4" style="background-color: lavender;">
			<h2>${product.name}</h2>
			<h3>${product.description}</h2>
			<h3>${product.unitPrice}</h2>
			<form action="/Lab2/processOrder" method="post">
				<input type="hidden" name="productId" value="${product.productId}">
				<label>Quantity</label> <input type="text" name="quantity">
				<input type="submit" value="Order">
			</form>
		</div>
	</div>
</body>
</html>
