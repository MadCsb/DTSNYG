package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;
import com.msy.travel.common.ComparePojo.MyAnnotation;

@Alias(value = "user")
public class User extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597847906506203439L;
	// columns START

	/**
	 * 用户类型 微信 0
	 */
	public static final String USER_TYPE_WEIXIN = "0";

	/**
	 * 用户类型 账号密码登录 1
	 */
	public static final String USER_TYPE_USERNAME_PASSWORD = "1";

	/**
	 * 用户类型 山东移动 2
	 */
	public static final String USER_TYPE_SDMOBILE = "2";

	/**
	 * 用户ID db_column: F_USER_ID
	 */
	@MyAnnotation(desc = "用户ID")
	private String userId;
	/**
	 * 用户登录名 db_column: F_USER_LOGINNAME 用户登录名。PC端:登录名；微信公众号:openId；
	 */
	private String userLoginName;
	/**
	 * 用户姓名 db_column: F_USER_NAME
	 */
	@MyAnnotation(desc = "用户名")
	private String userName;
	/**
	 * 用户描述 db_column: F_USER_DESC
	 */
	@MyAnnotation(desc = "用户描述")
	private String userDesc;
	/**
	 * 用户密码 db_column: F_USER_PWD
	 */
	private String userPwd;
	/**
	 * 用户固定电话 db_column: F_USER_TEL
	 */
	@MyAnnotation(desc = "用户固定电话")
	private String userTel;
	/**
	 * 用户手机号码 db_column: F_USER_MOBILE
	 */
	@MyAnnotation(desc = "用户手机号码")
	private String userMobile;
	/**
	 * 用户电子邮件 db_column: F_USER_EMAIL
	 */
	@MyAnnotation(desc = "用户电子邮件")
	private String userEmail;
	/**
	 * 用户联系地址 db_column: F_USER_ADDR
	 */
	@MyAnnotation(desc = "用户联系地址")
	private String userAddr;
	/**
	 * 用户注册日期 db_column: F_USER_REG_DATE
	 */
	private String userRegDate;
	/**
	 * 用户状态：1：有效；0：无效，不允许登录；-1：已删除 db_column: F_USER_STATE
	 */
	private String userState;

	/**
	 * 绑定IP地址,为空时不绑定 db_column: F_USER_IP
	 */
	private String userIp;
	/**
	 * 用户是否被锁定0-没有1-锁定 db_column: F_USER_LOCKED
	 */
	private String userLocked;
	/**
	 * 最近一次被锁定时间 db_column: F_USER_LOCKTIME
	 */
	private String userLockTime;
	/**
	 * 0-采购商1-供应商商2系统平台3-目的地运营商4-分销渠道5-客人6-集团目的地运营商7-B2B供应商 8-B2B组团社 db_column:
	 * F_USER_ROLETYPE
	 */
	@MyAnnotation(desc = "用户类型")
	private String userRoleType;
	/**
	 * 存放目的地运营商编号 db_column: F_ACCID
	 */
	private String accId;
	/**
	 * 用户所辖单位编号 db_column: F_UNIT_ID
	 */
	@MyAnnotation(desc = "用户所辖单位编号")
	private String unitId;
	/**
	 * 所属部门ID db_column: F_STOREID
	 */
	@MyAnnotation(desc = "所属部门ID")
	private String storeId;
	// columns END

	private String securityCode;

	private String msg;

	private String createUserId;// 创建用户id--企业新增角色赋权时使用

	/**
	 * 用户IDList db_column: F_USER_ID
	 */
	private List userIdList;
	/**
	 * 当前登录用的 userId
	 * 
	 * @param userId
	 */
	private String loginUserId;

	private String condition;

	private String userGroupId;// 组ID

	private String userGroupState;// 组状态
	/**
	 * 当前用户组ID
	 */
	private String ugId;
	/**
	 * 用户组ID
	 */
	private String oldUgId;
	/**
	 * 用户组ID
	 */
	private String userGroupName;

	/**
	 * 用户新密码
	 */
	private String userNewPwd;

	/**
	 * 用户新支付密码
	 * 
	 * @param userId
	 */
	private String payNewPasswd;

	private String unitName;
	/**
	 * 是否删除 0：未删除 1：已删除
	 */
	private String delFlag;
	/**
	 * 部门名称
	 */
	private String depName;

	/**
	 * sessionId
	 */
	private String sessionId;

	private String userPicUrl;

	// F_WXSERVICEID
	private String wxServiceId;

	// F_TYPE
	private String type;

	// F_COUNTRY
	private String country;

	// F_CITY
	private String city;

	// F_PROVINCE
	private String province;

	// F_SEX
	private String sex;

	// F_UPDATETIME

	private String updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

	// F_HEADPIC
	private String headPic;

	private RoleData roleData;

	private String roleType;

	// F_UNIONID
	private String unionId;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeEnd() {
		return updateTimeEnd;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWxServiceId() {
		return wxServiceId;
	}

	public void setWxServiceId(String wxServiceId) {
		this.wxServiceId = wxServiceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPayNewPasswd() {
		return payNewPasswd;
	}

	public void setPayNewPasswd(String payNewPasswd) {
		this.payNewPasswd = payNewPasswd;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserAddr() {
		return this.userAddr;
	}

	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getUserRegDate() {
		return this.userRegDate;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserLocked(String userLocked) {
		this.userLocked = userLocked;
	}

	public String getUserLocked() {
		return this.userLocked;
	}

	public void setUserLockTime(String userLockTime) {
		this.userLockTime = userLockTime;
	}

	public String getUserLockTime() {
		return this.userLockTime;
	}

	public void setUserRoleType(String userRoleType) {
		this.userRoleType = userRoleType;
	}

	public String getUserRoleType() {
		return this.userRoleType;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccId() {
		return this.accId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreId() {
		return this.storeId;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List userIdList) {
		this.userIdList = userIdList;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupState() {
		return userGroupState;
	}

	public void setUserGroupState(String userGroupState) {
		this.userGroupState = userGroupState;
	}

	public String getUgId() {
		return ugId;
	}

	public void setUgId(String ugId) {
		this.ugId = ugId;
	}

	public String getOldUgId() {
		return oldUgId;
	}

	public void setOldUgId(String oldUgId) {
		this.oldUgId = oldUgId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public String getUserNewPwd() {
		return userNewPwd;
	}

	public void setUserNewPwd(String userNewPwd) {
		this.userNewPwd = userNewPwd;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserPicUrl() {
		return userPicUrl;
	}

	public void setUserPicUrl(String userPicUrl) {
		this.userPicUrl = userPicUrl;
	}

	public RoleData getRoleData() {
		return roleData;
	}

	public void setRoleData(RoleData roleData) {
		this.roleData = roleData;
	}
}
