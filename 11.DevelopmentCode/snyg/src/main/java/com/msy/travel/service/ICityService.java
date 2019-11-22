package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.City;

/**
 * CityService接口
 * 
 * @author wootide
 * 
 */
public interface ICityService {
	/**
	 * 新增City
	 *
	 * @param city
	 *            City对象
	 */
	public void createCity(City city) throws Exception;

	/**
	 * 删除City
	 *
	 * @param city
	 *            City对象
	 */
	public void deleteCity(City city) throws Exception;

	/**
	 * 修改City
	 *
	 * @param city
	 *            City对象
	 */
	public void updateCity(City city) throws Exception;

	/**
	 * 查询单个City
	 *
	 * @param city
	 *            City对象
	 *
	 * @return City实体对象
	 */
	public City displayCity(City city) throws Exception;

	/**
	 * 获取总行数
	 *
	 * @return 总行数
	 */
	public int getTotalCount(City city) throws Exception;

	/**
	 * 查询City列表
	 *
	 * @param city
	 *            City对象
	 *
	 * @return City列表
	 */
	public List<City> queryCityList(City city) throws Exception;
	
	public List<City> queryCityListByName(City city) throws Exception;

}
