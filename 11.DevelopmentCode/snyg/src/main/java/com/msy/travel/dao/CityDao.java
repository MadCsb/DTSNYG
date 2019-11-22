package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.City;

/**
 * CityDao接口
 * 
 * @author wootide
 * 
 */
public interface CityDao {
	/**
	 * 增加City
	 *
	 * @param city
	 *            City对象
	 */
	void insertCity(City city) throws Exception;

	/**
	 * 删除City
	 *
	 * @param city
	 *            成语对象
	 */
	void deleteCity(City city) throws Exception;

	/**
	 * 修改City
	 *
	 * @param city
	 *            City对象
	 */
	void updateCity(City city) throws Exception;

	/**
	 * 查询单个City信息
	 *
	 * @param city
	 *            City对象
	 *
	 * @return City实体对象
	 */
	City queryCity(City city) throws Exception;

	/**
	 * 获取满足查询条件总行数
	 *
	 * @param city
	 *            City实体对象
	 *
	 * @return 行数
	 */
	int getTotalCount(City city) throws Exception;

	/**
	 * 查询City列表信息
	 *
	 * @param city
	 *            City对象
	 *
	 * @return City列表
	 */
	List<City> queryCityList(City city) throws Exception;
	
	List<City> queryCityListByName(City city) throws Exception;

}
