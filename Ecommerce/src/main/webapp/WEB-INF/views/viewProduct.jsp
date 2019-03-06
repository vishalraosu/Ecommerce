<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include\header.jsp"%>
<html>
<head>
<title>View Products</title>
<script>
function addCart() {
  alert("Product has been Added to the Cart");
}
</script>
</head>
<style>
table {
	border-collapse: collapse;
	margin: 10px;
}

table, td, th {
	border: 1px solid black;
	padding: 10px;
	text-align: left;
}
</style>
<body bgcolor="#f0f5f5">
	<div align="center">

		<h1 style="color: black;">Product List</h1>

		<c:forEach var="Product" items="${list}">
			<table border="2" cellpadding="2" style="float: left;" height="200px"
				width="320px">
				<tr>
					<td><b>ProductID:</b> ${Product.productId}</br> <b>Product
							Description:</b> ${Product.productDesc}</br> <b> Category:</b>
						${Product.category}</br> <b> Price:</b> ${Product.price}</br>
						<form action="cart/${Product.productId}/quantity/" method="get">
							<b> Quantity:</b><select name="quantity">
								<option value="1" selected>1</option>
								<option value="2">2</option>
								<option value="3">3</option></td>
					<th rowspan="2"><img src="${Product.image}" alt="not found"
						style="height: 150px; width: 120px"></th>
				</tr>
				<tr>
					<th colspan="1" align="center"></select> <input type="submit"
						value="Add Cart "onclick="addCart()"> 
						</form></th>
				</tr>

			</table>
		</c:forEach>
		<br />
	</div>
	<center>
		<%@include file="include/footer.jsp"%>
	</center>
</body>
</html>