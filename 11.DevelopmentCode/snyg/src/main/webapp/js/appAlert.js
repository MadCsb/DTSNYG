//JavaScript Document
var time=3; 
var stop;
var controlTypeId;
var controlValueId;
var controlImg;
var controlPrice;
var controlImgPath;
var flag = true;
var sourceSrc;
var Alert={	 
		show3sMsg:function(obj){
			if(flag){
				flag = false;
				var subhtml='<div id="alert_dialog_show_3s_box" style=" overflow:hidden;"><div id="alert_show_3" class="time1" style="height:80px; width:200px; background-color:#000; color:#fff; opacity:0.8;  border-radius:8px;font-size:16px; text-align:center;z-index: 2000; position:fixed;top:30%;left:23%;"><p style="padding-top:30px;">'+obj+'</p></div></div>';
				$("body").append(subhtml);
				//计数器
				time=2;		
				stop=setInterval(closedShow3sMsg,1000);	
			}
		},
		show3sGoToMsg:function(obj,src){
			sourceSrc=src;
			if(flag){
				flag = false;
				var subhtml='<div id="alert_dialog_show_3s_box" style=" overflow:hidden;"><div id="alert_show_3" class="time1" style="height:80px; width:200px; background-color:#000; color:#fff; opacity:0.8;  border-radius:8px;font-size:16px; text-align:center;z-index: 2000; position:fixed;top:30%;left:23%;"><p style="padding-top:30px;">'+obj+'</p></div></div>';
				$("body").append(subhtml);
				//计数器
				time=2;		
				stop=setInterval(closedGoToShow3sMsg,1000);	
			}
		},
		show3sMsgReturn:function(obj,method){
			returnMethod = method;
			if(flag){
				flag = false;
				var subhtml='<div id="alert_dialog_show_3s_box" style=" overflow:hidden;"><div id="alert_show_3" class="time1" style="height:80px; width:200px; background-color:#000; color:#fff; opacity:0.8;  border-radius:8px;font-size:16px; text-align:center;z-index: 2000; position:fixed;top:30%;left:23%;"><p style="padding-top:30px;">'+obj+'</p></div></div>';
				$("body").append(subhtml);
				//计数器
				time=2;
				stop=setInterval(closedShow3sMsgReturn,1000);
			}
		},
		showErrMsg:function(obj){
				var subhtml='<div onclick="closedShowMsg()" id="alert_dialog_show_msg_box" style=" overflow:hidden;"><div id="alert_show_3" class="time1" style="height:80px; width:200px; background-color:#000; color:#fff; opacity:0.8;  border-radius:8px;font-size:16px; text-align:center;z-index: 2000; position:fixed;top:30%;left:23%;"><p style="padding-top:30px;">'+obj+'</p></div></div>';
				$("body").append(subhtml);
		},
		//确认
		showMsg:function(obj){
		var subhtml='<div onclick="closedShowMsg()" id="alert_dialog_show_msg_box" style="overflow:hidden;height:100px;width:100%;margin:0 auto;">'
				   +'<div class="sweet-overlay" tabIndex="-1"  style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;"></div>'
				   +'<div id="alert_show_3" style="height:300px; width:100%;z-index:2000;position:absolute;top:10px">'
				   +'<p style="padding-top:30px;">'+obj+'</p>'
				   +'<div align="center"><input name="button" onclick="closedShowMsg()" type="button" value="我知道了" style="margin:100px auto; width:120px; height:50px; line-height:40px;border:3px solid #ff9900;border-radius:10px;color:#ff9900;font-size:20px;"  />'
				   +'</div></div>'
				   +'</div>';
			$("body").append(subhtml);
		},
		showChooseObj:function(typeId,valueId,src){
			controlTypeId=typeId;
			controlValueId=valueId;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="border-radius:8px;height:140px; width:80%; background-color:#fff;z-index:2000;position:absolute;top:100px;left:10%;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		showChooseFeature:function(typeId,valueId,src){
			controlTypeId=typeId;
			controlValueId=valueId;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div onclick="closedShowMsg()" class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="background-color:transparent;border-radius:10px;height:100%; width:80%;z-index:2000;position:absolute;top:10px;left:10%;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;border-radius:10px;background-color:transparent;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		showChooseAge:function(typeId,valueId,src){
			controlTypeId=typeId;
			controlValueId=valueId;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div onclick="closedShowMsg()" class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="border-radius:10px;height:300px; width:80%; background-color:#fff;z-index:2000;position:absolute;top:100px;left:10%;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;border-radius:10px;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		showChooseSex:function(typeId,valueId,src){
			controlTypeId=typeId;
			controlValueId=valueId;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div onclick="closedShowMsg()" class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="border-radius:10px;height:140px; width:80%; background-color:#fff;z-index:2000;position:absolute;top:100px;left:10%;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;border-radius:10px;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		showChooseClass:function(idValue,idKey,src){
			controlValueId=idValue;
			controlTypeId=idKey;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="height:100%; width:100%; background-color:#fff;z-index:2000;position:absolute;top:0;left:0;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		//商品选择 控件ID 和action
		showChoosePro:function(idValue,idKey,imgId,imgPath,priceId,src){
			controlValueId=idValue;
			controlTypeId=idKey;
			controlImg=imgId;
			controlImgPath=imgPath;
			controlPrice=priceId;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="height:100%; width:100%; background-color:#fff;z-index:2000;position:absolute;top:0;left:0;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		//城市选择 控件ID 和action
		showChooseCity:function(id,src){
			controlValueId=id;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:0 auto;">'
						+'<div class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="height:100%; width:100%; background-color:#fff;z-index:2000;position:absolute;top:0;left:0;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;background-color:#fff;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		},
		closedLoading:function(){
			$("#alert_dialog_show_loading_box").remove();
		},
		showDialog:function(src,height)
		{
			var top = $(window).height()/2 - 130;
			var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:260px;margin:0 auto;">'
						+'<div onclick="closedShowMsg()" class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;">'
						+'</div>'
						+'<div id="alert_show_3" style="border-radius:10px;height:'+height+'px; width:80%;z-index:2000;position:absolute;top:'+top+'px;left:10%;">'
						+'<iframe id="mainContent" width="100%" height="100%" src="'+src+'" style="border:0;border-radius:10px;"></iframe>'
						+'</div>'
						+'</div>';
			$("body").append(subhtml);
		}
}

//2s关闭弹出框
function closedShow3sMsg(){
	time=time-1;
	if(time==0){
		$('#alert_dialog_show_3s_box').remove();
		clearInterval(stop);
		flag = true;
	}
}

//2s关闭弹出框
function closedGoToShow3sMsg(){
	time=time-1;
	if(time==0){
		$('#alert_dialog_show_3s_box').remove();
		clearInterval(stop);
		flag = true;
		location.href=sourceSrc;
	}
}

//2s关闭弹出框
function closedShow3sMsgReturn(method){
	time=time-1;
	if(time==0){
		$('#alert_dialog_show_3s_box').remove();
		clearInterval(stop);
		flag = true;
		returnMethod();
	}
}

//关闭确认弹出框
function rec(callback){
	$("#alert_dialog_show_confirm_box").remove();
	callback();
}

//关闭弹出框
function closedShowMsg(){
	$("#alert_dialog_show_msg_box").remove();
}

//关闭弹出框
function closedShowChooseObj(type,value){
	
	if(null!=value&&value!="")
	{
		$('#'+controlTypeId).val(type);
		$('#'+controlValueId).val(value);
	}
	$("#alert_dialog_show_msg_box").remove();
}

//关闭弹出框
function closedShowPro(type){
	
	$('#'+controlTypeId).val(type);
	getProInfo(type);
	$("#alert_dialog_show_msg_box").remove();
}

//关闭弹出框
function closedShowClass(type,value){
	
	if(null!=value&&value!="")
	{
		$('#'+controlTypeId).val(type);
		$('#'+controlValueId).html(value);
	}
	$("#alert_dialog_show_msg_box").remove();
}

//关闭弹出框
function closedShowChooseObj(type,value){
	
	if(null!=value&&value!="")
	{
		$('#'+controlTypeId).val(type);
		$('#'+controlValueId).val(value);
	}
	$("#alert_dialog_show_msg_box").remove();
}

function closedShowChooseCity(value){
	
	if(null!=value&&value!="")
	{
		$('#'+controlValueId).val(value);
	}
	$("#alert_dialog_show_msg_box").remove();
}


function closedShowChooseFeature(type,value){
	
	if(null!=value&&value!="")
	{
		$('#'+controlTypeId).val(type);
		$('#'+controlValueId).val(value);
	}
	$("#alert_dialog_show_msg_box").remove();
}

function getProInfo(pdcId)
{
	$.post("getChooseMicroShopPro.action",{"partnerprdlink.pdcId":pdcId},function(data)
		{
			$('#'+controlImg).attr("src",controlImgPath+data[0].thumbPic); 
			$('#'+controlPrice).html(data[0].price);
			$('#'+controlValueId).html(data[0].pdcName);
	},"json");
}
