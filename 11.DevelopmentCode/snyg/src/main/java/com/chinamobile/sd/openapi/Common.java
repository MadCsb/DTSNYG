package com.chinamobile.sd.openapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.HttpClientTool;
import com.msy.travel.common.MD5;
import com.msy.travel.common.Result;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

/**
 * Created by cheng on 2020/3/19.
 */
public class Common {

  public static String url = "http://t.sd.chinamobile.com:18380/dccp-portal/openapi";
  public static String portalType = Common.PORTALTYPE_WAP;
  public static String portalID = "QYDTDS";
  public static String key = "qLd8cG3^2mH%s#dU";

  public static String testToken = "abc";

  /**
   * 接口返回值 成功 0
   */
  public static String CODE_SUCCESS = "0";

  /**
   * 接口返回值 未知异常 1
   */
  public static String CODE_ERROR = "1";

  /**
   * 接口返回值 签名错误 99
   */
  public static String CODE_SIGN_ERROR = "99";

  /**
   * portalType类型定义 WAP门户: WAP
   */
  public static String PORTALTYPE_WAP = "WAP";


  /**
   * portalType类型定义 Android客户端: Android
   */
  public static String PORTALTYPE_ANDROID = "Android";

  /**
   * portalType类型定义 IOS客户端: IOS
   */
  public static String PORTALTYPE_IOS = "IOS";

  /**
   * portalType类型定义 微信公众平台: WEIXIN
   */
  public static String PORTALTYPE_WEIXIN = "WEIXIN";

  private static AtomicInteger TRANSACTION_AI =  new AtomicInteger(0);
  /**
   * 获取签名
   * @param paramMap map中参加签名的对象
   * @param key 合作方秘钥
   * @return
   */
  public static Result getSign(Map<String, String> paramMap, String key)
  {
    Result result = new Result();
    try {
      List<String> list = new ArrayList(paramMap.keySet());
      Collections.sort(list);// 升序排序
      StringBuffer sb = new StringBuffer(); //参与签名的字符串
      for (int i = 0; i < list.size(); i++) {
        String paramValue = paramMap.get(list.get(i));
        if(paramValue != null && ! paramValue.trim().equals("")) //如果参数的值为空不参与签名
        {
          if (i == 0) {
            sb.append(list.get(i)).append("=").append(paramValue);
          } else {
            sb.append("&").append(list.get(i)).append("=").append(paramValue);
          }
        }
      }
      sb.append(key);
      result.setResultCode("0");
      result.setResultPojo(MD5.encode(sb.toString(),"utf-8").toUpperCase());
    }catch (Exception e) {
      result.setResultCode("1");
      result.setResultMsg("获取签名错误");
    }
    return result;
  }

  /**
   * 获取交易唯一编码 yyyMMddHHmmss+8位唯一序号
   *
   * @return
   */
  private static String getOnlyTransactionID() {
    return DateTimeUtil.getDateTime14()+String.valueOf(99999999-TRANSACTION_AI.incrementAndGet());
  }
  /**
   * 获取完整Url
   * @param param 参数Map
   *
   * @return
   */
  private static String getCompleteUrl(Map<String, String> param) {
    StringBuffer urlSb = new StringBuffer();
    urlSb.append(Common.url).append("?");
    Set<String> paramSet = param.keySet();
    for (String tmp : paramSet)
    {
      urlSb.append(tmp).append("=").append(param.get(tmp)).append("&");
    }
    return urlSb.substring(0,urlSb.length());
  }

  /**
   * 获取登录手机号（第三方平台—>传播平台）
   * @param param 获取登录手机号需要的参数Map {token:}
   * @return Result {resultCode:0,resultPojo:msisdn}
   */
  public static Result getUserByToken(Map<String, String> param)
  {
    Result result = new Result();

    param.put("portalType",Common.PORTALTYPE_WAP);
    param.put("portalID",Common.portalID);
    param.put("transactionID",getOnlyTransactionID());
    param.put("method","getUserByToken");
    param.put("signType","MD5");
    Result signResult = Common.getSign(param,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }
    param.put("sign",signResult.getResultPojo().toString());

    HttpPost httpPost = new HttpPost(getCompleteUrl(param));
    Result httpResult = HttpClientTool.doHttpPost(httpPost);
    if (!"0".equals(httpResult.getResultCode()))
    {
      return httpResult;
    }
    System.out.println(httpResult.getResultPojo().toString());
    JSONObject httpResultObject = JSON.parseObject(httpResult.getResultPojo().toString());
    String code = httpResultObject.getString("code");
    if(Common.CODE_SUCCESS.equals(code))
    {
      result.setResultCode("0");
      result.setResultMsg(httpResultObject.getString("message"));
      result.setResultPojo(httpResultObject.getString("msisdn"));
    }else if(Common.CODE_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("未知异常");
    }else if(Common.CODE_SIGN_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("签名错误");
    }else if("0001".equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("token参数错误");
    }else if("0002".equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("token已过期");
    }
    return result;
  }

  /**
   * 用户权益订购校验接口(第三方平台->内容传播平台) 第三方平台通过手机号、权益产品编码查询用户订购资格信息
   * @param param 用户权益订购校验接口需要的参数Map {msisdn:用户手机号码密文,priceCode:本系统销售编码}
   * @return Result {resultCode:0,resultPojo:1可以订购0不能订购}
   */
  public static Result validMemberMbr(Map<String, String> param) {
    Result result = new Result();

    param.put("portalType",Common.PORTALTYPE_WAP); //请求方门户类型
    param.put("portalID",Common.portalID); //请求方门户唯一标识
    param.put("transactionID",getOnlyTransactionID()); //交易唯一编码
    param.put("method","validMemberMbr");
    param.put("signType","MD5");
    param.put("msisdn",param.get("msisdn")); //用户手机号码密文
    param.put("mbrSource","yryp"); //会员来源
    param.put("mbrProdType","0"); //权益产品类型 0或空：电子券，1：额度
    param.put("mbrProdNo",Common.portalID+param.get("priceCode")); //权益产品编码 portalID+xxxxxxxx
    param.put("dateTime",DateTimeUtil.getDateTime14());//操作时间

    Result signResult = Common.getSign(param,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }
    param.put("sign",signResult.getResultPojo().toString());

    HttpPost httpPost = new HttpPost(getCompleteUrl(param));
    Result httpResult = HttpClientTool.doHttpPost(httpPost);
    if (!"0".equals(httpResult.getResultCode()))
    {
      return httpResult;
    }
    JSONObject httpResultObject = JSON.parseObject(httpResult.getResultPojo().toString());
    String code = httpResultObject.getString("code");
    if(Common.CODE_SUCCESS.equals(code))
    {
      result.setResultCode("0");
      result.setResultMsg(httpResultObject.getString("message"));
      result.setResultPojo(httpResultObject.getString("mbrValid"));
    }else if(Common.CODE_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("未知异常");
    }else if(Common.CODE_SIGN_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("签名错误");
    }
    return result;
  }

  /**
   * 用户权益订购结果同步接口(第三方平台->内容传播平台) 第三方平台将权益产品的订单成功结果同步给内容平台
   * @param param 用户权益订购结果同步接口需要的参数Map {msisdn:用户手机号码密文,priceCode:本系统销售编码,orderId:订单ID}
   * @return Result {resultCode:0,resultPojo:ok成功fail失败error错误}
   */
  public static Result syncMemberMbrOrder(Map<String, String> param) {
    Result result = new Result();

    param.put("portalType",Common.PORTALTYPE_WAP); //请求方门户类型
    param.put("portalID",Common.portalID); //请求方门户唯一标识
    param.put("transactionID",getOnlyTransactionID()); //交易唯一编码
    param.put("method","syncMemberMbrOrder");
    param.put("signType","MD5");
    param.put("msisdn",param.get("msisdn")); //用户手机号码密文
    param.put("mbrSource","yryp"); //会员来源
    param.put("mbrProdType","0"); //权益产品类型 0或空：电子券，1：额度
    param.put("mbrProdNo",Common.portalID+param.get("priceCode")); //权益产品编码 portalID+xxxxxxxx
    param.put("mbrOrderId",Common.portalID+param.get("orderId")); //权益产品编码 portalID+xxxxxxxx
    param.put("mbrOrderStatus","1");//订单状态：1：订购成功
    param.put("dateTime",DateTimeUtil.getDateTime14());//操作时间
    Result signResult = Common.getSign(param,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }
    param.put("sign",signResult.getResultPojo().toString());

    HttpPost httpPost = new HttpPost(getCompleteUrl(param));
    Result httpResult = HttpClientTool.doHttpPost(httpPost);
    if (!"0".equals(httpResult.getResultCode()))
    {
      return httpResult;
    }
    JSONObject httpResultObject = JSON.parseObject(httpResult.getResultPojo().toString());
    String code = httpResultObject.getString("code");
    if(Common.CODE_SUCCESS.equals(code))
    {
      result.setResultCode("0");
      result.setResultMsg(httpResultObject.getString("message"));
      result.setResultPojo(httpResultObject.getString("status"));
    }else if(Common.CODE_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("未知异常");
    }else if(Common.CODE_SIGN_ERROR.equals(code))
    {
      result.setResultCode("1");
      result.setResultMsg("签名错误");
    }
    return result;
  }


  public static void main(String[] args)
  {
    String s = "dateTime=20160622111213&method=getTicket&msisdn=13588888888&portalID=WXYYT&portalType=WEIXIN&signType=MD5&transactionID=2016062211121300065535abce$OO7&+-*22L";
    //
    if (MD5.encode(s,"utf-8").toUpperCase().equals("465B4A51074DFB822E75FBE8B4DDEB2B"))
    {
      System.out.println(112);
    }
  }
}
