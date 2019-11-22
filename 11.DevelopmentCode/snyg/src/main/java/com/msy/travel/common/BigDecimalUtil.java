package com.msy.travel.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {

	/**
	 * 两数相乘
	 * 
	 * @param strNum1
	 * @param strNum2
	 * @return
	 */
	public static final String multiply(String strNum1, String strNum2) {
		if (strNum1 == null || "".equals(strNum1) || strNum2 == null || "".equals(strNum2)) {
			return "0";
		}
		BigDecimal num1 = new BigDecimal(strNum1);
		BigDecimal num2 = new BigDecimal(strNum2);
		return num1.multiply(num2).toString();
	}

	/**
	 * 两数相除
	 * 
	 * @param strNum1
	 * @param strNum2
	 * @return
	 */
	public static final String divide(String strNum1, String strNum2) {
		if (strNum1 == null || "".equals(strNum1) || strNum2 == null || "".equals(strNum2) || "0".equals(strNum2)) {
			return "0";
		}
		BigDecimal num1 = new BigDecimal(strNum1);
		BigDecimal num2 = new BigDecimal(strNum2);
		if (num1.compareTo(BigDecimal.ZERO) == 0 || num2.compareTo(BigDecimal.ZERO) == 0) {
			return "0";
		}

		return num1.divide(num2, 2, RoundingMode.HALF_UP).toString();
	}

	/**
	 * 两数相加
	 * 
	 * @param strNum1
	 * @param strNum2
	 * @return
	 */
	public static final String add(String strNum1, String strNum2) {
		if (strNum1 == null || "".equals(strNum1) || strNum2 == null || "".equals(strNum2)) {
			return "0";
		}
		BigDecimal num1 = new BigDecimal(strNum1);
		BigDecimal num2 = new BigDecimal(strNum2);
		return num1.add(num2).toString();
	}

	/**
	 * 两数相减
	 * 
	 * @param strNum1
	 * @param strNum2
	 * @return
	 */
	public static final String subtract(String strNum1, String strNum2) {
		if (strNum1 == null || "".equals(strNum1) || strNum2 == null || "".equals(strNum2)) {
			return "0";
		}
		BigDecimal num1 = new BigDecimal(strNum1);
		BigDecimal num2 = new BigDecimal(strNum2);
		return num1.subtract(num2).toString();
	}

	/**
	 * 去掉多余的零
	 * 
	 * @param number
	 * @return
	 */
	public static String getPrettyNumber(String number) {
		return BigDecimal.valueOf(Double.parseDouble(number)).stripTrailingZeros().toPlainString();
	}
}
