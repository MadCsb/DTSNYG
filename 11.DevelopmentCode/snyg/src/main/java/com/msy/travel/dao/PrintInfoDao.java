package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.PrintInfo;
/**
 * PrintInfoDao接口
 * 
 * @author wootide
 * 
 */
public interface PrintInfoDao
{
    /**
     * 增加PrintInfo
     * 
     * @param printInfo PrintInfo对象
     */
    void insertPrintInfo(PrintInfo printInfo) throws Exception;
   
    /**
     * 检查PrintInfo
     * 
     * @param printInfo PrintInfo对象
     */
    void mergePrintInfo(PrintInfo printInfo) throws Exception;
   
    /**
     * 删除PrintInfo
     * 
     * @param printInfo 成语对象
     */
    void deletePrintInfo(PrintInfo printInfo) throws Exception;
    
    /**
     * 批量删除PrintInfo
     * 
     * @param ids ids
     */
    void deleteBatchPrintInfo(PrintInfo printInfo) throws Exception;  
    
    /**
     * 修改PrintInfo
     * 
     * @param printInfo PrintInfo对象
     */
    void updatePrintInfo(PrintInfo printInfo) throws Exception;  
   
    /**
     * 查询单个PrintInfo信息
     * 
     * @param printInfo PrintInfo对象
     * 
     * @return PrintInfo实体对象
     */
    PrintInfo queryPrintInfo(PrintInfo printInfo) throws Exception;
    
    /**
     * 查询PrintInfo列表信息
     * 
     * @param printInfo PrintInfo对象
     * 
     * @return PrintInfo列表
     */
    List<PrintInfo> queryPrintInfoList(PrintInfo printInfo) throws Exception;

    /**
     * 获取PrintInfoID
     */
    String getPrintInfoId() throws Exception;
}
