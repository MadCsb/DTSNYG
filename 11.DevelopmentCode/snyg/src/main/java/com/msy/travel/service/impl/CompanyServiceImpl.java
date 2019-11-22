package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.CompanyDao;
import com.msy.travel.pojo.Company;
import com.msy.travel.pojo.Linkinfo;
import com.msy.travel.pojo.User;
import com.msy.travel.service.CompanyService;
import com.msy.travel.service.ILinkinfoService;

/**
 * CompanyService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Resource(name = "companyDao")
	private CompanyDao companyDao;

	@Resource(name = "linkinfoServiceImpl")
	private ILinkinfoService linkinfoService;

	/**
	 * 新增Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void createCompany(Company company, User user) throws Exception {
		int flag = 0;// 判断主键是否存在
		if (company.getVenId() == null) {
			company.setVenId(PrimaryKeyUtil.generateKey());
			flag = 1;
		}
		Linkinfo linkinfo = new Linkinfo();
		String name[] = company.getlName().split(",");
		String handphone[] = company.getlHandphone().split(",");
		String duty[] = company.getlDuty().split(",");
		String tel[] = company.getlTel().split(",");
		String fax[] = company.getlFax().split(",");
		String QQ[] = company.getlQQ().split(",");
		linkinfo.setCreateTime(DateTimeUtil.getDateTime19());
		linkinfo.setCreator(user.getUserName());
		linkinfo.setCreatorUid(user.getUserId());
		linkinfo.setVenId(company.getVenId());

		for (int i = 0; i < name.length; i++) {
			if (i == 0 && flag == 0) {
				continue;
			}
			linkinfo.setName(name[i].trim());
			linkinfo.setHandPhone(handphone[i].trim());
			linkinfo.setDuty(duty[i].trim());
			linkinfo.setTel(tel[i].trim());
			linkinfo.setFax(fax[i].trim());
			linkinfo.setQq(QQ[i].trim());
			if (linkinfo.getName().length() > 0) {
				linkinfoService.createLinkinfo(linkinfo);
			}
		}
		if (flag == 1) {
			companyDao.insertCompany(company);
		}
	}

	/**
	 * 检查Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void mergeCompany(Company company) throws Exception {
		companyDao.mergeCompany(company);
	}

	/**
	 * 删除Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void deleteCompany(Company company) throws Exception {
		companyDao.deleteCompany(company);
	}

	/**
	 * 修改Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void updateCompany(Company company, User user) throws Exception {
		Linkinfo uLinkinfo = new Linkinfo();
		// 修改当前联系人
		String uName[] = company.getuName().split(",");
		String uHandphone[] = company.getuHandphone().split(",");
		String uDuty[] = company.getuDuty().split(",");
		String uTel[] = company.getuTel().split(",");
		String uFax[] = company.getuFax().split(",");
		String uQQ[] = company.getuQQ().split(",");
		String uLinkId[] = company.getuLinkId().split(",");
		uLinkinfo.setUpdateTime(DateTimeUtil.getDateTime19());
		uLinkinfo.setUpdater(user.getUserName());
		uLinkinfo.setUpdaterUid(user.getUserId());
		uLinkinfo.setVenId(company.getVenId());
		for (int i = 1; i < uName.length; i++) {
			uLinkinfo.setName(uName[i].trim());
			uLinkinfo.setHandPhone(uHandphone[i].trim());
			uLinkinfo.setDuty(uDuty[i].trim());
			uLinkinfo.setTel(uTel[i].trim());
			uLinkinfo.setFax(uFax[i].trim());
			uLinkinfo.setQq(uQQ[i].trim());
			uLinkinfo.setLinkId(uLinkId[i].trim());
			linkinfoService.updateLinkinfo(uLinkinfo);
		}
		companyDao.updateCompany(company);
	}

	/**
	 * 修改Company
	 * 
	 * @param company
	 *            Company对象
	 */
	public void updateCompany(Company company) throws Exception {
		companyDao.updateCompany(company);
	}

	/**
	 * 批量删除Company
	 * 
	 * @param companyIdList
	 *            存放company主键的list
	 */
	public void deleteBatchCompany(Company company) throws Exception {
		companyDao.deleteBatchCompany(company);
	}

	/**
	 * 查询单个Company
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return 成员实体对象
	 */
	public Company displayCompany(Company company) throws Exception {
		return companyDao.queryCompany(company);
	}

	/**
	 * 查询Company列表
	 * 
	 * @param company
	 *            Company对象
	 * 
	 * @return Company列表
	 */
	public List<Company> queryCompanyList(Company company) throws Exception {
		return companyDao.queryCompanyList(company);
	}

	/**
	 * 获取CompanyID
	 */
	public String getCompanyId() throws Exception {
		return companyDao.getCompanyId();
	}

	/**
	 * 根据商家名称检索条数
	 * 
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public int getCountByVenName(Company company) throws Exception {
		return companyDao.getCountByVenName(company);
	}

	@Override
	public List<Company> queryCompanyListByIdList(Company company) throws Exception {
		// TODO Auto-generated method stub
		return this.companyDao.queryCompanyListByIdList(company);
	}
}
