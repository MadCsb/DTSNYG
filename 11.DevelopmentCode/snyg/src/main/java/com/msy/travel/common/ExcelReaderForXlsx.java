package com.msy.travel.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderForXlsx extends ExcelReader {

	// 申明一个工作薄
	private XSSFWorkbook xwb = null;

	// 生成一个表格
	private XSSFSheet xsheet = null;

	// 产生表格行
	private XSSFRow row = null;

	public ExcelReaderForXlsx(File file, int num) {
		super(file, num);
	}

	@Override
	public void open() throws IOException, Exception {
		try {
			fis = new FileInputStream(getFile());
			xwb = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getSheetCount() {
		int sheetCount = -1;
		sheetCount = xwb.getNumberOfSheets();
		return sheetCount;
	}

	@Override
	public int getRowCount() {
		xsheet = xwb.getSheetAt(getSheetNum());
		int rowCount = -1;
		rowCount = xsheet.getLastRowNum();
		return rowCount;
	}

	@Override
	public String[] readExcelLine(int sheetNum, int lineNum) {
		if (sheetNum < 0 || lineNum < 0)
			return null;
		String[] line = null;
		try {
			xsheet = xwb.getSheetAt(sheetNum);
			row = xsheet.getRow(lineNum);
			if (row != null) {
				line = new String[getHeadNum()];
				for (int i = 0; i < getHeadNum(); i++) {
					line[i] = readExcelCell(sheetNum, lineNum, i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public String readExcelCell(int sheetNum, int rowNum, int cellNum) {
		if (sheetNum < 0 || rowNum < 0 || cellNum < 0) {
			return "";
		}
		String cellCont = "";
		try {
			xsheet = xwb.getSheetAt(sheetNum);
			row = xsheet.getRow(rowNum);
			if (row.getCell(cellNum) != null) {
				switch (row.getCell(cellNum).getCellType()) {
				case XSSFCell.CELL_TYPE_FORMULA:
					cellCont = "FORMULA";
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					cellCont = String.valueOf(row.getCell(cellNum).getNumericCellValue());
					break;
				case XSSFCell.CELL_TYPE_STRING:
					cellCont = row.getCell(cellNum).getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					cellCont = "";
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					cellCont = String.valueOf(row.getCell(cellNum).getBooleanCellValue());
					break;
				default:
					cellCont = "";
					break;
				}
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellCont;
	}

}
