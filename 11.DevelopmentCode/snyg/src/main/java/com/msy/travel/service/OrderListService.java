package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.OrderList;

/**
 * OrderListService接口
 * 
 * @author wootide
 * 
 */
public interface OrderListService {
	/**
	 * 新增OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void createOrderList(OrderList orderList) throws Exception;

	/**
	 * 检查OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void mergeOrderList(OrderList orderList) throws Exception;

	/**
	 * 删除OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void deleteOrderList(OrderList orderList) throws Exception;

	/**
	 * 批量删除OrderList
	 * 
	 * @param orderListIdList
	 *            存放orderList主键的list
	 */
	public void deleteBatchOrderList(OrderList orderList) throws Exception;

	/**
	 * 修改OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void updateOrderList(OrderList orderList) throws Exception;

	/**
	 * 查询单个OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return OrderList实体对象
	 */
	public OrderList displayOrderList(OrderList orderList) throws Exception;

	/**
	 * 查询OrderList列表
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return OrderList列表
	 */
	public List<OrderList> queryOrderListList(OrderList orderList) throws Exception;

	/**
	 * 查询信息
	 *
	 * @param orderList
	 *            OrderList对象
	 *
	 * @return OrderList列表
	 */
	public OrderList queryGoodPriceCount(OrderList orderList) throws Exception;

	/**
	 * 获取OrderList主键ID
	 */
	public String getOrderListId() throws Exception;

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
	public List<OrderList> queryOrderListBill(OrderList orderList) throws Exception;

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
	public OrderList queryOrderListBillSum(OrderList orderList) throws Exception;

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
	public List<OrderList> queryOrderListDetailList(OrderList orderList) throws Exception;

	/**
	 * 账单明细导出
	 * 
	 * @author wzd
	 * @date 2020年3月31日 下午4:53:51
	 * @param orderList
	 * @return
	 * @throws Exception
	 * @return List<OrderList>
	 */
	public List<OrderList> queryOrderListDetailListExport(OrderList orderList) throws Exception;

	/**
	 * 对账单
	 * 
	 * @author wzd
	 * @date 2020年4月12日 下午6:56:08
	 * @param orderList
	 * @return
	 * @throws Exception
	 * @return List<OrderList>
	 */
	public List<OrderList> queryOrderListListForMonth(OrderList orderList) throws Exception;
}
