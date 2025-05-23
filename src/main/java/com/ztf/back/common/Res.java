package com.ztf.back.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res<T> {
    private Integer code;      // 状态码
    private String message;    // 提示信息
    private T data;            // 返回数据

    // 成功返回（带数据）
    public static <T> Res<T> success(T data) {
        return new Res<>(200, "success", data);
    }

    // 成功返回（不带数据）
    public static <T> Res<T> success() {
        return new Res<>(200, "success", null);
    }

    // 失败返回（自定义信息）
    public static <T> Res<T> error(String message) {
        return new Res<>(500, message, null);
    }

    // 未登录（自定义信息）
    public static <T> Res<T> notLogin(String message) {
        return new Res<>(401, message, null);
    }

    // 自定义状态码和信息
    public static <T> Res<T> of(int code, String message, T data) {
        return new Res<>(code, message, data);
    }
}
