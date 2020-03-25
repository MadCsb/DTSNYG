/**
 * Created by cheng on 2019/10/17.
 */
function OpenApi(){
  OpenApi.prototype.WEB = "WEB"; //WEB PC页面
  OpenApi.prototype.WX = "WX"; //微信公众号
  OpenApi.prototype.WAP = "WAP"; //HTML 5 页面
  OpenApi.prototype.pageType = null; //页面类型，只能是WEB WX WAP
}
/**
 * 如果 参数pageType等于以支持的页面，则this.pageType=参数
 * 否则 通过浏览器设置则this.pageType
 */
Person.prototype.resetDefaultPageType = function (pageType) {
  if (this.WEB == pageType || this.WX == pageType || this.WAP == pageType)
  {
    this.pageType = pageType;
  }else
  {
    var userAgentInfo = window.navigator.userAgent.toLowerCase();
    if(userAgentInfo.match(/MicroMessenger/i) == 'micromessenger') { //微信浏览器判断
      this.pageType = this.WX;
    }else
    {
      var isMobile = false;//当前浏览器是否为移动段浏览器，假设移动端浏览器都支持微信了
      var mobileAgents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
      for (var v = 0; v < mobileAgents.length; v++) {
        if (userAgentInfo.indexOf(mobileAgents[v]) > 0) { isMobile = true; break; }
      }
      if(isMobile)
      {
        this.pageType  = this.WAP;
      }else {
        this.pageType  = this.WEB;
      }
    }
  }
  return this.pageType;
}

/**
 * 根据 pageType 不同，跳转不同的销售详情
 * param.priceId 销售ID
 * param.spId 运营商ID
 */
Person.prototype.gotoSellPrice = function (param) {
  if (this.pageType == null)
  {
    this.resetDefaultPageType();
  }

  var detailUrl = "";
  if (this.pageType == this.WX)
  {
    detailUrl = "${rc.contextPath}/wx?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId+"&spId="+param.spId;
  }else if (this.pageType == this.WEB)
  {
    detailUrl = "${rc.contextPath}/webCommproduct?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId;
  }else if (this.pageType == this.WAP)
  {
    detailUrl = "${rc.contextPath}/wapCommproduct?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId+"&spId="+param.spId;
  }
  window.location.replace(detailUrl)
}


/**
 * 根据 pageType 不同，跳转不同的订单列表
 * param.spId 运营商ID
 */
Person.prototype.gotoOrderList = function (param) {
  if (this.pageType == null)
  {
    this.resetDefaultPageType();
  }

  var detailUrl = "";
  if (this.pageType == this.WX)
  {
    detailUrl = "${rc.contextPath}/wx?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId+"&spId="+param.spId;
  }else if (this.pageType == this.WEB)
  {
    detailUrl = "${rc.contextPath}/webCommproduct?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId;
  }else if (this.pageType == this.WAP)
  {
    detailUrl = "${rc.contextPath}/wapCommproduct?method=toQueryCommproductDetailByPriceId&priceId="+param.priceId+"&spId="+param.spId;
  }
  window.location.replace(detailUrl)
}

