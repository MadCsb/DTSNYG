/**
 * Created by cheng on 2019/10/17.
 */
function WxPerson(){
  WxPerson.prototype.userId = null;
  WxPerson.prototype.user = null;
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
WxPerson.prototype.orderList = function (sync,searchObject,pageEntity)
{
  var orderList = null;
  $.ajax({
    type: "POST",
    async: sync,
    dataType: "json",
    url: "wxorder?method=wxAjaxOrderList",
    data: {
      d:new Date().getTime(),
      userId:searchObject.userId,
      searchKey: searchObject.searchKey,
      payTag: searchObject.payTag,
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
 * 获取微信用户的订单数量
 * sync true 异步, false 同步
 * searchObject
 * searchObject.searchKey搜索关键字
 * searchObject.userId 用户id
 * searchObject.payTag支付状态
 * searchObject.beforePayStatus支付前状态
 * searchObject.status支付后订单状态
 * searchObject.backNumS是否有退订
 */
WxPerson.prototype.orderNum = function (searchObject)
{
  var orderNum = 0;
  $.ajax({
    type: "POST",
    async: false,
    dataType: "json",
    url: "wxorder?method=wxAjaxOrderCount",
    data: {
      d:new Date().getTime(),
      userId:searchObject.userId,
      searchKey: searchObject.searchKey,
      payTag: searchObject.payTag,
      beforePayStatus: searchObject.beforePayStatus,
      status: searchObject.status,
      backNumS: searchObject.backNumS
    },
    success: function (data) {
      if (data.resultCode == "0")
      {
        orderNum = data.resultPojo;
      }else
      {
        orderNum = "0";
      }
    }
  });
  return orderNum;
}

/**
 * 获取微信用户的订单详情
 * sync true 异步, false 同步
 * orderId 订单id
 * func 获取订单详情后，执行的方法，如果未定义，则返回订单详情
 */
WxPerson.prototype.orderDetail = function (sync,orderId,func)
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



