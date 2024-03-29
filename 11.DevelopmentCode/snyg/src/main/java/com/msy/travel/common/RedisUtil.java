package com.msy.travel.common;

import org.springframework.stereotype.Component;

/**
 * redis cache 工具类
 * 
 */
@Component
public final class RedisUtil {
	// private Logger logger = Logger.getLogger(RedisUtil.class);
	//
	// @Resource(name = "redisTemplate")
	// private RedisTemplate<Serializable, Object> redisTemplate;
	//
	// /**
	// * 批量删除对应的value
	// *
	// * @param keys
	// */
	// public void remove(final String... keys) {
	// for (String key : keys) {
	// remove(key);
	// }
	// }
	//
	// /**
	// * 批量删除key
	// *
	// * @param pattern
	// */
	// public void removePattern(final String pattern) {
	// Set<Serializable> keys = redisTemplate.keys(pattern);
	// if (keys.size() > 0)
	// redisTemplate.delete(keys);
	// }
	//
	// /**
	// * 删除对应的value
	// *
	// * @param key
	// */
	// public void remove(final String key) {
	// if (exists(key)) {
	// redisTemplate.delete(key);
	// }
	// }
	//
	// /**
	// * 判断缓存中是否有对应的value
	// *
	// * @param key
	// * @return
	// */
	// public boolean exists(final String key) {
	// return redisTemplate.hasKey(key);
	// }
	//
	// /**
	// * 读取缓存
	// *
	// * @param key
	// * @return
	// */
	// public Object get(final String key) {
	// Object result = null;
	// ValueOperations<Serializable, Object> operations =
	// redisTemplate.opsForValue();
	// result = operations.get(key);
	// return result;
	// }
	//
	// /**
	// * 写入缓存
	// *
	// * @param key
	// * @param value
	// * @return
	// */
	// public boolean set(final String key, Object value) {
	// boolean result = false;
	// try {
	// ValueOperations<Serializable, Object> operations =
	// redisTemplate.opsForValue();
	// operations.set(key, value);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// /**
	// * 写入缓存
	// *
	// * @param key
	// * @param value
	// * @return
	// */
	// public boolean set(final String key, Object value, Long expireTime) {
	// boolean result = false;
	// try {
	// ValueOperations<Serializable, Object> operations =
	// redisTemplate.opsForValue();
	// operations.set(key, value);
	// redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//
	// public RedisTemplate<Serializable, Object> getRedisTemplate() {
	// return redisTemplate;
	// }

}