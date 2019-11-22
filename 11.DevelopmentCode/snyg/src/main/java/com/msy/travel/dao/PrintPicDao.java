package com.msy.travel.dao;

import java.util.List;
import com.msy.travel.pojo.PrintPic;
/**
 * PrintPicDao接口
 * 
 * @author wootide
 * 
 */
public interface PrintPicDao
{
    /**
     * 增加PrintPic
     * 
     * @param printPic PrintPic对象
     */
    void insertPrintPic(PrintPic printPic) throws Exception;
   
    /**
     * 检查PrintPic
     * 
     * @param printPic PrintPic对象
     */
    void mergePrintPic(PrintPic printPic) throws Exception;
   
    /**
     * 删除PrintPic
     * 
     * @param printPic 成语对象
     */
    void deletePrintPic(PrintPic printPic) throws Exception;
    
    /**
     * 批量删除PrintPic
     * 
     * @param ids ids
     */
    void deleteBatchPrintPic(PrintPic printPic) throws Exception;  
    
    /**
     * 修改PrintPic
     * 
     * @param printPic PrintPic对象
     */
    void updatePrintPic(PrintPic printPic) throws Exception;  
   
    /**
     * 查询单个PrintPic信息
     * 
     * @param printPic PrintPic对象
     * 
     * @return PrintPic实体对象
     */
    PrintPic queryPrintPic(PrintPic printPic) throws Exception;
    
    /**
     * 查询PrintPic列表信息
     * 
     * @param printPic PrintPic对象
     * 
     * @return PrintPic列表
     */
    List<PrintPic> queryPrintPicList(PrintPic printPic) throws Exception;

    /**
     * 获取PrintPicID
     */
    String getPrintPicId() throws Exception;
}
