package com.st.core.exception.runtime;


import com.st.core.exception.BaseErrorMessage;
import com.st.core.exception.BaseRuntimeException;

/**
 * 数据校验异常
 *
 * @author 枫竹
 */
public class DataValidateException extends BaseRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataValidateException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    public DataValidateException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public DataValidateException(int code, String message) {
        super(code, message);
    }

    public DataValidateException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}