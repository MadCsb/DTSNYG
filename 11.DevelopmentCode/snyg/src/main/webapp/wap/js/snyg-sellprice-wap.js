var alertHtml = "";


//获得价格策略
function getSellPriceList(contextPath){
	$.post("wapSellPrice?method=queryGoodsPriceListForWx",{
		productId:$("#productId").val(),
		priceType:$("#priceType").val(),
		delFlag:'0'
	},function(data){
		if(data!=null && data.length>0){
			var str = "";
			var str1 = "";
			for(var i=0;i<data.length;i++){
				str+='<div class="spgg_title"';
				if($("#priceId").val() ==  data[i].priceId){
					checkPriceId = data[i].priceId;
					if(data[i].freight == ""){
						$("#kuaidi").html("快递 免运费");
					}else{
						$("#kuaidi").html("快递 "+data[i].freight);
					}
					
					$("#goodsPriceNameCheck").html(data[i].priceName);
				}else{
					str+="style='display:none;'"
				}
				str+=' id="pricePic'+data[i].priceId+'">';
				str+='<div class="sptucss"><img src="'+contextPath+'/upload/wxpic/'+data[i].thumbPic+'"></div>';
				str+='<span class="f1" style="margin-left:120px; line-height:50px;">&yen;'+data[i].price+'</span><a class="closdiv" onclick="ydNone()"></a>';      
				str+='</div>';
				str+='<input type="hidden" id="limitBuyCount'+data[i].priceId+'" value="'+data[i].limitBuyCount+'"/>';
				str+='<input type="hidden" id="maxBuyCount'+data[i].priceId+'" value="'+data[i].maxBuyCount+'"/>';
				if($("#priceId").val() ==  data[i].priceId){
					str1+='<button class="spggflon" onclick="checkGoodsPrice(\''+data[i].priceId+'\',this)">'+data[i].priceName+'</button>';
				}else{
					str1+='<button class="spggfloff" onclick="checkGoodsPrice(\''+data[i].priceId+'\',this)">'+data[i].priceName+'</button>';
				}
			}
			$("#picAndPrice").html(str);
			$("#goodsPriceDiv").html(str1);
		}
		
		alertHtml = $("#tcyddiv").html()
		$("#tcyddiv").remove();
	},'json');
}

//选择价格策略
function checkGoodsPrice(priceId,obj){
	$(".spgg_title").hide();
	$("#pricePic"+priceId).show();
	
	$(".spggflon").removeClass("spggflon").addClass("spggfloff");
	$(obj).removeClass("spggfloff").addClass("spggflon");
	
	checkPriceId = priceId;
	
	var num = parseInt($("#num").val());
	var limitBuyCount = parseInt($("#limitBuyCount"+priceId).val());
	var maxBuyCount = parseInt($("#maxBuyCount"+priceId).val());
	
	if(num < limitBuyCount){
		$("#num").val(limitBuyCount);
	}else if(num > maxBuyCount){
		$("#num").val(maxBuyCount);
	}
}

//修改数量
function changeNum(type){
	var num = parseInt($("#num").val());
	if(type=="1"){
		if(num >1){
			num --;
		}else{
			num = 1;
		}
	}else{
		num++;
	}
	var limitBuyCount = parseInt($("#limitBuyCount"+checkPriceId).val());
	var maxBuyCount = parseInt($("#maxBuyCount"+checkPriceId).val());
	
	if(num < limitBuyCount){
		$("#num").val(limitBuyCount);
		Alert.showMsg2("该商品最少购买"+limitBuyCount+"个");
	}else if(num > maxBuyCount){
		$("#num").val(maxBuyCount);
		Alert.showMsg2("该商品最多购买"+maxBuyCount+"个");
	}else{
		$("#num").val(num)	
	}
	
}

//点击确定 加入购物车 或者提交订单
function addShopCart(){
	if(showType == "1"){
		$.post("wapIndex?method=checkLogin",{
		},function(data){
			if(data.resultCode=='0'){
				$.post("wapShopCart?method=toAddOrUpdateShopCart",{
					priceId:checkPriceId,
					num:$("#num").val()
				},function(data){
					if(data=="success"){
						closeBottomHtml();
						Alert.showMsg("加入购物车成功");
					}
				});
			}else{
				closeBottomHtml();
				Alert.showConfirmMsg("您还没有登录，请先登录",'toLogin');
			}
		},'json')
		
	}else{
		submitOrder();
	}
}

//显示
function ydShow(showTypeInfo,refPatchCodeTemp)
{
	
   showType = showTypeInfo;
   refPatchCode = refPatchCodeTemp;
   Alert.showBottomHtml(alertHtml);
   $("#alert_show_3").css("height", "290");
   

	var num = parseInt($("#num").val());
	var limitBuyCount = parseInt($("#limitBuyCount"+checkPriceId).val());
	var maxBuyCount = parseInt($("#maxBuyCount"+checkPriceId).val());
	
	if(num < limitBuyCount){
		$("#num").val(limitBuyCount);
	}else if(num > maxBuyCount){
		$("#num").val(maxBuyCount);
	}else{
		$("#num").val(num)	
	}
}
//关闭
function ydNone()
{
	closeBottomHtml();
}