package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Order;

/**
 * OrderDao接口
 * 
 * @author wootide
 * 
 */
public interface OrderDao {
	/**
	 * 增加Order
	 * 
	 * @param order
	 *            Order对象
	 */
	void insertOrder(Order order) throws Exception;

	/**
	 * 检查Order
	 * 
	 * @param order
	 *            Order对象
	 */
	void mergeOrder(Order order) throws Exception;

	/**
	 * 删除Order
	 * 
	 * @param order
	 *            成语对象
	 */
	void deleteOrder(Order order) throws Exception;

	/**
	 * 批量删除Order
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchOrder(Order order) throws Exception;

	/**
	 * 修改Order
	 * 
	 * @param order
	 *            Order对象
	 */
	void updateOrder(Order order) throws Exception;

	/**
	 * 查询单个Order信息
	 * 
	 * @param order
	 *            Order对象
	 * 
	 * @return Order实体对象
	 */
	Order queryOrder(Order order) throws Exception;

	/**
	 * 查询Order列表信息
	 * 
	 * @param order
	 *            Order对象
	 * 
	 * @return Order列表
	 */
	List<Order> queryOrderList(Order order) throws Exception;

	/**
	 * 查询Order列表信息统计信息
	 *
	 * @param order
	 *            Order对象
	 *
	 * @return Order列表
	 */
	Order queryOrderListStatic(Order order) throws Exception;

	/**
	 * 获取OrderID
	 */
	String getOrderId() throws Exception;

}
