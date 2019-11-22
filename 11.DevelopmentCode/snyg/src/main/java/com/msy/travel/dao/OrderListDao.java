package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.OrderList;

/**
 * OrderListDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderListDao {
	/**
	 * 增加OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	void insertOrderList(OrderList orderList) throws Exception;

	/**
	 * 检查OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	void mergeOrderList(OrderList orderList) throws Exception;

	/**
	 * 删除OrderList
	 * 
	 * @param orderList
	 *            成语对象
	 */
	void deleteOrderList(OrderList orderList) throws Exception;

	/**
	 * 批量删除OrderList
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchOrderList(OrderList orderList) throws Exception;

	/**
	 * 修改OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	void updateOrderList(OrderList orderList) throws Exception;

	/**
	 * 查询单个OrderList信息
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return OrderList实体对象
	 */
	OrderList queryOrderList(OrderList orderList) throws Exception;

	/**
	 * 查询OrderList列表信息
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return OrderList列表
	 */
	List<OrderList> queryOrderListList(OrderList orderList) throws Exception;

	/**
	 * 查询信息
	 *
	 * @param orderList
	 *            OrderList对象
	 *
	 * @return OrderList列表
	 */
	OrderList queryGoodPriceCount(OrderList orderList) throws Exception;

	/**
	 * 获取OrderListID
	 */
	String getOrderListId() throws Exception;

	/**
	 * 财务清单
	 * 
	 * @author wzd
	 * @date 2019年11月18日 下午4:46:06
	 * @param order
	 * @return
	 * @throws Exception
	 * @return List<Order>
	 */
	List<OrderList> queryOrderListBill(OrderList orderList) throws Exception;

	/**
	 * 财务清单合计
	 * 
	 * @author wzd
	 * @date 2019年11月18日 下午6:50:05
	 * @param orderList
	 * @return
	 * @throws Exception
	 * @return OrderList
	 */
	OrderList queryOrderListBillSum(OrderList orderList) throws Exception;

	/**
	 * 账单明细
	 * 
	 * @author wzd
	 * @date 2019年11月19日 上午11:09:53
	 * @param orderList
	 * @return
	 * @throws Exception
	 * @return List<OrderList>
	 */
	List<OrderList> queryOrderListDetailList(OrderList orderList) throws Exception;
}
