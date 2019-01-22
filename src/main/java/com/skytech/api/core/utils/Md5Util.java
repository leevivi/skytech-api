package com.skytech.api.core.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Util {

    private Md5Util() {
    }

    /**
     * md5加密，并以16进制返回
     * 
     * @param rawStr
     * @return
     */
    public static String encodeHex(String rawStr) {
        return DigestUtils.md5Hex(rawStr);
    }

    /**
     * 获取文件md5值
     * 
     * @param file
     * @return
     */
    public static String getMD5(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return getMD5(in);
    }

    /**
     * 获取输入流的md5值
     * 
     * @param in
     * @return
     */
    public static String getMD5(InputStream in) {
        MessageDigest digest = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }
}
