package cn.test.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <br>
 * 获取RSA公钥接口
 * @author cuijing
 * @className KeyPairController
 * @date 2021-03-15 01:21
 */
@RestController
public class KeyPairController {

    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Value("${spring.redis.password}")
    private String urls;

    @GetMapping("/rsa/public_key")
    public void getKey() {
        System.out.println(ignoreUrlsConfig.getUrls().toString());
    }
    @GetMapping("/rsa/public_key1")
    public void getKey1() {
        System.out.println(urls);
    }

}