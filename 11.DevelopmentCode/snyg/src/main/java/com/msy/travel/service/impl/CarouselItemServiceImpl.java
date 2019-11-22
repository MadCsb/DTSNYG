package com.msy.travel.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.CarouselItem;
import com.msy.travel.dao.CarouselItemDao;
import com.msy.travel.service.CarouselItemService;

/**
 * CarouselItemService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CarouselItemServiceImpl implements CarouselItemService
{

	@Resource(name="carouselItemDao")
    private CarouselItemDao carouselItemDao;
    
    /**
     * 新增CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void createCarouselItem(CarouselItem carouselItem) throws Exception
    {
        carouselItemDao.insertCarouselItem(carouselItem);
    }
    /**
     * 检查CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void mergeCarouselItem(CarouselItem carouselItem) throws Exception
    {
    	carouselItemDao.mergeCarouselItem(carouselItem);
    }
    /**
     * 删除CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void deleteCarouselItem(CarouselItem carouselItem) throws Exception
    {
        carouselItemDao.deleteCarouselItem(carouselItem);
    }
   
    /**
     * 修改CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void updateCarouselItem(CarouselItem carouselItem) throws Exception
    {
        carouselItemDao.updateCarouselItem(carouselItem);
    }
    /**
     * 批量删除CarouselItem
     * 
     * @param carouselItemIdList 存放carouselItem主键的list
     */
    public void deleteBatchCarouselItem(CarouselItem carouselItem) throws Exception
    {
    	carouselItemDao.deleteBatchCarouselItem(carouselItem);
    }  
    /**
     * 查询单个CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return 成员实体对象
     */
    public CarouselItem displayCarouselItem(CarouselItem carouselItem) throws Exception
    {
        return carouselItemDao.queryCarouselItem(carouselItem);
    }

    /**
     * 查询CarouselItem列表
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return CarouselItem列表
     */
    public List<CarouselItem> queryCarouselItemList(CarouselItem carouselItem) throws Exception
    {
        return carouselItemDao.queryCarouselItemList(carouselItem);
    }

    /**
     * 获取CarouselItemID
     */
    public String getCarouselItemId() throws Exception
    {
    	return carouselItemDao.getCarouselItemId();
    }
}
