package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.Carousel;

/**
 * CarouselService接口
 * 
 * @author wootide
 * 
 */
public interface CarouselService {
	/**
	 * 新增Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void createCarousel(Carousel carousel) throws Exception;

	/**
	 * 检查Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void mergeCarousel(Carousel carousel) throws Exception;

	/**
	 * 删除Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void deleteCarousel(Carousel carousel) throws Exception;

	/**
	 * 批量删除Carousel
	 * 
	 * @param carouselIdList
	 *            存放carousel主键的list
	 */
	public void deleteBatchCarousel(Carousel carousel) throws Exception;

	/**
	 * 修改Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	public void updateCarousel(Carousel carousel) throws Exception;

	/**
	 * 查询单个Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return Carousel实体对象
	 */
	public Carousel displayCarousel(Carousel carousel) throws Exception;

	/**
	 * 查询Carousel列表
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return Carousel列表
	 */
	public List<Carousel> queryCarouselList(Carousel carousel) throws Exception;

	/**
	 * 获取Carousel主键ID
	 */
	public String getCarouselId() throws Exception;

	/**
	 * 校验重复
	 * 
	 * @author Gengb
	 * @date 2018年8月1日 下午1:15:48
	 * @param carousel
	 * @throws Exception
	 * @return int
	 */
	public int checkCarousel(Carousel carousel) throws Exception;
}
