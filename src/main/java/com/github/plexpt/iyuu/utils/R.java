

package com.github.plexpt.iyuu.utils;


import lombok.Data;


/**
 * 返回数据
 *
 * @author ADMIN
 */
@Data
public class R<T> {


    /**
     * 返回码
     */
    int code;

    /**
     * 提示消息
     */
    String msg;

    /**
     * 数据载体
     */
    T data;

    public R() {
        this.code = 0;
        this.msg = "success";
    }

    public static R error() {
        return error(500, "未知错误");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error400() {
        return error(400, "操作有误");
    }

    public static R error400(String msg) {
        return error(400, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.setMsg(msg);
        return r;
    }


    public static R ok() {
        return new R();
    }


    public R putData(T value) {

        this.setData(value);

        return this;
    }


}
