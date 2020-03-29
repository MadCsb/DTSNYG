package com.msy.travel.service.impl;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.SellPrice;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderService;
import com.msy.travel.service.SellPriceService;
import com.msy.travel.wx.controller.WxOrderController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.ThirdPayFlow;
import com.msy.travel.dao.ThirdPayFlowDao;
import com.msy.travel.service.ThirdPayFlowService;

/**
 * ThirdPayFlowService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ThirdPayFlowServiceImpl implements ThirdPayFlowService
{
    public static final Log log = LogFactory.getLog(ThirdPayFlowServiceImpl.class);

	@Resource(name="thirdPayFlowDao")
    private ThirdPayFlowDao thirdPayFlowDao;

    @Resource(name = "orderServiceImpl")
    private OrderService orderService;

    @Resource(name = "orderListServiceImpl")
    private OrderListService orderListService;

    @Resource(name = "userServiceImpl")
    private IUserService userService;

    @Resource(name = "sellPriceServiceImpl")
    private SellPriceService sellPriceService;
    
    /**
     * 新增ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void createThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
        thirdPayFlowDao.insertThirdPayFlow(thirdPayFlow);
    }
    /**
     * 检查ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void mergeThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
    	thirdPayFlowDao.mergeThirdPayFlow(thirdPayFlow);
    }
    /**
     * 删除ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void deleteThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
        thirdPayFlowDao.deleteThirdPayFlow(thirdPayFlow);
    }
   
    /**
     * 修改ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     */
    public void updateThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
        thirdPayFlowDao.updateThirdPayFlow(thirdPayFlow);
    }
    /**
     * 批量删除ThirdPayFlow
     * 
     * @param thirdPayFlow 存放thirdPayFlow主键的list
     */
    public void deleteBatchThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
    	thirdPayFlowDao.deleteBatchThirdPayFlow(thirdPayFlow);
    }  
    /**
     * 查询单个ThirdPayFlow
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return 成员实体对象
     */
    public ThirdPayFlow displayThirdPayFlow(ThirdPayFlow thirdPayFlow) throws Exception
    {
        return thirdPayFlowDao.queryThirdPayFlow(thirdPayFlow);
    }

    /**
     * 查询ThirdPayFlow列表
     * 
     * @param thirdPayFlow ThirdPayFlow对象
     * 
     * @return ThirdPayFlow列表
     */
    public List<ThirdPayFlow> queryThirdPayFlowList(ThirdPayFlow thirdPayFlow) throws Exception
    {
        return thirdPayFlowDao.queryThirdPayFlowList(thirdPayFlow);
    }

    /**
     * 获取ThirdPayFlowID
     */
    public String getThirdPayFlowId() throws Exception
    {
    	return thirdPayFlowDao.getThirdPayFlowId();
    }

    /**
     * 流水响应护理
     */
    public void flowReturn(ThirdPayFlow thirdPayFlow) throws Exception
    {
        boolean operate = false; //需要操作订单相关内容
        ThirdPayFlow thirdPayFlowDb = null;
        String orderIds = null;
        synchronized (thirdPayFlow.getPlatformFlowCode().intern())
        {
            thirdPayFlowDb = new ThirdPayFlow();
            thirdPayFlowDb.setFlowId(thirdPayFlow.getFlowId());
            thirdPayFlowDb = displayThirdPayFlow(thirdPayFlowDb);
            orderIds = thirdPayFlowDb.getPlatformOrders();
            if (thirdPayFlowDb.getFlowState().equals("0"))
            {
                operate = true;
                thirdPayFlowDb.setThirdFlowCode(thirdPayFlow.getThirdFlowCode());
                thirdPayFlowDb.setThirdCreateTime(thirdPayFlow.getThirdCreateTime());
                thirdPayFlowDb.setFlowState("1");
                thirdPayFlowDb.setThirdType(thirdPayFlow.getThirdType());
                updateThirdPayFlow(thirdPayFlowDb);
            }
        }
        if (operate)
        {
            orderService.payOrder(thirdPayFlowDb);
        }
        try {
            String[] orderIdArray = orderIds.split(",");
            for(int i=0;i<orderIdArray.length;i++)
            {
                Order order = new Order();
                order.setOrderId(orderIdArray[i]);
                order = orderService.displayOrder(order);
                User user = new User();
                user.setUserId(order.getUserId());
                user = userService.displayUser(user);
                if("2".equals(user.getType()))
                {
                    OrderList orderListTmp = new OrderList();
                    orderListTmp.setOrderId(order.getOrderId());
                    List<OrderList> orderListList = orderListService.queryOrderListList(orderListTmp);

                    SellPrice sellPrice = new SellPrice();
                    sellPrice.setPriceId(orderListList.get(0).getPriceId());
                    sellPrice = sellPriceService.displaySellPrice(sellPrice);
                    Map<String ,String> sdParam = new HashMap<>(); //param.priceCode = 销售code param.orderId = 订单ID
                    sdParam.put("orderId",order.getOrderId());
                    sdParam.put("priceCode",sellPrice.getPriceCode());
                    Result sdResult = orderService.sdMobileSyncOrder(sdParam,user);
                }
            }
        }catch (Exception e)
        {
            log.error("同步山东移动订单错误");
            log.error(e,e);
        }
    }
}
