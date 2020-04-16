package com.chinamobile.sd.openapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.HttpClientTool;
import com.msy.travel.common.MD5;
import com.msy.travel.common.Result;
import com.msy.travel.service.impl.OrderServiceImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

/**
 * Created by cheng on 2020/3/19.
 */
public class Common {

  public static String url = "http://t.sd.chinamobile.com:18380/dccp-portal/openapi";
  public static String homeUrl = "http://t.sd.chinamobile.com:18380/dccp-portal/quanyihui/market.ajax";
  public static String portalType = Common.PORTALTYPE_WAP;
  public static String portalID = "QYDTDS";
  public static String key = "qLd8cG3^2mH%s#dU";
  public static final Log log = LogFactory.getLog(Common.class);
  public static String testToken = "abc";

  public static String MSISDN_SEPARATOR = "-*-";
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
  private static String getCompleteUrl(Map<String, String> param){
    StringBuffer urlSb = new StringBuffer();
    urlSb.append(Common.url).append("?");
    Set<String> paramSet = param.keySet();
    for (String tmp : paramSet)
    {
      //urlSb.append(tmp).append("=").append(param.get(tmp)).append("&");
      if(tmp.equals("msisdn"))//有特殊字符需要encoder
      {
        try {
          urlSb.append(tmp).append("=").append(URLEncoder.encode(param.get(tmp),"UTF-8")).append("&");
        }catch (Exception e)
        {
          return "";
        }
      }else
      {
        urlSb.append(tmp).append("=").append(param.get(tmp)).append("&");
      }
    }
    return urlSb.substring(0,urlSb.length()-1);
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
      log.error("山东移动获取登录手机号请求post="+JSON.toJSONString(httpPost));
      log.error("山东移动获取登录手机号请求post结果="+JSON.toJSONString(httpResult));
      return httpResult;
    }
    JSONObject httpResultObject = JSON.parseObject(httpResult.getResultPojo().toString());

    String code = httpResultObject.getString("code");
    if(Common.CODE_SUCCESS.equals(code))
    {
      result.setResultCode("0");
      result.setResultMsg(httpResultObject.getString("message"));
      String tel=AESUtil.decrypt(AESUtil.md5Key(Common.key),httpResultObject.getString("msisdn"));
      result.setResultPojo(tel+Common.MSISDN_SEPARATOR+httpResultObject.getString("msisdn")); //防止国际电话，所以设置特殊的分隔符
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
    String telMsisdn = param.get("msisdn");
    String tel = telMsisdn.substring(0,telMsisdn.indexOf(Common.MSISDN_SEPARATOR));
    String msisdn = telMsisdn.substring(telMsisdn.indexOf(Common.MSISDN_SEPARATOR)+3);

    Map<String, String> signMap = new HashMap<>();
    signMap.put("portalType",Common.PORTALTYPE_WAP); //请求方门户类型
    signMap.put("portalID",Common.portalID); //请求方门户唯一标识
    signMap.put("transactionID",getOnlyTransactionID()); //交易唯一编码
    signMap.put("method","validMemberMbr");
    signMap.put("signType","MD5");
    signMap.put("msisdn",tel); //URL传递msisdn是电话明文
    signMap.put("mbrSource","yryp"); //会员来源
    signMap.put("mbrProdType","1"); //权益产品类型 0或空：电子券，1：额度
    signMap.put("mbrProdNo",Common.portalID+param.get("priceCode")); //权益产品编码 portalID+xxxxxxxx
    signMap.put("dateTime",DateTimeUtil.getDateTime14());//操作时间
    Result signResult = Common.getSign(signMap,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }
    signMap.put("sign",signResult.getResultPojo().toString());
    signMap.put("msisdn",msisdn);//URL传递msisdn是电话加密msisdn
    HttpPost httpPost = new HttpPost(getCompleteUrl(signMap));
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
    String telMsisdn = param.get("msisdn");
    String tel = telMsisdn.substring(0,telMsisdn.indexOf(Common.MSISDN_SEPARATOR));
    String msisdn = telMsisdn.substring(telMsisdn.indexOf(Common.MSISDN_SEPARATOR)+Common.MSISDN_SEPARATOR.length());

    Map<String, String> signMap = new HashMap<>();
    signMap.put("portalType",Common.PORTALTYPE_WAP); //请求方门户类型
    signMap.put("portalID",Common.portalID); //请求方门户唯一标识
    signMap.put("transactionID",getOnlyTransactionID()); //交易唯一编码
    signMap.put("method","syncMemberMbrOrder");
    signMap.put("signType","MD5");
    signMap.put("msisdn",tel); //用户手机号码密文
    signMap.put("mbrSource","yryp"); //会员来源
    signMap.put("mbrProdType","1"); //权益产品类型 0或空：电子券，1：额度
    signMap.put("mbrProdNo",Common.portalID+param.get("priceCode")); //权益产品编码 portalID+xxxxxxxx
    signMap.put("mbrOrderId",Common.portalID+param.get("orderId")); //权益产品编码 portalID+xxxxxxxx
    signMap.put("mbrOrderStatus","1");//订单状态：1：订购成功
    signMap.put("dateTime",DateTimeUtil.getDateTime14());//操作时间
    Result signResult = Common.getSign(signMap,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }
    signMap.put("sign",signResult.getResultPojo().toString());
    signMap.put("msisdn",msisdn);

    HttpPost httpPost = new HttpPost(getCompleteUrl(signMap));
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
    String url = "www.baidu.com?";
    if(url.indexOf("?")>0) //如果请求中已存在?
    {
      if(url.indexOf("?") == url.length()-1) //如果最后一个参数是?
      {
        System.out.println("最后一个参数是?");
      }else
      {
        System.out.println("包含参数?");
      }
    }else
    {
      System.out.println("不包含参数");
    }

  }
}
