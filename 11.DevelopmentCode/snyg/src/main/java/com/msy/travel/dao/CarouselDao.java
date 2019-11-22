package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.Carousel;

/**
 * CarouselDao接口
 * 
 * @author wootide
 * 
 */
public interface CarouselDao {
	/**
	 * 增加Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	void insertCarousel(Carousel carousel) throws Exception;

	/**
	 * 检查Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	void mergeCarousel(Carousel carousel) throws Exception;

	/**
	 * 删除Carousel
	 * 
	 * @param carousel
	 *            成语对象
	 */
	void deleteCarousel(Carousel carousel) throws Exception;

	/**
	 * 批量删除Carousel
	 * 
	 * @param ids
	 *            ids
	 */
	void deleteBatchCarousel(Carousel carousel) throws Exception;

	/**
	 * 修改Carousel
	 * 
	 * @param carousel
	 *            Carousel对象
	 */
	void updateCarousel(Carousel carousel) throws Exception;

	/**
	 * 查询单个Carousel信息
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return Carousel实体对象
	 */
	Carousel queryCarousel(Carousel carousel) throws Exception;

	/**
	 * 查询Carousel列表信息
	 * 
	 * @param carousel
	 *            Carousel对象
	 * 
	 * @return Carousel列表
	 */
	List<Carousel> queryCarouselList(Carousel carousel) throws Exception;

	/**
	 * 获取CarouselID
	 */
	String getCarouselId() throws Exception;

	/**
	 * 校验重复
	 * 
	 * @author Gengb
	 * @date 2018年8月1日 下午1:15:48
	 * @param carousel
	 * @throws Exception
	 * @return int
	 */
	int checkCarousel(Carousel carousel) throws Exception;
}
