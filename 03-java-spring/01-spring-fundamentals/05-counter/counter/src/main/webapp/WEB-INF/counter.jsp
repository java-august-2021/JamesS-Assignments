<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>
<h3>You have visited this site <c:out value="${countToShow}"/> times.</h3>
<a href="/">Test another visit?</a>
<p></p>
<a href="/reset">Reset Counter</a>
</body>
</html>