package cn.tul.oauth2.service;

import cn.hutool.core.collection.CollUtil;
import cn.tul.common.enums.BizExceptionEnum;
import cn.tul.oauth2.entity.vo.SecurityUserVo;
import cn.tul.oauth2.entity.vo.UserVo;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理业务类
 * @author cuijing
 * @className UserServiceImpl
 * @date 2021-03-14 15:50
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private List<UserVo> userList;
    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserVo());
        userList.add(new UserVo());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserVo> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isEmpty(findUserList)) {
            throw new UsernameNotFoundException(BizExceptionEnum.USERNAME_PASSWORD_ERROR.toString());
        }
        SecurityUserVo securityUser = new SecurityUserVo(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException(BizExceptionEnum.ACCOUNT_DISABLED.toString());
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(BizExceptionEnum.ACCOUNT_LOCKED.toString());
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(BizExceptionEnum.ACCOUNT_EXPIRED.toString());
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(BizExceptionEnum.CREDENTIALS_EXPIRED.toString());
        }
        return securityUser;
    }
}
