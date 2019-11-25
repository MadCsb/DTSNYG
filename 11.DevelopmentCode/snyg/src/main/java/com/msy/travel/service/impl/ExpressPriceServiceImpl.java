package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.ExpressPrice;
import com.msy.travel.dao.ExpressPriceDao;
import com.msy.travel.service.ExpressPriceService;

/**
 * ExpressPriceService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ExpressPriceServiceImpl implements ExpressPriceService
{

	@Resource(name="expressPriceDao")
    private ExpressPriceDao expressPriceDao;
    
    /**
     * 新增ExpressPrice
     * 
     * @param expressPrice ExpressPrice对象
     */
    public void createExpressPrice(ExpressPrice expressPrice) throws Exception
    {
        expressPriceDao.insertExpressPrice(expressPrice);
    }
    /**
     * 检查ExpressPrice
     * 
     * @param expressPrice ExpressPrice对象
     */
    public void mergeExpressPrice(ExpressPrice expressPrice) throws Exception
    {
    	expressPriceDao.mergeExpressPrice(expressPrice);
    }
    /**
     * 删除ExpressPrice
     * 
     * @param expressPrice ExpressPrice对象
     */
    public void deleteExpressPrice(ExpressPrice expressPrice) throws Exception
    {
        expressPriceDao.deleteExpressPrice(expressPrice);
    }
   
    /**
     * 修改ExpressPrice
     * 
     * @param expressPrice ExpressPrice对象
     */
    public void updateExpressPrice(ExpressPrice expressPrice) throws Exception
    {
        expressPriceDao.updateExpressPrice(expressPrice);
    }
    /**
     * 批量删除ExpressPrice
     * 
     * @param expressPriceIdList 存放expressPrice主键的list
     */
    public void deleteBatchExpressPrice(ExpressPrice expressPrice) throws Exception
    {
    	expressPriceDao.deleteBatchExpressPrice(expressPrice);
    }  
    /**
     * 查询单个ExpressPrice
     * 
     * @param expressPrice ExpressPrice对象
     * 
     * @return 成员实体对象
     */
    public ExpressPrice displayExpressPrice(ExpressPrice expressPrice) throws Exception
    {
        return expressPriceDao.queryExpressPrice(expressPrice);
    }

    /**
     * 查询ExpressPrice列表
     * 
     * @param expressPrice ExpressPrice对象
     * 
     * @return ExpressPrice列表
     */
    public List<ExpressPrice> queryExpressPriceList(ExpressPrice expressPrice) throws Exception
    {
        return expressPriceDao.queryExpressPriceList(expressPrice);
    }

    /**
     * 获取ExpressPriceID
     */
    public String getExpressPriceId() throws Exception
    {
    	return expressPriceDao.getExpressPriceId();
    }
}
