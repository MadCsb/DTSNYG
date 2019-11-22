package com.msy.travel.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class ExcelReader {

	//excel文件
	private File file = null;
	
	//首行字段个数
	private int headNum = 0 ;
	
	//当前使用sheet序号
	private int sheetNum = 0;
	
    protected	FileInputStream fis = null;
	/**
	 * 
	 * @param file excel文件
	 * @param num 首行字段个数
	 */
	public ExcelReader(File file,int num)
	{
		this.file = file;
		this.headNum = num;
	}
	
	/**
	 * 读取excel文件获得Workbook对象
	 * @throws IOException 
	 * @throws Exception 
	 */
	public abstract void open() throws IOException, Exception;
	
	/**
	 * 返回sheet表数目
	 */
	public abstract int getSheetCount();
	
	/**
	 * 返回sheetNum下记录行数
	 * 
	 */
	public abstract int getRowCount();
	
	/**
	 * 读取 制定工作表和行数内容
	 * @param sheetNum工作表序号
	 * @param lineNum 行数
	 * @return 工作表某行的数据
	 */
	public abstract String[] readExcelLine(int sheetNum,int lineNum);
	
	/**
	 * 读取 某个单元格的数据
	 * @param sheetNum 工作表序号
	 * @param rowNum 行号
	 * @param cellNum 列号
	 * @return
	 */
	public abstract String readExcelCell(int sheetNum,int rowNum,int cellNum);

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getHeadNum() {
		return headNum;
	}

	public void setHeadNum(int headNum) {
		this.headNum = headNum;
	}

	public int getSheetNum() {
		return sheetNum;
	}

	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
}
