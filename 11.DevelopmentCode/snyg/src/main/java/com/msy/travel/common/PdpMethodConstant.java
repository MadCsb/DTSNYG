package com.msy.travel.common;

/**
 * 下行方法名称 ota\ets系统调用pdp系统方法
 * 
 * @author whn
 *
 */
public class PdpMethodConstant {

	public class Ota {
		/**
		 * 查询产品信息
		 */
		public static final String PDP_METHOD_QUERYPRODUCT = "queryProduct";

		/**
		 * 查询景点信息
		 */
		public static final String PDP_METHOD_QUERYSCENIC = "queryScenic";

		/**
		 * 查询产品价格策略
		 */
		public static final String PDP_METHOD_QUERYPRICESTRATEGY = "queryPriceStrategy";

		/**
		 * 产品预定
		 */
		public static final String PDP_METHOD_ORDERPRODUCT = "orderProduct";

		/**
		 * 支付前下单
		 */
		public static final String PDP_METHOD_CREATEORDERBEFOREPAY = "createOrderBeforePay";

		/**
		 * 支付后下单
		 */
		public static final String PDP_METHOD_CREATEORDERAFTERPAY = "createOrderAfterPay";

		/**
		 * 订单支付
		 */
		public static final String PDP_METHOD_PAYORDER = "payOrder";

		/**
		 * 订单查询
		 */
		public static final String PDP_METHOD_QUERYORDER = "queryOrder";

		/**
		 * 发送订单凭证
		 */
		public static final String PDP_METHOD_SENDORDERTICKET = "sendOrderTicket";

		/**
		 * 申请退款
		 */
		public static final String PDP_METHOD_APPLYORDERCANCEL = "applyOrderCancel";
		
		
		/**
		 * 支付后下单酒店
		 */
		public static final String PDP_METHOD_HOTEL_CREATEORDERAFTERPAY = "hotelCreateOrderAfterPay";
		
		/**
		 * 申请退款
		 */
		public static final String PDP_METHOD_HOTEL_APPLYORDERCANCEL = "hotelApplyOrderCancel";

	}

	public class Method {

		/**
		 * 查询OTA请求参数
		 */
		public static final String PDP_QUERY_OTAPARAM = "queryOtaParam";
	}

	public class Ets {

		/**
		 * 验票回调通知
		 */
		public static final String PDP_METHOD_VERIFYNOTIFY = "verifyNotify";

		/**
		 * 获取订单信息通知
		 */
		public static final String PDP_METHOD_QUERYORDERNOTIFY = "queryOrderNotify";

		/**
		 * 获取产品信息通知
		 */
		public static final String PDP_METHOD_QUERYPRODUCTNOTIFY = "queryProductNotify";
	}

	public class App {

		/**
		 * 订单验证
		 */
		public static final String PDP_APP_ORDERCHECK = "orderCheck";
	}

}
