package com.chinamobile.sd.openapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

  /**
   * 获取签名
   * @param paramMap map中参加签名的对象
   * @param key 合作方秘钥
   * @return
   */
  public static Result getSign(Map<String, String> paramMap, String key)
  {
    Result result = new Result();
    String sign = "";
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
   * 获取登录手机号（第三方平台—>传播平台）
   * @param param 获取登录手机号需要的参数Map {token:}
   */
  public static Result getUserByToken(Map<String, String> param)
  {
    Result result = new Result();

    param.put("portalType",Common.PORTALTYPE_WAP);
    param.put("portalID",Common.portalID);
    param.put("transactionID",Common.portalID);
    param.put("method","getUserByToken");
    param.put("signType","MD5");
    Result signResult = Common.getSign(param,Common.key);
    if (!"0".equals(signResult.getResultCode()))
    {
      return signResult;
    }

    StringBuffer urlSb = new StringBuffer();
    urlSb.append(Common.url).append("?");
    Set<String> paramSet = param.keySet();
    for (String tmp : paramSet)
    {
      urlSb.append(tmp).append("=").append(param.get(tmp)).append("&");
    }
    HttpPost httpPost = new HttpPost(urlSb.substring(0,urlSb.length()));
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
