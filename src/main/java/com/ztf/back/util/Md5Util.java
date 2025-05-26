package com.ztf.back.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    // MD5加密方法
    public static String encryptPassword(String password) {
        try {
            // 获取 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算并获取字节数组
            byte[] digest = md.digest(password.getBytes());
            // 将字节数组转化为16进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));  // 转为16进制
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密算法不存在", e);
        }
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";
        String encryptedPassword = encryptPassword(password);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}
