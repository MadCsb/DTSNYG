

//复制链接
function copyUrlChannel(priceCode){
	var url = $("#domainName").val()+"/open/"+currentSpId+"/"+priceCode;
	$("#copyHidden").val(url);
	var copyText = $("#copyHidden");//获取对象
    copyText.select();//选择
    document.execCommand("Copy");//执行复制
　　parent.layer.alert("复制成功！");
} 


function delPrice(priceId) {
	var index = parent.layer.confirm('确认删除该商品吗?', function() {
		$.post("sellPrice?method=delete", {
			priceId : priceId
		}, function(ret) {
			if (ret=="success") {
				var index2 = parent.layer.alert("删除成功",function(){
					$("#queryFrm").submit();

					parent.layer.closeAll();
				}); 
			}
		})
	}, function() {
		parent.layer.closeAll();
	});
}

function toQueryForAdd(){
	var content = "sellPrice?method=toQuerySellPriceListForAdd&priceType="+$("#priceType").val();
	parent.layer.open({
		type : 2,
		title : '管理活动商品',
		area : [ '1320px', '600px' ],
		fix : true,
		content :content,
		end: function(){
			$("#queryFrm").submit();
		}
	});
}

function delCheckSellPrice(checkId){
	$("#"+checkId).remove();
} 


function saveSellPrice(){
	if ($("#priceForm").validationEngine('validate')){
		var priceType = $("#priceType").val();

		if(priceType=="" || priceType=="undefined" || priceType==undefined){
			parent.layer.alert("系统错误，请重新进入该页面");
		}else{
			var len = $("#saveTable tr").length;
			if(len > 1){
				layer.load(2,{shade: [0.2, '#000']});
				$("#priceForm").submit();
			}else{
				parent.layer.alert("请选择活动商品");
			}
		}
	}
}



function setDate(){
	var priceStartDate = $("#priceStartDate").val();
	var priceEndDate = $("#priceEndDate").val();
	
	$(".dateStartClass").each(function(i){
		if($(this).val()==""){
			$(this).val(priceStartDate);
		}
	});
	
	$(".dateEndClass").each(function(i){
		if($(this).val()==""){
			$(this).val(priceEndDate);
		}
	});
}