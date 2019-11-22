package com.msy.travel.service.impl;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.pojo.Order;
import com.msy.travel.service.OrderService;
import java.util.List;
import javax.annotation.Resource;
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

	@Resource(name="thirdPayFlowDao")
    private ThirdPayFlowDao thirdPayFlowDao;

    @Resource(name = "orderServiceImpl")
    private OrderService orderService;
    
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
        synchronized (thirdPayFlow.getPlatformFlowCode().intern())
        {
            thirdPayFlowDb = new ThirdPayFlow();
            thirdPayFlowDb.setFlowId(thirdPayFlow.getFlowId());
            thirdPayFlowDb = displayThirdPayFlow(thirdPayFlowDb);
            if (thirdPayFlowDb.getFlowState().equals("0"))
            {
                operate = true;
                thirdPayFlowDb.setThirdFlowCode(thirdPayFlow.getThirdFlowCode());
                thirdPayFlowDb.setThirdCreateTime(thirdPayFlow.getThirdCreateTime());
                thirdPayFlowDb.setFlowState("1");
                updateThirdPayFlow(thirdPayFlowDb);
            }
        }
        if (operate)
        {
            orderService.payOrder(thirdPayFlowDb);
        }
    }
}
