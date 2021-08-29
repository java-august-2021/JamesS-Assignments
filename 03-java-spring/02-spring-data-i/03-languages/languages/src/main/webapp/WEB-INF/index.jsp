<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Language Table</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
	
		<div class="container">
			<table class="table table-striped">
				<thead>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</thead>
				<tbody>			
				<c:forEach items="${allTheLanguages}" var="language">
				<tr>
				<td><a href="/languages/${language.id}">${language.name}</a></td>
					<td>${language.creator}</td>
					<td>${language.version}</td>
					<td class="action_row"><form action="/languages/${language.id}/delete" method="POST">
					    <input type="hidden" name="destroy" value="delete">
					    <input type="submit" value="Delete">
						</form>
						<a href="/languages/${language.id}/edit">edit</a>
					</td>
					
				</tr>
				</c:forEach>
				</tbody>	
			</table> 
			
			<hr>
			
			<form:form method = "POST" action="/languages" modelAttribute="language">
			<div class="form">
				<div class="mb-3">
					<form:label path="name">Name</form:label>
					<form:errors path="name"></form:errors>
					<form:input path="name" type="text"/>
				</div>
				<div class="mb-3">
					<form:label path="creator">Creator</form:label>
					<form:errors path="creator"></form:errors>
					<form:input path="creator" type="text"/>
				</div>
				<div class="mb-3">
					<form:label path="version">Version</form:label>
					<form:errors path="version"></form:errors>
					<form:input path="version" type="float"/>
				</div>
			</div>
			<button type="submit">Submit</button>
			</form:form>	
		</div>	
		
	</body>
</html>