<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="myres/css/mystyle.css" rel="stylesheet">
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="login-page">
		<h1>Welcome ${actor.username}</h1>
		<p>${message}</p>
		<br> <a href="logout" class="btn btn-warning">logout</a>
	</div>
</body>
</html>