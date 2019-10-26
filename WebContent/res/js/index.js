$(document).ready(function() {

	$("#submit").click(function() {

	});

});

function validateUser() {
	if ($("#username").val() == "") {
		$("#err_msg").html("Please Enter Username");
		return false;
	} else {
		$("#err_msg").html("")
	}
	
	
	if ($("#password").val() == "") {
		$("#err_msg").html("Please Enter Password")
		return false;
	} else {
		$("#err_msg").html("")
	}
}