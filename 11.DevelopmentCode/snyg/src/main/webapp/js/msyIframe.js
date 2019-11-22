function initMsyIframe(){
	var divId,fun;
	var args = arguments;
    if (args && args.length >= 2){
    	divId = args[0];
    	fun = args[1];
    	var urlStr = $("#" + divId).attr("src");
    	$.ajax({
    		type: "POST",
    		url:urlStr,       
    		dataType:'html',
    		success: function(data){ 
    			$("#" + divId).html(data);
    			fun();
    		}
    	});
    }
    else
    {
    	divId = args[0];
    	var urlStr = $("#" + divId).attr("src");
    	$.ajax({
    		type: "POST",
    		url:urlStr,       
    		dataType:'html',
    		success: function(data){ 
    			$("#" + divId).html(data);
    		}
    	});
    }
}