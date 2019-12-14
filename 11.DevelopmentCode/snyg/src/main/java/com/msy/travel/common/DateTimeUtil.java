package com.msy.travel.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateTimeUtil {

	public static String sdf10 = "yyyy-MM-dd";

	public static String sdf16 = "yyyy-MM-dd HH:mm";

	public static String sdf14 = "yyyyMMddHHmmss";

	public static String sdf12 = "yyyyMMddHHmm";

	public static String sdf17 = "yyyyMMddHHmmssSSS";

	public static String sdf19 = "yyyy-MM-dd HH:mm:ss";

	public static String sdf23 = "yyyy-MM-dd HH:mm:ss:SSS";

	public static final String getDateTime19() {
		return getDateTime19(System.currentTimeMillis());
	}

	public static final String getDateTime14() {
		return getDateTime14(System.currentTimeMillis());
	}

	public static final String getDateTime14(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf14).format(d);
	}

	public static final String getDateTime12() {
		return getDateTime12(System.currentTimeMillis());
	}

	public static final String getDateTime12(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf12).format(d);
	}

	public static final String getDateTime17() {
		return getDateTime17(System.currentTimeMillis());
	}

	public static final String getDateTime17(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf17).format(d);
	}

	public static final String getDateTime19(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf19).format(d);
	}

	public static final String getDateTime23() {
		return getDateTime23(System.currentTimeMillis());
	}

	public static final String getDateTime23(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf23).format(d);
	}

	public static final long getLongTime23(String dataStr23) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat(sdf23).parse(dataStr23);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d.getTime();
	}

	public static final long getLongTime10(String dataStr10) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat(sdf10).parse(dataStr10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d.getTime();
	}

	public static final String getDateTime10() {
		return getDateTime10(System.currentTimeMillis());
	}

	public static final String getDateTime10(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf10).format(d);
	}

	public static final String getDateTime16() {
		return getDateTime16(System.currentTimeMillis());
	}

	public static final String getDateTime16(long time) {
		Date d = new Date(time);
		return new SimpleDateFormat(sdf16).format(d);
	}

	public static final Date getDateTime16Str(String time) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat(sdf16).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static final Date getDateTime19Str(String time) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat(sdf19).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static final Date getDateTime10Str(String time) {
		Date d = new Date();
		try {
			d = new SimpleDateFormat(sdf10).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static final String parseDateTime14To19(String datetime14) {
		StringBuffer sf = new StringBuffer(datetime14);
		sf.insert(4, "-");
		sf.insert(7, "-");
		sf.insert(10, " ");
		sf.insert(13, ":");
		sf.insert(16, ":");
		return sf.toString();
	}

	public static final String parseDateTime19To14(String datetime19) {// 2012-04-05
																		// 19:32:03
		return datetime19.replaceAll("-|:| ", "");
	}

	public static final String parseTime6To8(String time6) {
		StringBuffer sf = new StringBuffer(time6);
		sf.insert(2, ":");
		sf.insert(5, ":");
		return sf.toString();
	}

	public static final String parseDate8To10(String date8) {
		StringBuffer sf = new StringBuffer(date8);
		sf.insert(4, "-");
		sf.insert(7, "-");
		return sf.toString();
	}

	// 获取当前时间的时分秒字符串
	public static final String getCurrentHMS() {
		Calendar ca = Calendar.getInstance();
		return ca.get(Calendar.HOUR) + "" + ca.get(Calendar.MINUTE) + ca.get(Calendar.SECOND);

	}

	public static String addDate(String now, String day) {
		try {
			Calendar fromCal = Calendar.getInstance();
			Date date = new SimpleDateFormat().parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.DATE, Integer.parseInt(day));

			return new SimpleDateFormat().format(fromCal.getTime()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public static String addDate(String pattern, String now, String day) {
		try {
			Calendar fromCal = Calendar.getInstance();
			Date date = new SimpleDateFormat(pattern).parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(day));

			return new SimpleDateFormat(pattern).format(fromCal.getTime()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public static double getDiffHour(Date startDate, Date endDate) {
		// long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		// long nm = 1000 * 60;
		long diff = 0l;
		double hour = 0;
		try {
			// 获得两个时间的毫秒时间差异
			diff = endDate.getTime() - startDate.getTime();
			// 计算差多少小时
			hour = round(diff, nh, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hour;
	}

	public static double round(double num1, double num2, int scale) {
		return new BigDecimal(num1).divide(new BigDecimal(num2), scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static long getDiffDays(Date startDate, Date endDate) {
		long nd = 1000 * 24 * 60 * 60;
		// long nh = 1000 * 60 * 60;
		// long nm = 1000 * 60;
		long diff = 0l;
		long day = 0l;
		try {
			// 获得两个时间的毫秒时间差异
			diff = endDate.getTime() - startDate.getTime();
			// 计算差多少天
			day = diff / nd;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return day;
	}

	/**
	 * 判断时间与所给定时间区间的关系
	 * 
	 * @author KDurant
	 * @date 2016年11月30日 上午10:18:19
	 * @param judgeTime需要判断的时间
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @param startTime
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @param endTime
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @return int 0:小于 1:其中 2:大于
	 */
	public static String judgeDateTime(String judgeTime, String startTime, String endTime) throws Exception {
		String result = "-1";
		Date startDate, endDate, nowDate;
		nowDate = getDateTime19Str(judgeTime);
		if (StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime)) {
			if (startTime.length() == 19 && endTime.length() == 19) {
				startDate = getDateTime19Str(startTime);
				endDate = getDateTime19Str(endTime);
				if (nowDate.getTime() < startDate.getTime()) {
					result = "0";
				} else if (nowDate.getTime() >= startDate.getTime() && nowDate.getTime() < endDate.getTime()) {
					result = "1";
				} else if (nowDate.getTime() >= endDate.getTime()) {
					result = "2";
				}
			}
		}

		return result;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算 ,相差天数
	 */
	public static int daysBetween(String smdate, String bdate, String model) throws ParseException {
		SimpleDateFormat sdf = null;
		if ("0".equals(model)) // 日
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if ("1".equals(model)) // 日
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		if ("2".equals(model)) // 月
		{
			sdf = new SimpleDateFormat("yyyy-MM");
		}
		if ("3".equals(model)) // 年
		{
			sdf = new SimpleDateFormat("yyyy");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算 ,相差天数
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算年龄
	 * 
	 * @author KDurant
	 * @date 2017年1月4日 下午12:16:49
	 * @param startStr
	 *            "yyyy-MM-dd"
	 * @param endStr
	 *            "yyyy-MM-dd"
	 * @return
	 * @return int
	 */
	public static int getAgeByDateStr(String startStr, String endStr) {
		Date startDate = null, endDate = null;
		long diff = 0l, d = 24 * 60 * 60 * 1000, y = 365;
		int age = 0;
		try {
			if (StringUtils.isNotEmpty(startStr) && StringUtils.isNotEmpty(endStr)) {
				if (startStr.length() == 10) {
					startDate = getDateTime10Str(startStr);
				}
				if (endStr.length() == 10) {
					endDate = getDateTime10Str(endStr);
				}
			}
			if (startDate != null && endDate != null) {
				diff = endDate.getTime() - startDate.getTime();
				if (diff >= 0) {
					age = (int) Math.ceil(round(round(diff, d, 5), y, 5));
				} else {
					age = (int) Math.floor(round(round(diff, d, 5), y, 5));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return age;
	}

	/**
	 * 计算月加减，返回计算完当前月的第一天
	 * 
	 * @param now
	 * @param month
	 * @return
	 */
	public static String addMonthStart(String now, String month) {
		try {
			Calendar fromCal = Calendar.getInstance();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.MONTH, Integer.parseInt(month));
			return new SimpleDateFormat("yyyy-MM-01").format(fromCal.getTime()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 计算月加减，返回计算完当前月的最后一天
	 * 
	 * @param now
	 * @param month
	 * @return
	 */
	public static String addMonthEnd(String now, String month) {
		try {
			Calendar fromCal = Calendar.getInstance();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.MONTH, Integer.parseInt(month));
			return new SimpleDateFormat("yyyy-MM-" + fromCal.getActualMaximum(Calendar.DAY_OF_MONTH)).format(fromCal.getTime()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 获取整型时间
	 * 
	 * @return
	 */
	public static long convertDateTimeToLong() {
		Date dt = new Date();
		return dt.getTime() / 1000;
	}

	/**
	 * 增加时分秒
	 * 
	 * @param now
	 * @param day
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static String addDateTime(String now, String day, String hour, String minute) {
		try {
			Calendar fromCal = Calendar.getInstance();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = f.parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.DATE, Integer.parseInt(day));
			fromCal.add(Calendar.HOUR, Integer.parseInt(hour));
			fromCal.add(Calendar.MINUTE, Integer.parseInt(minute));

			return f.format(fromCal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * yyyy-MM-dd 转 m/d
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToMonthDay(String date) {
		if (date != null && date.length() == 10) {
			String month = date.substring(5, 7);
			String day = date.substring(8, 10);

			if (month.startsWith("0")) {
				month = month.substring(1);
			}

			if (day.startsWith("0")) {
				day = day.substring(1);
			}

			return month + "/" + day;
		}

		return "";

	}

	/**
	 * 计算一周的开始日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekDateStart(String date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			int d = 0;
			if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
				d = -6;
			} else {
				d = 2 - cal.get(Calendar.DAY_OF_WEEK);
			}
			cal.add(Calendar.DAY_OF_WEEK, d);

			// 开始日期
			String weekStart = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

			return weekStart;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 计算一周的结束日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekDateEnd(String date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			int d = 0;
			if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
				d = -6;
			} else {
				d = 2 - cal.get(Calendar.DAY_OF_WEEK);
			}
			cal.add(Calendar.DAY_OF_WEEK, d);

			// 结束日期
			cal.add(Calendar.DAY_OF_WEEK, 6);
			String weekEnd = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

			return weekEnd;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 计算一个月的开始日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDateStart(String date) {
		try {
			String monthStart = date.substring(0, 8) + "01";
			return monthStart;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 计算一个月的结束日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDateEnd(String date) {
		try {
			String monthStart = date.substring(0, 8) + "01";

			// 获取本月的最后一天
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(monthStart));
			cal.add(Calendar.MONTH, 1);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			String monthEnd = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

			return monthEnd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 比较两个时间大小
	 * 
	 * @author wzd
	 * @date 2019年12月12日 下午8:30:55
	 * @param time1
	 * @param time2
	 * @return
	 * @return boolean
	 */
	public static String compareDate(String time1, String time2) {
		String result = "0";
		try {
			// 如果想比较日期则写成"yyyy-MM-dd"就可以了
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// 将字符串形式的时间转化为Date类型的时间
			Date a = sdf.parse(time1);
			Date b = sdf.parse(time2);
			// Date类的一个方法，如果a早于b返回1，否则返回3
			if (a.before(b))
				return "1";
			else if (a.equals(b))
				return "2";
			else
				return "3";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		String result = compareDate(DateTimeUtil.getDateTime19(), DateTimeUtil.getDateTime10() + " 22:00:00");
		System.out.println(result);
	}
}
