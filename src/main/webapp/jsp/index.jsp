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
<script src="../resources/js/index.js"></script>

</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="header">
				<!--  <a> Log Out</a>-->
				<form action="/logout" method="post">
					<button type="submit" name="logout" class="btn btn-danger"
						value="logout" style="float: right;">Log out</button>
				</form>
			</div>

			<div class="menu-custm col-md-1 ">
				<a class="unclkmovies" href="#">Apps</a> <a class="unclkmovies"
					href="#">Games</a> <a class="clkmovies active" href="#" onclick="">Movies</a>
				<a class="unclkmovies" href="#">Books</a> <a class="unclkmovies"
					href="#">Newspaper</a> <a class="unclkmovies" href="/GoToUserList">Go
					to company's list</a>
			</div>
			<div class="content col-md-offset-1 col-md-9" id="movies">
				<div class=row>
					<div class="breadCrumb-style col-md-10">
						<ul id="breadcrumbs-one">
							<li><a href="">Home</a></li>
							<li><a href="">Level 1</a></li>
							<li><a href="">Level 2</a></li>
							<li><a href="">Level 3</a></li>
							<li><a href="">Last</a></li>
						</ul>
					</div>
					<div class="Test-java col-md-2">TEST-JAVA</div>
				</div>

				<table class="table table-bordered table-custm" id="example">

					<thead>
						<tr>
							<th>Store Code</th>
							<th>Store Name</th>
							<th>Store Abbr</th>
							<th>Company</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="stores" items="${getStoreInfo}" varStatus="loop">
							<tr id="${stores.id}">
								<td><c:out value="${stores.mf11_storeCode}"></c:out></td>
								<td><c:out value="${stores.mf11_storeName}"></c:out></td>
								<td><c:out value="${stores.mf11_storeAbbr}"></c:out></td>
								<td><c:out value="${stores.mf11_companyName}"></c:out></td>
								<td>
									<button type="submit" class="btn btn-primary butn-view"
										data-toggle="modal" data-target="#edit-modal" id="edit123">Edit</button>
									<button type="button" class="btn btn-danger"
										data-toggle="modal" data-target="#new" id="delete123">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="addStore">
					<button type="button" class="btn btn-danger">Add New Store</button>
				</a>

				<div class="modal fade" id="new" role="dialog">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">
									Delete Data <span id="deletingStoreCode"></span>
								</h4>
							</div>
							<div class="modal-footer">
								<form method="POST" action="/deleteStoreInfo">
									<!-- <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#new" >Delete</button> -->
									<input id="storeIdDelete" name="mf11_storeIdDel" type="hidden"
										value="" /> <input type="submit" value="Delete"
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
							<form>
								<div class="modal-body">
									<input class="input-modal" type="hidden" name="storeId"
										id="storeId" value="" /> <input class="input-modal"
										id="storeCode" type="text" placeholder="xyz" name="storeCode">
									<input class="input-modal" id="storeName" type="text"
										placeholder="Store Name eg : Klang Parade" name="storeName">
									<input class="input-modal" id="storeAbbr" type="text"
										placeholder="Store Abbr eg : KP" name="storeAbbr">
									<div class="dropdown drop-cust">
										<select class="form-control" id="companyList"
											name="companyList">
											<c:forEach items="${companyList}" var="company">
												<option>${company}</option>
												<%-- <li><a href="#">${company}</a></li> --%>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="modal-footer">
									<input type="submit" value="Submit" id="editSubmit"
										class="btn btn-primary delete" onclick="updateStore()">
									<button type="button" class="btn" data-dismiss="modal">
										Cancel</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>