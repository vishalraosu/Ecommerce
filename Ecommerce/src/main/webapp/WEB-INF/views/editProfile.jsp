<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<title>Person Page</title>

<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>

<body bgcolor="#f0f5f5">
	<a href="index.jsp"><h4>Home</h4></a>

	<h1>User Details</h1>
	<form:form action="editdata/${user.id}/" modelAttribute="user" method="put">
		<table>

			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr>

			<tr>
				<td><form:label path="firstName">
						<spring:message text="First Name" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="Last Name" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="emailId">
						<spring:message text="Email ID" />
					</form:label></td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td><form:label path="gender">
						<spring:message text="Gender" />
					</form:label></td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber">
						<spring:message text="Contact Number" />
					</form:label></td>
				<td><form:input path="contactNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="street">
						<spring:message text="Street" />
					</form:label></td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message text="City" />
					</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state">
						<spring:message text="State" />
					</form:label></td>
				<td><form:input path="state" /></td>
			</tr>

			<tr>
				<td><form:label path="zipcode">
						<spring:message text="ZipCode" />
					</form:label></td>
				<td><form:input path="zipcode" /></td>
			</tr>
			<tr>
			</tr>
			<tr align="center">
				<td colspan="2"><c> <input type="submit"
						value="<spring:message text="Save"/>" /> </c></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>User List</h3>
	<c>
	<table class="tg">
		<tr>
			<th width="80">User ID</th>
			<th width="80">First Name</th>
			<th width="80">Last Name</th>
			<th width="80">Email ID</th>
			<th width="80">Gender</th>
			<th width="80">Contact Number</th>
			<th width="80">Password</th>
			<th width="80">Street</th>
			<th width="120">City</th>
			<th width="120">State</th>
			<th width="80">ZipCode</th>
		</tr>
		<c items="${user}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.emailId}</td>
			<td>${user.gender}</td>
			<td>${user.contactNumber}</td>
			<td>${user.password}</td>
			<td>${user.street}</td>
			<td>${user.city}</td>
			<td>${user.state}</td>
			<td>${user.zipcode}</td>
		</tr>
		</c>
	</table>
	</c>
</body>
</html>
