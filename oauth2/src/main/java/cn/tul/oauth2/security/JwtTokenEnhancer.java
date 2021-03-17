package cn.tul.oauth2.security;

import cn.tul.oauth2.web.vo.SecurityUserVo;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 * JWT内容增强器
 * @author cuijing
 * @className JwtTokenEnhancer
 * @date 2021-03-14 16:48
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {
    /**
     * 设置JWT token中的信息
     * @param accessToken 鉴权token
     * @param authentication 当前登录人缓存
     * @return 包装以后的登陆信息
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        SecurityUserVo securityUser = (SecurityUserVo) authentication.getPrincipal();
        Map<String, Object> info = new HashMap<>(2);
        info.put("id", securityUser.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
