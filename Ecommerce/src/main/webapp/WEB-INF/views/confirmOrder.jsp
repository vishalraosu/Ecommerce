<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,java.text.SimpleDateFormat,java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>
<h3>
	<a href="index.jsp">Home</a>
</h3>
</head>
<body bgcolor="#f0f5f5">
	<center>
		<h1 style="color: rgb(100, 100, 200); text-transform: uppercase;">
			THANK YOU
			<%
			if (session.getAttribute("username") != null) {
				out.print(session.getAttribute("username"));
			}
		%>
		</h1>
	</center>
	<center>
		<h1 style="color: rgb(100, 100, 200">FOR USING FASHION WORLD!</h1>
	</center>
	<center>
		<h2 style="color: rgb(100, 100, 200)"; margin-top: 130px;">ORDER
			DETAILS</h2>
	</center>

	<center>
		<h2 style="color: rgb(100, 100, 200)">Order Number:</h2>
		<c:set var="rand">FSNWORLDO-ID1000<%=java.lang.Math.round(java.lang.Math.random() * 7 + 1)%></c:set>

	</center>
	<center>
		<h3 style="color: rgb(100, 100, 200)">Orderd Time:</h3><%=(new java.util.Date()).toLocaleString()%>
	</center>

	<center>
		<h3 style="color: rgb(100, 100, 200)">Delivery Date By:</h3>
		<%
			{
				String oldDate = (new java.util.Date()).toLocaleString();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(sdf.parse(oldDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.DAY_OF_MONTH, 3);
				String newDate = sdf.format(c.getTime());
				out.print(newDate);
			}
		%>
	</center>
	<center>
		<h2 style="color: rgb(100, 100, 200)">HAS BEEN SUCCESSFULLY
			PLACED !!</h2>
	</center>
	<marquee>
		<h3 style="color: rgb(100, 100, 200)">HOPE YOU HAD A WONDERFUL
			EXPERIENCE!</h3>
	</marquee>
	<%@include file="include/footer.jsp"%>
</body>
</html>