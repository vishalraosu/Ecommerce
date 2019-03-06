<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<title>Login</title>

</head>

<%@include file="include\header.jsp"%>

<body bgcolor="#f0f5f5">
	<c:if test="${!empty message}">
		<br>
		<center>
			<font color="red">${message}</font>
		</center>
		<br>
	</c:if>
	<table align="left">
		<div align="center">
			<form action="login" method="post">

				<legend>
					<h1 style="color: black;">Login</h1>
				</legend>
				<label><b> <font face="verdana">Email-ID:</font>
				</b></label> <br /> 
				<input type="email" size="45" placeholder="Enter Email ID"name="emailId" required> <br> 
				<label><b><font	face="verdana">Password:</font></b></label> <br> 
				<input type="password" size="45" placeholder="Enter Password" name="Password"
					maxlength="12" required> <br> <br> <br> 
					<input id="submit" type="submit" value="Login">
			</form>
			<br> <br> <a href="register"><b>New User Register</b></a> <br />
		</div>
	</table>
	<div>
		<center>
			<%@include file="include\footer.jsp"%>
		</center>
	</div>
</body>
</html>