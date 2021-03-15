package cn.tul.common.tips;

import cn.tul.common.enums.BizExceptionEnum;

/**
 * <br>
 * 返回给前台的提示（最终转化为json形式）
 * @author cuijing
 * @className tip
 * @date 2021-03-14 16:18
 */
public class Tip {

    protected int code;
    protected String message;
    protected boolean success;

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

    @Override
    public String toString() {
        return "Tip [code=" + code + ", message=" + message + "]";
    }

    public Tip(int code, String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
}

