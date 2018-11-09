package com.st.web.filter;

import com.st.core.exception.ErrorMessage;
import com.st.core.exception.runtime.BusinessException;
import com.st.core.exception.runtime.ForbiddenException;
import com.st.core.exception.runtime.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.st.web.filter.GlobalErrorMessage.*;


/**
 * 统一验证异常处理器
 *
 * @author 枫竹
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 参数绑定错误，处理参数类型转换错误，比如将字符串赋值给数字型
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public HttpEntity<?> bindExceptionHandler(BindException e) {
        int index = 0;
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : fieldErrors) {
            if (!StringUtils.isEmpty(error.getDefaultMessage()) && !StringUtils.isEmpty(error.getField())) {
                if (index == 0) {
                    index++;
                } else {
                    errorMessage.append("\n");
                }
                errorMessage.append("字段类型错误,字段名:").append(error.getField()).append(",字段值:")
                        .append(error.getRejectedValue());
            }
        }
        LOGGER.error("请求参数校验失败,异常信息:{}.", e.getMessage());
        return new ResponseEntity<>(new ErrorMessage(ARGUMENT_BIND_ERROR.getCode(), errorMessage.toString()),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * 参数校验错误，处理参数校验失败
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public HttpEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        int index = 0;
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : fieldErrors) {
            if (index == 0) {
                index++;
            } else {
                errorMessage.append("\n");
            }
            if (!StringUtils.isEmpty(error.getDefaultMessage()) && !StringUtils.isEmpty(error.getField())) {
                errorMessage.append(error.getDefaultMessage());
            }
        }
        LOGGER.error("请求参数绑定失败,异常信息:{}.", e.getMessage());
        return new ResponseEntity<Object>(new ErrorMessage(
                ARGUMENT_VALID_ERROR.getCode(), errorMessage.toString()), HttpStatus.BAD_REQUEST);
    }

    /**
     * 请求格式转换错误，请求内容不符合JSON格式
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public HttpEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOGGER.debug("请求参数绑定失败,错误信息:{}", e.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorMessage(
                ARGUMENT_JSON_ERROR.getCode(), "服务器无法识别请求"), HttpStatus.BAD_REQUEST);
    }

    /**
     * 未授权异常
     */
    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public HttpEntity<?> forbiddenExceptionHandler(Exception e) {
        ForbiddenException error = (ForbiddenException) e;
        LOGGER.debug("未授权异常,错误码:{},错误消息:{}.堆栈信息:{}.", error.getCode(), error.getMessage(), e);
        return new ResponseEntity<>(new ErrorMessage(error.getCode(), error.getMessage()), HttpStatus.FORBIDDEN);
    }

    /**
     * 禁止访问异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public HttpEntity<?> unauthorizedExceptionHandler(Exception e) {
        UnauthorizedException error = (UnauthorizedException) e;
        LOGGER.debug("禁止访问异常,错误码:{},错误消息:{}.堆栈信息:{}.", error.getCode(), error.getMessage(), e);
        return new ResponseEntity<>(new ErrorMessage(error.getCode(), error.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public HttpEntity<?> businessExceptionHandler(Exception e) {
        BusinessException error = (BusinessException) e;
        LOGGER.debug("业务异常,错误码:{},错误消息:{}.堆栈信息:{}.", error.getCode(), error.getMessage(), e);
        return new ResponseEntity<>(new ErrorMessage(error.getCode(), error.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * 全局错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpEntity<?> exceptionHandler(Exception e) {
        LOGGER.error("系统内部错误,异常信息:{},堆栈信息:{}.", e.getMessage(), e);
        return new ResponseEntity<>(
                new ErrorMessage(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
