<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">

	<div class="header">
		<h1><c:out value="${showQuestion.question}"/></h1>
		<h3>Tags: <c:forEach items = "${tagsToQuestion}" var="tag">
					<button> <c:out value="${tag.tag}"/></button> 
				  </c:forEach>
		</h3>
	</div>
	<hr>
	<div class="content">
	<table class="table table-striped" border="5" style="width:500px">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${answersToQuestion}" var="answer">
			<tr>
				<td> <c:out value="${answer.answer}"/> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<div class="form">
		<h4>Add your answer:</h4>
		<form class="form-group" action="/questions/addAnswer/${showQuestion.id}" method="POST">
			<label for="answer">Answer: </label>
			<textarea name ="answer" rows="2" cols="25"></textarea>
			<button type="submit">Add</button>
		</form>
		</div>
		<c:forEach items="${error}" var = "err">
			<p style="color:red" >${err}</p>
		</c:forEach>
	</div>

	<div class="footer">
	</div>
</div>
</body>
</html>