package com.msy.travel.pojo;


public class Charts implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -381929352812603899L;
	
	/**
	 * 坐标x名称
	 */
	private String pointsName;
	
	/**
	 * 坐标y值
	 */
	private String pointsValue;
	
	/**
	 * 时间区间开始
	 */
	private String timeStart;
	
	/**
	 * 时间区间结束
	 */
	private String timeEnd;
	
	/**
	 * 数据1
	 */
	private String data1;
	
	/**
	 * 数据1
	 */
	private String data2;
	
	public String getPointsName() {
		return pointsName;
	}

	public void setPointsName(String pointsName) {
		this.pointsName = pointsName;
	}

	public String getPointsValue() {
		return pointsValue;
	}

	public void setPointsValue(String pointsValue) {
		this.pointsValue = pointsValue;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}
}
