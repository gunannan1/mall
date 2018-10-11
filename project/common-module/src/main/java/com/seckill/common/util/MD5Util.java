package com.seckill.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

@Slf4j
public class MD5Util {

//    public static String MD5(String key) {
//        char hexDigits[] = {
//                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
//        };
//        try {
//            byte[] btInput = key.getBytes();
//            // 获得MD5摘要算法的 MessageDigest 对象
//            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//            // 使用指定的字节更新摘要
//            mdInst.update(btInput);
//            // 获得密文
//            byte[] md = mdInst.digest();
//            // 把密文转换成十六进制的字符串形式
//            int j = md.length;
//            char str[] = new char[j * 2];
//            int k = 0;
//            for (int i = 0; i < j; i++) {
//                byte byte0 = md[i];
//                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//                str[k++] = hexDigits[byte0 & 0xf];
//            }
//            return new String(str);
//        } catch (Exception e) {
//            log.error("生成MD5失败", e);
//            return null;
//        }
//    }


    private static final String salt = "2c5e7s1h";

    private static String inputPassToFormPass(String inputPass) {
        String str = salt.charAt(2)+salt.charAt(1) + inputPass +salt.charAt(5) + salt.charAt(4);
        return DigestUtils.md5Hex(str);
    }

    private static String formPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(2)+salt.charAt(1) + formPass +salt.charAt(5) + salt.charAt(4);
        return DigestUtils.md5Hex(str);
    }

    public static String md5(String password,String salt) {
        String formPass = inputPassToFormPass(password);
        String dbPass = formPassToDBPass(formPass, salt);
        return dbPass;
    }



}
