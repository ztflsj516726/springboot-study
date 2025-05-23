package com.ztf.back.common;

public class UserContext {

    private static final ThreadLocal<String> USER_HOLDER = new ThreadLocal<>();

    public static void setUserId(String id) {
        USER_HOLDER.set(id);
    }

    public static String getUserId() {
        return USER_HOLDER.get();
    }

    public static void clear() {
        USER_HOLDER.remove(); // 防止内存泄漏
    }
}
