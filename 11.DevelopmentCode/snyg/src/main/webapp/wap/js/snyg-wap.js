
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

/**
 * 获取微信用户的订单
 * sync true 异步, false 同步
 * searchObject
 * searchObject.searchKey搜索关键字
 * searchObject.userId 用户id
 * searchObject.payTag支付状态
 * searchObject.beforePayStatus支付前状态
 * searchObject.status支付后订单状态
 * searchObject.backNumS是否有退订
 * pageEntity
 * pageEntity.pageNum 查询分页数
 * pageEntity.pageSize 查询每页数量
 */
function ajaxOrderList(sync,searchObject,pageEntity)
{
  var orderList = null;
  $.ajax({
    type: "POST",
    async: sync,
    dataType: "json",
    url: "webOrder?method=ajaxOrderList",
    data: {
      d:new Date().getTime(),
      userId:searchObject.userId,
      searchKey: searchObject.searchKey,
      payTag: searchObject.payTag,
      createTimeS:searchObject.createTimeS,
      createTimeE:searchObject.createTimeE,
      orderCodeLike:searchObject.orderCodeLike,
      beforePayStatus: searchObject.beforePayStatus,
      status: searchObject.status,
      backNumS: searchObject.backNumS,
      pageNum: pageEntity.pageNum,
      pageSize: pageEntity.pageSize
    },
    success: function (data) {
      orderList = data;
    }
  });
  return orderList;
}

/**
 * 获取微信用户的订单详情
 * sync true 异步, false 同步
 * orderId 订单id
 * func 获取订单详情后，执行的方法，如果未定义，则返回订单详情
 */
function ajaxOrderDetail(sync,orderId,func)
{
  var orderDetail = null;
  $.ajax({
    type: "POST",
    async: sync,
    dataType: "json",
    url: "wxorder?method=wxAjaxOrderDetail",
    data: {
      d:new Date().getTime(),
      orderId:orderId
    },
    success: function (data) {
      orderDetail = data;
      func(orderDetail);
    }
  });
  return orderDetail;
}
//////////////////////////////////////////////////////////////////////


/**
 * web首页
 * searchObject
 */
function toWebIndex(){
  window.location.href = "webIndex?method=webIndex";
}

/**
 * web个人中心首页
 * searchObject
 */
function toWebPersonalIndex(){
  window.location.href = "webPersonal?method=index";
}

/**
 * 跳转web销售详情
 */
function toWebSellPrice(priceId){
  window.location.href = "webCommproduct?method=toQueryCommproductDetailByPriceId&priceId="+priceId;

}


/**
 * 跳转web销售详情
 */
function toWebOrderDetail(orderId){
  window.location.href = "webPersonal?method=toOrderDetail&orderId="+orderId;
}

/**
 * 跳转订单退货详情
 */
function toWebOrderBackDetail(orderId){
  // window.location.href = "wxorder?method=toOrderBackDetail&orderId="+orderId;
}

/**
 * 弹出微信支付
 * @param orderId
 */
function toWebPayOrder(orderId) {
  var url = 'webOrder?method=toPayOrder&orderId='+orderId;
  layer.open({
    type : 2,
    title : '支付订单',
    area : [ '500px', '550px'],
    fix : true,
    content :url,
    end: function(){
      window.location.reload();
    }
  });
}

/**
 * web弹出提示信息
 */
function toWebAlertMsg(msg) {
  parent.layer.alert(msg);
}
