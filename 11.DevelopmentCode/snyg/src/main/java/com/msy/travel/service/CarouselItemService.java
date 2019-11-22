package com.msy.travel.service;

import java.util.List;
import com.msy.travel.pojo.CarouselItem;

/**
 * CarouselItemService接口
 * 
 * @author wootide
 * 
 */
public interface CarouselItemService
{
    /**
     * 新增CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void createCarouselItem(CarouselItem carouselItem) throws Exception;
    
    /**
     * 检查CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void mergeCarouselItem(CarouselItem carouselItem) throws Exception;
  
    /**
     * 删除CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void deleteCarouselItem(CarouselItem carouselItem) throws Exception;
   
    /**
     * 批量删除CarouselItem
     * 
     * @param carouselItemIdList  存放carouselItem主键的list
     */
    public void deleteBatchCarouselItem(CarouselItem carouselItem) throws Exception;  
    
    /**
     * 修改CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    public void updateCarouselItem(CarouselItem carouselItem) throws Exception;
    
    /**
     * 查询单个CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return CarouselItem实体对象
     */
    public CarouselItem displayCarouselItem(CarouselItem carouselItem) throws Exception;
  
   /**
     * 查询CarouselItem列表
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return CarouselItem列表
     */
    public List<CarouselItem> queryCarouselItemList(CarouselItem carouselItem) throws Exception;

    /**
     * 获取CarouselItem主键ID
     */
    public String getCarouselItemId() throws Exception;
}

