package cn.tul.common.enums;

/**
 * <br>
 *
 * @author cuijing
 * @className ResultEnum
 * @date 2021-03-15 02:20
 */
public enum ResultEnum  implements ServiceExceptionEnum{
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限");
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public void setCode(Integer code) {
        this.code = code;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
