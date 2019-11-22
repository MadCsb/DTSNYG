package com.msy.travel.common;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64ToPic {

	/**
	 * 图片转化成base64字符串  
	 * @author msy
	 * @date 2019年4月24日 上午11:03:21
	 * @param imgFile 图片路径
	 * @return
	 * @return String
	 */
	public static String GetImageStr(String imgFile)  
	{
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
		InputStream in = null;  
		byte[] data = null;  
		//读取图片字节数组  
		try   
		{  
			in = new FileInputStream(imgFile);          
			data = new byte[in.available()];  
			in.read(data);  
			in.close();  
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		//对字节数组Base64编码  
		BASE64Encoder encoder = new BASE64Encoder();  
		return encoder.encode(data);//返回Base64编码过的字节数组字符串  
	}  

	/**
	 * Base64字符串转化成图片  
	 * @author msy
	 * @date 2019年4月24日 上午11:03:42
	 * @param imgStr 图片Base64编码
	 * @param newImgPath 生成图片保存路径
	 * @return
	 * @return boolean
	 */
	public static boolean GenerateImage(String imgStr,String newImgPath,String newFileName)  
	{   //对字节数组字符串进行Base64解码并生成图片  
		if (imgStr == null) //图像数据为空  
			return false;  
		String ext = SubStringBetween(imgStr, "data:image/",";");//图片后缀
		imgStr = imgStr.substring(imgStr.indexOf(',')+1);//一般插件返回的base64编码的字符串都是有一个前缀的。"data:image/jpeg;base64," 解码之前这个得去掉
		
		if("jpeg".equalsIgnoreCase(ext))
		{
			ext = "jpg";
		} 
		
		String fileName = File.separator +newFileName+"."+ext;//文件名

		BASE64Decoder decoder = new BASE64Decoder();  
		try   
		{  
			//Base64解码  
			byte[] b = decoder.decodeBuffer(imgStr);  
			for(int i=0;i<b.length;++i)  
			{  
				if(b[i]<0)  
				{//调整异常数据  
					b[i]+=256;  
				}  
			}  
			//生成jpeg图片  
			OutputStream out = new FileOutputStream(newImgPath+fileName);      
			out.write(b);  
			out.flush();  
			out.close();  
			return true;  
		}   
		catch (Exception e)   
		{  
			return false;  
		}  
	}

	/**
	 * 截取字符串str中指定字符 strStart、strEnd之间的字符串
	 * 
	 * @param string
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String SubStringBetween(String str, String strStart, String strEnd) {

		/* 找出指定的2个字符在 该字符串里面的 位置 */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);

		/* index 为负数 即表示该字符串中 没有该字符 */
		if (strStartIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
		}
		if (strEndIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
		}
		/* 开始截取 */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;
	}
}
