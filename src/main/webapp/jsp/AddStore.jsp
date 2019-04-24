<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Store Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="../resources/css/index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://nightly.datatables.net/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css" />
<script src="https://nightly.datatables.net/js/jquery.dataTables.js"></script>
<script
	src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/natural.js"></script>
<script src="../resources/js/index.js"></script>
</head>
<body>
	<center>
		<h1>Store Details</h1>
		<table>
			<form action="POST">
				<tr>
					<th>Store Code</th>
					<td><input type="text" name="mf11_storeCode"
						id="mf11_storeCode"></td>
				</tr>
				<tr>
					<th>Store Name</th>
					<td><input type="text" name="mf11_storeName"
						id="mf11_storeName"></td>
				</tr>
				<tr>
					<th>Store Abbr Name</th>
					<td><input type="text" name="mf11_storeAbbr"
						id="mf11_storeAbbr"></td>
				</tr>

				<tr>
					<th>Company Names</th>
					<td>
						<div class="dropdown drop-cust">
							<select id="companyList" name="mf11_companyName">
								<c:forEach items="${companyList}" var="company">
									<option>${company}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" id="submitStore" value="Add"
						onclick="createStore()">
				</tr>
			</form>
		</table>
	</center>

</body>
</html>