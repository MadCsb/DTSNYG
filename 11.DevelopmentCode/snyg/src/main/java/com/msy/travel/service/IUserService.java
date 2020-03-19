package com.msy.travel.service;

import java.util.List;

import com.msy.travel.pojo.User;

/**
 * UserService接口
 * 
 * @author wootide
 * 
 */
public interface IUserService {
	/**
	 * 新增User
	 *
	 * @param user
	 *            User对象
	 */
	public void createUser(User user) throws Exception;

	/**
	 * 修改User
	 *
	 * @param user
	 *            User对象
	 */
	public void updateUser(User user) throws Exception;

	/**
	 * 修改User密码
	 *
	 * @param user
	 *            User对象
	 */
	public void updateUserPWD(User user) throws Exception;

	/**
	 * 查询单个User
	 *
	 * @param user
	 *            User对象
	 *
	 * @return User实体对象
	 */
	public User displayUser(User user) throws Exception;

	/**
	 * 查询User列表
	 * 
	 * @param user
	 *            User对象
	 * 
	 * @return User列表
	 */
	public List<User> queryUserList(User user) throws Exception;

	/**
	 * 获取满足查询条件总行数
	 *
	 * @param user
	 *            User实体对象
	 *
	 * @return 行数
	 */
	public int getUserCount(User user) throws Exception;

	/**
	 * 分页查询User列表信息
	 *
	 * @param user
	 *            User对象
	 *
	 * @return User列表
	 */
	public List<User> queryUserByPage(User user) throws Exception;

	public User queryUser(User user) throws Exception;

	/**
	 * 登录时查询
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUserListByLogin(User user) throws Exception;

	User getUserByUserLoginName(User user) throws Exception;

	/**
	 * 获取或新增
	 * 
	 * @author wzd
	 * @date 2019年10月15日 下午1:04:04
	 * @param user
	 * @return
	 * @throws Exception
	 * @return User
	 */
	User getOrCreateByUserLoginName(String spId, String code) throws Exception;

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
	List<User> queryUserListByType(User user) throws Exception;

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
	int getUserCountFromAdd(User user) throws Exception;

	/**
	 *
	 * 获取或新增 山东移动用户
	 * @param sdToken 山东移动访问我方平台时附带的token
	 */
	User getOrCreateBySdToken(String sdToken) throws Exception;
}
