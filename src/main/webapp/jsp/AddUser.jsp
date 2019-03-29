<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../resources/css/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://nightly.datatables.net/css/jquery.dataTables.css" rel="stylesheet" type="text/css" />
    <script src="https://nightly.datatables.net/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/natural.js"></script>
    <script src="../resources/js/user.js"></script>
</head>
<body>
<center>
<h1>User Details</h1>
<table>
<form action="/addUser" method="POST">

<tr>
<th>Company Code</th>
<td><input type="text" name="mf11_compCode" id="mf11_compCode"></td>
</tr>

<tr>
<th>Company HRIS Code</th>
<td><input type="text" name="mf11_compCodeHRIS" id="mf11_compCodeHRIS"></td>
</tr>

<tr>
<th>Company Name</th>
<td><input type="text" name="mf11_compName" id="mf11_compName"></td>
</tr>


<tr>
<th>Company Abbr Name</th>
<td><input type="text" name="mf11_compAbbrName" id="mf11_compAbbrName"></td>
</tr>

<tr>
<th>Company Registration Number</th>
<td><input type="text" name="mf11_compRegNo" id="mf11_compRegNo"></td>
</tr>

<tr>
<th>Company Logo</th>
<td><input type="text" name="mf11_compLogo"  id="mf11_compLogo"></td>
</tr>


<tr>
<th>Status</th>
<td>
Y<input type="radio" name="mf11_isActive" value="1" checked>
N<input type="radio" name="mf11_isActive" value="0">
</td>
</tr> 

<tr>
<td><input type="submit" id="userSubmit" value="Register"> 
</tr>

</form>
</table>
</center>

</body>
</html>