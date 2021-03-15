package cn.tul.common.tips;

import cn.tul.common.enums.BizExceptionEnum;
import cn.tul.common.enums.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <br>
 * 返回给前台的提示（最终转化为json形式）
 * @author cuijing
 * @className tip
 * @date 2021-03-14 16:18
 */
public class Tip<T> {

    private int code;

    private String message;

    private boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Tip() {
        super();
    }

    /**
     * 根据业务异常枚举返回提示信息
     * @param bizException 错误枚举类型
     */
    public Tip(BizExceptionEnum bizException) {
        this.code = bizException.getCode();
        this.message = bizException.getMessage();
        this.success = false;
    }
    /**
     * success为true则返回操作成功，否则返回操作失败
     * @param success 是否成功
     */
    public Tip(boolean success) {
        this.success = success;
        if (success) {
            this.code = 200;
            this.message = "操作成功";

        } else {
            this.code = BizExceptionEnum.OPERATION_FAILED.getCode();
            this.message = BizExceptionEnum.OPERATION_FAILED.getMessage();
        }
    }

    /**
     * success为true则返回操作成功，否则返回操作失败
     * @param success success 是否成功
     * @param message 返回信息
     */
    public Tip(boolean success, String message) {
        this.success = success;
        if (success) {
            this.code = 200;
        } else {
            this.code = BizExceptionEnum.OPERATION_FAILED.getCode();
        }
        this.message = message;
    }
    /**
     * 未授权返回结果
     */
    public static <T> Tip<T> forbidden(T data) {
        return new Tip<>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), data, false);
    }
    /**
     * 未登录返回结果
     */
    public static <T> Tip<T> unauthorized(T data) {
        return new Tip<>(ResultEnum.UNAUTHORIZED.getCode(), ResultEnum.UNAUTHORIZED.getMessage(), data, false);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Tip<T> success(T data) {
        return new Tip<>(ResultEnum.FORBIDDEN.getCode(), ResultEnum.FORBIDDEN.getMessage(), data, true);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> Tip<T> success(T data, String message) {
        return new Tip<>(ResultEnum.SUCCESS.getCode(), message, data, true);
    }
    /**
     * 成功返回结果
     *
     * @param  message 提示信息
     */
    public static <T> Tip<T> success(String message) {
        return new Tip<>(ResultEnum.SUCCESS.getCode(), message, true);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> Tip<T> failed(BizExceptionEnum errorCode) {
        return new Tip<>(errorCode.getCode(), errorCode.getMessage(), false);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> Tip<T> failed(BizExceptionEnum errorCode,String message) {
        return new Tip<>(errorCode.getCode(), message, false);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> Tip<T> failed(String message) {
        return new Tip<>(BizExceptionEnum.FAILED.getCode(), message, false);
    }

    /**
     * 失败返回结果
     */
    public static <T> Tip<T> failed() {
        return failed(BizExceptionEnum.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Tip<T> validateFailed() {
        return failed(BizExceptionEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Tip<T> validateFailed(String message) {
        return new Tip<>(BizExceptionEnum.VALIDATE_FAILED.getCode(), message, false);
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tip [code=" + code + ", message=" + message + "]";
    }

    public Tip(int code, String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = null;
    }
    public Tip(int code, String message,T data,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }
}

