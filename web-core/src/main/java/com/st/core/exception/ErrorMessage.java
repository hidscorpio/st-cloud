package com.st.core.exception;

/**
 * 异常响应实体DTO
 *
 * @author 枫竹
 */
public class ErrorMessage {
    private Integer code;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(BaseErrorMessage baseErrorMessage) {
        if (baseErrorMessage == null) {
            throw new IllegalArgumentException("BaseErrorMessage must not be null.");
        }
        this.code = baseErrorMessage.getCode();
        this.message = baseErrorMessage.getMessage();
    }

    public ErrorMessage(Integer code) {
        this.code = code;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}