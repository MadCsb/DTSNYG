package com.msy.travel.common;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimaryKeyUtil {

	private static Date date = new Date();
	private static int stepNum = 0;
	private static final int maxNum = 99;
	/**
	 * 系统静态变量
	 */
	private static ConcurrentHashMap SystemStaticVia = new ConcurrentHashMap();

	/**
	 * 微信code=user对应关系
	 */
	public static ConcurrentHashMap<String, String> WxCodeForUser = new ConcurrentHashMap<String, String>();

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String generateKey() {

		String key = "";
		try {
			UUID uuid = UUID.randomUUID();
			key = uuid.toString().replaceAll("-", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return key;
	}

	/**
	 * 生成16位 numcode 规则 当前时间毫秒数+3位随机数
	 * 
	 * @return
	 */
	public static String generateNumCode() {
		String code = "";

		try {

			long time = System.currentTimeMillis();

			Random random = new Random();
			int num = random.nextInt(999);
			if (num <= 9 && num >= 0) {
				code += time + "00" + num;
			} else if (num <= 99 && num >= 10) {
				code += time + "0" + num;
			} else {
				code += time + "" + num;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return code;

	}

	/**
	 * 15位支付编码生成规则
	 * 
	 * @return
	 */
	public static synchronized String payCode() {

		if (stepNum > maxNum) {
			stepNum = 0;
		}
		return System.currentTimeMillis() + String.format("%02d", stepNum++);

	}

	/**
	 * 生成8位随机数
	 * 
	 * @return
	 */
	public static String createRandom8() {
		String code = "";
		try {
			StringBuilder str = new StringBuilder();// 定义变长字符串
			Random random = new Random();
			// 随机生成数字，并添加到字符串
			for (int i = 0; i < 8; i++) {
				str.append(random.nextInt(10));
			}
			code = str.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return code;
	}

	/**
	 * 获取唯一订单编号orderCode key = OC_yyyy-MM-dd value = OC_AtomicInteger_当前时间
	 *
	 * @return
	 */
	public static String getOnlyOrderCode() {
		String day = DateTimeUtil.getDateTime10();
		String key = "OC_" + day;
		String value = "OC_";
		AtomicInteger codeInc = (AtomicInteger) SystemStaticVia.get(key);
		if (codeInc == null) {
			SystemStaticVia.put(key, new AtomicInteger(0));
			codeInc = (AtomicInteger) SystemStaticVia.get(key);
		}
		value = value + codeInc.incrementAndGet() + "_" + System.currentTimeMillis();
		return value;
	}

	/**
	 * 获取唯一退订单编号orderCode key = OBC_yyyy-MM-dd value = OBC_AtomicInteger_当前时间
	 *
	 * @return
	 */
	public static String getOnlyOrderBackCode() {
		String day = DateTimeUtil.getDateTime10();
		String key = "OBC_" + day;
		String value = "OBC_";
		AtomicInteger codeInc = (AtomicInteger) SystemStaticVia.get(key);
		if (codeInc == null) {
			SystemStaticVia.put(key, new AtomicInteger(0));
			codeInc = (AtomicInteger) SystemStaticVia.get(key);
		}
		value = value + codeInc.incrementAndGet() + "_" + System.currentTimeMillis();
		return value;
	}

	/**
	 * 获取唯一团购批次号 Price1PatchCode key = Price1PatchCode _yyyy-MM-dd value =
	 * Price1PatchCode_AtomicInteger_当前时间
	 *
	 * @return
	 */
	public static String getOnlyPrice1PatchCode() {
		String day = DateTimeUtil.getDateTime10();
		String key = "Price1PatchCode_" + day;
		String value = "Price1PatchCode_";
		AtomicInteger codeInc = (AtomicInteger) SystemStaticVia.get(key);
		if (codeInc == null) {
			SystemStaticVia.put(key, new AtomicInteger(0));
			codeInc = (AtomicInteger) SystemStaticVia.get(key);
		}
		value = value + codeInc.incrementAndGet() + "_" + System.currentTimeMillis();
		return value;
	}

	/**
	 * 获取唯一我方批次流水号 platformFlowCode key = pfc _yyyy-MM-dd value =
	 * platformFlowCode_AtomicInteger_当前时间
	 *
	 * @return
	 */
	public static String getOnlyPlatformFlowCode() {
		String day = DateTimeUtil.getDateTime10();
		String key = "pfc" + day;
		String value = "pfc_";
		AtomicInteger codeInc = (AtomicInteger) SystemStaticVia.get(key);
		if (codeInc == null) {
			SystemStaticVia.put(key, new AtomicInteger(0));
			codeInc = (AtomicInteger) SystemStaticVia.get(key);
		}
		value = value + codeInc.incrementAndGet() + "_" + System.currentTimeMillis();
		return value;
	}

	/**
	 * 通过code获取微信用户Id
	 * 
	 * @author wzd
	 * @date 2019年11月15日 下午10:10:42
	 * @return
	 * @return String
	 */
	public static String getUserIdByCode(String code) {
		String userId_time = WxCodeForUser.get(code);
		if (userId_time != null) {
			userId_time = userId_time.split("_")[0];
		}
		return userId_time;
	}

	public static void setUserIdByCode(String code, String userId) {
		WxCodeForUser.put(code, userId + "_" + System.currentTimeMillis());
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println(getUserIdByCode("123"));
		setUserIdByCode("123", "cheng");
		System.out.println(getUserIdByCode("123"));
		int i = 1000000000;
		while (i > 0) {
			long time = System.currentTimeMillis() - 10000;
			for (String code : PrimaryKeyUtil.WxCodeForUser.keySet()) {
				long codeTime = Long.valueOf(PrimaryKeyUtil.WxCodeForUser.get(code).split("_")[1]);
				if (time > codeTime) {
					PrimaryKeyUtil.WxCodeForUser.remove(code);
				}
			}
			System.out.println(getUserIdByCode("123"));
			i--;
			Thread.currentThread().sleep(1000);
		}

		// System.out.println(PrimaryKeyUtil.generateKey());
		// System.out.println(PrimaryKeyUtil.generateNumCode());
		// for(int i=0;i<300;i++)
		// {
		// System.out.println(payCode());
		// }

	}

}
