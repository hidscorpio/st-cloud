package com.st.core.exception;

/**
 * 所有异常信息接口类
 * 主要是为了实现error重用
 *
 * @author 枫竹
 */
public interface BaseErrorMessage {
    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    String getMessage();
}