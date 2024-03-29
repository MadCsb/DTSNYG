package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.dao.UserDao;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;
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
	 * 获取或新增 微信端
	 */
	public User getOrCreateByUserLoginName(String spId, String code) throws Exception {
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
						user.setUserName("");
					}

					user.setCountry(wxuser.getCountry());
					user.setProvince(wxuser.getProvince());
					user.setCity(wxuser.getCity());
					user.setSex(wxuser.getSex());// 1男 2女 3未知
					userDao.insertUser(user);

					u = user;
				}
			}
		}

		return u;
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
}
