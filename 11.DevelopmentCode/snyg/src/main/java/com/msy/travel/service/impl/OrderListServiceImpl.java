package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.OrderListDao;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.service.OrderListService;

/**
 * OrderListService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {

	@Resource(name = "orderListDao")
	private OrderListDao orderListDao;

	/**
	 * 新增OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void createOrderList(OrderList orderList) throws Exception {
		orderListDao.insertOrderList(orderList);
	}

	/**
	 * 检查OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void mergeOrderList(OrderList orderList) throws Exception {
		orderListDao.mergeOrderList(orderList);
	}

	/**
	 * 删除OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void deleteOrderList(OrderList orderList) throws Exception {
		orderListDao.deleteOrderList(orderList);
	}

	/**
	 * 修改OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 */
	public void updateOrderList(OrderList orderList) throws Exception {
		orderListDao.updateOrderList(orderList);
	}

	/**
	 * 批量删除OrderList
	 * 
	 * @param orderListIdList
	 *            存放orderList主键的list
	 */
	public void deleteBatchOrderList(OrderList orderList) throws Exception {
		orderListDao.deleteBatchOrderList(orderList);
	}

	/**
	 * 查询单个OrderList
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return 成员实体对象
	 */
	public OrderList displayOrderList(OrderList orderList) throws Exception {
		return orderListDao.queryOrderList(orderList);
	}

	/**
	 * 查询OrderList列表
	 * 
	 * @param orderList
	 *            OrderList对象
	 * 
	 * @return OrderList列表
	 */
	public List<OrderList> queryOrderListList(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListList(orderList);
	}

	/**
	 * 查询信息
	 *
	 * @param orderList
	 *            OrderList对象
	 *
	 * @return OrderList列表
	 */
	public OrderList queryGoodPriceCount(OrderList orderList) throws Exception {
		return orderListDao.queryGoodPriceCount(orderList);
	}

	/**
	 * 获取OrderListID
	 */
	public String getOrderListId() throws Exception {
		return orderListDao.getOrderListId();
	}

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
	public List<OrderList> queryOrderListBill(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListBill(orderList);
	}

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
	public OrderList queryOrderListBillSum(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListBillSum(orderList);
	}

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
	public List<OrderList> queryOrderListDetailList(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListDetailList(orderList);
	}

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
	public List<OrderList> queryOrderListDetailListExport(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListDetailListExport(orderList);
	}

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
	public List<OrderList> queryOrderListListForMonth(OrderList orderList) throws Exception {
		return orderListDao.queryOrderListListForMonth(orderList);
	}
}
