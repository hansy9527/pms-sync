package com.houli.pms.sync.utils;



/**
 * 字符串工具类
 */
public class StringUtils {


    /**
     * 拼接 like 匹配字符串
     *
     * @param str
     * @return
     */
    public static String matchLikeStr(String str) {
        return "%" + str + "%";
    }
    /**
     * 拼接 like left 匹配字符串
     *
     * @param str
     * @return
     */
    public static String matchLikeLeftStr(String str) {
        return "%" + str;
    }

    /**
     * 拼接 like right 匹配字符串
     *
     * @param str
     * @return
     */
    public static String matchLikeRightStr(String str) {
        return str + "%";
    }
}