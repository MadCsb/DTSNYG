var m_pdcType;
var m_pmastCoding;
var m_pdcId;
var m_fansId;

// 打开优惠券
function showCoupon(pdcType, pmastCoding, pdcId, fansId) {

	m_pdcType = pdcType;
	m_pmastCoding = pmastCoding;
	m_pdcId = pdcId;
	m_fansId = fansId;

	var html = '<div id="yddiv" class="yddiv" style="height:400px; background:#FFFFFF;">'
		+ '<div class="content">'
		+ '<div class="details-title1">'
		+ '<span class="btline"></span>优惠券<a class="closdiv" onclick="closeBottomHtml()"></a> '
		+ '</div>'
		+ '<dl class="xlxqcss" style="height:255px; overflow-y:auto; overflow-x:hidden;">'
		+ '<ul class="tcyhj" id="ulCouponList">';
	html = html
		+ '</ul>'
		+ ' </dl>'
		+ '<div align="center"><span class="btn-big" onclick="closeBottomHtml()">完成</span></div>'
		+ '</div>' + '</div>';
	
	Alert.showBottomHtml(html);

	loadCouponUlList();
}

// 领取优惠券
function receiveCouponAjax(couponId, fansId) {

	event.cancelBubble=true;
	// 所有按钮不可用
	$(".btnReceiveCoupon").attr("disabled", true); 
	

	$.post("wxCoupon.do?method=receiveCouponSquareAjax", {
		couponId : couponId,
		userId : fansId
	}, function(data) {
		data = eval('(' + data + ')');
		if (data.resultCode == "0") {
			Alert.alertMsgCallBack("领取成功", 'receiveSuccess');
		} else {
			Alert.alertMsgCallBack(data.resultMsg, 'receiveError');
		}
	})
}

/**
 * 领取成功
 */
function receiveSuccess() {
	
	// 按钮可用
	$(".btnReceiveCoupon").removeAttr("disabled"); 
	
	// 加载数据
	loadCouponUlList();
}

/**
 * 领取失败
 */
function receiveError() {
	
	// 按钮可用
	$(".btnReceiveCoupon").removeAttr("disabled"); 
}


// 加载数据
function loadCouponUlList() {
	
	$("#ulCouponList").html("");
	
	$.post("wxCoupon.do?method=queryCouponList", {
		pdcType : m_pdcType,
		pmastCoding : m_pmastCoding,
		priceId : m_pdcId,
		userId : m_fansId
	},
	function(data) {

		data = eval("(" + data + ")");

		if (data != null && data.length > 0) {
			var html = "";
			for (var i = 0; i < data.length; i++) {
				html = html + '<li>'
						+ '<div class="tcyhj-list">'
						+ '<a href="javascript:void(0)" onclick="openCouponRule(\'' + data[i].couponId + '\')"><div class="tcyhj-bt">';

				// 满减
				if (data[i].useType == "1") {
					html = html + '<p class="btzi">&yen;'
							+ parseFloat(data[i].discount)
							+ '</p>'
							+ '<span class="nrzi">代金券</span>'
							+ '<span class="leftyuan"></span>'
							+ '<span class="rightyuan"></span>'
							+ '<p style="color: #333333;">订单金额满'
							+ parseFloat(data[i].useLimit)
							+ '可使用</p>';
				} else if (data[i].useType == "2") {
					html = html + '<p class="btzi">'
							+ parseFloat(data[i].discount)
							+ '折</p>'
							+ '<span class="nrzi">打折券</span>'
							+ '<span class="leftyuan"></span>'
							+ '<span class="rightyuan"></span>'
							+ '<p style="color: #333333;">订单金额满'
							+ parseFloat(data[i].useLimit)
							+ '可使用</p>';
				}

				html = html
						+ '<p style="color: #333333;">有效期'
						+ data[i].validBegin
						+ '至'
						+ data[i].validEnd
						+ '</p>'
						+ '</div></a>'
						+ '<a href="javascript:void(0)" onclick="receiveCouponAjax(\''+ data[i].couponId + '\',\'' + m_fansId+ '\')"><div class="tcyhj-data">立即领取</div></a>'
						+ '</div>' + '</li>';
			}
			
			$("#ulCouponList").html(html);
		}
	})
}

// 打开使用规则
function openCouponRule(couponId) {
	event.cancelBubble=true;
	$.post("wxCoupon.do?method=couponRuleAjax",{
		couponId : couponId
	},function(data){
		data = eval("(" + data + ")");
		
		var text3 = "";
		
		// 全部商品
		if (data.coupon.couponType == "1") {
			text3 = '3. 本优惠券针对本平台/本商户所有品类的商品使用，结算时可抵扣或减免相应面额的商品费用，但不包含配送费，不设找零，超额需补差价，一次只能使用一张优惠券；';
		} else {
			text3 = '3. 本优惠券只针对<span class="f1">' + data.goodsName + '</span>商品使用，其他商品无法享受本次优惠/本优惠券针对平台类内所有商品使用，结算时可抵扣或减免相应面额的商品费用，但不包含配送费，不设找零，超额需补差价，一次只能使用一张优惠券；';
		}
		
		var html = '<div class="yddiv" style="height:400px; background:#FFFFFF;">'
			+ '<div class="content">'
			+ '<div class="details-title1">'
			+ '<span class="btline"></span>使用规则<a class="closdiv" onclick="closeBottomHtmlNoMask()"></a>'
			+ '</div>'
			+ '<dl class="xlxqcss" style="height:310px;overflow-y:auto;">'
			+ '<dd>1. 优惠券是<span class="f1">三农壹购</span>的优惠购买的方式之一；</dd></br>'
			+ '<dd>2. 您可通过优惠活动领取相应优惠券(例如满减活动、满折活动等)，或待平台邀请您参与相关优惠活动参与领券；</dd></br>'
			+ '<dd>' + text3 + '</dd></br>'
			+ '<dd>4. 本优惠券有效期为<span class="f1">' + data.coupon.validBegin + '至' + data.coupon.validEnd+ '</span>，超出即为失效将无法使用。 </dd>'
			+ '</dl>'
			+ '</div>'
			+ '</div>';

		Alert.showBottomHtmlNoMask(html);
	})
}

