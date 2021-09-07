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
	<h1>Create New Product</h1>
	<hr>
	
	<form:form action="/products/new" method="POST" modelAttribute="product">
		<div class="form-group">	
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
		</div>
		<div class="form-group">	
		<form:label path="description">Description: </form:label>
		<form:errors path="description"/>
		<form:input path="description"/>
		</div>
		<div class="form-group">	
		<form:label path="price">Price: </form:label>
		<form:errors path="price"/>
		<form:input path="price"/>
		</div>
		<button type="submit">Create Product</button>
	</form:form>
		

</div>
</body>
</html>