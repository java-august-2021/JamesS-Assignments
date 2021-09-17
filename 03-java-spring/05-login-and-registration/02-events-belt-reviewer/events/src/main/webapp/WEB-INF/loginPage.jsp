<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
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
	<h1>Welcome</h1>
</div>

<hr>

<div class="content">

    <div class = "registration_form">
    
    <form:form method="POST" action="/registration" modelAttribute="user" style="width:400px">
    	<fieldset style="border: solid; border-width: thin; padding:25px; border-radius:5px">
   		<legend style="color:green">-Register-</legend>
	    	<div class="mb-3">
		   		<form:label path="firstName">First Name:</form:label>
		   		<form:errors path="firstName"/>
		        <form:input class="form-control" type="text" path="firstName"/>
		   	</div>
	    	<div class="mb-3">
		   		<form:label path="lastName">Last Name:</form:label>
		   		<form:errors path="lastName"/>
		        <form:input class="form-control" type="text" path="lastName"/>
		   	</div>
		    <div class="mb-3">
		   		<form:label path="email">Email:</form:label>
		   		<form:errors path="email"/>
		        <form:input class="form-control" type="email" path="email"/>
		   	</div>
		   	<div class="mb-3">
		   		<form:label path="location">Location:</form:label>
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
		    <div class="mb-3">
		    	<form:label path="password">Password:</form:label>
		    	<form:errors path="password"/>
		        <form:password class="form-control" path="password"/>
		    </div>
		    <div class="mb-3">
		    	<form:label path="passwordConfirmation">Password Confirmation:</form:label>
		    	<form:errors path="passwordConfirmation"/>
		        <form:password class="form-control" path="passwordConfirmation"/>
		    </div>
		    <input type="submit" value="Register"/>
    	</fieldset>
    </form:form>
        <p style="color:red"><form:errors path="user.*"/></p>
    
    </div>
    
   	<div class="login_form">
   	
   		<p><c:out value="${error}"/></p>
	
    <form method="post" action="/login" style="width:400px">
    <fieldset style="border: solid; border-width: thin; padding:25px; border-radius:5px">
    <legend style="color:green">-Login-</legend>
	    <div class="mb-3">
	     	<label for="email">Email</label>
	        <input class="form-control" type="text" id="email" name="email"/>
	    </div>
	    <div class="mb-3">
	    	<label for="password">Password</label>
	        <input class="form-control" type="password" id="password" name="password"/>
	    </div>
	    <input type="submit" value="Login"/>
 	</fieldset>   
    </form>  
   	</div>
</div>

<div class="footer">
</div>
	
</div>
</body>
</html>