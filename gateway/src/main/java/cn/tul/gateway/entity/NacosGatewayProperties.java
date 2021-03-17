package cn.tul.gateway.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 自定义属性绑定值，可通过配置文件配置属性。
 * @author cuijing
 * @className NacosGatewayProperties
 * @date 2021-03-15 22:42
 */
@ConfigurationProperties(prefix = "timing.nacos.config")
@Component
public class NacosGatewayProperties {
    private String serverAddr;

    private String dataId;

    private String groupId;

    private String namespace;

    private Long timeout;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}