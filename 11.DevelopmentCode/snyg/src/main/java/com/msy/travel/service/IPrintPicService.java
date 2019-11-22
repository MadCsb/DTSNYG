package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.PrintPic;

/**
 * PrintPicService接口
 * 
 * @author wootide
 * 
 */
public interface IPrintPicService {
	/**
	 * 新增PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void createPrintPic(PrintPic printPic) throws Exception;

	/**
	 * 检查PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void mergePrintPic(PrintPic printPic) throws Exception;

	/**
	 * 删除PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void deletePrintPic(PrintPic printPic) throws Exception;

	/**
	 * 批量删除PrintPic
	 * 
	 * @param printPicIdList
	 *            存放printPic主键的list
	 */
	public void deleteBatchPrintPic(PrintPic printPic) throws Exception;

	/**
	 * 修改PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void updatePrintPic(PrintPic printPic) throws Exception;

	/**
	 * 查询单个PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 * 
	 * @return PrintPic实体对象
	 */
	public PrintPic displayPrintPic(PrintPic printPic) throws Exception;

	/**
	 * 查询PrintPic列表
	 * 
	 * @param printPic
	 *            PrintPic对象
	 * 
	 * @return PrintPic列表
	 */
	public List<PrintPic> queryPrintPicList(PrintPic printPic) throws Exception;

	/**
	 * 获取PrintPic主键ID
	 */
	public String getPrintPicId() throws Exception;
}
