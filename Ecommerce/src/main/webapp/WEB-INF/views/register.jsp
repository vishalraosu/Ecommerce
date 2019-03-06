<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign-Up</title>
<script>
function onSubmit() {
alert("Registration Successful \n Login to Access Your Profile");
}
</script>
</head>
<%@include file="include\header.jsp"%>

<body bgcolor="#f0f5f5">
	<div align="center">
		<form action="signUp" method="post">

			<fieldset style="width: 280px; border-color: black">
				<legend>
					<h1 style="color: black;">SignUp</h1>
				</legend>

				<label><b>First Name:</b></label> <br> <input type="text"
					size="30" name="FirstName" placeholder="Enter FirstName" required><br>
				<label><b>Last Name:</b></label> <br> <input type="text"
					size="30" name="LastName" placeholder="Enter LastName" required><br>
				<label><b>Email-Id:</b></label> <br> <input type="email"
					size="30" name="EmailId" placeholder="Enter E-Mail" required><br>
				<br> <label><b>Gender:</b></label> <input type="radio"
					name="Gender" value="male">Male <input type="radio"
					name="Gender" value="female">Female<br> <br> <label><b>Contact
						No:</b></label> <br> <input type="text" size="30" name="contactNumber"
					placeholder="Enter Phone_No" required><br> <label><b>Password:</b></label>
				<br> <input type="password" size="30" name="Password"
					placeholder="Enter Password" required> <br>
				<lable> <b>Enter Address</b></lable>
				<br> <label><b>Street:</b></label> <br> <input type="text"
					size="30" name="street" placeholder="Enter street" required><br>
				<label><b>City:</b></label> <br> <input type="text" size="30"
					name="city" placeholder="Enter city" required> <br> <label><b>State:</b></label>
				<br> <input type="text" size="30" name="state"
					placeholder="Enter state" required><br> <label><b>Zipcode:</b></label>
				<br> <input type="text" size="30" name="zipcode"
					placeholder="Enter zipcode" required> <br> <br><label>
					<input id="submit" type="submit" value="Register" OnClick="onSubmit()">
				</label> <label> <input id="reset" type="reset" value="Reset" ></label>
			</fieldset>
		</form>

	</div>
	<center>
		<%@include file="include\footer.jsp"%>
	</center>
</body>
</html>