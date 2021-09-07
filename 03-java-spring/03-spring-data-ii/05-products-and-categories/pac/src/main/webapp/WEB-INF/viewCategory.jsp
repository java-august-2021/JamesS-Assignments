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
	<h1><c:out value="${categoryView.name}"/></h1>
	<hr>
	<h2>Products: </h2>
	<c:forEach items="${categoryView.products}" var="product">
		<p>- ${product.name}</p>
	</c:forEach>
	<hr>
	<div class=form-group>
		<form action="/categories/add/${categoryView.id}" method="POST">
			<label for="products"> Add Product</label>
			<select name="products">
			<c:forEach items="${productsAvailable}" var="product">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
			</select>
			<button type="submit">Add</button>
		</form>		
	</div>
</div>

</body>
</html>