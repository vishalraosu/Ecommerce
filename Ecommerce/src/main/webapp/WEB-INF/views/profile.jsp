<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<div align="right">
	<form action="editProfile" method="post">
		<input type="submit" value="Edit Profile">

	</form>
</div></head>
<body  bgcolor="#f0f5f5">
	<h1>User Profile</h1>
	<table border="2" width="70%" cellpadding="2">
		<c var="user" items="${user}"> <b>UserID:</b> ${user.id}</br>
		<b>First Name</b> ${user.firstName}</br>
		<b>Last Name</b> ${user.lastName}</br>
		<b>Email_id </b> ${user.emailId}</br>
		<b>Gender</b> ${user.gender}</br>
		<b>ContactNumber</b> ${user.contactNumber}</br>
		<b>Password</b> ${user.password}</br>
		<b>Street</b> ${user.street}</br>
		<b>City</b> ${user.city}</br>
		<b>State</b> ${user.state}</br>
		<b>zipcode</b> ${user.zipcode}</br>
		</c>
	</table>
</body>
</html>