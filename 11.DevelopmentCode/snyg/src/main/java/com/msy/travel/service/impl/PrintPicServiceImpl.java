package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.PrintPicDao;
import com.msy.travel.pojo.PrintPic;
import com.msy.travel.service.IPrintPicService;

/**
 * PrintPicService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PrintPicServiceImpl implements IPrintPicService {

	@Resource(name = "printPicDao")
	private PrintPicDao printPicDao;

	/**
	 * 新增PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void createPrintPic(PrintPic printPic) throws Exception {
		printPic.setPicId(PrimaryKeyUtil.generateKey());
		printPicDao.insertPrintPic(printPic);
	}

	/**
	 * 检查PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void mergePrintPic(PrintPic printPic) throws Exception {
		printPicDao.mergePrintPic(printPic);
	}

	/**
	 * 删除PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void deletePrintPic(PrintPic printPic) throws Exception {
		printPicDao.deletePrintPic(printPic);
	}

	/**
	 * 修改PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 */
	public void updatePrintPic(PrintPic printPic) throws Exception {
		printPicDao.updatePrintPic(printPic);
	}

	/**
	 * 批量删除PrintPic
	 * 
	 * @param printPicIdList
	 *            存放printPic主键的list
	 */
	public void deleteBatchPrintPic(PrintPic printPic) throws Exception {
		printPicDao.deleteBatchPrintPic(printPic);
	}

	/**
	 * 查询单个PrintPic
	 * 
	 * @param printPic
	 *            PrintPic对象
	 * 
	 * @return 成员实体对象
	 */
	public PrintPic displayPrintPic(PrintPic printPic) throws Exception {
		return printPicDao.queryPrintPic(printPic);
	}

	/**
	 * 查询PrintPic列表
	 * 
	 * @param printPic
	 *            PrintPic对象
	 * 
	 * @return PrintPic列表
	 */
	public List<PrintPic> queryPrintPicList(PrintPic printPic) throws Exception {
		return printPicDao.queryPrintPicList(printPic);
	}

	/**
	 * 获取PrintPicID
	 */
	public String getPrintPicId() throws Exception {
		return printPicDao.getPrintPicId();
	}
}
