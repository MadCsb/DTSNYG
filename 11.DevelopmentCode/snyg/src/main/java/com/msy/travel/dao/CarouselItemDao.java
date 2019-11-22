package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.CarouselItem;
/**
 * CarouselItemDao接口
 * 
 * @author wootide
 * 
 */
public interface CarouselItemDao
{
    /**
     * 增加CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    void insertCarouselItem(CarouselItem carouselItem) throws Exception;
   
    /**
     * 检查CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    void mergeCarouselItem(CarouselItem carouselItem) throws Exception;
   
    /**
     * 删除CarouselItem
     * 
     * @param carouselItem 成语对象
     */
    void deleteCarouselItem(CarouselItem carouselItem) throws Exception;
    
    /**
     * 批量删除CarouselItem
     * 
     * @param ids ids
     */
    void deleteBatchCarouselItem(CarouselItem carouselItem) throws Exception;  
    
    /**
     * 修改CarouselItem
     * 
     * @param carouselItem CarouselItem对象
     */
    void updateCarouselItem(CarouselItem carouselItem) throws Exception;  
   
    /**
     * 查询单个CarouselItem信息
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return CarouselItem实体对象
     */
    CarouselItem queryCarouselItem(CarouselItem carouselItem) throws Exception;
    
    /**
     * 查询CarouselItem列表信息
     * 
     * @param carouselItem CarouselItem对象
     * 
     * @return CarouselItem列表
     */
    List<CarouselItem> queryCarouselItemList(CarouselItem carouselItem) throws Exception;

    /**
     * 获取CarouselItemID
     */
    String getCarouselItemId() throws Exception;
}
