<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<h1>Welcome, <c:out value="${loggedUser.firstName}"/></h1>
<a href="/logout">Logout</a>
</div>
<hr>
<br>
<br>
<div class="dashbard_content">
	<h4>Here are some of the events in your state:</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${eventsInState}" var="event">
			<tr>
				<td><a href="events/${event.id}"><c:out value="${event.name}"/></a></td> 
				<td><fmt:formatDate type = "date" dateStyle = "long"  value = "${event.eventDate}" /></td>
				<td><c:out value="${event.location}"/></td>
				<td><c:out value="${event.user.firstName}"/></td>
				<c:set value="${loggedUser.id}" var="userId"/>
					<c:if test="${userId==event.user.id}">
						<td> <a href="/events/${event.id}/edit">Edit</a>  <a>Delete</a> </td>
					</c:if>
					<c:if test="${userId!=event.user.id}">
						<c:set  var="user" value="${loggedUser}"></c:set>  
						<c:choose>
							<c:when test='${fn:contains(event.joiners,user)}'>
						        <td> Attending <a href="events/cancel/${event.id}"> Cancel </a></td>
							</c:when>
							<c:otherwise>
						       <td><a href="/events/join/${event.id}">Join</a></td>
							</c:otherwise> 
						</c:choose>
					</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<h4>Here are some of the events outside your state:</h4>
		<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${eventsNotInState}" var="event">
			<tr>
				<td><a href="events/${event.id}"><c:out value="${event.name}"/></a></td> 
				<td><fmt:formatDate type = "date" dateStyle = "long"  value = "${event.eventDate}" /></td>
				<td><c:out value="${event.location}"/></td>
				<td><c:out value="${event.user.firstName}"/></td>
				<c:set value="${loggedUser.id}" var="userId"/>
					<c:if test="${userId==event.user.id}">
						<td> <a href="/events/${event.id}/edit">Edit</a>  <a>Delete</a> </td>
					</c:if>
					<c:if test="${userId!=event.user.id}">
						<c:set  var="user" value="${loggedUser}"></c:set>  
						<c:choose>
							<c:when test='${fn:contains(event.joiners,user)}'>
						        <td> Attending <a href="events/cancel/${event.id}"> Cancel </a></td>
							</c:when>
							<c:otherwise>
						       <td><a href="/events/join/${event.id}">Join</a></td>
							</c:otherwise> 
						</c:choose>
					</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<hr>

	<h4>Create an Event</h4>
	<form:form action="/events/create" method="POST" modelAttribute="event" style="width:300px">
		<div class="mb-3">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input class="form-control" type="text" path="name"/>
		</div>
		<div class="mb-3">
			<form:label path="eventDate">Date</form:label>
			<form:errors path="eventDate"/>
			<form:input class="form-control"  type="Date" path="eventDate"/>
		</div>
		<div class="mb-3">
			<form:label path="location">Location</form:label>
			<form:errors path="location"/>
			<form:input class="form-control" type="text" path="location"/>
			<form:select path="state">
	        	<form:option value="AL">AL</form:option>
				<form:option value="AK">AK</form:option>
				<form:option value="AZ">AZ</form:option>
				<form:option value="AR">AR</form:option>
				<form:option value="CA">CA</form:option>
				<form:option value="CO">CO</form:option>
				<form:option value="CT">CT</form:option>
				<form:option value="DE">DE</form:option>
				<form:option value="DC">DC</form:option>
				<form:option value="FL">FL</form:option>
				<form:option value="GA">GA</form:option>
				<form:option value="HI">HI</form:option>
				<form:option value="ID">ID</form:option>
				<form:option value="IL">IL</form:option>
				<form:option value="IN">IN</form:option>
				<form:option value="IA">IA</form:option>
				<form:option value="KS">KS</form:option>
				<form:option value="KY">KY</form:option>
				<form:option value="LA">LA</form:option>
				<form:option value="ME">ME</form:option>
				<form:option value="MD">MD</form:option>
				<form:option value="MA">MA</form:option>
				<form:option value="MI">MI</form:option>
				<form:option value="MN">MN</form:option>
				<form:option value="MS">MS</form:option>
				<form:option value="MO">MO</form:option>
				<form:option value="MT">MT</form:option>
				<form:option value="NE">NE</form:option>
				<form:option value="NV">NV</form:option>
				<form:option value="NH">NH</form:option>
				<form:option value="NJ">NJ</form:option>
				<form:option value="NM">NM</form:option>
				<form:option value="NY">NY</form:option>
				<form:option value="NC">NC</form:option>
				<form:option value="ND">ND</form:option>
				<form:option value="OH">OH</form:option>
				<form:option value="OK">OK</form:option>
				<form:option value="OR">OR</form:option>
				<form:option value="PA">PA</form:option>
				<form:option value="RI">RI</form:option>
				<form:option value="SC">SC</form:option>
				<form:option value="SD">SD</form:option>
				<form:option value="TN">TN</form:option>
				<form:option value="TX">TX</form:option>
				<form:option value="UT">UT</form:option>
				<form:option value="VT">VT</form:option>
				<form:option value="VA">VA</form:option>
				<form:option value="WA">WA</form:option>
				<form:option value="WV">WV</form:option>
				<form:option value="WI">WI</form:option>
				<form:option value="WY">WY</form:option>
	        </form:select>
		</div>
		<input type="submit" value="Create"/>
	</form:form>

</div>
<br>
<div class="footer">

</div>
	
</div>
</body>
</html>