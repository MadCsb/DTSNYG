// JavaScript Document
var time=3; 
var stop;
var Alert={	  
	show3sMsg:function(obj){
		
		// 禁止滚动条滚动
		unScroll();
		
		var subhtml='<div id="alert_dialog_show_3s_box" style=" overflow:hidden;"><div id="alert_show_3" class="time1" style="height:auto;padding: 20px 5%; width:50%; background-color:#000; color:#fff; opacity:0.8;  border-radius:8px;font-size:14px; text-align:center;z-index: 2000; position:fixed;top:20%;left:20%;"><p>'+obj+'</p></div></div>';
		$("body").append(subhtml);
		//计数器
		time=3;
		stop=setInterval(closedShow3sMsg,1000)	
	},	
	//确认
	showMsg:function(obj){
		
		// 禁止滚动条滚动
		unScroll();
		
		var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;"></div><div id="alert_show_3" style="height:auto; padding-bottom:20px;width:200px; background-color:#fff; color:#000; border-radius:8px;text-align:center;z-index:2000;position:fixed;top:200px"><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="closedShowMsg()" class="ydbtn-ico">确认</span></div></div>';
		$("body").append(subhtml);
	},
	//确认
	showMsg2:function(obj){		
		var subhtml='<div id="alert_dialog_show_msg_box1" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;" onclick="closedShowMsg()"></div><div id="alert_show_3" style="height:auto; padding-bottom:20px;width:200px; background-color:#fff; color:#000; border-radius:8px;text-align:center;z-index:2000;position:fixed;top:200px"><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="closedShowMsg1()" class="ydbtn-ico">确认</span></div></div>';
		$("body").append(subhtml);
	},

	//确认
	showMsg3:function(obj,callback){
		
		// 禁止滚动条滚动
		unScroll();
		
		var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;"></div><div id="alert_show_3" style="height:auto; padding-bottom:20px;width:200px; background-color:#fff; color:#000; border-radius:8px;text-align:center;z-index:2000;position:fixed;top:200px"><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="rec('+callback+')" class="ydbtn-ico">确认</span></div></div>';
		$("body").append(subhtml);
		callback = callback || function(){};
	},
	showConfirmMsg:function(obj,callback){
		// 禁止滚动条滚动
		unScroll();
		var subhtml='<div id="alert_dialog_show_confirm_box" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.4; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;"></div><div id="alert_show_3" style="height:100px; width:200px; background-color:#fff; color:#000; border-radius:8px;font-size:20px; text-align:center; position:absolute;z-index:2000;position:fixed;top:200px""><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="rec('+callback+')" class="ydbtn-ico">确认</span><span name="button" onclick="rec3()" class="ckbtn-ico">取消</span></div></div>';
		$("body").append(subhtml);
		callback = callback || function(){};
	},
	showConfirmMsg3:function(obj,callbackOk, callbackCancel){
		
		// 禁止滚动条滚动
		unScroll();
		
		var subhtml='<div id="alert_dialog_show_confirm_box" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.4; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;"></div><div id="alert_show_3" style="height:100px; width:200px; background-color:#fff; color:#000; border-radius:8px;font-size:20px; text-align:center; position:absolute;z-index:2000;position:fixed;top:200px""><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="AlertConfirmOk();" class="ydbtn-ico">确认</span><span name="button" onclick="AlertConfirmCancel();" class="ckbtn-ico">取消</span></div></div>';
		$("body").append(subhtml);
		this.callbackOk = callbackOk || function(){};
		this.callbackCancel = callbackCancel || function(){};
	},
	
	// 底部弹出框
	showBottomHtml:function(obj) {
		
		// 禁止滚动条滚动
		unScroll();
		
		var subhtml='<div id="alert_dialog_show_msg_box" style=" overflow:hidden;height:100px;width:100%;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;" onclick="closeBottomHtml()"></div><div id="alert_show_3" style="height:100px; width:200px; background-color:#fff; color:#000;z-index:2000;position:fixed;bottom:0px;width:100%">'+obj+'</div>';
		$("body").append(subhtml);
	},
	
	// 底部弹出框(没有蒙板)
	showBottomHtmlNoMask:function(obj) {
		var subhtml='<div id="showBottomHtmlNoMask_box" style=" overflow:hidden;height:100px;width:100%;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style="opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;" onclick="closeBottomHtmlNoMask()"></div><div id="alert_show_3" style="height:100px; width:200px; background-color:#fff; color:#000;z-index:2000;position:fixed;bottom:0px;width:100%">'+obj+'</div>';
		$("body").append(subhtml);
	},
	
	// 弹出日历控件
	showCalendar:function(obj) {
		
		// 禁止滚动条滚动
		unScroll();
		
		// 监听触摸事件
		document.body.addEventListener('touchstart', handlerTouchstart, {passive: false});

		// 监听滑动事件
		document.body.addEventListener('touchmove', handlerTouchmove, {passive: false});
		
		var subhtml='<div id="alert_dialog_show_msg_box_c" style="overflow:hidden;height:100px;width:100%;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style="background-color:#000; opacity:0.8; position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;" onclick="closeShowCalendar()"></div><div id="alert_show_3" style="height:100px; width:200px; background-color:#fff; color:#000;z-index:2000;position:fixed;bottom:0px;width:100%">'+obj+'</div>';
		$("body").append(subhtml);
	},
	
	// 提示框（弹出层上操作后，弹出的提示框，不需要禁用滚动条和蒙板）
	alertMsg:function(obj){		
		var subhtml='<div id="alertMsg_box" style=" overflow:hidden;height:100px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:1000;" onclick="closeAlertMsg()"></div><div id="alert_show_3" style="height:auto; padding-bottom:20px;width:200px; background-color:#ddd; color:#000; border-radius:8px;text-align:center;z-index:2000;position:fixed;top:200px"><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="closeAlertMsg()" class="ydbtn-ico">确认</span></div></div>';
		$("body").append(subhtml);
	},
	
	// 提示框（弹出层上操作后，弹出的提示框，点击确定后回调，不需要禁用滚动条和蒙板）
	alertMsgCallBack:function(obj, callback){		
		var subhtml='<div id="alertMsgCallBack_box" style=" overflow:hidden;height:140px;width:200px;margin:15% auto;"><div class="sweet-overlay" tabIndex="-1" style=" position: fixed; left: 0; right: 0; top: 0; bottom: 0; z-index:9998;"></div><div id="alert_show_3" style="height:auto; padding-bottom:20px;width:200px; background-color:#f5f5f5;padding:10px;box-sizing:border-box;border:1px solid #ddd; color:#000; border-radius:8px;text-align:center;z-index:9999;position:fixed;top:200px"><p style="font-size:14px; margin:15px auto;">'+obj+'</p><span name="button" onclick="closeAlertMsgCallBack(' + callback + ')" class="ydbtn-ico">确认</span></div></div>';
		$("body").append(subhtml);
	},
	//
	loading:function(){
   var subhtml='<style>.spinner{margin:0 auto;width:40px;height:40px;position:relative}.container1>div,.container2>div,.container3>div{width:10px;height:10px;background-color:#53d653;border-radius:100%;position:absolute;-webkit-animation:bouncedelay 1.2s infinite ease-in-out;animation:bouncedelay 1.2s infinite ease-in-out;-webkit-animation-fill-mode:both;animation-fill-mode:both}.spinner .spinner-container{position:absolute;width:100%;height:100%}.container2{-webkit-transform:rotateZ(45deg);transform:rotateZ(45deg)}.container3{-webkit-transform:rotateZ(90deg);transform:rotateZ(90deg)}.circle1{top:0;left:0}.circle2{top:0;right:0}.circle3{right:0;bottom:0}.circle4{left:0;bottom:0}.container2 .circle1{-webkit-animation-delay:-1.1s;animation-delay:-1.1s}.container3 .circle1{-webkit-animation-delay:-1.0s;animation-delay:-1.0s}.container1 .circle2{-webkit-animation-delay:-0.9s;animation-delay:-0.9s}.container2 .circle2{-webkit-animation-delay:-0.8s;animation-delay:-0.8s}.container3 .circle2{-webkit-animation-delay:-0.7s;animation-delay:-0.7s}.container1 .circle3{-webkit-animation-delay:-0.6s;animation-delay:-0.6s}.container2 .circle3{-webkit-animation-delay:-0.5s;animation-delay:-0.5s}.container3 .circle3{-webkit-animation-delay:-0.4s;animation-delay:-0.4s}.container1 .circle4{-webkit-animation-delay:-0.3s;animation-delay:-0.3s}.container2 .circle4{-webkit-animation-delay:-0.2s;animation-delay:-0.2s}.container3 .circle4{-webkit-animation-delay:-0.1s;animation-delay:-0.1s}@-webkit-keyframes bouncedelay{0%,80%,100%{-webkit-transform:scale(0.0)}40%{-webkit-transform:scale(1.0)}}@keyframes bouncedelay{0%,80%,100%{transform:scale(0.0);-webkit-transform:scale(0.0)}40%{transform:scale(1.0);-webkit-transform:scale(1.0)}}</style><div id="alert_dialog_show_loading_box" style="overflow:hidden;height:40px;width:40px;margin-left:50%;margin-top:20%;"><div class="sweet-overlay" tabIndex="-1" style="background-color:#000;opacity:0.4;position:fixed;left:0;right: 0; top: 0;bottom: 0;z-index:1000;"></div><div id="alert_show_3"  style=" position:absolute;z-index:2000;"><div class="spinner"><div class="spinner-container container1"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div><div class="spinner-container container2"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div><div class="spinner-container container3"><div class="circle1"></div><div class="circle2"></div><div class="circle3"></div><div class="circle4"></div></div></div></div></div>';
		$("body").append(subhtml);	
 
	},
	closedLoading:function(){
		  $("#alert_dialog_show_loading_box").remove();
	}	
}
	
//3s关闭弹出框
function closedShow3sMsg(){
	time=time-1;
	if(time==0){
		$('#alert_dialog_show_3s_box').remove();
		clearInterval(stop);
	}

	removeUnScroll();
}

//关闭确认弹出框
function rec(callback){
	$("#alert_dialog_show_msg_box").remove();
	callback();

	removeUnScroll();
}
function rec3(){
	$("#alert_dialog_show_confirm_box").remove();

	removeUnScroll();
}

//关闭弹出框
function closedShowMsg(){
	$("#alert_dialog_show_msg_box").remove();

	removeUnScroll();
}
//关闭弹出框
function closedShowMsg1(){
	$("#alert_dialog_show_msg_box1").remove();

}

// 关闭底部弹出框
function closeBottomHtml() {
	
	$("#alert_dialog_show_msg_box").remove();

	removeUnScroll();
}

// 关闭弹框
function closeAlertMsg() {
	$("#alertMsg_box").remove();
}

//关闭弹框(没有蒙板)
function closeAlertMsgCallBack(callback) {
	$("#alertMsgCallBack_box").remove();
	callback();
}

// 关闭底部弹出框（没有蒙板）
function closeBottomHtmlNoMask() {
	$("#showBottomHtmlNoMask_box").remove();
}

/********************日历控件开始*******************************/

var startX = 0;
var startY = 0;

// 触摸
function handlerTouchstart(e) {
    startX = e.changedTouches[0].pageX,
    startY = e.changedTouches[0].pageY;
}

// 滑动
function handlerTouchmove(e) {
	e.preventDefault();
    var moveEndX = e.changedTouches[0].pageX;
    var moveEndY = e.changedTouches[0].pageY;
    X = moveEndX - startX,
    Y = moveEndY - startY;
     
    if ( Math.abs(X) > Math.abs(Y) && X > 0 ) { // 右滑
    	
    	// 上一月
        $('.fc-button-prev').trigger("click");
    	
    } else if ( Math.abs(X) > Math.abs(Y) && X < 0 ) { // 左滑
    	
    	// 下一月
        $('.fc-button-next').trigger("click");
    } else if ( Math.abs(Y) > Math.abs(X) && Y > 0) { // 下滑
    	
    } else if ( Math.abs(Y) > Math.abs(X) && Y < 0 ) { // 上滑
    	
    }
}

// 关闭日历控件
function closeShowCalendar() {
	$("#alert_dialog_show_msg_box_c").remove();

	// 释放监听触摸事件
	document.body.removeEventListener('touchstart', handlerTouchstart, {passive: false});

	// 释放监听滑动事件
	document.body.removeEventListener('touchmove', handlerTouchmove, {passive: false});

	removeUnScroll();
}

/********************日历控件结束*******************************/


//禁止滚动条滚动
var m_top = 0;
function unScroll() {
	
	m_top = $(document).scrollTop();
	var bodyTop = "0px";//"-" + m_top + "px";

	$('html').css({"height":"100%","overflow":"hidden"});
	$('body').css({"overflow":"hidden","top": bodyTop,"position":"fixed"});
	
	// 禁止上下滑动
	//document.body.addEventListener('touchmove', handler, {passive: false});
}

//移除禁止滚动条滚动
function removeUnScroll() {

	$('html').css({"height":"","overflow":""});
	$('body').css({"height":"","overflow":"","position":""});

	$(document).scrollTop(m_top);
	
	// 解除禁止上下滑动
	//document.body.removeEventListener('touchmove', handler, {passive: false});
}

//function handler() {
//	event.preventDefault();
//}

function AlertConfirmOk(){
	$("#alert_dialog_show_confirm_box").remove();
	Alert.callbackOk();
	removeUnScroll();
}

function AlertConfirmCancel(){
	$("#alert_dialog_show_confirm_box").remove();
	Alert.callbackCancel();
	removeUnScroll();
}




