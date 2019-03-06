<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Now Page</title>
<a href="index.jsp">Home</a>
</head>
<body bgcolor="#f0f5f5" align="center">
	<h1 style="color: black">Cart Details</h1>
	<table border="2" width="70%" cellpadding="2" align="center">
		<c:set var="total" value="${0}" />
		<c:forEach var="buyNowList" items="${buyNowList}">
			<tr>
				<td><b>ProductID:</b> ${buyNowList.productId}</br> <b>Product
						Description:</b> ${buyNowList.productDesc}</br> <b> Category:</b>
					${buyNowList.category}</br> <b> Price:</b> ${buyNowList.price}</br> <b>
						Quantity:</b> ${buyNowList.quantity}</br> <b> </br></td>

				<th><img src="${buyNowList.image}" alt="not found"
					style="height: 100px; width: 100px"></th>
				<td><b>Total price:</b>${buyNowList.quantity*buyNowList.price}</td>
				<form action="remove/${buyNowList.productId}/"
					method="post">
					<th><input type="submit" value="Remove"></th>
				</form>
			</tr>
			<c:set var="total"
				value="${total +buyNowList.price*buyNowList.quantity}" />
		</c:forEach>

	</table>
	<br>
	<br>
	<table border="2" width="70%" cellpadding="2" align="center">
		<tr>
			<th><b>Total Amount</b></th>
			<b>
				<td align="center">Rs. <c:out value="${total}"></c:out></td>
			</b>
		</tr>

	</table>
	<br>
	<br>
	<center>
		<form action="confirmOrder" method="post">
			<input type="submit" value="Place Order">
		</form>
	</center>
	<%@include file="include/footer.jsp"%>
</body>
</html>