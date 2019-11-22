/**
 * Created by cheng on 2019/10/29.
 * snyg项目特有属性
 */

var currentSpId = "da14b98e-cb26-4169-9b58-babe98b98047";

/**
 * 跳转首页
 * searchObject
 */
function toIndex(){
  window.location.href = "wx?method=wxIndex&spId="+currentSpId;
}

/**
 * 跳转分页
 * searchObject
 */
function toPdcTypeList(){
  window.location.href = "wx?method=toQueryPdcTypeList&spId="+currentSpId;
}

/**
 * 跳转我的购物车
 */
function toShopCart(){
 var detailUrl = "wx?method=toQueryShopCartWx";
  wxAuthorizeBase(detailUrl);
}
/**
 * 跳转个人中心
 * searchObject
 */
function toPersonal(){
  wxAuthorizeBase("wxpersonal.do?method=toPersonal");
}
/**
 * 跳转我的订单
 * orderListType = 0 全部订单
 * searchObject
 * orderListType = 1 待支付
 * orderListType = 2 待发货
 * orderListType = 3 待收货
 * orderListType = 4 退换货
 */
function toOrderList(orderListType){
  if(typeof(orderListType) == "undefined")
  {
    orderListType = "0";
  }
  wxAuthorizeBase("wxorder.do?method=toOrderList&orderListType="+orderListType);
}


/**
 * 跳转我的收货地址
 */
function toConsignee(){
  wxAuthorizeBase("wx?method=toQueryConsignee");
}

/**
 * 跳转文章详情
 */
function toArticle(articleId){
  window.location.href = "wx.do?method=showArticle&articleId="+articleId;
}

/**
 * 跳转销售详情
 */
function toSellPrice(priceId){
  wxAuthorizeBase("wx?method=toQueryCommproductDetailByPriceId&priceId="+priceId);
}

/**
 * 跳转订单详情
 */
function toOrder(orderId){
  wxAuthorizeBase("wxorder?method=toOrderDetail&orderId="+orderId);
}
/**
 * 跳转订单物流详情
 */
function toOrderExpress(orderId){
  window.location.href = "wxorder?method=toOrderExpress&orderId="+orderId;
}
/**
 * 跳转订单退货详情
 */
function toOrderBack(orderId){
  window.location.href = "wxorder?method=toOrderBack&orderId="+orderId;
}
/**
 * 跳转订单退货详情
 */
function toOrderBackDetail(orderId){
  window.location.href = "wxorder?method=toOrderBackDetail&orderId="+orderId;
}
/**
 * 跳转提醒发货
 */
function alertMsg(msg){
  Alert.show3sMsg(msg);
}
