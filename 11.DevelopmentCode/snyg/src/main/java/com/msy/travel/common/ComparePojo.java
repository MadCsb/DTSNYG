package com.msy.travel.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComparePojo {

	/**
	 * 比较两个对象中的属性值是否发生变化
	 * 
	 * @author yf-wanghuan
	 * @date 2016年12月8日 下午4:09:27
	 * @param oldPojo
	 * @param newPojo
	 * @return 返回map的list map中参数值 field——变化字段 desc——字段描述oldVal——变更前的值
	 *         newVal——变更后的值
	 * @return List<HashMap<String,String>>
	 */
	public static List<HashMap<String, String>> comparePojo(Object oldPojo, Object newPojo) {

		List<HashMap<String, String>> updateList = new ArrayList<HashMap<String, String>>();

		// 判断对象的CLASS是否相等
		if (oldPojo.getClass() == newPojo.getClass()) {
			String oldValue;
			String newValue;
			HashMap<String, String> valueMap;
			Field[] field = oldPojo.getClass().getDeclaredFields();
			for (Field f : field) {
				try {
					MyAnnotation annotation = f.getAnnotation(MyAnnotation.class);
					if (annotation == null) {
						continue;
					}
					oldValue = WTConvert.ToString(oldPojo.getClass().getDeclaredMethod(getMethodName(f.getName())).invoke(oldPojo));
					newValue = WTConvert.ToString(newPojo.getClass().getDeclaredMethod(getMethodName(f.getName())).invoke(newPojo));
					if (!oldValue.equals(newValue)) {
						// System.out.println(f.getType());
						// System.out.println(BaseEntity.class.isInstance(f.getType().newInstance()));
						valueMap = new HashMap<String, String>();
						valueMap.put("field", f.getName());
						valueMap.put("desc", annotation == null ? "" : annotation.desc());
						valueMap.put("oldVal", oldValue);
						valueMap.put("newVal", newValue);
						updateList.add(valueMap);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return updateList;
	}

	/**
	 * 拼接get方法名称
	 * 
	 * @author yf-wanghuan
	 * @date 2016年12月8日 下午4:23:42
	 * @param fieldName
	 * @return
	 * @return String
	 */
	private static String getMethodName(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
	}

	/**
	 * 自定义注解
	 * 
	 * @author yf-wanghuan
	 * @date 2016年12月8日 下午4:21:52
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MyAnnotation {
		String desc() default "";
	}

	/**
	 * 获取变化字符串
	 * 
	 * @author yf-wanghuan
	 * @date 2016年12月27日 下午1:38:44
	 * @param changeList
	 * @return
	 * @return String
	 */
	public static String getChangeStrs(List<HashMap<String, String>> changeList) {
		StringBuffer sbf = new StringBuffer();
		try {
			HashMap<String, String> map;
			if (changeList != null) {
				for (int i = 0; i < changeList.size(); i++) {
					map = (HashMap<String, String>) changeList.get(i);
					sbf.append("[");
					sbf.append(map.get("desc"));
					sbf.append(":");
					sbf.append(map.get("oldVal"));
					sbf.append("-->");
					sbf.append(map.get("newVal"));
					sbf.append("]");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sbf.toString();
	}

}
