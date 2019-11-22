/** added by jackywu 2016年12月28日 星期三
 * 打印初始化函数
 * initPrintParamsAllInOne(btnPrintId,ndv,btnPrintSetupId,checkReceiptId,rdv)
 * 
 * 没有设置按钮
 * initPrintParamsNoSetup(btnPrintId,ndv)
 * 
 * 有设置按钮
 * initPrintParams(btnPrintSetupId,btnPrintId,ndv)
 * 
 * 有两种格式
 * initPrintParamsWithReceipt(btnPrintSetupId,btnPrintId,ndv,checkReceiptId,rdv)
 * 
 * updated list:
 * 
 */

//普通页面格式打印页面参数
var printLeft=0;
var printTop=0;
var printFontSize=14;
var printZoomRate=1;

//小票格式打印页面参数
var printTopForR=0;
var printLeftForR=0;
var printFontSizeForR=24;
var printZoomRateForR=1;

//是否小票格式
var checkedR=false;
var dialog=null;

var normalDiv=null;
var receiptDiv=null;


/**
 * 打印函数
 * @param btnPrintId
 * @param ndv
 * @param checkReceiptId
 * @param rdv
 * @returns
 */
function initPrintParamsAllInOne(btnPrintId,ndv,btnPrintSetupId,checkReceiptId,rdv){
	//打印，无设置按钮
	if(btnPrintSetupId == null){
		initPrintParamsNoSetup(btnPrintId,ndv);
	}
	else{
		//打印带设置按钮，无小票格式切换
		if(checkReceiptId==null){
			initPrintParams(btnPrintSetupId,btnPrintId,ndv);
		}
		//带小票格式
		else{
			initPrintParamsWithReceipt(btnPrintSetupId,btnPrintId,ndv,checkReceiptId,rdv);
		}
	}
}

//打印，不用设置
function initPrintParamsNoSetup(btnPrintId,ndv){	
	if (typeof(ndv) != "undefined"&&ndv !=null){
		normalDiv=ndv;
	}
    //绑定打印按钮事件
	$("#"+btnPrintId).click(
		function(){	
			$("#"+normalDiv).show();
			$("#"+normalDiv).removeClass("noPrint");
		 
			//弹出打印参数设置界面
			window.print();
		}
    );
	
	loadSettingFromCookie();
	applyPrintSettings();
}


/*
 * 有时候弹出打印设置对话框，设置参数时，
 * 对话框会往下掉，或者对话框后面的主页面滚动条一直增加，
 * 这时候，给主页面的body增加宽度和高度设置就能解决问题
 * 
 */
//通用打印
function initPrintParams(btnPrintSetupId,btnPrintId,ndv,teamInfoId,type){
	if (typeof(ndv) != "undefined"&&ndv !=null){
		normalDiv=ndv;
	}
	
    //加载打印机配置事件
	$("#"+btnPrintSetupId).click(function printSetup() {		
			loadPrintSettings();
			openPrintSetupDialog();
	});

    //绑定打印按钮事件
	$("#"+btnPrintId).click(
		function(){	
			applyPrintSettings();
			if(null != teamInfoId && "" != teamInfoId){
				addPrintTeamOpRecord(teamInfoId,type);
			}
			//弹出打印参数设置界面
			window.print();
		}
    );

    //保存打印机配置参数
	$("#btnPrintSave").click(function (){		
		savePrintSettings();	
		
        dialog.close();
     });
 
	//绑定按钮事件
	bindEditKeyUpEvent();
	
	
	loadSettingFromCookie();
	loadPrintSettings();
	applyPrintSettings();
}

//有小票格式
function initPrintParamsWithReceipt(btnPrintSetupId,btnPrintId,ndv,checkReceiptId,rdv){
	if (typeof(ndv) != "undefined"&&ndv !=null){
		normalDiv=ndv;
	}
	
	if (typeof(rdv) != "undefined"&&rdv !=null){
		receiptDiv=rdv;
	}
	
	//设置下 普通页面的打印设置参数
	loadSettingFromCookie();	
	applyPrintSettings();
	
	if (typeof(checkReceiptId) != "undefined"&&checkReceiptId !=null )
	{
		checkedR=$("#"+checkReceiptId).attr("checked")=="checked";
		loadSettingFromCookie();
		loadPrintSettings();
		applyPrintSettings();
	}
	
    //勾选小票格式	
	$("#"+checkReceiptId).click(function(){
	   checkedR=$("#"+checkReceiptId).attr("checked")=="checked";	 
	   
	   loadSettingFromCookie();
	   loadPrintSettings();
	   applyPrintSettings();
	});


    //加载打印机配置事件
	$("#"+btnPrintSetupId).click(function printSetup() {
		loadPrintSettings();

		openPrintSetupDialog();
	});

    //绑定打印按钮事件
	$("#"+btnPrintId).click(
		function(){	
			applyPrintSettings();	
			
			if(checkedR){
				$("#"+receiptDiv).show();
				$("#"+receiptDiv).removeClass("noPrint");

				$("#"+normalDiv).hide();
				$("#"+normalDiv).addClass("noPrint");
			}
						
			//弹出打印参数设置界面
			window.print();

			//恢复普通页面模式			
			$("#"+receiptDiv).hide();
			$("#"+receiptDiv).addClass("noPrint");

			$("#"+normalDiv).show();
			$("#"+normalDiv).removeClass("noPrint");		
		}
    );

    //保存打印机配置参数
	$("#btnPrintSave").click(function (){
		savePrintSettings();
		
        dialog.close();
     });
 
	//绑定按钮事件
	bindEditKeyUpEvent();
	
	
}

//绑定按钮事件
function bindEditKeyUpEvent(){
	 //绑定上部留空按键抬起事件
    $("#topMargin").keyup(function(){
   	 //alert($(this).val()+"px");
		 if(checkedR){
			$("#"+receiptDiv).css("margin-top",$(this).val()+"px");
		 }
		 else{
			$("#"+normalDiv).css("margin-top",$(this).val()+"px");
		 }
   	  
    });

	 //绑定上部留空按键抬起事件
    $("#leftMargin").keyup(function(){
   	 if(checkedR){
			$("#"+receiptDiv).css("margin-left",$(this).val()+"px");
		 }
		 else{
			$("#"+normalDiv).css("margin-left",$(this).val()+"px");
		 }
    });

	 //绑定字体大小设置按键抬起事件
	 $("#fontSize").keyup(function(){
	   	 if(checkedR){
			$("#"+receiptDiv).css("font-size",$(this).val()+"px");
		 }
		 else{
			$("#"+normalDiv).css("font-size",$(this).val()+"px");
		 }
    });
	 
	//绑定字体大小设置按键抬起事件	
	$("#zoomRate").keyup(function(){
	   	if(checkedR){
			$("#"+receiptDiv).css("zoom",$(this).val());
		}
		else{
			$("#"+normalDiv).css("zoom",$(this).val());
		}
    });
	
	//绑定字体大小设置按键抬起事件	
	/*$("#zoomRate").keypress(function(){
		alert($(this).val());
		//$(this).val($(this).val()+1);
    });*/
}

//打开打印设置对话框
function openPrintSetupDialog(){
  	dialog = art.dialog({
	    drag:false,
	    content: document.getElementById("divPrintSetup"),
		//background: '#600', // 背景色
		opacity: 0.2,	// 透明度
		left:"40%",
		top:"30%",
		width:500,
		height:400,
		close:function(){
			applyPrintSettings();
		}
	});	
}

//加载打印设置
function loadPrintSettings(){
	if(checkedR){
		$("#topMargin").val(printTopForR);
		$("#leftMargin").val(printLeftForR);
		$("#fontSize").val(printFontSizeForR);
		$("#zoomRate").val(printZoomRateForR);
	}
	else{
		$("#topMargin").val(printTop);
		$("#leftMargin").val(printLeft);
		$("#fontSize").val(printFontSize);
		$("#zoomRate").val(printZoomRate);
	}
}

//保存打印设置
function savePrintSettings(){
	if(checkedR){
		printTopForR=$("#topMargin").val();
		printLeftForR=$("#leftMargin").val();
		printFontSizeForR=$("#fontSize").val();
		printZoomRateForR=$("#zoomRate").val();
	}
	else{
		printTop=$("#topMargin").val();
		printLeft=$("#leftMargin").val();
		printFontSize=$("#fontSize").val();
		printZoomRate=$("#zoomRate").val();
	}
	
	saveSetting2Cookie();
}

//替换所有
function ReplaceAll(str, sptr, sptr1){
    while (str.indexOf(sptr) >= 0){
       str = str.replace(sptr, sptr1);
    }
    return str;
}

//从cookie加载打印参数设置
function loadSettingFromCookie(){
	var url=window.location.pathname;
	url=ReplaceAll(url,"/",".")+".";
	
	var printTop_cookie= $.cookie(url+'printTop');
	var printLeft_cookie= $.cookie(url+'printLeft');
	var printFontSize_cookie= $.cookie(url+'printFontSize');	
	var printZoomRate_cookie= $.cookie(url+'printZoomRate');
	
	var printTopForR_cookie= $.cookie(url+'printTopForR');
	var printLeftForR_cookie= $.cookie(url+'printLeftForR');
	var printFontSizeForR_cookie= $.cookie(url+'printFontSizeForR');	
	var printZoomRateForR_cookie= $.cookie(url+'printZoomRateForR');
	
	if(checkedR){
		if(typeof printLeftForR_cookie != 'undefined'){
			printLeftForR=printLeftForR_cookie;
		}
		else{
			printLeftForR=$("#"+receiptDiv).css("margin-left");
			printLeftForR=ReplaceAll(printLeftForR,"px","");
		}
		
		if(typeof printTopForR_cookie != 'undefined'){
			printTopForR=printTopForR_cookie;
		}
		else{
			printTopForR=$("#"+receiptDiv).css("margin-top");
			printTopForR=ReplaceAll(printTopForR,"px","");
		}

		if(typeof printFontSizeForR_cookie != 'undefined'){
			printFontSizeForR=printFontSizeForR_cookie;
		}
		else{
			printFontSizeForR=$("#"+receiptDiv).css("font-size");
			printFontSizeForR=ReplaceAll(printFontSizeForR,"px","");
		}
		
		if(typeof printZoomRateForR_cookie != 'undefined'){
			printZoomRateForR=printZoomRateForR_cookie;
		}
		else{
			printZoomRateForR=$("#"+receiptDiv).css("zoom");
			printZoomRateForR=ReplaceAll(printZoomRateForR,"px","");
			printZoomRateForR=ReplaceAll(printZoomRateForR,"normal","1");
			printZoomRateForR=ReplaceAll(printZoomRateForR,"100%","1");
		}
	}
	else{
		if(typeof printLeft_cookie != 'undefined'){
			printLeft=printLeft_cookie;
		}
		else{
			printLeft=$("#"+normalDiv).css("margin-left");
			printLeft=ReplaceAll(printLeft,"px","");
		}
		
		if(typeof printTop_cookie != 'undefined'){
			printTop=printTop_cookie;
		}
		else{
			printTop=$("#"+normalDiv).css("margin-top");
			printTop=ReplaceAll(printTop,"px","");
		}

		if(typeof printFontSize_cookie != 'undefined'){
			printFontSize=printFontSize_cookie;
		}
		else{
			printFontSize=$("#"+normalDiv).css("font-size");
			printFontSize=ReplaceAll(printFontSize,"px","");
		}
		
		if(typeof printZoomRate_cookie != 'undefined'){
			printZoomRate=printZoomRate_cookie;
		}
		else{
			printZoomRate=$("#"+normalDiv).css("zoom");
			printZoomRate=ReplaceAll(printZoomRate,"px","");
			printZoomRate=ReplaceAll(printZoomRate,"normal","1");
			printZoomRate=ReplaceAll(printZoomRate,"100%","1");
		}
	}
}

//保存参数到cookie
function saveSetting2Cookie(){
	var url=window.location.pathname;
	url=ReplaceAll(url,"/",".")+".";
	var options={expires: 99999}
	//存入cookie
	if(checkedR){
		$.cookie(url+'printTopForR',printTopForR,options);
		$.cookie(url+'printLeftForR',printLeftForR,options);
		$.cookie(url+'printFontSizeForR',printFontSizeForR,options);	
		$.cookie(url+'printZoomRateForR',printZoomRateForR,options);
	}
	else{
		$.cookie(url+'printTop',printTop,options);
		$.cookie(url+'printLeft',printLeft,options);
		$.cookie(url+'printFontSize',printFontSize,options);	
		$.cookie(url+'printZoomRate',printZoomRate,options);
	}
}

function applyPrintSettings(){
	//按照小票格式
	if(checkedR){
	/*	$("#"+receiptDiv).show();
		$("#"+receiptDiv).removeClass("noPrint");

		$("#"+normalDiv).hide();
		$("#"+normalDiv).addClass("noPrint");*/
   
		$("#"+receiptDiv).css("margin-left",printLeftForR+"px");
		$("#"+receiptDiv).css("margin-top",printTopForR+"px");
		$("#"+receiptDiv).css("font-size",printFontSizeForR+"px");
		$("#"+receiptDiv).css("zoom",printZoomRateForR);
   }
   //按照普通页面模式
   else{			
	  /* if(receiptDiv!=null){
		   $("#"+receiptDiv).hide();
		   $("#"+receiptDiv).addClass("noPrint");
	   }
	 
	   $("#"+normalDiv).show();
	   $("#"+normalDiv).removeClass("noPrint");*/
			
	   $("#"+normalDiv).css("margin-left",printLeft+"px");
	   $("#"+normalDiv).css("margin-top",printTop+"px");
	   $("#"+normalDiv).css("font-size",printFontSize+"px");
	   $("#"+normalDiv).css("zoom",printZoomRate);
   }					
}
/**
 * 团队行程单打印插入业务处理记录
 * @param teamInfoId
 * @param type
 */
function addPrintTeamOpRecord(teamInfoId,type){	
	$.ajax({
		   type: "POST",
		   url:"teamTrip.do?method=addPrintTeamOpRecord",           
		   data: {
			   "teamInfoId":teamInfoId,
			   "type":type
		   },
		   success: function(data){           
		   }
		 });
}
