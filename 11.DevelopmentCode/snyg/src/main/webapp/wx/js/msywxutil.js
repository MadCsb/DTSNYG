/**
 * 参考https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 * scope=snsapi_base，不弹出授权页面，直接跳转，只能获取用户openid
 * @param appId
 * @param redirecturl
 */
function wxAuthorizeBase(redirecturl){
	var appId = "wx43f80960a6089397";
	var redirecturl = "http://www.3nong1gou.com/"+redirecturl;
	var url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="
		+ appId + "&redirect_uri="
		+ encodeURIComponent(redirecturl)
		+ "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";

	location.href=url;
}

/**
 * 参考https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 * scope=snsapi_userinfo，弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 
 * @param appId
 * @param redirecturl
 */
function wxAuthorizeUserinfo(appId, redirecturl){
	var url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="
		+ appId + "&redirect_uri="
		+ encodeURIComponent(redirecturl)
		+ "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
	
	location.href=url;
}

/**
 * 计算字符串长度（中文算两位）
 * @returns {Number}
 */
function getStrLengthCom(str) {
	var tmp = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charAt(i).match(/[^\x00-\xff]/ig) != null) {
			tmp += 2;
		} else {
			tmp += 1;
		}
	}
	return tmp;
}

/**
 * 身份证校验
 * @param code
 * @returns {Boolean}
 */
function identityCodeValid(code) { 
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var tip = "";
    var pass= true;

    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
        tip = "身份证号格式错误";
        pass = false;
    }

   else if(!city[code.substr(0,2)]){
        tip = "地址编码错误";
        pass = false;
    }
    else{
        //18位身份证需要验证最后一位校验位
        if(code.length == 18){
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++)
            {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if(parity[sum % 11] != code[17]){
                tip = "校验位错误";
                pass =false;
            }
        }
    }
    return pass;
}

// 验证手机号
function isPhoneNoCom(phone) {
    var pattern = /^1[345789]\d{9}$/;
    return pattern.test(phone);
}


//开始支付
function startPayCom(orderId, serviceUrl, spId, appId, payAfterFunction) {
	
	$.post("wx.do?method=getPayInfo",{
		orderId : orderId
	},function(data) {

		var payInfo = eval("("+data+")");
		
		WeixinJSBridge.invoke(
			'getBrandWCPayRequest', {
                "appId":payInfo.appId.toString(), //"wx2421b1c4370ec43b",     //公众号名称，由商户传入
                "timeStamp":payInfo.timeStamp.toString(),//"1395712654",         //时间戳，自1970年以来的秒数
                "nonceStr":payInfo.nonceStr.toString(), //"e61463f8efa94090b1f366cccfbbb444", //随机串
                "package":payInfo.package.toString(), //u802345jgfjsdfgsdg888
                "signType":payInfo.signType.toString(),         //微信签名方式：
                "paySign": payInfo.paySign.toString()//"70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名
            }, function(res){

                if(res.err_msg == "get_brand_wcpay_request:ok" ) { //支付成功，查询支付状态是否成功
                	
                	// 跳转到我的订单
            		var url = serviceUrl + "/" + "wx.do?method=queryOrderListAll&spId=" + spId;
            		wxAuthorizeBase( url);
                	
                } else if(res.err_msg=='get_brand_wcpay_request:cancel'){//支付失败
                	Alert.showMsg("支付失败");
                
                	payAfterFunction();
        			
                } else{ //其他支付状态
                }
            }
        );
        if (typeof WeixinJSBridge == "undefined"){
            if(document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
	})
}

/**
 * url过长时，改用form提交
 */
function submitByUrlCom(url){
	var index = url.indexOf("?");
	var action = url.substring(0, index) + "?";
    var str = url.substring(index + 1, url.length);

    var items = str.split("&");
    
    var form = '<form id="urlSubmitForm" action="' + action + '" style="display:none" method="post">';
	
    var arr,name,value;
    
    for(var i = 0, l = items.length; i < l; i++){
        arr = items[i].split("=");
        name = arr[0];
        value = arr[1];
        
        if (name == "orderCustomerListJson" || name == "ticketCustomerJson") {
        	var reg = new RegExp("\"","g");
        	value = value.replace(reg,"&quot;");
        	form = form + '<textarea name="' + name + '">' + value + '</textarea>';
        } else {
            form = form + '<input type="hidden" name="' + name + '" value="' + value + '">';
        }
    }
    
    form = form + '</form>';
    
    $('body').append(form);
    $("#urlSubmitForm").submit();
}