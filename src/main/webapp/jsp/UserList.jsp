<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Page</title>
<meta charset="utf-8">
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
<script src="../resources/js/user.js"></script>

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="header">
				<form action="/logout" method="post">
					<button type="submit" class="btn btn-danger" name="logout"
						value="logout" style="float: right;">Log out</button>
				</form>
				<form action="/back" method="post">
					<button type="submit" class="btn btn-primary butn-view" name="back"
						value="Back" style="float: left;">Back</button>
				</form>
			</div>


			<table class="table table-bordered table-custm" id="example">

				<thead>
					<tr>
						<th>Company Code</th>
						<th>Company Code HRIS</th>
						<th>Company Name</th>
						<th>Company Abbr Name</th>
						<th>Company Registration Number</th>
						<th>Company Logo Path</th>
						<th>Is Active</th>
						<th>Created On</th>
						<th>Created By</th>
						<th>Modified On</th>
						<th>Modified By</th>
						<th>Action</th>
					</tr>
				</thead>


				<tbody>
					<c:forEach var="users" items="${ListUser}" varStatus="loop">
						<tr id="${users.id}">
							<td><c:out value="${users.mf11_compCode}"></c:out></td>
							<td><c:out value="${users.mf11_compCodeHRIS}"></c:out></td>
							<td><c:out value="${users.name}"></c:out></td>
							<td><c:out value="${users.mf11_compAbbrName}"></c:out></td>
							<td><c:out value="${users.mf11_compRegNo}"></c:out></td>
							<td><c:out value="${users.mf11_compLogo}"></c:out></td>
							<td><c:out value="${users.mf11_isActive}"></c:out></td>
							<td><c:out value="${users.mf11_createdOn}"></c:out></td>
							<td><c:out value="${users.mf11_createdBy}"></c:out></td>
							<td><c:out value="${users.mf11_lastModifiedOn}"></c:out></td>
							<td><c:out value="${users.mf11_lastModifiedBy}"></c:out></td>
							<td>
								<button type="submit" class="btn btn-primary butn-view"
									data-toggle="modal" data-target="#edit-modal" id="edit123">Edit</button>
								<button type="button" class="btn btn-danger" data-toggle="modal"
									data-target="#new" id="delete123">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<a href="addUser">
				<button type="button" class="btn btn-danger">Add New
					Company</button>
			</a>


			<div class="modal fade" id="new" role="dialog">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">
								Delete Data <span id="deletingCompanyCode"></span>
							</h4>
						</div>
						<div class="modal-footer">
							<form method="POST" action="/deleteUser">
								<!-- <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#new" >Delete</button> -->
								<input id="companyIdDelete" name="mf11_companyIdDel"
									type="hidden" value="" /> <input type="submit" value="Delete"
									class="btn btn-danger" />
							</form>
							<button type="button" class="btn btn-primary cancel"
								data-dismiss="modal">CANCEL</button>
						</div>
					</div>
				</div>
			</div>


			<div class="modal fade" id="edit-modal" role="dialog">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<form action="/editUser" method="POST">
							<div class="modal-body">
								<input class="input-modal" type="hidden" name="companyId"
									id="companyId" value="" /> <input class="input-modal"
									id="compCode" type="text" name="compCode" /> <input
									class="input-modal" id="compCodeHRIS" type="text"
									name="compCodeHRIS" /> <input class="input-modal"
									id="compName" type="text" name="compName" /> <input
									class="input-modal" id="compAbbrName" type="text"
									name="compAbbrName" /> <input class="input-modal"
									id="compRegNo" type="text" name="compRegNo" /> <input
									class="input-modal" id="compLogoreAbbr" type="text"
									name="compLogo"> <input class="input-modal"
									id="isActive" type="text" name="isActive" /> <input
									class="input-modal" id="createdOn" name="createdOn"
									type="hidden" /> <input class="input-modal" id="createdBy"
									name="createdBy" type="hidden" />
							</div>
							<div class="modal-footer">

								<input type="submit" value="Submit" id="editUserSubmit"
									class="btn btn-primary delete" />
								<button type="button" class="btn" data-dismiss="modal">
									Cancel</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>