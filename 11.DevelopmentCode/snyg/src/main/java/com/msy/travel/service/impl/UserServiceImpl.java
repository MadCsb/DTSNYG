package com.msy.travel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.msy.travel.service.ChannelService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
import com.msy.travel.service.RoleDataService;
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

					if (u.getUserName() == null || u.getUserName().equals("")) {
						WxUser wxuser = WeixinUtil.getUserDeatil(WeixinService.getAccessToken(serviceCode), openId);
						log.info("用户关注获取用户信息详情wxuser[" + wxuser + "]");
						// 值为0时，代表此用户没有关注该公众号，拉取不到其余信息
						if (wxuser != null && !"0".equals(wxuser.getSubscribe())) {
							try {
								u.setUserName(wxuser.getNickname());
							} catch (Exception e) {
								u.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
							}

							log.info("用户关注获取用户信息姓名[" + u.getUserName() + "]");
							u.setUserState("1");
							u.setCountry(wxuser.getCountry());
							u.setProvince(wxuser.getProvince());
							u.setCity(wxuser.getCity());
							u.setSex(wxuser.getSex());// 1男 2女 3未知
							u.setUpdateTime(DateTimeUtil.getDateTime19());
							u.setHeadPic(wxuser.getHeadimgurl());
							// userService.updateUser(u);
						}
					}
				} else {

					WxUser wxuser = WeixinUtil.getUserDeatil(WeixinService.getAccessToken(serviceCode), openId);
					user = new User();
					String userId = PrimaryKeyUtil.generateKey();
					user.setUserId(userId);
					user.setType(User.USER_TYPE_WEIXIN);
					user.setUserLoginName(openId);
					user.setWxServiceId(serviceCode.getServiceId());
					user.setUpdateTime(DateTimeUtil.getDateTime19());
					user.setHeadPic(wxuser.getHeadimgurl());

					try {
						user.setUserName(wxuser.getNickname());
					} catch (Exception e) {
						user.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
					}

					user.setCountry(wxuser.getCountry());
					user.setProvince(wxuser.getProvince());
					user.setCity(wxuser.getCity());
					user.setSex(wxuser.getSex());// 1男 2女 3未知
					user.setUserState("1");
					user.setUserLocked("0");
					user.setUserRegDate(DateTimeUtil.getDateTime19());
					userDao.insertUser(user);
					u = user;
				}
				// 添加老用户角色信息
				if (oldLoginUser != null) { // 需要把老用户的角色信息放在微信用户中
					// 老用户的角色信息
					RoleData roleData = new RoleData();
					roleData.setUserId(oldLoginUser.getUserId());
					List<RoleData> oldRoleDataList = roleDataService.queryRoleDataList(roleData);

					// 微信用户的角色信息
					roleData = new RoleData();
					roleData.setUserId(u.getUserId());
					List<RoleData> userRoleDataList = roleDataService.queryRoleDataList(roleData);
					for (int i = 0; i < oldRoleDataList.size(); i++) {
						boolean isHave = false; // 微信用户是否已经有oldLoginUser的渠道信息
						for (int j = 0; j < userRoleDataList.size(); j++) { // 如果角色类型，accid，unitId相同则是已有角色
							if (oldRoleDataList.get(i).getRoleType().equals(userRoleDataList.get(j).getRoleType()) && oldRoleDataList.get(i).getAccId().equals(userRoleDataList.get(j).getAccId())
									&& oldRoleDataList.get(i).getAccId().equals(userRoleDataList.get(j).getAccId())) {
								isHave = true;
								break;
							}
						}
						if (!isHave) // 如果不存在渠道，则新增渠道
						{
							RoleData roleDataDb = new RoleData();
							roleDataDb.setUserRoleDataId(PrimaryKeyUtil.generateKey());
							roleDataDb.setRoleType(oldRoleDataList.get(i).getRoleType());
							roleDataDb.setAccId(oldRoleDataList.get(i).getAccId());
							roleDataDb.setUnitId(oldRoleDataList.get(i).getUnitId());
							roleDataDb.setUserId(u.getUserId());
							roleDataDb.setIsDefault("0");
							roleDataService.createRoleData(roleDataDb);
							log.error("微信用户" + u.getUserLoginName() + ":添加roleData=" + roleDataDb.getUserRoleDataId());
						}
					}
					// 新老用户合并
					unionUser(u.getUserId(), oldLoginUser.getUserId());
				}

				// 添加三农易购角色信息
				Channel snygChannel = channelService.getChannelByChannelKey(Channel.SNYG);
				RoleData snygRoleData = new RoleData();
				snygRoleData.setUserId(u.getUserId());
				snygRoleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
				snygRoleData.setAccId(Destsp.currentSpId);
				snygRoleData.setUnitId(snygChannel.getChannelId());
				List<RoleData> userRoleDataList = roleDataService.queryRoleDataList(snygRoleData);
				if (userRoleDataList.size() == 0) {
					snygRoleData.setUserRoleDataId(PrimaryKeyUtil.generateKey());
					snygRoleData.setIsDefault("1");
					roleDataService.createRoleData(snygRoleData);
					log.error("微信用户" + u.getUserLoginName() + ":添加roleData=" + snygRoleData.getUserRoleDataId());
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
		List<User> userList = userService.queryUserList(user);

		if (userList.size() != 0) {
			return userList.get(0);
		} else {
			User userDb = new User();
			userDb.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
			userDb.setUserLoginName(tel);
			userDb.setDelFlag("0");
			userDb.setUserState("1");
			String userPwd = tel;
			userDb.setUserPwd(MD5.encode(userPwd));
			userDb.setUserLocked("0");
			userDb.setUserRegDate(DateTimeUtil.getDateTime19());
			userDb.setUserId(PrimaryKeyUtil.generateKey());
			userDb.setType(User.USER_TYPE_SDMOBILE);
			userDb.setUserName(PrimaryKeyUtil.getDefaultWxUserName());
			userDb.setUpdateTime(DateTimeUtil.getDateTime19());

			// 新增的用户的角色信息
			String accId = Destsp.currentSpId;
			Channel sdyhChannel = channelService.getChannelByChannelKey(Channel.SDYD);
			// 山农易购渠道角色
			String unitId = sdyhChannel.getChannelId();
			List<RoleData> roleDataList = new ArrayList<>();// 角色信息
			RoleData roleData = new RoleData();
			roleData.setUserRoleDataId(PrimaryKeyUtil.generateKey());
			roleData.setRoleType(RoleData.ROLE_TYPE_CHANNEL);
			roleData.setAccId(accId);
			roleData.setUnitId(unitId);
			roleData.setUserId(user.getUserId());
			roleData.setIsDefault("1");
			roleDataList.add(roleData);
			userService.createUserAndRoledata(userDb, roleDataList);
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

	/**
	 * 合并用户 userIdTwo合并到userIdOne
	 */
	public void unionUser(String userIdOne, String userIdTwo) throws Exception {
		User userOne = new User();
		userOne.setUserId(userIdOne);
		userOne = userDao.queryUser(userOne);

		User userTwo = new User();
		userTwo.setUserId(userIdTwo);
		userTwo = userDao.queryUser(userTwo);
		// 如果userOne是单用户,则为userOne设置unionId
		if (userOne.getUnionId() == null || userOne.getUnionId().trim().equals("")) {
			userOne.setUnionId(PrimaryKeyUtil.generateKey());
			userDao.updateUser(userOne);
		}

		List<User> userTwoList = new ArrayList<>();// 用户userTwo 所在union下所有用户
		// 如果userTwo是新用户
		if (userTwo.getUnionId() == null || userTwo.getUnionId().trim().equals("")) {
			userTwoList.add(userTwo);
		} else {
			User userTwoUnion = new User();
			userTwoUnion.setUnionId(userIdTwo);
			userTwoList = userDao.queryUserList(userTwoUnion);
		}
		// 更新userTwoList的unionId
		for (int i = 0; i < userTwoList.size(); i++) {
			userTwoList.get(i).setUnionId(userOne.getUnionId());
			userDao.updateUser(userTwoList.get(i));
		}
	}

	/**
	 * 分开已合并用户 userIdTwo分开
	 */
	public void unUnionUser(String userIdOne, String userIdTwo) throws Exception {
		User userOne = new User();
		userOne.setUserId(userIdOne);
		userOne = userDao.queryUser(userOne);

		User userTwo = new User();
		userTwo.setUserId(userIdTwo);
		userTwo = userDao.queryUser(userTwo);

		// 如果userOne与userTwo的UnionId，相同，则把userTwo的union清空
		if (userOne.getUnionId() != null && !userOne.getUnionId().trim().equals("") && userTwo.getUnionId() != null && !userTwo.getUnionId().trim().equals("")
				&& userOne.getUnionId().equals(userTwo.getUnionId())) {
			userTwo.setUnionId(null);
			List<String> colList = new ArrayList<>();
			colList.add("unionId");
			User updateColNullUser = new User();
			updateColNullUser.setUserId(userTwo.getUserId());
			updateColNullUser.setColList(colList);
			updateColNull(updateColNullUser);
		}
	}

	/**
	 * 修改User字段为null
	 *
	 * @param user
	 *            User对象
	 */
	public void updateColNull(User user) throws Exception {
		userDao.updateColNull(user);
	}
}
