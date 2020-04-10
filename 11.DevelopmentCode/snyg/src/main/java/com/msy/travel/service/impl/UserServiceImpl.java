package com.msy.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.chinamobile.sd.openapi.Common;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.MD5;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.dao.UserDao;
import com.msy.travel.pojo.Channel;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.RoleData;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.pojo.UserBindChannel;
import com.msy.travel.service.ChannelService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.RoleDataService;
import com.msy.travel.service.UserBindChannelService;
import com.msy.travel.wx.pojo.WxUser;
import com.msy.travel.wx.utils.WeixinService;
import com.msy.travel.wx.utils.WeixinUtil;

/**
 * UserService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	public static final Log log = LogFactory.getLog(IUserService.class);

	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "serviceCodeServiceImpl")
	private IServiceCodeService serviceCodeService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	@Resource(name = "userBindChannelServiceImpl")
	private UserBindChannelService userBindChannelService;

	@Resource(name = "channelServiceImpl")
	private ChannelService channelService;

	@Resource(name = "roleDataServiceImpl")
	private RoleDataService roleDataService;

	/**
	 * 新增User
	 *
	 * @param user
	 *            User对象
	 */
	public void createUser(User user) throws Exception {
		userDao.insertUser(user);
	}

	/**
	 * 修改User
	 *
	 * @param user
	 *            User对象
	 */
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	/**
	 * 修改User密码
	 *
	 * @param user
	 *            User对象
	 */
	public void updateUserPWD(User user) throws Exception {
		userDao.updateUserPWD(user);
	}

	/**
	 * 查询单个User
	 *
	 * @param user
	 *            User对象
	 *
	 * @return 成员实体对象
	 */
	public User displayUser(User user) throws Exception {
		return userDao.queryUser(user);
	}

	/**
	 * 查询User列表
	 * 
	 * @param user
	 *            User对象
	 * 
	 * @return User列表
	 */
	public List<User> queryUserList(User user) throws Exception {
		return userDao.queryUserList(user);
	}

	@Override
	public int getUserCount(User user) throws Exception {
		int total = 0;

		total = userDao.getUserCount(user);

		return total;
	}

	@Override
	public List<User> queryUserByPage(User user) throws Exception {
		return userDao.queryUserByPage(user);
	}

	@Override
	public User queryUser(User user) throws Exception {
		user = userDao.queryUser(user);
		return user;
	}

	/**
	 * 登录时查询
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUserListByLogin(User user) throws Exception {
		return userDao.queryUserListByLogin(user);
	}

	@Override
	public User getUserByUserLoginName(User user) throws Exception {
		return userDao.selectUserByUserLoginName(user);
	}

	/**
	 * 获取或新增 微信端 历史登录用户，用于其他平台已登录，跳转到微信时
	 */
	public User getOrCreateByUserLoginName(String spId, String code, User oldLoginUser) throws Exception {
		User u = new User();

		if (code != null && !"".equals(code)) {
			// 支撑商ID
			ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(spId);

			if (serviceCode != null) {
				String appId = serviceCode.getAppId();
				String appSecret = serviceCode.getAppSecret();

				// 获取用户openId
				String openId = WeixinUtil.getUserOpenId(appId, appSecret, code);

				User user = new User();
				user.setUserLoginName(openId);
				user.setWxServiceId(serviceCode.getServiceId());
				user = userDao.selectUserByUserLoginName(user);
				if (user != null && user.getUserId() != null) {
					u = user;
				} else {

					WxUser wxuser = WeixinUtil.getUserDeatil(WeixinService.getAccessToken(serviceCode), openId);
					log.error(JSON.toJSONString(wxuser));
					user = new User();
					String userId = PrimaryKeyUtil.generateKey();
					user.setUserId(userId);
					user.setType("0");
					user.setAccId(spId);
					user.setUserLoginName(openId);
					user.setWxServiceId(serviceCode.getServiceId());
					user.setUpdateTime(DateTimeUtil.getDateTime19());
					user.setHeadPic(wxuser.getHeadimgurl());
					user.setUnitId(spId);

					try {
						user.setUserName(wxuser.getNickname());
					} catch (Exception e) {
						user.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
					}

					user.setCountry(wxuser.getCountry());
					user.setProvince(wxuser.getProvince());
					user.setCity(wxuser.getCity());
					user.setSex(wxuser.getSex());// 1男 2女 3未知
					userDao.insertUser(user);
					u = user;

					Channel channel = channelService.getChannelByChannelKey(Channel.SNYG);
					// 用户角色
					RoleData roleData = new RoleData();
					roleData.setUserRoleDataId(PrimaryKeyUtil.generateKey());
					roleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
					roleData.setAccId(Destsp.currentSpId);
					roleData.setUnitId(channel.getChannelId());
					roleData.setUserId(user.getUserId());
					roleData.setIsDefault("1");
					roleDataService.createRoleData(roleData);
				}
				if (oldLoginUser != null) {
					// 老用户的渠道信息
					UserBindChannel userBindChannel = new UserBindChannel();
					userBindChannel.setUserId(oldLoginUser.getUserId());
					List<UserBindChannel> oldUserBindChannelList = userBindChannelService.queryUserBindChannelList(userBindChannel);

					// 微信用户的渠道信息
					userBindChannel = new UserBindChannel();
					userBindChannel.setUserId(u.getUserId());
					List<UserBindChannel> userBindChannelList = userBindChannelService.queryUserBindChannelList(userBindChannel);

					for (int i = 0; i < oldUserBindChannelList.size(); i++) {
						boolean isHave = false; // 微信用户是否已经有oldLoginUser的渠道信息
						for (int j = 0; j < userBindChannelList.size(); j++) {
							if (oldUserBindChannelList.get(i).getChannelId().equals(userBindChannelList.get(j).getChannelId())) {
								isHave = true;
								break;
							}
						}
						if (!isHave) // 如果不存在渠道，则新增渠道
						{
							UserBindChannel userBindChannelTmp = new UserBindChannel();
							userBindChannelTmp.setUserId(u.getUserId());
							userBindChannelTmp.setChannelId(oldUserBindChannelList.get(i).getChannelId());
							userBindChannelTmp.setCreateTime(DateTimeUtil.getDateTime19());
							userBindChannelService.createUserBindChannel(userBindChannelTmp);
						}
					}
				}
			}
		}

		return u;
	}

	/**
	 *
	 * 获取或新增 山东移动用户
	 * 
	 * @param sdToken
	 *            山东移动访问我方平台时附带的token
	 */
	public User getOrCreateBySdToken(String sdToken) throws Exception {

		// 根据token获取山东移动用户唯一手机号码 msisdn
		Map<String, String> tokenParam = new HashMap<>();
		tokenParam.put("token", sdToken);
		Result tokenResult = Common.getUserByToken(tokenParam);
		if (!"0".equals(tokenResult.getResultCode())) {
			throw new LogicException(tokenResult.getResultMsg());
		}
		// 用户手机号码-msisdn
		String tel = tokenResult.getResultPojo().toString();

		User user = new User();
		user.setUserLoginName(tel);
		user.setType(User.USER_TYPE_SDMOBILE);
		List<User> userList = userDao.queryUserListByLogin(user);

		if (userList.size() != 0) {
			return userList.get(0);
		} else {
			User userDb = new User();
			userDb.setUserId(PrimaryKeyUtil.generateKey());
			userDb.setUserLoginName(tel);
			userDb.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
			String userPwd = tel;
			userDb.setUserPwd(MD5.encode(userPwd));
			userDb.setUserRegDate(DateTimeUtil.getDateTime19());
			userDb.setUserState("1");
			userDb.setUserLocked("0");
			userDb.setUserRoleType(null);
			userDb.setAccId(Destsp.currentSpId);
			userDb.setUnitId(Destsp.currentSpId);
			userDb.setType(User.USER_TYPE_SDMOBILE);
			userDb.setUpdateTime(DateTimeUtil.getDateTime19());
			userService.createUser(userDb);

			Channel channel = channelService.getChannelByChannelKey(Channel.SDYD);

			UserBindChannel userBindChannel = new UserBindChannel();
			userBindChannel.setChannelId(channel.getChannelId());
			userBindChannel.setUserId(userDb.getUserId());
			userBindChannel.setCreateTime(DateTimeUtil.getDateTime19());
			userBindChannelService.createUserBindChannel(userBindChannel);

			// 用户角色
			RoleData roleData = new RoleData();
			roleData.setUserRoleDataId(PrimaryKeyUtil.generateKey());
			roleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
			roleData.setAccId(Destsp.currentSpId);
			roleData.setUnitId(channel.getChannelId());
			roleData.setUserId(user.getUserId());
			roleData.setIsDefault("1");
			roleDataService.createRoleData(roleData);
			return userDb;
		}
	}

	/**
	 * 查询微商城或pC用户
	 * 
	 * @author wzd
	 * @date 2019年11月16日 下午8:13:51
	 * @param user
	 * @return
	 * @throws Exception
	 * @return List<User>
	 */
	public List<User> queryUserListByType(User user) throws Exception {
		return userDao.queryUserListByType(user);
	}

	/**
	 * 验证重名
	 * 
	 * @author wzd
	 * @date 2019年11月20日 上午10:33:31
	 * @param user
	 * @return
	 * @throws Exception
	 * @return int
	 */
	public int getUserCountFromAdd(User user) throws Exception {
		return userDao.getUserCountFromAdd(user);
	}

	/**
	 *
	 * 判断用户是否是山东用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return boolean 是否是山东用户
	 */
	public boolean checkIsSdUser(String userId) throws Exception {
		User user = new User();
		user.setUserId(userId);
		user = userDao.queryUser(user);
		if (User.USER_TYPE_SDMOBILE.equals(user.getType())) {
			return true;
		} else {
			Channel channel = new Channel();
			channel.setChannelKey(Channel.SDYD);
			channel = channelService.displaychannel(channel);
			UserBindChannel userBindChannel = new UserBindChannel();
			userBindChannel.setChannelId(channel.getChannelId());
			userBindChannel.setUserId(userId);
			List<UserBindChannel> userBindChannelList = userBindChannelService.queryUserBindChannelList(userBindChannel);
			if (userBindChannelList.size() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 新增用戶- 用戶角色信息
	 *
	 */
	public User createUserAndRoledata(User user, List<RoleData> roleDataList) throws Exception {
		if (user.getUserId() == null || user.getUserId().equals("")) {
			user.setUserId(PrimaryKeyUtil.generateKey());
		}
		user.setUserRegDate(DateTimeUtil.getDateTime19());
		userService.createUser(user);
		for (int i = 0; i < roleDataList.size(); i++) {
			RoleData roleData = roleDataList.get(i);
			roleData.setUserId(user.getUserId());
			roleDataService.createRoleData(roleData);
		}
		return user;
	}

	/**
	 * 查询用户新方法
	 * 
	 * @author wzd
	 * @date 2020年4月10日 下午7:23:20
	 * @param user
	 * @return
	 * @throws Exception
	 * @return List<User>
	 */
	public List<User> queryUserListAndRoleData(User user) throws Exception {
		return userDao.queryUserListAndRoleData(user);
	}
}
