$(document).ready(function() {

});
$(window).load(function() {
	$("#display_name").html(lFullname);

})


function setUpUrl(pData) {
	alert(atob(pData));
	
	$("#CentralFrame").attr("src",lBasePath+"/page_loader?token="+pData);
	
	
}