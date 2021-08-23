<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="POST" action="/results">
			<div id="view_post">
			 	<label for="name">Your Name:</label>
			    <input type="text" name="name">
			</div>
			
			<div id="view_post">
			 	<label for="location">Dojo Location:</label>
			 	<select name="location">
				  <option selected>Choose Location</option>
				  <option value="San_Jose">San Jose</option>
				  <option value="Chicago">Chicago</option>
				  <option value="Dallas">Dallas</option>
				</select>    
			</div>
			
			<div id="view_post">
			 	<label for="fav_language">Favorite Language:</label>
			    <select name="fav_language">
				  <option selected>Choose Language</option>
				  <option value="Python">Python</option>
				  <option value="Ruby">Ruby</option>
				  <option value="Java">Java</option>
				</select>
			</div>
			
			<div id="comment_post">
			 	<label for="comment" id="comment_label">Comment (optional): </label>
			    <textarea name="comment" rows="8" cols="10"></textarea>
			</div>
		   		    
		    <button>Button</button>
		</form>	
	</div>
</body>
</html>