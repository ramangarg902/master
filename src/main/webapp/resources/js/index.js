$(document).ready(function() {

	$('#example').on('click', '#edit123', function(e) {
		var tr = $(this).closest('tr');
		var data = table.row(tr).data();
		var storeId = table.row(tr).id();
		$("#storeCode").val(data[0]);
		$("#storeName").val(data[1]);
		$("#storeAbbr").val(data[2]);
		$("#companyList").val(data[3]);
		$("#storeId").val(storeId);

	});

	$('#example').on('click', '#delete123', function(e) {
		var tr = $(this).closest('tr');
		var data = table.row(tr).data();
		var storeId = table.row(tr).id();
		$("#storeIdDelete").val(storeId);
		$("#deletingStoreCode").html(data[0]);

	});

	/* CLIENT SIDE VALIDATION ******** */
	$("#submitStore").click(function() {
		var storeCode = document.getElementById('mf11_storeCode').value;
		var storeName = document.getElementById('mf11_storeName').value;
		var storeAbbr = document.getElementById('mf11_storeAbbr').value;

		if (storeCode.length == 0 || isNaN(storeCode)) {
			alert("Please input a Store Code and only inetegr value");
			return false;
		} else if (storeName.length == 0) {
			alert("Please input a Store name");
			return false;
		} else if (storeAbbr.length == 0) {
			alert("Please input a  Abbr");
			return false;
		}
	});

	$("#editSubmit").click(function() {
		var storeCode = document.getElementById('storeCode').value;
		var storeName = document.getElementById('storeName').value;
		var storeAbbr = document.getElementById('storeAbbr').value;

		if (storeCode.length == 0 || isNaN(storeCode)) {
			alert("Please input a Store Code and only inetegr value");
			return false;
		} else if (storeName.length == 0) {
			alert("Please input a Store name");
			return false;
		} else if (storeAbbr.length == 0) {
			alert("Please input a  Abbr");
			return false;
		}
	});

	$('#edit-modal #storeCode').text

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

function createStore() {
	var store = JSON.stringify({
		mf11_storeCode : $('#mf11_storeCode').val(),
		mf11_storeName : $('#mf11_storeName').val(),
		mf11_storeAbbr : $('#mf11_storeAbbr').val(),
		mf11_companyName : $('#companyList').val(),
	});
	$.ajax({
		type : "POST",
		contentType : "application/json",
		dataType : 'json',
		url : "addStore",
		data : store, // Note it is important
		success : function(data) {
			alert(data);
			//window.location.replace('/index.jsp');
			//windows.location.reload();
		},
	  error: function (jqXHR, textStatus, errorThrown) {
		  alert("error "+errorThrown);
	      }
	});
}

function updateStore() {
	var store = JSON.stringify({
		id : $('#storeId').val(),
		mf11_storeCode : $('#storeCode').val(),
		mf11_storeName : $('#storeName').val(),
		mf11_storeAbbr : $('#storeAbbr').val(),
		mf11_companyName : $('#companyList').val(),
	});
	alert(store);
	$.ajax({
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		url : "/editStoreInfo",
		data : store, // Note it is important
		success : function(result) {
			windows.localtion.reload();
		}
	});
}
