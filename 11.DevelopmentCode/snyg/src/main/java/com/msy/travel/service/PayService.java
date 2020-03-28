package com.msy.travel.service;

import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.PdcType;
import java.util.List;
import java.util.Map;

/**
 * 支付service
 * 
 * @author chengsb
 * 
 */
public interface PayService {

	/**
	 * 获取 支付 信息
	 * @param param 参数信息 paramObject 参数信息 {payMethod:支付方式,openId:微信用户openId,userId:登录用户Id,spId:运营商id,platformOrders:订单ids,remoteAddr;请求ip地址}
	 * @return
	 */
	public Result getPayInfo(JSONObject param) throws Exception;

	/**
	 * @Description 收到支付宝的成功回调之后验证签名是否正确
	 * @param requestParams
	 * @return
	 */
	public boolean aliPayCheckSignature(Map<String, String> requestParams);

}
