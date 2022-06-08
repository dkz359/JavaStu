package com.dukz.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * 自定义字符串工具类
 *
 * @ClassName StringUtil
 * @Author dukz
 * @Date 2022/6/8
 * @Version 1.0
 */
@Slf4j
public class StringUtil {
    //Applies Sha256 to a string and returns the result.
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // This will contain hash as hexidecimal
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch(Exception e) {
            log.error("使用sha256失败！", e);
            throw new RuntimeException(e);
        }
    }
}
