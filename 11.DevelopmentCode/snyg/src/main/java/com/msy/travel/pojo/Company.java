package com.msy.travel.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.msy.travel.common.BaseEntity;

@Alias(value = "company")
public class Company extends BaseEntity implements java.io.Serializable {

	/**
	 * 用于确定导出EXCEL的列
	 */
	public static final String[] EXPORT_HEADERS = {
			// columns START
			"venName:商家名称", "linkTel:联系电话", "linkPerson:联系人", "createTime:创建时间"

	};

	// columns START
	/**
	 * 供应商编号 db_column: F_VENID
	 */
	private String venId;
	/**
	 * 运营商编号 db_column: F_SPID
	 */
	private String spId;
	/**
	 * 运营商名称 db_column: F_VENNAME
	 */
	private String venName;
	/**
	 * 法人电话 db_column: F_TEL
	 */
	private String tel;
	/**
	 * 公司网址 db_column: F_WWWSITE
	 */
	private String wWWSite;
	/**
	 * 公司传真 db_column: F_FAX
	 */
	private String fax;
	/**
	 * 法人 db_column: F_LEAGAL
	 */
	private String leagal;
	/**
	 * 法人联系信息 db_column: F_LEAGALTEL
	 */
	private String leagalTel;
	/**
	 * 联系人 db_column: F_LINKPERSON
	 */
	private String linkPerson;
	/**
	 * 联系人电话 db_column: F_LINKTEL
	 */
	private String linkTel;
	/**
	 * 供应商备注 db_column: F_VENMEMO
	 */
	private String venMemo;
	/**
	 * 银行信息备注 db_column: F_BANKMEMO
	 */
	private String bankMemo;
	/**
	 * 联系方式备注 db_column: F_LINKMEMO
	 */
	private String linkMemo;
	/**
	 * 公司详细地址 db_column: F_COMPADDRESS
	 */
	private String compAddress;
	/**
	 * 开户行名称 db_column: F_BANKNAME
	 */
	private String bankName;
	/**
	 * 开户行账号 db_column: F_BANKACC
	 */
	private String bankAcc;
	/**
	 * 银行税号 db_column: F_BANKTAX
	 */
	private String bankTax;
	/**
	 * 注册资金 db_column: F_FUND
	 */
	private String fund;
	/**
	 * 经营许可证 db_column: F_BUSCERT
	 */
	private String buscert;
	/**
	 * 公司图片 db_column: F_LOGOURL
	 */
	private String logoUrl;
	/**
	 * 主营业务 db_column: F_BUSINESSRANGE
	 */
	private String businessRange;
	/**
	 * 开户人名称 db_column: F_BANKUSER
	 */
	private String bankUser;

	/**
	 * 创建时间 db_column: F_CREATETIME
	 */
	private String createTime;
	/**
	 * 创建人 db_column: F_CREATORUID
	 */
	private String creatorUid;
	/**
	 * 创建人姓名 db_column: F_CREATOR
	 */
	private String creator;
	/**
	 * 修改时间 db_column: F_UPDATETIME
	 */
	private String updateTime;
	/**
	 * 修改人 db_column: F_UPDATERUID
	 */
	private String updaterUid;
	/**
	 * 修改人姓名 db_column: F_UPDATER
	 */
	private String updater;
	/**
	 * 是否删除0-未删除1-已删除 db_column: F_DELFLAG
	 */
	private String delFlag;

	/**
	 * 收货地址F_RECVADDRESS
	 */
	private String recvAddress;

	/**
	 * 收货人F_RECEIVER
	 */
	private String receiver;

	/**
	 * 收货电话F_RECVPHONE
	 */
	private String recvPhone;

	// columns END
	private List<String> companyIdList;

	private String spName;

	private String lName;

	private String lHandphone;

	private String lDuty;

	private String lTel;

	private String lFax;

	private String lQQ;

	private String uName;

	private String uHandphone;

	private String uDuty;

	private String uTel;

	private String uFax;

	private String uQQ;

	private String uLinkId;

	private String num;

	private String venTypeName;

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuHandphone() {
		return uHandphone;
	}

	public void setuHandphone(String uHandphone) {
		this.uHandphone = uHandphone;
	}

	public String getuDuty() {
		return uDuty;
	}

	public void setuDuty(String uDuty) {
		this.uDuty = uDuty;
	}

	public String getuTel() {
		return uTel;
	}

	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

	public String getuFax() {
		return uFax;
	}

	public void setuFax(String uFax) {
		this.uFax = uFax;
	}

	public String getuQQ() {
		return uQQ;
	}

	public void setuQQ(String uQQ) {
		this.uQQ = uQQ;
	}

	public String getwWWSite() {
		return wWWSite;
	}

	public void setwWWSite(String wWWSite) {
		this.wWWSite = wWWSite;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getlHandphone() {
		return lHandphone;
	}

	public void setlHandphone(String lHandphone) {
		this.lHandphone = lHandphone;
	}

	public String getlDuty() {
		return lDuty;
	}

	public void setlDuty(String lDuty) {
		this.lDuty = lDuty;
	}

	public String getlTel() {
		return lTel;
	}

	public void setlTel(String lTel) {
		this.lTel = lTel;
	}

	public String getlFax() {
		return lFax;
	}

	public void setlFax(String lFax) {
		this.lFax = lFax;
	}

	public String getlQQ() {
		return lQQ;
	}

	public void setlQQ(String lQQ) {
		this.lQQ = lQQ;
	}

	public void setVenId(String venId) {
		this.venId = venId;
	}

	public String getVenId() {
		return this.venId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenName() {
		return this.venName;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return this.tel;
	}

	public void setWWWSite(String wWWSite) {
		this.wWWSite = wWWSite;
	}

	public String getWWWSite() {
		return this.wWWSite;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
	}

	public void setLeagal(String leagal) {
		this.leagal = leagal;
	}

	public String getLeagal() {
		return this.leagal;
	}

	public void setLeagalTel(String leagalTel) {
		this.leagalTel = leagalTel;
	}

	public String getLeagalTel() {
		return this.leagalTel;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	public String getLinkPerson() {
		return this.linkPerson;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkTel() {
		return this.linkTel;
	}

	public void setVenMemo(String venMemo) {
		this.venMemo = venMemo;
	}

	public String getVenMemo() {
		return this.venMemo;
	}

	public void setBankMemo(String bankMemo) {
		this.bankMemo = bankMemo;
	}

	public String getBankMemo() {
		return this.bankMemo;
	}

	public void setLinkMemo(String linkMemo) {
		this.linkMemo = linkMemo;
	}

	public String getLinkMemo() {
		return this.linkMemo;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public String getCompAddress() {
		return this.compAddress;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	public String getBankAcc() {
		return this.bankAcc;
	}

	public void setBankTax(String bankTax) {
		this.bankTax = bankTax;
	}

	public String getBankTax() {
		return this.bankTax;
	}

	public void setFund(String fund) {
		this.fund = fund;
	}

	public String getFund() {
		return this.fund;
	}

	public void setBuscert(String buscert) {
		this.buscert = buscert;
	}

	public String getBuscert() {
		return this.buscert;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setBusinessRange(String businessRange) {
		this.businessRange = businessRange;
	}

	public String getBusinessRange() {
		return this.businessRange;
	}

	public void setBankUser(String bankUser) {
		this.bankUser = bankUser;
	}

	public String getBankUser() {
		return this.bankUser;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreatorUid(String creatorUid) {
		this.creatorUid = creatorUid;
	}

	public String getCreatorUid() {
		return this.creatorUid;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdaterUid(String updaterUid) {
		this.updaterUid = updaterUid;
	}

	public String getUpdaterUid() {
		return this.updaterUid;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setCompanyIdList(List<String> companyIdList) {
		this.companyIdList = companyIdList;
	}

	public List<String> getCompanyIdList() {
		return this.companyIdList;
	}

	public String getVenTypeName() {
		return venTypeName;
	}

	public void setVenTypeName(String venTypeName) {
		this.venTypeName = venTypeName;
	}

	public String getuLinkId() {
		return uLinkId;
	}

	public void setuLinkId(String uLinkId) {
		this.uLinkId = uLinkId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getRecvAddress() {
		return recvAddress;
	}

	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRecvPhone() {
		return recvPhone;
	}

	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}

}
