package cn.tul.common.enums;

/**
 * <br>
 * 错误枚举类
 *
 * @author cuijing
 * @className BizExceptionEnum
 * @date 2021-03-14 16:24
 */
public enum BizExceptionEnum implements ServiceExceptionEnum {

    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),
    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 数据请求格式失败
     */
    BODY_NOT_MATCH(400, "数据请求格式失败"),
    /**
     * 操作失败
     */
    OPERATION_FAILED(400, "操作失败"),
    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    /**
     * 用户密码错误
     */
    USERNAME_PASSWORD_ERROR(401, "用户密码错误！"),
    /**
     * 不能登录
     */
    ACCOUNT_DISABLED(401, "禁止登录！"),
    /**
     * 账户已经锁定
     */
    ACCOUNT_LOCKED(401, "账户已经锁定！"),
    /**
     * 账户已过期
     */
    ACCOUNT_EXPIRED(403, "账户已过期！"),
    /**
     * 锁定过期
     */
    CREDENTIALS_EXPIRED(403, "锁定过期！"),
    /**
     * 用户名或者密码错误
     */
    AUTHENTICATION_ERROR(401, "用户名或者密码错误");


    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public static BizExceptionEnum valueOf(Integer value) {
        if (value != null) {
            for (BizExceptionEnum ms : BizExceptionEnum.values()) {
                if (ms.getCode().equals(value)) {
                    return ms;
                }
            }
        }
        return null;
    }

}
