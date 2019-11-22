package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.dao.CarouselDao;
import com.msy.travel.pojo.Carousel;
import com.msy.travel.service.CarouselService;

/**
 * CarouselService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

	@Resource(name = "carouselDao")
	private CarouselDao carouselDao;

	/**
	 * 新增Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void createCarousel(Carousel carousel) throws Exception {
		carouselDao.insertCarousel(carousel);
	}

	/**
	 * 检查Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void mergeCarousel(Carousel carousel) throws Exception {
		carouselDao.mergeCarousel(carousel);
	}

	/**
	 * 删除Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void deleteCarousel(Carousel carousel) throws Exception {
		carouselDao.deleteCarousel(carousel);
	}

	/**
	 * 修改Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void updateCarousel(Carousel carousel) throws Exception {
		carouselDao.updateCarousel(carousel);
	}

	/**
	 * 批量删除Carousel
	 * 
	 * @param carouselIdList
	 *            存放carousel主键的list
	 */
	public void deleteBatchCarousel(Carousel carousel) throws Exception {
		carouselDao.deleteBatchCarousel(carousel);
	}

	/**
	 * 查询单个Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return 成员实体对象
	 */
	public Carousel displayCarousel(Carousel carousel) throws Exception {
		return carouselDao.queryCarousel(carousel);
	}

	/**
	 * 查询Carousel列表
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return Carousel列表
	 */
	public List<Carousel> queryCarouselList(Carousel carousel) throws Exception {
		return carouselDao.queryCarouselList(carousel);
	}

	/**
	 * 获取CarouselID
	 */
	public String getCarouselId() throws Exception {
		return carouselDao.getCarouselId();
	}

	/**
	 * 校验重复
	 * 
	 * @author Gengb
	 * @date 2018年8月1日 下午1:15:48
	 * @param carousel
	 * @throws Exception
	 * @return int
	 */
	public int checkCarousel(Carousel carousel) throws Exception {
		return carouselDao.checkCarousel(carousel);
	}
}
