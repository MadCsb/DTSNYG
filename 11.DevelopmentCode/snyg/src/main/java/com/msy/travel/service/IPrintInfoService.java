package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.PrintInfo;

/**
 * PrintInfoService接口
 * 
 * @author wootide
 * 
 */
public interface IPrintInfoService {
	/**
	 * 新增PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void createPrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 检查PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void mergePrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 删除PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void deletePrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 批量删除PrintInfo
	 * 
	 * @param printInfoIdList
	 *            存放printInfo主键的list
	 */
	public void deleteBatchPrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 修改PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void updatePrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 查询单个PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 * 
	 * @return PrintInfo实体对象
	 */
	public PrintInfo displayPrintInfo(PrintInfo printInfo) throws Exception;

	/**
	 * 查询PrintInfo列表
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 * 
	 * @return PrintInfo列表
	 */
	public List<PrintInfo> queryPrintInfoList(PrintInfo printInfo) throws Exception;

	/**
	 * 获取PrintInfo主键ID
	 */
	public String getPrintInfoId() throws Exception;
}
