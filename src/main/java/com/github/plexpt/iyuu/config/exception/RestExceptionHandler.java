
package com.github.plexpt.iyuu.config.exception;


import com.github.plexpt.iyuu.utils.R;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;


/**
 * REST风格异常处理器
 *
 * @author ADMIN
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {


    private static final String PROD_PROFILE = "prod";

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RestException.class)
    public R handleRestException(RestException e) {

        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(Exception e) {

        return R.error(404, "404 路径不存在");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        if (isProdEnv()) {
            log.warn("系统中已存在该记录: " + e.getMessage());
            return R.error("已存在该记录");
        }
        return R.error("系统中已存在该记录");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        if (isProdEnv()) {
            log.warn(e.getMessage());
            return R.error("请求有误");
        }
        return R.error("参数传少了或传丢了,传歪了" + e.getMessage());
    }

//
//    @ExceptionHandler(AuthorizationException.class)
//    public R handleAuthorizationException(AuthorizationException e) {
//        return R.error("没有权限，请联系后台授权");
//    }
//
//    @ExceptionHandler(UnauthorizedException.class)
//    public R handleAuthorizationException(UnauthorizedException e) {
//        return R.error("未授权，请联系后台授权");
//    }

    @ExceptionHandler(SQLException.class)
    public R handlerSQLException(SQLException e) {
        sendMessage(e);
        if (isProdEnv()) {
            return R.error("后台出错了,请联系后台");
        }

        return R.error("SQL语句错误，请联系客服");
    }

    @ExceptionHandler(NullPointerException.class)
    public R handlerExcelException(NullPointerException e) {
        log.error(e.getMessage(), e);
        sendMessage(e);

        if (isProdEnv()) {
            return R.error("内容有误,请联系客服");
        }

        return R.error("某条记录为空指针，请联系后台");


    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        if (isProdEnv()) {
            return R.error("非法请求");

        }
        return R.error("非法请求");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R validationError(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        if (isProdEnv()) {
            return R.error("非法请求");

        }

        return R.error(400, fieldError.getField() + fieldError.getDefaultMessage());
    }


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        sendMessage(e);

        if (isProdEnv()) {
            log.error(e.getMessage(), e);
            return R.error();
        }
        log.error(e.getMessage(), e);
        return R.error(" 报错详情: " + e.getMessage());
    }


    public void sendMessage(Exception e) {

    }


    public boolean isProdEnv() {

        return true;
//        if (StringUtils.isBlank(profile)) {
//            return false;
//        }

//        return profile.equals(PROD_PROFILE);
    }
}
