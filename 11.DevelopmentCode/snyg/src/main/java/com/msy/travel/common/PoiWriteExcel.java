package com.msy.travel.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class PoiWriteExcel<T> extends ExportSupport<T> {

	/**
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * 
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean export() {
		if (!super.export()) {
			return false;
		}
		String title = fileTitle;
		String path, tempName, headFieldName, headTitle;

		OutputStream out = null;

		try {
			out = new FileOutputStream(exportFileName);

			// 申明一个工作薄
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);

			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(15);

			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			// 把字体应用到当前的样式
			style.setFont(font);

			// 生成并设置另一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			// 把字体应用到当前的样式
			style2.setFont(font2);

			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				headTitle = this.getTitleFormHead(headers[i]);
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headTitle);
				cell.setCellValue(text);
			}

			// 遍历集合数据，产生数据行
			Iterator<T> it = dataset.iterator();

			int index = 0;

			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = it.next();

				int j = 0;

				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				// 返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段
				// Field[] fields = t.getClass().getDeclaredFields();
				// jy 直接使用数组效率会很高，并且可以控制顺序也可以直接使用通用的QUERYLIST方法

				for (int i = 0; i < headers.length; i++) {
					// Field field = fields[i];
					String fieldName = this.getFieldNameFormHead(headers[i]);
					String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

					try {
						Class cls = t.getClass();

						Method getMethod = cls.getMethod(getMethodName, new Class[] {});

						Object value = getMethod.invoke(t, new Object[] {});

						String formatType = this.getFormatTypeHead(headers[i]);

						String textValue = null;

						// 数据类型处理
						if (value != null) {
							textValue = value.toString();
						} else {
							textValue = "";
						}

						HSSFCellStyle contextstyle = workbook.createCellStyle();

						HSSFCell contentCell = row.createCell(j);
						HSSFDataFormat df = workbook.createDataFormat(); // 此处设置数据格式

						if (!"".equals(textValue)) {
							if ("0".equals(formatType)) {
								contextstyle.setDataFormat(df.getBuiltinFormat("#,#0"));// 数据格式只显示整数
								contentCell.setCellStyle(contextstyle);
								contentCell.setCellValue(Double.parseDouble(textValue));
							} else if ("1".equals(formatType)) {
								contextstyle.setDataFormat(df.getBuiltinFormat("#,##0.00"));// 保留两位小数点
								contentCell.setCellStyle(contextstyle);
								contentCell.setCellValue(Double.parseDouble(textValue));
							} else if ("2".equals(formatType)) {
								contextstyle.setDataFormat(df.getFormat("¥#,##0.00"));// 金额保留两位小数点
								textValue = textValue.replace(",", "");

								if (textValue.contains("¥")) {
									textValue = textValue.substring(1, textValue.length());
								}

								contentCell.setCellStyle(contextstyle);
								contentCell.setCellValue(Double.parseDouble(textValue));
							} else {
								contentCell.setCellStyle(contextstyle);
								contentCell.setCellValue(textValue);
							}
						} else {
							contentCell.setCellStyle(contextstyle);
							contentCell.setCellValue(textValue);
						}

						j++;
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

			try {
				workbook.write(out);

				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public void buchong() {

		// 申明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("leno");

	}

	/**
	 * 
	 *
	 * @Title: getFieldNameFormHead
	 * @Description: TODO取得字段名称
	 * @param @param head
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private String getFieldNameFormHead(String head) {
		if (head.indexOf(":") < 0) {
			return "";
		}
		return head.substring(0, head.indexOf(":"));

	}

	/**
	 * 
	 *
	 * @Title: getTitleFormHead
	 * @Description: TODO(取得字段标题)
	 * @param @param head
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private String getTitleFormHead(String head) {
		if (head.indexOf(":") < 0) {
			return head;
		}

		String[] arryType = head.split(":");

		return arryType[1];
	}

	/**
	 * 
	 *
	 * @Title: getTitleFormHead
	 * @Description: TODO(取得字段标题)
	 * @param @param head
	 * @param @return 设定文件
	 * @return String 返回类型 0整数 1保留两位小数 2人民币开头保留两位小数 3字符型
	 * @throws
	 */
	private String getFormatTypeHead(String head) {
		String formatType = "";

		if (head.indexOf(":") < 0) {
			formatType = "3";
		}

		String[] arryType = head.split(":");

		if (arryType.length == 3) {
			if ("0".equals(arryType[2])) {
				formatType = "0";
			} else if ("1".equals(arryType[2])) {
				formatType = "1";
			} else if ("2".equals(arryType[2])) {
				formatType = "2";
			} else {
				formatType = "3";
			}
		} else {
			formatType = "3";
		}

		return formatType;
	}

	public static void main(String[] args) {

	}

	/**
	 * 大数据量导出
	 *
	 * @param filepath
	 *            文件完整路径
	 * @param headers
	 *            第一行标题数组
	 * @param maps
	 *            数据集合
	 * @param sheetname
	 *            sheet标题
	 * @return
	 * @throws FileNotFoundException
	 */
	public Boolean exportForSXSSFWorkBook(String filepath, String[] headers, List<Map<String, Object>> maps, String sheetname) throws FileNotFoundException {

		// log.info("导出大数据excel：[" + filepath + "][" + maps.size() + "]--开始");

		OutputStream out = new FileOutputStream(filepath);
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetname);

		Row row = sheet.createRow(0);
		String headTitle;
		for (int i = 0; i < headers.length; i++) {
			headTitle = getTitleFormHead(headers[i]);
			Cell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headTitle);
			cell.setCellValue(text);
		}
		String paramName;
		String textValue;
		for (int i = 0; i < maps.size(); i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < headers.length; j++) {
				String formatType = getFormatTypeHead(headers[j]);
				paramName = getFieldNameFormHead(headers[j]);
				Object obj = maps.get(i).get(paramName);
				if (obj != null) {
					textValue = obj.toString();
				} else {
					textValue = "";
				}
				CellStyle contextstyle = workbook.createCellStyle();
				Cell contentCell = row.createCell(j);
				DataFormat df = workbook.createDataFormat(); // 此处设置数据格式
				contentCell.setCellValue(textValue);
				if (!"".equals(textValue)) {
					if ("0".equals(formatType)) {
						contextstyle.setDataFormat(df.getFormat("#,#0"));// 数据格式只显示整数
						contentCell.setCellStyle(contextstyle);
						try {
							contentCell.setCellValue(Double.parseDouble(textValue));
						} catch (Exception e) {
							contentCell.setCellValue(Double.parseDouble("0"));
						}
					} else if ("1".equals(formatType)) {
						contextstyle.setDataFormat(df.getFormat("#,##0.00"));// 保留两位小数点
						contentCell.setCellStyle(contextstyle);
						try {
							contentCell.setCellValue(Double.parseDouble(textValue));
						} catch (Exception e) {
							contentCell.setCellValue(Double.parseDouble("0"));
						}
					} else if ("2".equals(formatType)) {
						contextstyle.setDataFormat(df.getFormat("#,##0.00"));// 金额保留两位小数点
						textValue = textValue.replace(",", "");

						if (textValue.contains("¥")) {
							textValue = textValue.substring(1, textValue.length());
						}

						contentCell.setCellStyle(contextstyle);
						try {
							contentCell.setCellValue(Double.parseDouble(textValue));
						} catch (Exception e) {
							contentCell.setCellValue(Double.parseDouble("0"));
						}

					} else {
						contentCell.setCellStyle(contextstyle);
						contentCell.setCellValue(textValue);
					}
				} else {
					contentCell.setCellStyle(contextstyle);
					contentCell.setCellValue(textValue);
				}
			}
		}
		try {
			workbook.write(out);
			// log.info("导出大数据excel：[" + filepath + "][" + maps.size() +
			// "]--结束");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
