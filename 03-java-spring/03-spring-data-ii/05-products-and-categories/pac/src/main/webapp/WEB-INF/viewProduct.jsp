<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<h1><c:out value="${productView.name}"/></h1>
	<hr>
	<h2>Categories: </h2>
	<c:forEach items="${productView.categories}" var="category">
		<p>- ${category.name}</p>
	</c:forEach>
	
	<hr>
	<div class=form-group>
		<form action="/products/add/${productView.id}" method="POST">
			<label for="categories"> Add Category</label>
			<select name="categories">
			<c:forEach items="${categoriesAvailable}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
			</select>
			<button type="submit">Add</button>
		</form>
	</div>
</div>

</body>
</html>