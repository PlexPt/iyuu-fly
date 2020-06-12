

package com.github.plexpt.iyuu.config.exception;

/**
 * 自定义REST异常
 *
 * @author ADMIN
 */
public class RestException extends RuntimeException {

    protected int code = 500;


    public RestException() {
        super("未知错误");
    }

    public RestException(String msg) {
        super(msg);
    }

    public RestException(String msg, Throwable e) {
        super(msg, e);
    }

    public RestException(String msg, int code) {
        super(msg);
        this.code = code;
    }

//    public RestException(ResponseCodeEnums responseCodeEnums) {
//        super(responseCodeEnums.getMsg());
//        this.code = responseCodeEnums.getCode();
//    }

    public RestException(String msg, int code, Throwable e) {
        super(msg, e);
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
