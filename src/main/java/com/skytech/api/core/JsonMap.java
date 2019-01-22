package com.skytech.api.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

import java.util.HashMap;

/**
 * @author 剑神卓凌昭
 * @date 2018-01-16 17:11:28
 */
public class JsonMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 通知消息
     */
    private static final String MESSAGE = "message";

    /**
     * 状态码
     */
    private static final String CODE = "code";

    /**
     * 数据
     */
    private static final String DATA = "data";

    public static String ofJson(String code, String message, Object data, PropertyPreFilter... propertyPreFilters) {
        JsonMap map = of(code, message, data);
        return JSON.toJSONString(map, propertyPreFilters);
    }

    public static String ofJson(String code, Object data, PropertyPreFilter... propertyPreFilters) {
        return ofJson(code, "", data, propertyPreFilters);
    }

    public static String ofJson(String code, String message, PropertyPreFilter... propertyPreFilters) {
        return ofJson(code, message, new Object(), propertyPreFilters);
    }

    public static String ofJson(String code, PropertyPreFilter... propertyPreFilters) {
        return ofJson(code, "", propertyPreFilters);
    }

    public static JsonMap of(boolean success, String message, Object data) {
        return of(success ? "2000" : "5000", message, data);
    }

    public static JsonMap of(String code, String message, Object data) {
        JsonMap map = new JsonMap();
        map.setCode(code);
        map.setMessage(message);
        map.setData(data);
        return map;
    }

    public static JsonMap of(boolean success, String message) {
        return of(success, message, null);
    }

    public static JsonMap of(String code, String message) {
        return of(code, message, null);
    }

    public static JsonMap of(String code, Object data) {
        return of(code, "", data);
    }

    public static JsonMap of(boolean success) {
        return of(success, "");
    }

    public static JsonMap of(String code) {
        return of(code, "");
    }

    public JsonMap() {
        super();
        this.setCode("2000");
        this.setData(new Object());
        this.setMessage("");
    }

    public Object getData() {
        return this.get(DATA);
    }

    public void setData(Object data) {
        this.put(DATA, data);
    }

    public String getCode() {
        Object code = this.get(CODE);
        return code != null ? code.toString() : "";
    }

    public void setCode(String code) {
        this.put(CODE, code);
    }

    public String getMessage() {
        Object message = this.get(MESSAGE);
        return message != null ? message.toString() : "";
    }

    public void setMessage(String message) {
        this.put(MESSAGE, message);
    }

    public boolean isSuccess() {
        return this.getCode().equals("2000");
    }

}
