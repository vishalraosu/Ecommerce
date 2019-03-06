<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>About US</title>
<style>
tr:hover {
	background-color: #e6eeff;
}
</style>
</head>
<body bgcolor="#f0f5f5">
	<%@include file="include/header.jsp"%>
	<div>
		<marquee behavior="alternate" scrollamount="5" onmouseover="stop()"
			onmouseout="start()">
			<table>
				<tr>
					<td style="font-size: 25px; color: red">Members of the Team:</td>
					<td></td>
					<td style="font-size: 21px; color: green">Mentor: Manoj, Adi &
						Surender</td>
					<br>
					<td></td>
					<td style="font-size: 21px; color: blue">Vishal,</td>
					<td></td>
					<td style="font-size: 21px; color: blue">Shreyas,</td>
					<td></td>
					<td style="font-size: 21px; color: blue">Milan,</td>
					<td></td>
					<td style="font-size: 21px; color: blue">DheenChand</td>
					<td></td>
					<td style="font-size: 21px; color: blue">&</td>
					<td style="font-size: 21px; color: blue">Arka</td>
				</tr>
			</table>
		</marquee>
	</div>
	<div>
		<img src="Images/AboutUs/abt.png" alt="AboutUs">
	</div>
	<div>
		<p style="color: black">This section gives an overview of Fashion
			World, its businesses, values and commitment, and its management. It
			also gives details of its long and illustrious history, and the
			personalities who founded and enriched it</p>
	</div>
	<div align="center">
		<h2 align="center">Fashion World Team</h2>
		<img src="Images/AboutUs/about.png" alt="img"> <br> <img
			src="Images/AboutUs/about-us.png" alt="img">
	</div>
	<div align="center">
		<h2>Don't Forget to Share your Knowledge with Us</h2>
		<img alt="img" src="Images/AboutUs/sharing-2.jpg"><br> <br>
		<img alt="img" src="Images/AboutUs/logoviolet.png" width="822"
			height="333">
	</div>
	<div align="center">
		<form action="feedback" method="post">
			<table align="center">
				<tr align="center">
					<td>Email Id:<input type="email" name="emailId" maxlength="24"
						size="25" required></td>
				</tr>
				<tr align="center">
					<td>Feedback: <br> <textarea rows="2" cols="60"
							name="message" maxlength="100" required></textarea> <input
						id="submit" type="submit" value="Share">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>