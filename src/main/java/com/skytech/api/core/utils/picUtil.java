package com.skytech.api.core.utils;

import java.math.BigDecimal;

/**
 * Created by LiWei on 2019/4/16.
 */
public class picUtil {
    public static final String TEST_SERVER_URL = "http://47.244.189.240:8080/statics";
    public static final String FORMAL_SERVER_URL = "http://47.244.99.59:8080/statics";
    public static String getUrl(){
        return TEST_SERVER_URL;
//        return FORMAL_SERVER_URL;
    }

    public static void main(String[] args){
        BigDecimal a = new BigDecimal(0.0);
        BigDecimal b = new BigDecimal(0.0);
        boolean b1 = a.compareTo(BigDecimal.ZERO) == 0;
        System.out.println(b1);
    }
}
