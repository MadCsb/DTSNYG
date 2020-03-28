function Pay(){
  /**
   * 微信支付方式
   */
  Pay.prototype.payMethod = null;
  /**
   * 微信支付方式需要的支付信息
   */
  Pay.prototype.payInfo = null;

  /**
   * 我们支付流水编号
   */
  Pay.prototype.platformFlowCode = null;

  /**
   * 微信支付方式-公众号原生
   */
  Pay.prototype.PAY_METHOD_WX = "WX";
  /**
   * 微信支付方式-移动系统
   */
  Pay.prototype.PAY_METHOD_WX_WAP = "WX_WAP";
  /**
   * 微信支付方式-pc系统二维码
   */
  Pay.prototype.PAY_METHOD_WX_PC = "WX_PC";

  /**
   * 微信支付方式-支付宝
   */
  Pay.prototype.PAY_METHOD_ALIPAY_WAP = "ALIPAY_WAP";


  /**
   * 验证支付成功定时器
   */
  Pay.checkPayInterval = null;
}

//payMethod=wx微信浏览器，公众号直接支付
//payMethod=h5移动端html5页面，非微信浏览器打开
//payMethod=pc非移动浏览器打开，二维码
/**
 * 自动获取微信支付方式（根据浏览器类型不同，获取不同支付类型）
 * @returns {*}
 */
Pay.prototype.autoPayMethod = function()
{
  var userAgentInfo = window.navigator.userAgent.toLowerCase();
  if(userAgentInfo.match(/MicroMessenger/i) == 'micromessenger') { //微信浏览器判断
    this.payMethod =this.PAY_METHOD_WX;
  }else
  {
    var isMobile = false;//当前浏览器是否为移动段浏览器，假设移动端浏览器都支持微信了
    var mobileAgents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    for (var v = 0; v < mobileAgents.length; v++) {
      if (userAgentInfo.indexOf(mobileAgents[v]) > 0) { isMobile = false; break; }
    }
    if(isMobile)
    {
      this.payMethod =this.PAY_METHOD_WX_WAP;
    }else {
      this.payMethod =this.PAY_METHOD_WX_PC;
    }
  }
}

/**
 * 获取微信支付信息
 * @param param {openId:微信用户openId,spId:运营商id,platformOrders:订单ids,}
 * @returns {*}
 */
Pay.prototype.getPayInfo = function(param)
{
  // {payMethod:支付方式,openId:微信用户openId,spId:运营商id,platformOrders:订单ids,}
  param.payMethod = this.payMethod;
  var redirecturl = "pay_getPayInfo";
  var payInfoTmp = null;
  $.ajax({
    type : "GET",
    async : false,
    dataType : "json",
    data: {"param":JSON.stringify(param)},
    url: redirecturl,
    success: function(data){
      payInfoTmp = data;
    }
  });
  this.payInfo = payInfoTmp; //{resultCode:成功0,resultMsg:,platformFlowCode:流水id,不同支付必须的信息}
}

/**
 * 调用微信支付
 * @param paySuccessFun
 * @returns {*}
 */
Pay.prototype.toPay = function()
{
  var payInfoObj = this.payInfo;
    //payMethod=wx微信浏览器，公众号直接支付
    if(this.payMethod == this.PAY_METHOD_WX)
    {
      if (typeof WeixinJSBridge == "undefined"){
        if( document.addEventListener ){
          document.addEventListener('WeixinJSBridgeReady', this.toPay, false);
        }else if (document.attachEvent){
          document.attachEvent('WeixinJSBridgeReady', this.toPay);
          document.attachEvent('onWeixinJSBridgeReady', this.toPay);
        }
      }
        WeixinJSBridge.invoke(
            'getBrandWCPayRequest', {
                "appId":payInfoObj.appId.toString(), //"wx2421b1c4370ec43b",     //公众号名称，由商户传入
                "timeStamp":payInfoObj.timeStamp.toString(),//"1395712654",         //时间戳，自1970年以来的秒数
                "nonceStr":payInfoObj.nonceStr.toString(), //"e61463f8efa94090b1f366cccfbbb444", //随机串
                "package":payInfoObj.package.toString(), //u802345jgfjsdfgsdg888
                "signType":payInfoObj.signType.toString(),         //微信签名方式：
                "paySign": payInfoObj.paySign.toString()//"70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名
            },
            function(res){
                if(res.err_msg == "get_brand_wcpay_request:ok" ) { //支付成功，查询支付状态是否成功
                  this.checkPayed();
                }else if(res.err_msg=='get_brand_wcpay_request:cancel'){//支付失败

                }else{ //其他支付状态
                }
            }
        );
    }else if(this.payMethod == this.PAY_METHOD_WX_WAP)    //payMethod=h5移动端html5页面，非微信浏览器打开
    {
        window.location.href = this.payInfo.mweb_url; //返回点击链接
    }else if(this.payMethod == this.PAY_METHOD_WX_PC) //payMethod=pc非移动浏览器打开，二维码
    {
    	return this.payInfo.code_url; //返回微信二维码地址
    }else if(this.payMethod == this.PAY_METHOD_ALIPAY_WAP) //payMethod=ALIPAY_
    {
      document.write(this.payInfo.body); //支付宝wap支付，body就是当前页面具体内容
    }
}

/**
 * 调用微信支付后，验证是否完成支付
 * @param paySuccessFun
 * @returns {*}
 */
Pay.prototype.checkPayed = function()
{
  var payTmp = this;
  if(this.checkPayInterval == null)
  {
    this.checkPayInterval = setInterval(function(){payTmp.checkPayed()},500);
  }else
  {
    var platformFlowCode = this.payInfo.platformFlowCode;
    var flowState = null;
    $.ajax({
      type : "GET",
      async : false,
      dataType : "json",
      data: {
        "d":new Date().getTime(),
        "platformFlowCode":platformFlowCode
      },
      url: "pay_getThirdPayFlow",
      success: function(data){
        flowState = data.flowState;
      }
    });
    if (flowState!= null && flowState=="1")
    {
      clearInterval(this.checkPayInterval);
      this.havePayed();
    }
  }
}

/**
 * 已支付完成后调用的方法 ，需重写
 * @param paySuccessFun
 * @returns {*}
 */
Pay.prototype.havePayed = function()
{

}

