package cn.tul.oauth2.service;


import cn.hutool.core.collection.CollUtil;
import cn.tul.common.constant.RedisConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <br>
 *资源与角色匹配关系管理业务类
 * @author cuijing
 * @className ResourceServiceImpl
 * @date 2021-03-15 01:39
 */
@Service
public class ResourceServiceImpl {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        resourceRolesMap.put("/provider/helloProvider", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
