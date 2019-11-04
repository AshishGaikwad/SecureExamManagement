function get(pPageName,pJsonData)
{
	var lData ;
	$.ajaxSetup({
		async:false
	})
	
	$.post(pPageName,pJsonData,function(data){
		lData = data;
	})
	$.ajaxSetup({
		async:true
	})

	return lData;
}


function put(pPageName,pJsonData,pCallBack)
{

	$.post(pPageName,pJsonData,pCallBack)

}