package cn.tul.common.enums;

/**
 * <br>
 * 错误枚举类
 * @author cuijing
 * @className ServiceExceptionEnum
 * @date 2021-03-14 16:22
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     * @return Code
     */
    Integer getCode();

    /**
     * 获取异常信息
     * @return Message
     */
    String getMessage();
}
