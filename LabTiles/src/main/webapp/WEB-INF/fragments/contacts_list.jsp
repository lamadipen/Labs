<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>All Contacts</h2>
<table border="1">
	<c:forEach var="contact" items="${contactlist}">
		<tr>
			<td>${contact.firstname}</td>
			<td>${contact.lastname}</td>
		</tr>
	</c:forEach>
</table>