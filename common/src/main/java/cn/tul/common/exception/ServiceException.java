package cn.tul.common.exception;

import cn.tul.common.enums.ServiceExceptionEnum;

/**
 * <br>
 * 封装自定义的异常
 * @author cuijing
 * @className ServiceException
 * @date 2021-03-14 16:20
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -8490759249013729324L;

    private Integer code;

    private String message;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }
    public ServiceException(String message) {
        this.code = 500;
        this.message = message;
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
