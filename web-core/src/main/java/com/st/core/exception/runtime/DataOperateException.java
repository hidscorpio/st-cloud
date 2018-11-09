package com.st.core.exception.runtime;


import com.st.core.exception.BaseErrorMessage;
import com.st.core.exception.BaseRuntimeException;

/**
 * 数据操作异常
 *
 * @author 枫竹
 */
public class DataOperateException extends BaseRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataOperateException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    public DataOperateException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public DataOperateException(int code, String message) {
        super(code, message);
    }

    public DataOperateException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
