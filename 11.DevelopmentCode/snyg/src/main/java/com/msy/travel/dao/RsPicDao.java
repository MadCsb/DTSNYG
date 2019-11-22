package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.RsPic;
/**
 * RsPicDao接口
 * 
 * @author wootide
 * 
 */
public interface RsPicDao
{
    /**
     * 增加RsPic
     * 
     * @param rsPic RsPic对象
     */
    void insertRsPic(RsPic rsPic) throws Exception;
   
    /**
     * 检查RsPic
     * 
     * @param rsPic RsPic对象
     */
    void mergeRsPic(RsPic rsPic) throws Exception;
   
    /**
     * 删除RsPic
     * 
     * @param rsPic 成语对象
     */
    void deleteRsPic(RsPic rsPic) throws Exception;
    
    /**
     * 批量删除RsPic
     * 
     * @param ids ids
     */
    void deleteBatchRsPic(RsPic rsPic) throws Exception;  
    
    /**
     * 修改RsPic
     * 
     * @param rsPic RsPic对象
     */
    void updateRsPic(RsPic rsPic) throws Exception;  
   
    /**
     * 查询单个RsPic信息
     * 
     * @param rsPic RsPic对象
     * 
     * @return RsPic实体对象
     */
    RsPic queryRsPic(RsPic rsPic) throws Exception;
    
    /**
     * 查询RsPic列表信息
     * 
     * @param rsPic RsPic对象
     * 
     * @return RsPic列表
     */
    List<RsPic> queryRsPicList(RsPic rsPic) throws Exception;

    /**
     * 获取RsPicID
     */
    String getRsPicId() throws Exception;
}
