<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src=“js/app.js”></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src=“/webjars/bootstrap/js/bootstrap.min.js”></script>
</head>
<body>
<div class="container">

<div class="header">
<h1><c:out value="${event.name}"/></h1>
</div>
<hr>
<br>
<div class="showEvent_content" style="display:flex; justify-content: space-around">
	<div class="content_left">
		<div class="event_info">
		<p>Host: <c:out value="${event.user.firstName}"/> <c:out value="${event.user.lastName}"/></p>
		<p>Date: <fmt:formatDate type = "date" dateStyle = "long"  value = "${event.eventDate}" /></p>
		<p>Location: <c:out value="${event.location}"/>, <c:out value="${event.state}"/></p>
		<p>People who are attending: <c:out value="${event.joiners.size()}"/></p>
		
		</div>
		
		<div class="event_table">
		<table class="table table-striped" style="width:350px; border-style:solid; border-color:black">
			<thead>
				<tr>
					<th>Name</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allJoiners}" var="joiner">
				<tr>
					<td><c:out value="${joiner.firstName}"/> <c:out value="${joiner.lastName}"/></td>
					<td><c:out value="${joiner.location}"/></td>
				</tr>
			</c:forEach>
			</tbody>
			
		</table>
		
		</div>
	</div>
	<div class="content_right" style="display:flex; flex-direction: column; align-content: flex-start;">
		<h2>Message Wall</h2>
		
		
		<div class="message_wall" style="border-style:solid; border-color:black; width:350px; height:400px; padding:10px; overflow-y: scroll">
			<c:forEach items="${allMessages}" var="message">
				<br>
				<p><c:out value="${message.user.firstName}"/> says: <c:out value="${message.message}"/></p>
				<p>-------------------------------------</p>
				<br>
			</c:forEach>
		</div>
		
		
		<br>
		
		
		<div class="message_form">
		<form action="/events/message/create/${event.id}" method="POST">
		<label for="message">Add Comment:</label>
		<input name="message" type="text">
		<button type="submit">Comment</button>
		</form>
		</div>
	</div>
	
</div>

<div class="footer">
</div>
	
</div>
</body>
</html>