package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.WTConvert;
import com.msy.travel.dao.CommproductDao;
import com.msy.travel.pojo.Commproduct;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CommproductService;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.IRsPicService;

/**
 * CommproductService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CommproductServiceImpl implements CommproductService {

	@Resource(name = "commproductDao")
	private CommproductDao commproductDao;

	@Resource(name = "companyServiceImpl")
	private CompanyService companyService;

	@Resource(name = "rsPicServiceImpl")
	private IRsPicService rsPicService;

	/**
	 * 新增Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void createCommproduct(Commproduct commproduct) throws Exception {
		commproductDao.insertCommproduct(commproduct);
	}

	/**
	 * 检查Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void mergeCommproduct(Commproduct commproduct) throws Exception {
		commproductDao.mergeCommproduct(commproduct);
	}

	/**
	 * 删除Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void deleteCommproduct(Commproduct commproduct) throws Exception {
		commproductDao.deleteCommproduct(commproduct);
	}

	/**
	 * 修改Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 */
	public void updateCommproduct(Commproduct commproduct) throws Exception {
		commproductDao.updateCommproduct(commproduct);
	}

	/**
	 * 批量删除Commproduct
	 * 
	 * @param commproductIdList
	 *            存放commproduct主键的list
	 */
	public void deleteBatchCommproduct(Commproduct commproduct) throws Exception {
		commproductDao.deleteBatchCommproduct(commproduct);
	}

	/**
	 * 查询单个Commproduct
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return 成员实体对象
	 */
	public Commproduct displayCommproduct(Commproduct commproduct) throws Exception {
		return commproductDao.queryCommproduct(commproduct);
	}

	/**
	 * 查询Commproduct列表
	 * 
	 * @param commproduct
	 *            Commproduct对象
	 * 
	 * @return Commproduct列表
	 */
	public List<Commproduct> queryCommproductList(Commproduct commproduct) throws Exception {
		return commproductDao.queryCommproductList(commproduct);
	}

	/**
	 * 获取CommproductID
	 */
	public String getCommproductId() throws Exception {
		return commproductDao.getCommproductId();
	}

	/**
	 * 新增商品
	 * 
	 * @author wzd
	 * @date 2019年10月2日 上午10:43:10
	 * @param thumbPic
	 * @param picIds
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void createCommproduct(String thumbPic, String[] picIds, Commproduct commproduct, User user) throws Exception {

		commproduct.setProductCode(PrimaryKeyUtil.generateNumCode());
		commproduct.setSpId(user.getAccId());

		// 供应商名称
		String venName = "";
		Company company = new Company();
		company.setVenId(commproduct.getVenId());
		company = companyService.displayCompany(company);
		if (company != null) {
			venName = company.getVenName();
		}
		commproduct.setSpId(user.getAccId());
		commproduct.setDelFlag("0");
		commproduct.setVenName(venName);
		commproduct.setThumbPic(thumbPic);
		commproduct.setCreatorUid(user.getUserId());
		commproduct.setCreator(user.getUserName());
		commproduct.setCreaterTime(DateTimeUtil.getDateTime19());
		commproduct.setUpdater(user.getUserName());
		commproduct.setUpdaterUid(user.getUserId());
		commproduct.setUpdateTime(DateTimeUtil.getDateTime19());

		commproduct.setSaleNum(WTConvert.emptyToNull(commproduct.getSaleNum()));
		commproduct.setSortNum(WTConvert.emptyToNull(commproduct.getSortNum()));
		commproduct.setReferencePrice(WTConvert.emptyToNull(commproduct.getReferencePrice()));

		commproduct.setState("0");

		commproductDao.insertCommproduct(commproduct);

		rsPicService.saveRsPic(picIds, commproduct.getProductId());
	}

	/**
	 * 修改
	 * 
	 * @author wzd
	 * @date 2019年10月4日 下午2:33:08
	 * @param thumbPic
	 * @param picIds
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void updateCommproduct(String thumbPic, String[] picIds, Commproduct commproduct, User user) throws Exception {
		// 供应商名称
		String venName = "";
		Company company = new Company();
		company.setVenId(commproduct.getVenId());
		company = companyService.displayCompany(company);
		if (company != null) {
			venName = company.getVenName();
		}
		commproduct.setDelFlag("0");
		commproduct.setVenName(venName);
		commproduct.setThumbPic(thumbPic);
		commproduct.setUpdater(user.getUserName());
		commproduct.setUpdaterUid(user.getUserId());
		commproduct.setUpdateTime(DateTimeUtil.getDateTime19());

		commproduct.setSaleNum(WTConvert.emptyToNull(commproduct.getSaleNum()));
		commproduct.setSortNum(WTConvert.emptyToNull(commproduct.getSortNum()));
		commproduct.setReferencePrice(WTConvert.emptyToNull(commproduct.getReferencePrice()));
		commproduct.setState("0");
		commproductDao.updateCommproduct(commproduct);
		rsPicService.saveRsPic(picIds, commproduct.getProductId());
	}

	/**
	 * 上下架
	 * 
	 * @author wzd
	 * @date 2019年10月4日 下午4:14:57
	 * @param commproduct
	 * @param user
	 * @throws Exception
	 * @return void
	 */
	public void changeState(Commproduct commproduct, User user) throws Exception {

		// 0-下架 1-上架
		String newState = commproduct.getState();

		commproduct = commproductDao.queryCommproduct(commproduct);
		commproduct.setState(newState);
		commproduct.setUpdater(user.getUserName());
		commproduct.setUpdaterUid(user.getUserId());
		commproduct.setUpdateTime(DateTimeUtil.getDateTime19());
		commproductDao.updateCommproduct(commproduct);
	}

	/**
	 * 微信端查看详情
	 * 
	 * @author wzd
	 * @date 2019年10月6日 下午6:07:06
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return Commproduct
	 */
	public Commproduct queryCommproductForWx(Commproduct commproduct) throws Exception {
		return commproductDao.queryCommproductForWx(commproduct);
	}

	/**
	 * 后台查询，为了复制功能添加priceId
	 * 
	 * @author wzd
	 * @date 2019年12月2日 上午10:54:39
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return List<Commproduct>
	 */
	public List<Commproduct> queryCommproductListAndPriceId(Commproduct commproduct) throws Exception {
		return commproductDao.queryCommproductListAndPriceId(commproduct);
	}

	/**
	 * 优惠券已选择的商品
	 * 
	 * @author wzd
	 * @date 2020年3月21日 下午9:43:43
	 * @param commproduct
	 * @return
	 * @throws Exception
	 * @return List<Commproduct>
	 */
	public List<Commproduct> queryCommproductListForCouponCheck(Commproduct commproduct) throws Exception {
		return commproductDao.queryCommproductListForCouponCheck(commproduct);
	}
}
