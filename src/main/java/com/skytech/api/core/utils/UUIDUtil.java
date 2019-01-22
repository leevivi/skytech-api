package com.skytech.api.core.utils;/**
 * Created by Administrator on 2018/7/11.
 */

import java.util.UUID;

/**
 * uuid生成工具
 *
 * @author :付意伟
 * @date 2018-07-11 16:06
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
