<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="myres/css/mystyle.css" rel="stylesheet">
</head>
<body>
	<div class="login-page ">

		<form:form modelAttribute="product" method="post">
			<form:errors path="*" element="div"/>
			<div class="form-group">
				<label for="Product ID:">Product ID:</label>
				<form:input path="productId" cssClass="form-control" />
				<form:errors path="name" cssStyle="color: #ff0000;"/>
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Product Name:</label>
				<form:input path="name" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Description:</label>
				<form:textarea path="description" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Unit Price:</label>
				<form:input path="unitPrice" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Manufacturer:</label>
				<form:input path="manufacturer" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Units In Stock:</label>
				<form:input path="unitsInStock" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Category:</label>
				<form:input path="category" cssClass="form-control" />
			</div>


			<div class="form-group">
				<label for="exampleInputName2">Discontinued:</label>
				<form:checkbox path="discontinued" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Condition:</label>
				<form:radiobutton path="condition" value="New"
					cssClass="form-control" />
				New
				<form:radiobutton path="condition" value="Old"
					cssClass="form-control" />
				Old
				<form:radiobutton path="condition" value="Refurbished"
					cssClass="form-control" />
				Refurbished
			</div>
			<div class="form-group">
				<input type="submit" value="Add" class="btn btn-success" />
			</div>
		</form:form>

	</div>
</body>
</html>