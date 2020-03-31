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
OpenApi.prototype.resetDefaultPageType = function (pageType) {
  this.pageType = null;
  if (this.WEB == pageType || this.WX == pageType || this.WAP == pageType)
  {
    this.pageType = pageType;
  }else {
    //平台、设备和操作系统 
    var system = {
      win: false,
      mac: false,
      xll: false,
      ipad: false
    };
    //检测平台 
    var p = navigator.platform;
    system.win = p.indexOf("Win") == 0;
    system.mac = p.indexOf("Mac") == 0;
    system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
    system.ipad = (navigator.userAgent.match(/iPad/i) != null) ? true : false;
    //跳转语句，如果是手机访问就自动跳转到wap.baidu.com页面 
    if (system.win || system.mac || system.xll || system.ipad) {
      this.pageType = this.WEB;
    } else {
      var ua = navigator.userAgent.toLowerCase();
      if (ua.match(/MicroMessenger/i) == "micromessenger") {
        this.pageType = this.WX;
      } else {
        this.pageType = this.WAP;
      }
    }
  }
  return this.pageType;
}

