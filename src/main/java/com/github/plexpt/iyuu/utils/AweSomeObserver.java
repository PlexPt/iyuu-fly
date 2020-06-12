//package com.github.plexpt.iyuu.utils;
//
//import net.dreamlu.mica.http.ResponseSpec;
//
//import java.io.IOException;
//import java.net.ConnectException;
//import java.net.SocketTimeoutException;
//import java.net.UnknownHostException;
//import java.util.concurrent.TimeoutException;
//import java.util.function.Function;
//
//import cn.hutool.http.HttpException;
//import lombok.NonNull;
//
///**
// * @author pt
// * @email plexpt@gmail.com
// * @date 2020-06-10 15:05
// */
//
//public abstract class AweSomeObserver<T> implements Function<ResponseSpec, T>  {
//
//
//    @Override
//    public T apply(ResponseSpec spec) {
//
//        _onNext(spec);
//    }
//
//    @Override
//    public final void onNext(T t) {
//        //解决一个接口有时候返回json模型  有时候为null 报类型转换问题
//        try {
//            if (null != t && !t.equals("")) {
//                _onNext(t);
//            } else {
//                _onNext(null);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public final void onError(Throwable throwable) {
//        String message = "网络连接超时";
//
//        throwable.printStackTrace();
//
//        int code = BaseConfig.LOCAL_ERROR;//默认本地出错
//        if (throwable instanceof SocketTimeoutException) {
//            message = "网络连接超时";
//        } else if (throwable instanceof HttpException) {
//            message = " 请求失败了，绝对不是小爱的问题";//404not
//        } else if (throwable instanceof ConnectException) {
//            message = " 请求失败了，绝对不是小爱的问题";
//        } else if (throwable instanceof UnknownHostException) {//可能是关闭了数据和wifi
//            message = " 请求失败了，绝对不是小爱的问题";
//        } else if (throwable instanceof TimeoutException) {
//            message = "网络连接超时";
//        } else if (throwable instanceof IOException) {
//            message = "请求失败";
//        } else if (throwable instanceof CustomThrowable) {
//            code = ((CustomThrowable) throwable).code;
//            message = ((CustomThrowable) throwable).info;
//        } else if (throwable instanceof CustomException) {
//            code = ((CustomException) throwable).code;
//            message = ((CustomException) throwable).info;
//        } else if (throwable instanceof TokenThrowable) {
//            _onTokenOut((TokenThrowable) throwable);
//            message = throwable.getMessage();
////            _onFinish();
//////            ((BaseApp) BaseApp.getContext()).tokenTimeOut();
////            return;
//        } else if (throwable instanceof JSONException) {
//            message = "数据解析出错";
//        } else if (throwable instanceof NullPointerException) {
//            message = "数据出错";
//            if (message.equals("item is null") || message
//                    .equals("onNext called with null. Null values are generally not allowed in 2.x operators and sources.")) {
//                //说明是rxjava的onnext传入了一个空对象
//            }
//        } else {
//            message = throwable.getMessage();
//            //            message = "未知错误";
//        }
//        try {
//            _onError(code, message);
//            _onError(throwable);
//            _onFinish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void _onError(Throwable throwable) {
//
//    }
//
//    protected void _onTokenOut(TokenThrowable throwable) {
//        ((BaseApp) BaseApp.getContext()).tokenTimeOut();
//    }
//
//
//    @Override
//    public final void onComplete() {
//        try {
//            _onComplete();
//            _onFinish();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public abstract void _onNext(T t);
//
//    public void _onError(int code, String msg) {
//        ToastUtils.showShort(msg);
//    }
//
//
//    public void _onComplete() {
//
//    }
//
//    public void _onFinish() {
//
//    }
//}
