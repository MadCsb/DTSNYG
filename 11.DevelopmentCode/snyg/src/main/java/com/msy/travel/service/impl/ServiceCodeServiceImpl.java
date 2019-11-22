package com.msy.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.dao.ServiceCodeDao;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.service.IDestspService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.IUserService;

/**
 * ServiceCodeService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class ServiceCodeServiceImpl implements IServiceCodeService {

	@Resource(name = "serviceCodeDao")
	private ServiceCodeDao serviceCodeDao;

	@Resource(name = "destspServiceImpl")
	private IDestspService destspService;

	@Resource(name = "configParameter")
	private ConfigParameter configParameter;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * 新增ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void createServiceCode(ServiceCode serviceCode) throws Exception {
		serviceCodeDao.insertServiceCode(serviceCode);
	}

	/**
	 * 检查ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void mergeServiceCode(ServiceCode serviceCode) throws Exception {
		serviceCodeDao.mergeServiceCode(serviceCode);
	}

	/**
	 * 删除ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void deleteServiceCode(ServiceCode serviceCode) throws Exception {
		serviceCodeDao.deleteServiceCode(serviceCode);
	}

	/**
	 * 修改ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 */
	public void updateServiceCode(ServiceCode serviceCode) throws Exception {
		serviceCodeDao.updateServiceCode(serviceCode);
	}

	/**
	 * 批量删除ServiceCode
	 * 
	 * @param serviceCodeIdList
	 *            存放serviceCode主键的list
	 */
	public void deleteBatchServiceCode(ServiceCode serviceCode) throws Exception {
		serviceCodeDao.deleteBatchServiceCode(serviceCode);
	}

	/**
	 * 查询单个ServiceCode
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 * 
	 * @return 成员实体对象
	 */
	public ServiceCode displayServiceCode(ServiceCode serviceCode) throws Exception {
		return serviceCodeDao.queryServiceCode(serviceCode);
	}

	/**
	 * 查询ServiceCode列表
	 * 
	 * @param serviceCode
	 *            ServiceCode对象
	 * 
	 * @return ServiceCode列表
	 */
	public List<ServiceCode> queryServiceCodeList(ServiceCode serviceCode) throws Exception {
		return serviceCodeDao.queryServiceCodeList(serviceCode);
	}

	/**
	 * 获取ServiceCodeID
	 */
	public String getServiceCodeId() throws Exception {
		return serviceCodeDao.getServiceCodeId();
	}

	@Override
	public ServiceCode queryServiceCodeByCustom(ServiceCode serviceCode) {

		return serviceCodeDao.queryServiceCodeByCustom(serviceCode);
	}

	/**
	 * 根据SPID获取服务号信息
	 * 
	 * @param spId
	 * @return
	 * @throws Exception
	 */
	public ServiceCode getServiceCodeBySpId(String spId) throws Exception {
		ServiceCode serviceCode = new ServiceCode();

		// 检索支撑商信息
		Destsp destsp = new Destsp();
		destsp.setSpId(spId);
		destsp = destspService.displayDestsp(destsp);

		if (destsp != null) {
			serviceCode.setServiceId(destsp.getWxServiceId());
			serviceCode = serviceCodeDao.queryServiceCode(serviceCode);
		}

		return serviceCode;
	}

}
