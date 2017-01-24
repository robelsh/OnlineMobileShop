<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br />
		<h2>List Of User</h2>
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Age</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${update.users}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.surname}" /></td>
						<td><c:out value="${user.age}" /></td>
						<td><c:url value="/delete" var="url">
								<c:param name="idUser" value="${user.id}" />
							</c:url>
							<button class="btn btn-warning">
								<a href="${url}"> Delete </a>
							</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<hr>
				<br>
		<h3>Add Users</h3>
		<br>
		<form:form method="post" modelAttribute="create" action="create">
			<spring:message code="create.User.name" />
			<br>
			<form:input path="name" />
			<br>
			<br>
			<b><i><form:errors path="name" cssclass="error" /></i></b>
			<br>
			<spring:message code="create.User.surname" />
			<br>
			<form:input path="surname" />
			<b><i><form:errors path="surname" cssclass="error" /></i></b>
			<br>
			<br>
			<spring:message code="create.User.age" />
			<br>
			<form:input path="age" />
			<b><i><form:errors path="age" cssclass="error" /></i></b>
			<br>
			<br>
			<input class="btn btn-warning center" type="submit" value="Add" />
		</form:form>
		<br>
		<hr>
		<br>
		<h3>Update Users</h3>
		<br>
		<form:form method="post" modelAttribute="update" action="update">
			<table class="table table-striped" border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>SURNAME</th>
						<th>AGE</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${update.users}" var="user" varStatus="status">
						<tr>
							<td><c:out value="${user.id}" /><input type="hidden"
								name="users[${status.index}].id" value="${user.id}" /></td>
							<td><input type="text" name="users[${status.index}].name"
								value="${user.name}" /></td>
							<td><input type="text"
								name="users[${status.index}].surname" value="${user.surname}" /></td>
							<td><input type="text" name="users[${status.index}].age"
								value="${user.age}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input class="btn btn-warning" type="submit" value="Update" />
		</form:form>
	</div>
</body>
</html>