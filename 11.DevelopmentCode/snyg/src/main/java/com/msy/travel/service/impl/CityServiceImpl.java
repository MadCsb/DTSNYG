package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.CityDao;
import com.msy.travel.pojo.City;
import com.msy.travel.service.ICityService;

/**
 * CityService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Resource(name = "cityDao")
	private CityDao cityDao;

	/**
	 * 新增City
	 *
	 * @param city
	 *            City对象
	 */
	public void createCity(City city) throws Exception {
		cityDao.insertCity(city);
	}

	/**
	 * 删除City
	 *
	 * @param city
	 *            City对象
	 */
	public void deleteCity(City city) throws Exception {
		cityDao.deleteCity(city);
	}

	/**
	 * 修改City
	 *
	 * @param city
	 *            City对象
	 */
	public void updateCity(City city) throws Exception {
		cityDao.updateCity(city);
	}

	/**
	 * 查询单个City
	 *
	 * @param city
	 *            City对象
	 *
	 * @return 成员实体对象
	 */
	public City displayCity(City city) throws Exception {
		return cityDao.queryCity(city);
	}

	/**
	 * 通过条件获取总行数
	 *
	 * @param city
	 *            City实体对象
	 *
	 * @return 总行数
	 */
	public int getTotalCount(City city) throws Exception {
		int total = 0;

		total = cityDao.getTotalCount(city);

		return total;
	}

	/**
	 * 查询City列表
	 *
	 * @param city
	 *            City对象
	 *
	 * @return City列表
	 */
	public List<City> queryCityList(City city) throws Exception {
		return cityDao.queryCityList(city);
	}
	
	public List<City> queryCityListByName(City city) throws Exception {
		return cityDao.queryCityListByName(city);
	}

}
