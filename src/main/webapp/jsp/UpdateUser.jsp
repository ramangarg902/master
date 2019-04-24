<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
</head>
<body>
	<center>
		<h1>Update Detail</h1>
		<table>
			<form method="POST" action="/editUser">
				<tr>
					<th>Company Code HIRIS</th>
					<td><input type="text" value="${updateUser.mf11_compCodeHRIS}"
						name="mf11_compCodeHRIS"></td>
				</tr>

				<tr>
					<th>Company Name</th>
					<td><input type="text" value="${updateUser.mf11_compName}"
						name="mf11_compName"></td>
				</tr>

				<tr>
					<th>Company Abbr Name</th>
					<td><input type="text" value="${updateUser.mf11_compAbbrName}"
						name="mf11_compAbbrName"></td>
				</tr>

				<tr>
					<th>Company Registration Number</th>
					<td><input type="text" value="${updateUser.mf11_compRegNo}"
						name="mf11_compRegNo"></td>
				</tr>

				<tr>
					<th>Company Logo</th>
					<td><input type="text" value="${updateUser.mf11_compLogo}"
						name="mf11_compLogo"></td>
				</tr>

				<tr>
					<th>Status</th>
					<td><input type="text" value="${updateUser.mf11_isActive}"
						readonly="readonly" name="mf11_isActive"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
					<td><input type="reset" value="clear"></td>
					<input type="text" name="mf11_createdOn"
						value="${updateUser.mf11_createdOn}" hidden="true">
					<input type="text" name="mf11_createdBy"
						value="${updateUser.mf11_createdBy}" hidden="true">
					<input type="text" name="mf11_compCode"
						value="${updateUser.mf11_compCode}" hidden="true">
				</tr>
		</table>

		</form>
	</center>
</body>
</html>