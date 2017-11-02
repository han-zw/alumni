/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Json操作工具类.
 * @title JsonUtils
 * @description Json操作工具类. 
 * @author zw.han
 * @date 2016年12月31日
 * @version 1.0
 */
public class JsonUtils {
    private JsonUtils() {
    }

    /**
     * 转换json字符串为java bean对象.
     * @param jsonStr json字符串，不能为blank。
     * @param cls 目标类的class
     * @return 目标bean实例.
     */
    public static <T> T fromJson(String jsonStr, Class<T> cls) {
        Preconditions.checkNotNull(jsonStr);
        Preconditions.checkArgument(StringUtils.isNotEmpty(jsonStr));

        Gson gson = new Gson();
        return gson.fromJson(jsonStr, cls);
    }

    /**
     * 将src转换为json字符串.
     * @param src 待转换的对象.
     * @return 转换后的json字符串
     */
    public static String toJson(Object src) {
        Preconditions.checkNotNull(src);

        Gson gson = new Gson();
        return gson.toJson(src);
    }

    /**
     * 将传入的json字符串转换成相应对象的list.
     * @param jsonStr 待转换的json字符串，不能为null和blank.
     * @param cls 目标List中元素的class
     * @return json数组对应的java 对象list.
     */
    public static <T> List<T> listFromJson(String jsonStr, Class<T> cls) {
        Preconditions.checkNotNull(jsonStr);
        Preconditions.checkArgument(StringUtils.isNoneEmpty(jsonStr));

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonStr);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        List<T> objs = new ArrayList<T>();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement e = it.next();

            T obj = gson.fromJson(e, cls);
            objs.add(obj);
        }
        return objs;

    }
}
