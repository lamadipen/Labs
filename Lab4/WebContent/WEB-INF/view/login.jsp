<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="myres/css/mystyle.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="res/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="login" method="post">
				<input type="text" placeholder="username" name="username"
					value="${cookie.USERNAME.value}" /> <input type="password"
					placeholder="password" name="password" />

				<button type="submit">login</button>
				<label>Remember Me</label> <input type="checkbox" name="remember"
					<c:if test="${cookie.containsKey('USERNAME')}">checked</c:if>>

				<p class="message">${err_msg}</p>
			</form>
		</div>
	</div>
</body>



</html>