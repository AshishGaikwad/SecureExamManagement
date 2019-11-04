$(document).ready(function(){
	$("#CreateScreenButton").click(function(){

		
	});
	
	
	
	
	
});


$(window).load(function(){
	GetParentScreen()
})



function GetParentScreen()
{
	var lData = get(BASEURL+"screen",{
		RequestType:"GetScreenParentList"
	});
	
	lData = JSON.parse(lData);
	
	$.each(lData,function(key,value){
		$("#ScreenParent").append("<option value=\""+value.ScreenId+"\">"+value.ScreenName+"</option>");
	})
	
	

}