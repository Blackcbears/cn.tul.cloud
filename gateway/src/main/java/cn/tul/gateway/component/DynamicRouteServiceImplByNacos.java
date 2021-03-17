package cn.tul.gateway.component;

import cn.tul.gateway.config.IgnoreUrlsConfig;
import cn.tul.gateway.constant.NacosConsts;
import cn.tul.gateway.entity.NacosGatewayProperties;
import cn.tul.gateway.service.DynamicRouteServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
/**
 * <br>
 * 实现runner，通过nacos下发动态路由配置
 * @author cuijing
 * @className DynamicRouteServiceImplByNacos
 * @date 2021-03-15 22:47
 */
@Component
public class DynamicRouteServiceImplByNacos implements CommandLineRunner {

    private final DynamicRouteServiceImpl dynamicRouteService;

    private final NacosGatewayProperties nacosGatewayProperties;


    public DynamicRouteServiceImplByNacos(DynamicRouteServiceImpl dynamicRouteService, NacosGatewayProperties nacosGatewayProperties) {
        this.dynamicRouteService = dynamicRouteService;
        this.nacosGatewayProperties = nacosGatewayProperties;
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener() {
        try {
            Properties properties = new Properties();
            if(nacosGatewayProperties.getNamespace() != null){
                properties.put(NacosConsts.NAMESPACE, nacosGatewayProperties.getNamespace());
            }
            properties.put(NacosConsts.SERVER_ADDR, nacosGatewayProperties.getServerAddr());
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(),
                    nacosGatewayProperties.getTimeout());
            List<RouteDefinition> list = JSON.parseArray(content, RouteDefinition.class);
            if (!CollectionUtils.isEmpty(list)) {
                dynamicRouteService.updateBatch(list);
            }
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    List<RouteDefinition> list = JSON.parseArray(configInfo, RouteDefinition.class);
                    dynamicRouteService.updateBatch(list);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) {
        dynamicRouteByNacosListener();
    }

}