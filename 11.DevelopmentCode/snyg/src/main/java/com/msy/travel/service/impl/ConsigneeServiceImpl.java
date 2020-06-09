package com.msy.travel.service.impl;

import com.msy.travel.pojo.User;
import com.msy.travel.service.IUserService;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.dao.ConsigneeDao;
import com.msy.travel.pojo.Consignee;
import com.msy.travel.service.ConsigneeService;

/**
 * ConsigneeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ConsigneeServiceImpl implements ConsigneeService {

	@Resource(name = "consigneeDao")
	private ConsigneeDao consigneeDao;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * 新增Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void createConsignee(Consignee consignee) throws Exception {
		consigneeDao.insertConsignee(consignee);
	}

	/**
	 * 检查Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void mergeConsignee(Consignee consignee) throws Exception {
		consigneeDao.mergeConsignee(consignee);
	}

	/**
	 * 删除Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void deleteConsignee(Consignee consignee) throws Exception {
		consigneeDao.deleteConsignee(consignee);
	}

	/**
	 * 修改Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 */
	public void updateConsignee(Consignee consignee) throws Exception {
		consigneeDao.updateConsignee(consignee);
	}

	/**
	 * 批量删除Consignee
	 * 
	 * @param consigneeIdList
	 *            存放consignee主键的list
	 */
	public void deleteBatchConsignee(Consignee consignee) throws Exception {
		consigneeDao.deleteBatchConsignee(consignee);
	}

	/**
	 * 查询单个Consignee
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return 成员实体对象
	 */
	public Consignee displayConsignee(Consignee consignee) throws Exception {
		return consigneeDao.queryConsignee(consignee);
	}

	/**
	 * 查询Consignee列表
	 * 
	 * @param consignee
	 *            Consignee对象
	 * 
	 * @return Consignee列表
	 */
	public List<Consignee> queryConsigneeList(Consignee consignee) throws Exception {
		if(consignee.getUserId() != null && !consignee.getUserId().equals("")) //如果存在用戶ID作为参数
		{
			User user = new User();
			user.setUserId(consignee.getUserId());
			user = userService.displayUser(user);
			if(user.getUnionId() != null && !user.getUnionId().equals("")) //如果参数对应用户保存了unionId，则使用unionId作为参数
			{
				consignee.setUserId(null);
				consignee.setUnionId(user.getUnionId());
			}
		}
		return consigneeDao.queryConsigneeList(consignee);
	}

	/**
	 * 获取ConsigneeID
	 */
	public String getConsigneeId() throws Exception {
		return consigneeDao.getConsigneeId();
	}

	/**
	 * 更新默认信息
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午7:27:25
	 * @param consignee
	 * @throws Exception
	 * @return void
	 */
	public void updateConsigneeIsDefault(Consignee consignee) throws Exception {
		Consignee c = new Consignee();
		c.setIsDefault("0");
		c.setUserId(consignee.getUserId());
		consigneeDao.updateConsigneeIsDefault(c);

		consigneeDao.updateConsigneeIsDefault(consignee);
	}

	/**
	 * 微信端新建地址
	 * 
	 * @author wzd
	 * @date 2019年10月18日 下午1:27:48
	 * @param consignee
	 * @throws Exception
	 * @return void
	 */
	public void createConsigneeWx(Consignee consignee) throws Exception {
		// 设为默认 那其他为非默认
		if ("1".equals(consignee.getIsDefault())) {
			Consignee other = new Consignee();
			other.setUserId(consignee.getUserId());
			other.setIsDefault("0");
			consigneeDao.updateConsigneeIsDefault(other);
		}
		consignee.setConsigneeId(PrimaryKeyUtil.generateKey());
		consigneeDao.insertConsignee(consignee);
	}
}
