package com.chinamobile.sd.openapi;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by cheng on 2020/3/30.
 */
public class AESUtil {
  public static final Log LOGGER = LogFactory.getLog(AESUtil.class);

  private static final String AESTYPE ="AES/ECB/PKCS5Padding";

  public static String encrypt(String keyStr, String plainText) {
    byte[] encrypt = null;
    try{
      Key key = generateKey(keyStr);
      Cipher cipher = Cipher.getInstance(AESTYPE);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      encrypt = cipher.doFinal(plainText.getBytes());
    }catch(Exception e){
      LOGGER.error("AES加密失败：" + e.getMessage(),e);
      return null;
    }
    return new String(Base64.encodeBase64(encrypt));
  }

  public static String decrypt(String keyStr, String encryptData) {
    byte[] decrypt = null;
    try{
      Key key = generateKey(keyStr);
      Cipher cipher = Cipher.getInstance(AESTYPE);
      cipher.init(Cipher.DECRYPT_MODE, key);
      decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
    }catch(Exception e){
      LOGGER.error("AES解密失败：" + e.getMessage(),e);
      return null;
    }
    return new String(decrypt).trim();
  }
  public static String md5Key(String key){
    String original = DigestUtils.md5Hex(key);
    return original == null ? null : original.substring(8, 24).toUpperCase();
  }
  //解密demo
  public static void main(String[] args) {
    String keyString="qLd8cG3^2mH%s#dU";
    String dataString="X/oe6HbaBLEmczycUCzwRw=="; //HbaBLEmczycUCzwRw==
    String keyUpper=md5Key(keyString);
    String tel=decrypt(keyUpper,dataString);
    System.out.println(tel);
  }

  private static Key generateKey(String key)throws Exception{
    try{
      SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
      return keySpec;
    }catch(Exception e){
      throw e;
    }

  }

  private static final String KEY_AES = "AES";
  private static final String CHARSET = "UTF-8";

  //加密
  public static String encryptEasy(String key,String src) {
    if (key == null || key.length() != 16) {
      return null;
    }
    try {
      byte[] raw = key.getBytes();
      SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
      Cipher cipher = Cipher.getInstance(KEY_AES);
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
      byte[] encrypted = cipher.doFinal(src.getBytes(CHARSET));
      return byte2hex(encrypted);

    } catch (Exception e) {
      return null;
    }
  }

  //解密
  public static String decryptEasy(String key,String src) throws Exception {
    if (key == null || key.length() != 16) {
      return null;
    }
    try {

      byte[] raw = key.getBytes();
      SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
      Cipher cipher = Cipher.getInstance(KEY_AES);
      cipher.init(Cipher.DECRYPT_MODE, skeySpec);
      byte[] encrypted = hex2byte(src);
      byte[] original = cipher.doFinal(encrypted);
      return new String(original,CHARSET);
    } catch (Exception e) {
      return null;
    }
  }

  public static byte[] hex2byte(String strhex) {
    if (strhex == null) {
      return null;
    }
    int l = strhex.length();
    if (l % 2 == 1) {
      return null;
    }
    byte[] b = new byte[l / 2];
    for (int i = 0; i != l / 2; i++) {
      b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
    }
    return b;
  }

  public static String byte2hex(byte[] b) {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++) {
      stmp = (Integer.toHexString(b[n] & 0XFF));
      if (stmp.length() == 1) {
        hs = hs + "0" + stmp;
      } else {
        hs = hs + stmp;
      }
    }
    return hs.toUpperCase();
  }
  //
  ///**
  // * 解密手机号专用 aes方法
  // * @param password
  // * @param key
  // * @return
  // * @throws Exception
  // */
  //public static String DeCodeMobileAES(String password, String key) throws Exception{
  //  byte[] keybBytes = MD5STo16Byte.encrypt2MD5toByte16(key);
  //  byte[] debase64Bytes = Base64.decodeBase64(password);
  //  return new String(Decrypt(debase64Bytes, keybBytes));
  //}

  private static byte[] Decrypt(byte[] text, byte[] key) throws Exception {
    SecretKeySpec aesKey = new SecretKeySpec(key, "AES");

    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, aesKey);
    return cipher.doFinal(text);
  }
}
