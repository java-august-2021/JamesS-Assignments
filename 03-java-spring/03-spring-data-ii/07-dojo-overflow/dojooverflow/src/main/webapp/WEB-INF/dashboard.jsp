<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">

	<div class="header">
	<h1>Questions Dashboard</h1>
	</div>
	<hr>
	<div class="content">
		<table class="table table-striped" border="5">
			<thead>
				<tr>
					<th>Questions</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questions}" var="question">
	        <tr>
	            <td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
	            <td>
	            <c:forEach items = "${question.tags}" var="tag" varStatus="loop">
	            	<c:out value="${tag.tag}"/>
	            	<c:if test="${!loop.last}">,</c:if>
	            </c:forEach> 
	            </td>           
	            
	        </tr>
        	</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="footer">
	</div>
</div>
</body>
</html>