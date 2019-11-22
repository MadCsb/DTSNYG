package com.msy.travel.dao;

import java.util.List;

import com.msy.travel.pojo.User;

/**
 * UserDao接口
 * 
 * @author wootide
 * 
 */
public interface UserDao {

	/**
	 * 增加User
	 *
	 * @param user
	 *            User对象
	 */
	void insertUser(User user) throws Exception;

	/**
	 * 修改User
	 *
	 * @param user
	 *            User对象
	 */
	void updateUser(User user) throws Exception;

	/**
	 * 修改User密码
	 *
	 * @param user
	 *            User对象
	 */
	void updateUserPWD(User user) throws Exception;

	/**
	 * 查询单个User信息
	 *
	 * @param user
	 *            User对象
	 *
	 * @return User实体对象
	 */
	User queryUser(User user) throws Exception;

	/**
	 * 查询User列表信息
	 *
	 * @param user
	 *            User对象
	 *
	 * @return User列表
	 */
	List<User> queryUserList(User user) throws Exception;

	/**
	 * 获取满足查询条件总行数
	 *
	 * @param user
	 *            User实体对象
	 *
	 * @return 行数
	 */
	int getUserCount(User user) throws Exception;

	/**
	 * 分页查询User列表信息
	 *
	 * @param user
	 *            User对象
	 *
	 * @return User列表
	 */
	List<User> queryUserByPage(User user) throws Exception;

	/**
	 * 登录时查询
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<User> queryUserListByLogin(User user) throws Exception;

	/**
	 * 根据用户登录名查询单个User信息
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User selectUserByUserLoginName(User user) throws Exception;

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

}
