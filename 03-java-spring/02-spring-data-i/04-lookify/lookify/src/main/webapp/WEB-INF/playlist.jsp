<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Playlist</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<div class="headers">
		<h5>Songs by artist: <c:out value="${search}"/></h5>
		<form action="/search" method="POST">
			<input type="text" name="search">
			<button type="submit">Search Artists</button>
		</form>
		<a href="/dashboard">Dashboard</a>
	</div>
	<hr>
	<div class="content">
		<table class="table table-striped">
			<thead>
				<th>Title</th>
				<th>Rating</th>
				<th>Action</th>
			</thead>
			<tbody>		
			<c:forEach items="${artistSongs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td>
						<form action="/${song.id}/delete" method="POST">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>	
			</tbody>	
		</table>
	</div>

</div>

</body>
</html>