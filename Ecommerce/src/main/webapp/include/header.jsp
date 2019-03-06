<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/errorPage.jsp"%>

<!DOCTYPE html >
<html>
<head>
<title>Header</title>
<script>
        function logout() {
              
                var r = confirm("Press ok to logout or Press cancel for stay here!");
                if (r == true) {
                        alert("Logout Successfully !!!!");
                        document.getElementById("myForm").submit();
return true;
                } else {
                        alert("Continue..");
                        return false;
                }
   }            
</script>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #4db8ff;
}

li {
	float: left;
}

li a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #0066cc;
}

p {
	margin: 10px 70px 10px;
	color: white;
}

.head {
	width: 100%;
	height: 140px;
}

h1 {
	color: white;
	text-shadow: black;
}
</style>

</head>

<body style="position:inherit;">
	<div class="head" style="background-image: url(Images/back.jpg)">
		<font color="white" style="text-align: right" size="5"> <%
 	if (session.getAttribute("username") != null) {

 		out.print("Welcome " + session.getAttribute("username"));
 	}
 %>
		</font> <br>
		<h1 align="center">Fashion World</h1>
		<p align="right">A Classic Never goes out of Style</p>
	</div>
	<HR WIDTH="100%" COLOR="white" SIZE="1">
	<div >
		<ul>
			<li><a href="index.jsp"><font face="verdana" size="3"
					color="white">Home</font></a></li>
			<li><a href="viewProduct"><font face="verdana" size="3"
					color="white">Products</font></a></li>
			<li><a href="Men"><font face="verdana" size="3"
					color="white">Men</font></a></li>
			<li><a href="Women"><font face="verdana" size="3"
					color="white">Women</font></a></li>
			<li><a href="Kid"><font face="verdana" size="3"
					color="white">Kid</font></a></li>
			<li><a href="contactUs.jsp"><font face="verdana" size="3"
					color="white">Contact Us</font></a></li>
			<li><a href="aboutUs.jsp"><font face="verdana" size="3"
					color="white">About Us</font></a></li>
			<%
				String username = (String) session.getAttribute("username");
				if (username == null) {
			%>
			<li style="float: right"><a href="userLogin"><font
					face="verdana" size="3" color="white">Login</font></a></li>

			<%
				} else {
			%>

			<li style="float: right"><a href="profile"><font
					face="verdana" size="3" color="white">ViewProfile</font></a></li>


			<li style="float: right; color: white;"><font face="verdana"
				size="3" color="white"><a href="logout" type="submit" onclick="logout()">Logout</a></font></li>
			<%
				}
			%>
			<li style="float: right; color: white;"><a href="buyNowOrder"><img
					src="Images/cart.png" style="width: 30px; height: 30px"></a></li>
		</ul>

	</div>
	<HR WIDTH="100%" COLOR="white" SIZE="2">

</body>
</html>
