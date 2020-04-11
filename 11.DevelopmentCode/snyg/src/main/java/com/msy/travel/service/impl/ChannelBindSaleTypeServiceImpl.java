package com.msy.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.EntityPage;
import com.msy.travel.common.Result;
import com.msy.travel.dao.ChannelBindSaleTypeDao;
import com.msy.travel.pojo.Channel;
import com.msy.travel.pojo.ChannelBindSaleType;
import com.msy.travel.pojo.RoleData;
import com.msy.travel.pojo.User;
import com.msy.travel.service.ChannelBindSaleTypeService;
import com.msy.travel.service.ChannelService;
import com.msy.travel.service.RoleDataService;

/**
 * ChannelBindSaleTypeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ChannelBindSaleTypeServiceImpl implements ChannelBindSaleTypeService {

	@Resource(name = "channelBindSaleTypeDao")
	private ChannelBindSaleTypeDao channelBindSaleTypeDao;

	@Resource(name = "channelServiceImpl")
	private ChannelService channelService;

	@Resource(name = "roleDataServiceImpl")
	private RoleDataService roleDataService;

	/**
	 * 新增ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void createChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		channelBindSaleTypeDao.insertChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 检查ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void mergeChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		channelBindSaleTypeDao.mergeChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 删除ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void deleteChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		channelBindSaleTypeDao.deleteChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 修改ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 */
	public void updateChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		channelBindSaleTypeDao.updateChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 批量删除ChannelBindSaleType
	 * 
	 * @param channelBindSaleTypeIdList
	 *            存放channelBindSaleType主键的list
	 */
	public void deleteBatchChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		channelBindSaleTypeDao.deleteBatchChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 查询单个ChannelBindSaleType
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return 成员实体对象
	 */
	public ChannelBindSaleType displayChannelBindSaleType(ChannelBindSaleType channelBindSaleType) throws Exception {
		return channelBindSaleTypeDao.queryChannelBindSaleType(channelBindSaleType);
	}

	/**
	 * 查询ChannelBindSaleType列表
	 * 
	 * @param channelBindSaleType
	 *            ChannelBindSaleType对象
	 * 
	 * @return ChannelBindSaleType列表
	 */
	public List<ChannelBindSaleType> queryChannelBindSaleTypeList(ChannelBindSaleType channelBindSaleType) throws Exception {
		return channelBindSaleTypeDao.queryChannelBindSaleTypeList(channelBindSaleType);
	}

	/**
	 * 获取ChannelBindSaleTypeID
	 */
	public String getChannelBindSaleTypeId() throws Exception {
		return channelBindSaleTypeDao.getChannelBindSaleTypeId();
	}

	/**
	 * 通过用户判断可查看哪些渠道商品
	 * 
	 * @author wzd
	 * @date 2020年3月29日 下午4:28:00
	 * @param user
	 * @return
	 * @throws Exception
	 * @return List<ChannelBindSaleType>
	 */
	public List<String> querySaleTypeByUser(User user) throws Exception {
		List<String> saleTypeIdList = new ArrayList<String>();
		Channel channel = new Channel();
		if (user == null || user.getUserId().equals("")) {
			channel.setChannelKey(Channel.SNYG);
		} else {

			if (user.getRoleData() != null && RoleData.ROLE_TYPE_CHANNEL.equals(user.getRoleData().getRoleType())) {
				channel.setChannelId(user.getRoleData().getUnitId());
			} else {
				RoleData roleData = new RoleData();
				roleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
				roleData.setUserId(user.getUserId());
				EntityPage entityPage = new EntityPage(); // 相同用户 相同角色类型 相同unit下
															// 排序
				entityPage.setSortField("t.F_ISDEFAULT");
				entityPage.setSortOrder("DESC");
				roleData.setEntityPage(entityPage);
				List<RoleData> roleDataList = roleDataService.queryRoleDataList(roleData); // 用户所有的渠道角色信息
				if (roleDataList.size() > 0) {
					channel.setChannelId(roleDataList.get(0).getUnitId());
				} else {
					channel.setChannelKey(Channel.SNYG);
				}
			}
		}

		channel = channelService.displaychannel(channel);
		ChannelBindSaleType channelBindSaleType = new ChannelBindSaleType();
		channelBindSaleType.setChannelId(channel.getChannelId());
		channelBindSaleType.setStatus("1");
		saleTypeIdList = channelBindSaleTypeDao.queryChannelBindSaleTypeListByUserId(channelBindSaleType);

		return saleTypeIdList;
	}

	/**
	 * 通过渠道判断可购买商品范围
	 * 
	 * @author wzd
	 * @date 2020年3月29日 下午4:36:52
	 * @param channelBindSaleType
	 * @return
	 * @throws Exception
	 * @return List<ChannelBindSaleType>
	 */
	public List<String> queryChannelBindSaleTypeListByUserId(ChannelBindSaleType channelBindSaleType) throws Exception {
		return channelBindSaleTypeDao.queryChannelBindSaleTypeListByUserId(channelBindSaleType);
	}

	/**
	 * 保存
	 * 
	 * @author wzd
	 * @date 2020年3月31日 下午3:00:53
	 * @param channelId
	 * @param saleTypeId
	 * @return
	 * @throws Exception
	 * @return Result
	 */
	public Result createChannelBindSaleType(String channelId, String saleTypeId) throws Exception {
		Result result = new Result();
		result.setResultCode("0");

		ChannelBindSaleType channelBindSaleType = new ChannelBindSaleType();
		channelBindSaleType.setChannelId(channelId);
		channelBindSaleTypeDao.deleteChannelBindSaleType(channelBindSaleType);

		if (saleTypeId != null && !saleTypeId.trim().equals("")) {
			String[] saleTypeIdList = saleTypeId.split(",");

			for (String s : saleTypeIdList) {
				channelBindSaleType = new ChannelBindSaleType();
				channelBindSaleType.setChannelId(channelId);
				channelBindSaleType.setSaleTypeId(s);

				channelBindSaleTypeDao.insertChannelBindSaleType(channelBindSaleType);
			}

		}

		return result;
	}
}
