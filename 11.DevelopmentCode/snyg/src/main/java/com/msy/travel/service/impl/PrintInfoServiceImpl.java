package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.PrintInfoDao;
import com.msy.travel.pojo.PrintInfo;
import com.msy.travel.service.IPrintInfoService;

/**
 * PrintInfoService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class PrintInfoServiceImpl implements IPrintInfoService {

	@Resource(name = "printInfoDao")
	private PrintInfoDao printInfoDao;

	/**
	 * 新增PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void createPrintInfo(PrintInfo printInfo) throws Exception {
		printInfoDao.insertPrintInfo(printInfo);
	}

	/**
	 * 检查PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void mergePrintInfo(PrintInfo printInfo) throws Exception {
		printInfoDao.mergePrintInfo(printInfo);
	}

	/**
	 * 删除PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void deletePrintInfo(PrintInfo printInfo) throws Exception {
		printInfoDao.deletePrintInfo(printInfo);
	}

	/**
	 * 修改PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 */
	public void updatePrintInfo(PrintInfo printInfo) throws Exception {
		printInfoDao.updatePrintInfo(printInfo);
	}

	/**
	 * 批量删除PrintInfo
	 * 
	 * @param printInfoIdList
	 *            存放printInfo主键的list
	 */
	public void deleteBatchPrintInfo(PrintInfo printInfo) throws Exception {
		printInfoDao.deleteBatchPrintInfo(printInfo);
	}

	/**
	 * 查询单个PrintInfo
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 * 
	 * @return 成员实体对象
	 */
	public PrintInfo displayPrintInfo(PrintInfo printInfo) throws Exception {
		return printInfoDao.queryPrintInfo(printInfo);
	}

	/**
	 * 查询PrintInfo列表
	 * 
	 * @param printInfo
	 *            PrintInfo对象
	 * 
	 * @return PrintInfo列表
	 */
	public List<PrintInfo> queryPrintInfoList(PrintInfo printInfo) throws Exception {
		return printInfoDao.queryPrintInfoList(printInfo);
	}

	/**
	 * 获取PrintInfoID
	 */
	public String getPrintInfoId() throws Exception {
		return printInfoDao.getPrintInfoId();
	}
}
