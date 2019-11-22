package com.msy.travel.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReaderForXls extends ExcelReader {

	//申明一个工作簿
	private HSSFWorkbook wb = null;
	
	//生成一个表格
	private HSSFSheet sheet = null;
	
	//生成表格行
	private HSSFRow row= null;
	
	
	public ExcelReaderForXls(File file, int num) {
		super(file, num);
	}

	@Override
	public void open() throws IOException{
		// TODO Auto-generated method stub
		fis = new FileInputStream(getFile());
		wb =new HSSFWorkbook(fis);
		fis.close();
	}

	@Override
	public int getSheetCount() {
		 int sheetCount = -1;
	     sheetCount = wb.getNumberOfSheets();
	     return sheetCount;
	}

	@Override
	public int getRowCount() {
		sheet = wb.getSheetAt(getSheetNum());
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	@Override
	public String[] readExcelLine(int sheetNum, int lineNum) {
		 if (sheetNum < 0 || lineNum < 0)
	            return null;
		 String[] line = null;
		 try{
			 sheet = wb.getSheetAt(sheetNum);
			 row = sheet.getRow(lineNum);
			 if(row != null)
			 {
				 line = new String[getHeadNum()];
				 for(int i=0;i<getHeadNum();i++)
				 {
					 line[i] = readExcelCell(sheetNum, lineNum, i);
				 }
			 }
		 }catch (Exception e)
        {
            e.printStackTrace();
        }
		return line;
	}

	@Override
	public String readExcelCell(int sheetNum, int rowNum, int cellNum) {
		if(sheetNum<0 || rowNum<0 || cellNum <0)
		{
			return "";
		}
		String cellCont = "";
		try
		{
			sheet =wb.getSheetAt(sheetNum);
			row =sheet.getRow(rowNum);
			if(row.getCell(cellNum) != null)
			{
				switch(row.getCell(cellNum).getCellType())
				{
					case HSSFCell.CELL_TYPE_FORMULA:
						cellCont = "FORMULA";
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						cellCont = String.valueOf(row.getCell(cellNum).getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						cellCont = row.getCell(cellNum).getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						cellCont = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						cellCont = String.valueOf(row.getCell(cellNum).getBooleanCellValue());
						break;
					default:
						cellCont = "";
						break;
				}
			}else
			{
				return "";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cellCont;
	}

}
