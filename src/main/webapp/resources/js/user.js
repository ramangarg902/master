$(document).ready(function() {

	$('#example').on('click', '#edit123', function(e) {
		var tr = $(this).closest('tr');
		var data = table.row(tr).data();
		var companyId = table.row(tr).id();
		// alert(companyId);
		$("#compCode").val(data[0]);
		$("#compCodeHRIS").val(data[1]);
		$("#compName").val(data[2]);
		$("#compAbbrName").val(data[3]);
		$("#compRegNo").val(data[4]);
		$("#compLogoreAbbr").val(data[5]);
		$("#isActive").val(data[6]);
		$("#createdOn").val(data[7]);
		$("#createdBy").val(data[8]);
		$("#companyId").val(companyId);
	});

	$('#example').on('click', '#delete123', function(e) {
		var tr = $(this).closest('tr');
		var data = table.row(tr).data();
		var companyId = table.row(tr).id();
		// alert(companyId);
		$("#companyIdDelete").val(companyId);
		$("#deletingCompanyCode").html(data[0]);
	});

	/* CLIENT SIDE VALIDATION ******** */
	$("#userSubmit").click(function() {
		var compCode = document.getElementById('mf11_compCode').value;
		var compHRISCode = document.getElementById('mf11_compCodeHRIS').value;
		var compName = document.getElementById('mf11_compName').value;
		var compAbbrName = document.getElementById('mf11_compAbbrName').value;
		var compRegNo = document.getElementById('mf11_compRegNo').value;
		var compLogo = document.getElementById('mf11_compLogo').value;

		if (compCode.length == 0 || isNaN(compCode)) {
			alert("Please input a Company Code and only inetegr value");
			return false;
		} else if (compHRISCode.length == 0) {
			alert("Please input a Company HRIS code");
			return false;
		} else if (compName.length == 0) {
			alert("Please input a Company Name");
			return false;
		} else if (compAbbrName.length == 0) {
			alert("Please input a Company Abbr");
			return false;
		} else if (compRegNo.length == 0) {
			alert("Please input a Company RegNo");
			return false;
		} else if (compLogo.length == 0) {
			alert("Please input a Company Logo");
			return false;
		}
	});

	$("#editUserSubmit").click(function() {
		var compCode = document.getElementById('compCode').value;
		var compName = document.getElementById('compCodeHRIS').value;
		var compAbbr = document.getElementById('compName').value;
		var compAbbrName = document.getElementById('compAbbrName').value;
		var compRegNo = document.getElementById('compRegNo').value;
		var compLogo = document.getElementById('compLogoreAbbr').value;

		if (compCode.length == 0 || isNaN(compCode)) {
			alert("Please input a company Code and only inetegr value");
			return false;
		} else if (compName.length == 0) {
			alert("Please input a company name");
			return false;
		} else if (compAbbr.length == 0) {
			alert("Please input a company Abbr");
			return false;
		} else if (compAbbrName.length == 0) {
			alert("Please input a comp Abbr Name");
			return false;
		} else if (compRegNo.length == 0) {
			alert("Please input a comp RegNo");
			return false;
		} else if (compLogo.length == 0) {
			alert("Please input a  Company Logo");
			return false;
		}
	});

	$('#edit-modal #compCode').text

	$(".clkmovies").click(function() {
		$("#movies").show();
	});

	$(".unclkmovies").click(function() {
		$("#movies").hide();
	});

	$(' a').click(function() {
		$('a').removeClass("active");
		$(this).addClass("active", " a.active::after");
	});

	var table = $('#example').DataTable({
		columnDefs : [ {
			type : 'natural',
			targets : 0
		} ],
		order : [ [ 0, 'desc' ] ]
	});

});

function myFunction() {
	alert("Delete data!!!");
}

function createCompany() {
	var company = JSON.stringify({
		mf11_compCode : $('#mf11_compCode').val(),
		mf11_compCodeHRIS : $('#mf11_compCodeHRIS').val(),
		name : $('#mf11_compName').val(),
		mf11_compAbbrName : $('#mf11_compAbbrName').val(),
		mf11_compRegNo : $('#mf11_compRegNo').val(),
		mf11_compLogo : $('#mf11_compLogo').val()
	});
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : "/addUser",
		data : company, // Note it is important
		success : function(result) {
			// do what ever you want with data
		}
	});
}
