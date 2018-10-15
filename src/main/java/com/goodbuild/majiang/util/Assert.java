package com.goodbuild.majiang.util;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 16:08
 * @Description: 断言
 * @Version: 1.0.0
 */
public final class Assert {

    public static void isNull(Object object, String message) {
        isTrue(object == null, message);
    }

    public static void isNotNull(Object object, String message) {
        isTrue(object != null, message);
    }

    public static void isTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean condition, String message) {
        isTrue(!condition, message);
    }

    public static void isBlank(String str, String message) {
        isTrue(str == null || str.length() == 0, message);
    }

    public static void isNotBlank(String str, String message) {
        isTrue(str != null && str.length() > 0, message);
    }
}
